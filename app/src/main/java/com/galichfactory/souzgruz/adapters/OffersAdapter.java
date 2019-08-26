package com.galichfactory.souzgruz.adapters;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galichfactory.souzgruz.activities.DetailsActivity;
import com.galichfactory.souzgruz.R;
import com.galichfactory.souzgruz.specialClasses.Order;
import com.galichfactory.souzgruz.specialClasses.TimeFormater;

import java.util.List;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.OffersViewHolder> {

    private List<Order> orders;

    public OffersAdapter(List<Order> orders) {
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
        viewHolder.address.setText(orders.get(i).getPoints().get(0).getLocation());
        viewHolder.date.setText(TimeFormater.format(orders.get(i).getBeginDateTime()));
        if (orders.get(i).getCustomer().getPaymentType() == 1) {
            if (orders.get(i).getCostDelivererVat() != null) {
                viewHolder.price.setText(orders.get(i).getCostDelivererVat() + " \u20BD");
            }
            else viewHolder.price.setText("");
        }
        else{
            if (orders.get(i).getCostDeliverer() != null) {
                viewHolder.price.setText(orders.get(i).getCostDeliverer() + " \u20BD");
            }
            else viewHolder.price.setText("");
        }
        viewHolder.title.setText(orders.get(i).getCargo().getName());

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class OffersViewHolder extends RecyclerView.ViewHolder {
        TextView address;
        TextView date;
        TextView price;
        TextView title;



        public OffersViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                Intent i = new Intent(itemView.getContext(), DetailsActivity.class);
                i.putExtra("type", DetailsActivity.APPLICATION);
                i.putExtra("order", orders.get(position).getId());
                itemView.getContext().startActivity(i);
            });
            title = itemView.findViewById(R.id.tvTitle);
            price = itemView.findViewById(R.id.tvPrice);
            date = itemView.findViewById(R.id.tvDate);
            address = itemView.findViewById(R.id.tvAddress);

        }
    }

    public interface OnOrderClickListener{
        void onOrderClick(int position);
    }


}
