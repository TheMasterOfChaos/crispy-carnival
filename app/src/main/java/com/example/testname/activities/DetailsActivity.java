package com.example.testname.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.testname.R;
import com.example.testname.adapters.DetailOrderAdapter;
import com.example.testname.specialClasses.Order;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Order> order = new ArrayList<>();
        order.add(null);
        order.add(null);
        order.add(null);
        order.add(null);
        order.add(null);
        setContentView(R.layout.activity_details);
        RecyclerView recyclerView = findViewById(R.id.detailRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DetailOrderAdapter(order));

    }
}
