package com.example.testname.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testname.Api;
import com.example.testname.R;
import com.example.testname.adapters.OffersAdapter;
import com.example.testname.specialClasses.Order;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class OffersFragment extends Fragment {

    Response response;
    private Retrofit retrofit;
    private static Api api;
    List<Order> orderList;



    public OffersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        orderList = new ArrayList<>();
        // Inflate the layout for this fragment
        retrofit = new Retrofit.Builder()
                .baseUrl("http://176.53.160.19/api/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        api = retrofit.create(Api.class);
        update();
        return inflater.inflate(R.layout.fragment_offers, container, false);
    }

    private void update() {
        api.getOrders().enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                Log.wtf("TAG", "onResponse: " + response.body().toString());
                orderList = response.body();
            }
            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        orderList.add(null);
        orderList.add(null);
        orderList.add(null);
        orderList.add(null);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.offers_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        OffersAdapter adapter = new OffersAdapter(orderList);

        recyclerView.setAdapter(adapter);
    }


}
