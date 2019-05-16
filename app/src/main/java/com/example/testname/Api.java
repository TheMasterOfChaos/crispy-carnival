package com.example.testname;

import com.example.testname.specialClasses.Driver;
import com.example.testname.specialClasses.Order;
import com.example.testname.specialClasses.PhoneNumber;
import com.example.testname.specialClasses.SMSRequest;
import com.example.testname.specialClasses.SMSResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    @Headers({"Content-Type: application/json"})
    @GET("order")
    Call<List<Order>> getOrders(@Header("Authorization") String token);

    @Headers({"Content-Type: application/json"})
    @POST("phone_message")
    Call<ResponseBody> callSMS(@Body PhoneNumber phone_number);

    @Headers({"Content-Type: application/json"})
    @POST("phone_authentication")
    Call<SMSResponse> checkSMS(@Body SMSRequest request);

    @Headers({"Content-Type: application/json"})
    @GET("driver/{id}")
    Call<Driver> getDriver(@Path("id") int request);
}
