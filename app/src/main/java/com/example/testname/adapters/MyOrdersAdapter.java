package com.example.testname.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testname.R;
import com.example.testname.specialClasses.Order;

import java.util.List;

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.MyOrdersViewHolder> {

    private List<Order> orders;

    public MyOrdersAdapter(List<Order> orderList) {
        this.orders = orderList;
    }

    @NonNull
    @Override
    public MyOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_order_item, viewGroup, false);

        return new MyOrdersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrdersViewHolder viewHolder, int i) {
        viewHolder.adress.setText(orders.get(i).getPoints().get(0).getLocation());
        viewHolder.date.setText(orders.get(i).getBeginDateTime());
        viewHolder.price.setText(orders.get(i).getCostDeliverer() + " \u20BD");
        viewHolder.title.setText(orders.get(i).getCargo().getName());
        viewHolder.phone.setText(orders.get(i).getCustomer().getPhoneNumber());
        viewHolder.customer.setText(orders.get(i).getCustomer().getContactName());

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class MyOrdersViewHolder extends RecyclerView.ViewHolder {
        TextView adress;
        TextView date;
        TextView price;
        TextView title;
        TextView phone;
        TextView customer;
        public MyOrdersViewHolder(@NonNull View itemView) {
            super(itemView);
            customer  = itemView.findViewById(R.id.tvCustomer);
            phone = itemView.findViewById(R.id.tvPhone);
            title = itemView.findViewById(R.id.tvTitle);
            price = itemView.findViewById(R.id.tvPrice);
            date = itemView.findViewById(R.id.tvDate);
            adress = itemView.findViewById(R.id.tvAdress);
        }
    }
}
