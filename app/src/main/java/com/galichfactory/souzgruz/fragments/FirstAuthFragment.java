package com.galichfactory.souzgruz.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.galichfactory.souzgruz.R;
import com.galichfactory.souzgruz.specialClasses.PhoneNumber;
import com.galichfactory.souzgruz.specialClasses.Server;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstAuthFragment extends Fragment {
	public Button submit;
	public EditText phoneET;
	public String curNumber;
	private SharedPreferences preferences;



	public FirstAuthFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_first_auth, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		preferences = getActivity().getSharedPreferences("user_data", MODE_PRIVATE);

		submit = view.findViewById(R.id.button4);
		phoneET = view.findViewById(R.id.phoneET);
		phoneET.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
		submit.setOnClickListener(v -> {
			Editable editable = phoneET.getText();
			if (editable != null) {
				curNumber = "7" + PhoneNumberUtils.normalizeNumber(editable.toString());
				Call<ResponseBody> getSMS = Server.api.callSMS(new PhoneNumber(curNumber));
				getSMS.enqueue(new Callback<ResponseBody>() {
					@Override
					public void onResponse(@NonNull Call<ResponseBody> call,
					                       @NonNull Response<ResponseBody> response) {
						if (response.isSuccessful()) {
							preferences.edit().putString("phone", curNumber).apply();
							getActivity().getSupportFragmentManager().beginTransaction()
									.replace(R.id.authContainer, new SecondAuthFragment())
									.commit();
						}
						else{
							if (response.code() == 404)
								Toast.makeText(getContext(), "Номер не найден", Toast.LENGTH_SHORT).show();
							else
								Toast.makeText(getContext(), "Превышен лимит СМС по времени", Toast.LENGTH_SHORT).show();
						}
					}

					@Override
					public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
						Toast.makeText(getContext(),"Нет сети",Toast.LENGTH_LONG).show();

						t.printStackTrace();
					}
				});
			}
		});
	}
}
