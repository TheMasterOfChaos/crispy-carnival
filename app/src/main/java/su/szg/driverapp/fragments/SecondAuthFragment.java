package su.szg.driverapp.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import su.szg.driverapp.OffersUpdateService;
import su.szg.driverapp.R;
import su.szg.driverapp.activities.AuthActivity;
import su.szg.driverapp.activities.MainActivity;
import su.szg.driverapp.specialClasses.PhoneNumber;
import su.szg.driverapp.specialClasses.SMSRequest;
import su.szg.driverapp.specialClasses.SMSResponse;
import su.szg.driverapp.specialClasses.Server;
import su.szg.driverapp.specialClasses.User;

import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class SecondAuthFragment extends Fragment {

	SharedPreferences preferences;

	public SecondAuthFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_second_auth, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		preferences = getActivity().getSharedPreferences("user_data", MODE_PRIVATE);
		EditText smsCodeET = view.findViewById(R.id.smsCodeET);
		Button smsError = view.findViewById(R.id.smsError);
		smsError.setOnClickListener(v -> {
			Call<ResponseBody> getSMS = Server.api.callSMS(new PhoneNumber(preferences.getString("phone", "")));
			getSMS.enqueue(new Callback<ResponseBody>() {
				@Override
				public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

				}

				@Override
				public void onFailure(Call<ResponseBody> call, Throwable t) {

				}
			});
		});
		((TextView) view.findViewById(R.id.numberTV))
				.setText(((AuthActivity) Objects.requireNonNull(getActivity()))
						.curNumber);
		Button checkSMSButton = view.findViewById(R.id.checkSMSCode);
		checkSMSButton.setOnClickListener(v -> {
			Editable editable = smsCodeET.getText();
			if (editable.toString().length() == 5) {
				Call<SMSResponse> checkSMS = Server.api
						.checkSMS(new SMSRequest(preferences.getString("phone", "")
								, editable.toString()));
				checkSMS.enqueue(new Callback<SMSResponse>() {
					@Override
					public void onResponse(Call<SMSResponse> call, Response<SMSResponse> response) {
						if (response.isSuccessful()) {

							preferences.edit().putString("token", response.body().getToken()).apply();
							preferences.edit().putInt("id", response.body().getId()).apply();
							Server.token = " Token " + preferences.getString("token", "");
							Server.id = response.body().getId();
							Call<User> getDriver = Server.api
									.getUser(response.body().getId(), " Token "
											+ response.body().getToken());
							getDriver.enqueue(new Callback<User>() {
								@Override
								public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
									preferences.edit()
											.putBoolean("can_work", response.body().getDriver().getKYCControl().getWorkAccess())
											.putInt("driver_id", response.body().getDriver().getId())
											.apply();
									Server.driverID = response.body().getDriver().getId();
									if (!response.body().getDriver().getKYCControl().getWorkAccess()) {
										getActivity().getSupportFragmentManager().beginTransaction()
												.replace(R.id.authContainer, new ThirdAuthFragment())
												.commit();
									} else {
										try {
											if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
												getContext().startForegroundService(new Intent(getContext(), OffersUpdateService.class));
											} else {
												getContext().startService(new Intent(getContext(), OffersUpdateService.class));
											}
										} catch (Exception ignored) {
										}
										startActivity(new Intent(getContext(), MainActivity.class));
										((AuthActivity) getActivity()).stop();
									}

								}

								@Override
								public void onFailure(Call<User> call, Throwable t) {
									t.printStackTrace();
								}
							});
						} else {
							Toast.makeText(getContext(), "Неправильный код", Toast.LENGTH_SHORT).show();
						}
					}

					@Override
					public void onFailure(Call<SMSResponse> call, Throwable t) {
						Toast.makeText(getContext(), "Нет сети", Toast.LENGTH_LONG).show();

					}
				});
			}
		});
	}


}
