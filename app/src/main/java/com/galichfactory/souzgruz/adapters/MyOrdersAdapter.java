package com.galichfactory.souzgruz.adapters;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galichfactory.souzgruz.R;
import com.galichfactory.souzgruz.activities.DetailsActivity;
import com.galichfactory.souzgruz.activities.MainActivity;
import com.galichfactory.souzgruz.fragments.CompletedOrdersFragment;
import com.galichfactory.souzgruz.specialClasses.Order;
import com.galichfactory.souzgruz.specialClasses.TimeFormater;

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
		viewHolder.address.setText(orders.get(i).getPoints().get(0).getLocation());
		viewHolder.date.setText(TimeFormater.format(orders.get(i).getBeginDateTime()));
		try {
			viewHolder.price.setText(orders.get(i).getCostDeliverer() + " \u20BD");
		}
		catch (NullPointerException e){
			viewHolder.price.setText("");
		}
		viewHolder.title.setText(orders.get(i).getCargo().getName());
		viewHolder.phone.setText(orders.get(i).getCustomer().getPhoneNumber());
		viewHolder.customer.setText(orders.get(i).getCustomer().getContactName());
		
	}
	
	@Override
	public int getItemCount() {
		return orders.size();
	}
	
	public class MyOrdersViewHolder extends RecyclerView.ViewHolder {
		TextView address;
		TextView date;
		TextView price;
		TextView title;
		TextView phone;
		TextView customer;
		public MyOrdersViewHolder(@NonNull View itemView) {
			super(itemView);
			if((MainActivity.active.getClass()) != CompletedOrdersFragment.class){
				itemView.setOnClickListener(v -> {
					int position = getAdapterPosition();
					Intent i = new Intent(itemView.getContext(), DetailsActivity.class);
					
					i.putExtra("order", orders.get(position).getId());
					i.putExtra("type", 1);
					itemView.getContext().startActivity(i);
				});
			}
			else {
				itemView.setOnClickListener(v -> {
					int position = getAdapterPosition();
					Intent i = new Intent(itemView.getContext(), DetailsActivity.class);
					i.putExtra("order", orders.get(position).getId());
					i.putExtra("type", 2);
					itemView.getContext().startActivity(i);
				});
			}
			customer  = itemView.findViewById(R.id.tvCustomer);
			phone = itemView.findViewById(R.id.tvPhone);
			title = itemView.findViewById(R.id.tvTitle);
			price = itemView.findViewById(R.id.tvPrice);
			date = itemView.findViewById(R.id.tvDate);
			address = itemView.findViewById(R.id.tvAddress);
		}
	}
}
