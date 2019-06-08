package com.example.testname;

import com.example.testname.specialClasses.Order;
import com.example.testname.specialClasses.PhoneNumber;
import com.example.testname.specialClasses.SMSRequest;
import com.example.testname.specialClasses.SMSResponse;
import com.example.testname.specialClasses.User;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
	
	
	
	@Headers({"Content-Type: application/json"})
	@POST("phone_message")
	Call<ResponseBody> callSMS(@Body PhoneNumber phone_number);
	
	@Headers({"Content-Type: application/json"})
	@POST("phone_authentication")
	Call<SMSResponse> checkSMS(@Body SMSRequest request);
	
	@Headers({"Content-Type: application/json"})
	@GET("user/{id}")
	Call<User> getUser(@Path("id") int request,
	                   @Header("Authorization") String token);
	
	@Headers({"Content-Type: application/json"})
	@GET("order/{id}")
	Call<Order> getOrder(@Path("id") int request,
	                     @Header("Authorization") String token);
	
	@Headers({"Content-Type: application/json"})
	@PATCH("order/{id}")
	Call<String> changeOrder(@Path("id") int id,
	                         @Header("Authorization") String token,
	                         @Body Order order);
	
	@Headers({"Content-Type: application/json"})
	@GET("order?is_preorder=1")
	Call<List<Order>> getOrders(@Header("Authorization") String token);
	
	@Headers({"Content-Type: application/json"})
	@GET("order?status=1")
	Call<List<Order>> getMyOrders(@Query("driver") int id,
	                              @Header("Authorization") String token);
	
	@Headers({"Content-Type: application/json"})
	@GET("order?is_archived=0&is_finished=1&")
	Call<List<Order>> getCompletedOrders(@Query("driver") int id,
	                                     @Header("Authorization") String token);
	
	@Headers({"Content-Type: application/json"})
	@POST("next_point")
	Call<ResponseBody> nextPoint(@Body HashMap<String, String> id,
	                             @Header("Authorization") String token);
	
	@Headers({"Content-Type: application/json"})
	@GET("order?is_current=1&is_finished=0&")
	Call<List<Order>> getCurrentOrder(@Query("driver") int id,
	                                  @Header("Authorization") String token);
	
	
}
