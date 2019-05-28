package com.example.testname.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testname.activities.DetailsActivity;
import com.example.testname.R;
import com.example.testname.specialClasses.Order;

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
        viewHolder.adress.setText(orders.get(i).getPoints().get(0).getLocation());
        viewHolder.date.setText(orders.get(i).getBeginDateTime());
        viewHolder.price.setText(orders.get(i).getCostDeliverer() + " \u20BD");
        viewHolder.title.setText(orders.get(i).getCargo().getName());

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class OffersViewHolder extends RecyclerView.ViewHolder {
        TextView adress;
        TextView date;
        TextView price;
        TextView title;



        public OffersViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                Log.wtf("tag", "OffersViewHolder: " + position);
                if (position == RecyclerView.NO_POSITION) Log.wtf("tag", "OffersViewHolder: ");
                Intent i = new Intent(itemView.getContext(), DetailsActivity.class);

                i.putExtra("order", orders.get(position).getId());
                itemView.getContext().startActivity(i);
            });
            title = itemView.findViewById(R.id.tvTitle);
            price = itemView.findViewById(R.id.tvPrice);
            date = itemView.findViewById(R.id.tvDate);
            adress = itemView.findViewById(R.id.tvAdress);

        }
    }

    public interface OnOrderClickListener{
        void onOrderClick(int position);
    }


}
