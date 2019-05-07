package com.example.testname.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testname.R;
import com.example.testname.specialClasses.Order;

import java.util.List;

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.MyOrdersViewHolder> {

    private List<Order> orderList;

    public MyOrdersAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public MyOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_order_item, viewGroup, false);

        return new MyOrdersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrdersViewHolder myOrdersViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class MyOrdersViewHolder extends RecyclerView.ViewHolder {
        public MyOrdersViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
