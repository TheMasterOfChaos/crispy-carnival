package com.example.testname;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testname.specialClasses.Order;

import java.util.List;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.OffersViewHolder> {

    private List<Order> orders;

    OffersAdapter(List<Order> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public OffersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.offer_item,
                viewGroup, false);
        return new OffersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OffersViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class OffersViewHolder extends RecyclerView.ViewHolder {
        public OffersViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(itemView.getContext(), DetailsActivity.class);
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }

    public interface OnOrderClickListener{
        void onOrderClick(int position);
    }


}
