package com.example.testname.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
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

import com.example.testname.R;
import com.example.testname.activities.AuthActivity;
import com.example.testname.activities.MainActivity;
import com.example.testname.specialClasses.Driver;
import com.example.testname.specialClasses.SMSRequest;
import com.example.testname.specialClasses.SMSResponse;
import com.example.testname.specialClasses.Server;

import java.util.Objects;

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
                        Call<Driver> getDriver = Server.api
                                .getDriver(response.body().getId());
                        getDriver.enqueue(new Callback<Driver>() {
                            @Override
                            public void onResponse(@NonNull Call<Driver> call, @NonNull Response<Driver> response) {
                                preferences.edit().putBoolean("can_work", response.body().getCanWork()).apply();
                                if(!response.body().getCanWork()){
                                    getActivity().getSupportFragmentManager().beginTransaction()
                                            .replace(R.id.authContainer, new SecondAuthFragment())
                                            .commit();
                                }
                                else {
                                    startActivity(new Intent(getContext(), MainActivity.class));
                                    ((AuthActivity)getActivity()).stop();
                                }
                            }

                            @Override
                            public void onFailure(Call<Driver> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                        Log.wtf("tag", "onResponse: " + response.body().getToken());
                        Toast.makeText(getContext(), response.body().getToken(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<SMSResponse> call, Throwable t) {

                    }
                });
            }
        });
    }



}
