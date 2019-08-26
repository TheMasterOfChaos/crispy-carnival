package com.galichfactory.souzgruz;

import com.galichfactory.souzgruz.specialClasses.Deliverer;
import com.galichfactory.souzgruz.specialClasses.Driver;
import com.galichfactory.souzgruz.specialClasses.GeoPoint;
import com.galichfactory.souzgruz.specialClasses.Order;
import com.galichfactory.souzgruz.specialClasses.OrderApplication;
import com.galichfactory.souzgruz.specialClasses.PhoneNumber;
import com.galichfactory.souzgruz.specialClasses.RegID;
import com.galichfactory.souzgruz.specialClasses.SMSRequest;
import com.galichfactory.souzgruz.specialClasses.SMSResponse;
import com.galichfactory.souzgruz.specialClasses.User;

import java.util.HashMap;
import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
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
	@DELETE("order_application/{id}")
	Call<String> deleteOrder(@Header("Authorization") String token,
	                         @Path("id") int id);

	@Headers({"Content-Type: application/json"})
	@POST("order_application")
	Call<String> getOrdersApplication(@Header("Authorization") String token,
	                                  @Body OrderApplication orderApplication);

	@Headers({"Content-Type: application/json"})
	@GET("order_application?is_processing=1")
	Call<List<OrderApplication>> getOrdersApplications(@Header("Authorization") String token,
	                                                   @Query("driver") int driver);

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
	@POST("leave_point")
	Call<ResponseBody> leavePoint(@Body HashMap<String, String> id,
	                             @Header("Authorization") String token);

	@Headers({"Content-Type: application/json"})
	@GET("order?is_current=1&is_finished=0&")
	Call<List<Order>> getCurrentOrder(@Query("driver") int id,
	                                  @Header("Authorization") String token);

	@Headers({"Content-Type: application/json"})
	@GET("deliverer/{id}")
	Call<Deliverer> getDeliverer(@Path("id") int id,
	                             @Header("Authorization") String token);


	@Headers({"Content-Type: application/json"})
	@POST("geo/point")
	Call<ResponseBody> postGeoPos(@Header("Authorization") String token,
	                              @Body GeoPoint geoPoint);

	@Headers({"Content-Type: application/json"})
	@PATCH("user/registration_id")
	Call<ResponseBody> addRegID(@Header("Authorization") String token,
	                            @Body RegID regID);
}