package com.galichfactory.souzgruz.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galichfactory.souzgruz.R;
import com.galichfactory.souzgruz.specialClasses.Cargo;
import com.galichfactory.souzgruz.specialClasses.Order;
import com.galichfactory.souzgruz.specialClasses.Point;
import com.galichfactory.souzgruz.specialClasses.TimeFormater;

import java.util.List;

public class FullDetailOrderAdapter extends RecyclerView.Adapter<FullDetailOrderAdapter.FullDetailsViewHolder> {
	
	Order order;
	List<Point> pointList;
	Cargo cargo;

	
	public FullDetailOrderAdapter(Order order, List<Point> pointList, Cargo cargo) {
		this.pointList = pointList;
		this.cargo = cargo;
		this.order = order;
	}
	
	@NonNull
	@Override
	public FullDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.full_detail_order_item,
			viewGroup, false);
		return new FullDetailsViewHolder(v);
	}
	
	
	
	@Override
	public void onBindViewHolder(@NonNull FullDetailsViewHolder detailsViewHolder, int i) {
		detailsViewHolder.length.setText(cargo.getLength());
		detailsViewHolder.width.setText(cargo.getWidth());
		detailsViewHolder.height.setText(cargo.getHeight());
		detailsViewHolder.mass.setText(cargo.getMass());
		detailsViewHolder.date.setText(TimeFormater.format(order.getOrderDateTime()));
		detailsViewHolder.address.setText(pointList.get(i).getLocation());
		detailsViewHolder.number.setText(Integer.valueOf(i + 1).toString() + "");
		detailsViewHolder.title.setText("Пункт №" + (i + 1));
		detailsViewHolder.phone.setText(pointList.get(i).getPhoneNumber());
		detailsViewHolder.name.setText(order.getCustomer().getName());
		detailsViewHolder.notes.setText(order.getComment());
	}
	
	@Override
	public int getItemCount() {
		return pointList.size();
	}
	
	public class FullDetailsViewHolder extends RecyclerView.ViewHolder {
		TextView
			date,
			address,
			mass,
			height,
			width,
			length,
			notes,
			number,
			title,
			phone,
			name;
		
		public FullDetailsViewHolder(@NonNull View itemView) {
			super(itemView);
			name = itemView.findViewById(R.id.tvPerson);
			phone = itemView.findViewById(R.id.tvPhone);
			number = itemView.findViewById(R.id.tvPointNumber);
			date = itemView.findViewById(R.id.tvDate);
			address = itemView.findViewById(R.id.tvAddress);
			mass = itemView.findViewById(R.id.tvMass);
			height = itemView.findViewById(R.id.tvHeight);
			width = itemView.findViewById(R.id.tvWidth);
			length = itemView.findViewById(R.id.tvLength);
			notes = itemView.findViewById(R.id.tvNotes);
			title = itemView.findViewById(R.id.tvWhyWeNeedThis);
			
		}
		
	}
}
