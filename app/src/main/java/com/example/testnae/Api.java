package com.example.testnae;

import com.example.testnae.specialClasses.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Api {
    @Headers({"Content-Type: application/json", "Authorization: Token f3d3a25b1cab470725a92a5d814cd3688c4de692"})
    @GET("order")
    Call<List<Order>> getOrders();

}
