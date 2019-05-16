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
import com.example.testname.specialClasses.Server;

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
    public List<Order> orderList;
    OffersAdapter adapter;



    public OffersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        orderList = new ArrayList<>();
        // Inflate the layout for this fragment

        update();

        return inflater.inflate(R.layout.fragment_offers, container, false);
    }

    private void update() {
        Call<List<Order>> getOrder = Server.api.getOrders(" Token 351aa3d04e354804abd8373beb0de0469292aba6");
        getOrder.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, @NonNull Response<List<Order>> response) {
                if(response.body() == null) Log.wtf("suka", "onResponse: blyad");
                orderList.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.offers_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        adapter = new OffersAdapter(orderList);

        recyclerView.setAdapter(adapter);
    }


}
