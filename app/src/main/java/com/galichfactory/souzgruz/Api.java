package com.galichfactory.souzgruz;

import com.galichfactory.souzgruz.specialClasses.Deliverer;
import com.galichfactory.souzgruz.specialClasses.Driver;
import com.galichfactory.souzgruz.specialClasses.Order;
import com.galichfactory.souzgruz.specialClasses.OrderApplication;
import com.galichfactory.souzgruz.specialClasses.PhoneNumber;
import com.galichfactory.souzgruz.specialClasses.SMSRequest;
import com.galichfactory.souzgruz.specialClasses.SMSResponse;
import com.galichfactory.souzgruz.specialClasses.User;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
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
	@GET("driver/{id}")
	Call<Driver> getDriver(@Path("id") int request,
	                     @Header("Authorization") String token);
	
	@Headers({"Content-Type: application/json"})
	@GET("order/{id}")
	Call<Order> getOrder(@Path("id") int request,
	                     @Header("Authorization") String token);
	
	@Headers({"Content-Type: application/json"})
	@POST("order_application")
	Call<String> changeOrder(@Header("Authorization") String token,
	                         @Body OrderApplication orderApplication);
	
	@Headers({"Content-Type: application/json"})
	@POST("order_application")
	Call<String> getOrdersApplication(@Header("Authorization") String token,
	                         @Body OrderApplication orderApplication);
	
	@Headers({"Content-Type: application/json"})
	@GET("order/unapplied")
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
	
	@Headers({"Content-Type: application/json"})
	@GET("deliverer/{id}")
	Call<Deliverer> getDeliverer(@Path("id") int id,
	                             @Header("Authorization") String token);
	
}
