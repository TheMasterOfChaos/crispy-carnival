package com.galichfactory.souzgruz.adapters;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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
	public boolean isApplication = false;

	private static final int REQUEST = 3;
	private static final int APPLICATION = 2;
	private static final int ACCEPTED = 1;
	private static final int COMPLETED = 0;
	int type;

	public MyOrdersAdapter(List<Order> orderList, int type) {
		Log.d("TAG", "MyOrdersApplicationsAdapter: " );

		this.orders = orderList;
		this.type = type;
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
			itemView.setOnClickListener(v -> {
				int position = getAdapterPosition();
				Intent i = new Intent(itemView.getContext(), DetailsActivity.class);
				i.putExtra("order", orders.get(position).getId());
				i.putExtra("type", type);
				if(orders.get(position).getAppId() != null)
					i.putExtra("orderAppId", orders.get(position).getAppId());
				itemView.getContext().startActivity(i);
			});
			customer  = itemView.findViewById(R.id.tvCustomer);
			phone = itemView.findViewById(R.id.tvPhone);
			title = itemView.findViewById(R.id.tvTitle);
			price = itemView.findViewById(R.id.tvPrice);
			date = itemView.findViewById(R.id.tvDate);
			address = itemView.findViewById(R.id.tvAddress);
		}
	}
}
