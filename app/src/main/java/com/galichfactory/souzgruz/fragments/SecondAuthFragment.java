package com.galichfactory.souzgruz.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.galichfactory.souzgruz.OffersUpdateService;
import com.galichfactory.souzgruz.R;
import com.galichfactory.souzgruz.activities.AuthActivity;
import com.galichfactory.souzgruz.activities.MainActivity;
import com.galichfactory.souzgruz.specialClasses.PhoneNumber;
import com.galichfactory.souzgruz.specialClasses.SMSRequest;
import com.galichfactory.souzgruz.specialClasses.SMSResponse;
import com.galichfactory.souzgruz.specialClasses.Server;
import com.galichfactory.souzgruz.specialClasses.User;

import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
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
            if(editable.toString().length() == 5){
                Call<SMSResponse> checkSMS = Server.api
                        .checkSMS(new SMSRequest(preferences.getString("phone","")
                                ,editable.toString()));
                checkSMS.enqueue(new Callback<SMSResponse>() {
                    @Override
                    public void onResponse(Call<SMSResponse> call, Response<SMSResponse> response) {
                        preferences.edit().putString("token", response.body().getToken()).apply();
                        preferences.edit().putInt("id", response.body().getId()).apply();
	                    Server.token = " Token " + preferences.getString("token", "");
	                    Call<User> getDriver = Server.api
                                .getUser(response.body().getId(), " Token "
                                    + response.body().getToken());
	                    Server.id = response.body().getId();
                        getDriver.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                                preferences.edit()
	                                .putBoolean("can_work", response.body().getDriver().getKYCControl().getWorkAccess())
	                                .putInt("driver_id", response.body().getDriver().getId())
	                                .apply();
                                Server.driverID = response.body().getDriver().getId();
                                if(!response.body().getDriver().getKYCControl().getWorkAccess()){
                                    preferences.edit().putInt("driver_id", response.body().getDriver().getId()).apply();
                                    getActivity().getSupportFragmentManager().beginTransaction()
                                            .replace(R.id.authContainer, new ThirdAuthFragment())
                                            .commit();
                                }
                                else {
	                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
		                                getContext().startForegroundService(new Intent(getContext(), OffersUpdateService.class));
	                                }
	                                else {
		                                getContext().startService(new Intent(getContext(), OffersUpdateService.class));
	                                }
                                    startActivity(new Intent(getContext(), MainActivity.class));
                                    ((AuthActivity)getActivity()).stop();
                                }
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<SMSResponse> call, Throwable t) {
	                    Toast.makeText(getContext(),"Нет сети",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }



}
