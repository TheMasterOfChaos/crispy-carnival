package com.example.testname;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testname.adapters.MyOrdersAdapter;
import com.example.testname.specialClasses.Order;

import java.util.ArrayList;
import java.util.List;


public class CompletedOrdersFragment extends Fragment {


    public CompletedOrdersFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_completed_orders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.completed_orders_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Order> orderList = new ArrayList<>();
        orderList.add(null);
        orderList.add(null);
        orderList.add(null);
        orderList.add(null);
        orderList.add(null);
        orderList.add(null);
        MyOrdersAdapter adapter = new MyOrdersAdapter(orderList);
        recyclerView.setAdapter(adapter);
    }
}
