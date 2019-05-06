package com.example.testnae;

import com.example.testnae.specialClasses.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Api {
    @Headers({"Content-Type: application/json", "Authorization: Token 27c5864d45c65286c2ac8d88ae0c7dc6b5b6b6b1"})
    @GET("order")
    Call<List<Order>> getOrders();

}
