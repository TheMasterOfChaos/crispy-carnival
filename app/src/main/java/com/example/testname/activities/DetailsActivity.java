package com.example.testname.activities;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testname.R;
import com.example.testname.adapters.DetailOrderAdapter;

import com.example.testname.specialClasses.Cargo;
import com.example.testname.specialClasses.Order;
import com.example.testname.specialClasses.Point;
import com.example.testname.specialClasses.Server;
import com.example.testname.specialClasses.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {
    List<Point> order = new ArrayList<>();
    Order detOrder = new Order();
    Cargo cargo = new Cargo();
    DetailOrderAdapter adapter;
    Call<Order> call;
    TextView tvPrice;
    TextView tvDate;
    SharedPreferences preferences;
    TextView tvPointNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        preferences = getSharedPreferences("user_data", MODE_PRIVATE);
        tvPointNumber = ((TextView) findViewById(R.id.tvPointNumber));
        tvDate = ((TextView) findViewById(R.id.tvDate));
        tvPrice = ((TextView) findViewById(R.id.tvOrderPrice));
        int orderId = getIntent().getIntExtra("order", 0);
        call = Server.api.getOrder(orderId, Server.token);
        call.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                Log.wtf("tag", "onResponse: " + response.body().getPoints().get(0).toString());
                order.addAll(response.body().getPoints());
                cargo.setCargo(response.body().getCargo());
                detOrder = response.body();
                Log.wtf("tag", "onResponse: " + response.body().getCargo().toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {

            }
        });
        ((Button) findViewById(R.id.submitButton)).setOnClickListener(v -> {
            Call<User> getDriver = Server.api.getUser(preferences.getInt("id", -1), Server.token);
            getDriver.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    detOrder.setDriver(response.body().getDriver());
                    Call<String> r = Server.api.changeOrder(detOrder.getId(), Server.token, detOrder);
                    r.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {

                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
            onBackPressed();

        });
        adapter = new DetailOrderAdapter(order, cargo);
        RecyclerView recyclerView = findViewById(R.id.detailRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
