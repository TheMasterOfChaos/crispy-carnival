package com.example.testname.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.testname.R;
import com.example.testname.specialClasses.PhoneNumber;
import com.example.testname.specialClasses.Server;

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
    Log.wtf("tag", "onViewCreated: lohoh");
    submit.setOnClickListener(v -> {
      Editable editable = phoneET.getText();
      if (editable != null) {
        curNumber = "7" + PhoneNumberUtils.normalizeNumber(editable.toString());
        Call<ResponseBody> getSMS = Server.api.callSMS(new PhoneNumber(curNumber));
        getSMS.enqueue(new Callback<ResponseBody>() {
          @Override
          public void onResponse(@NonNull Call<ResponseBody> call,
                                 @NonNull Response<ResponseBody> response) {
            preferences.edit().putString("phone", curNumber).apply();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.authContainer, new SecondAuthFragment())
                    .commit();
          }

          @Override
          public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
            t.printStackTrace();
          }
        });
      }
    });
  }
}
