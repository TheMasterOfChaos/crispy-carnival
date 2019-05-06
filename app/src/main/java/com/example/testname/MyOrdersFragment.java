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

import com.example.testname.specialClasses.Order;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrdersFragment extends Fragment {


    public MyOrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_orders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.my_orders_view);
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
