package com.example.testname.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testname.R;
import com.example.testname.specialClasses.Order;

import java.util.List;

public class DetailOrderAdapter extends RecyclerView.Adapter<DetailOrderAdapter.DetailsViewHolder> {

    List<Order> orderList;

    public DetailOrderAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_order_item,
                viewGroup, false);
        return new DetailsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder detailsViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {
        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
