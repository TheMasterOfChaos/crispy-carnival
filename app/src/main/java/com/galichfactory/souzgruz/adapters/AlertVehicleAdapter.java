package com.galichfactory.souzgruz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.galichfactory.souzgruz.R;
import com.galichfactory.souzgruz.specialClasses.Vehicle;

import java.util.List;

public class AlertVehicleAdapter extends ArrayAdapter<Vehicle> {
	
	
	
	public AlertVehicleAdapter(Context context, List<Vehicle> vehicles) {
		super(context, R.layout.alert_item, vehicles);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Vehicle vehicle = getItem(position);
		
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext())
				.inflate(R.layout.alert_item, null);
		}
		((TextView) convertView.findViewById(R.id.textViewBrand))
			.setText(vehicle.getVehicleBrand());
		((TextView) convertView.findViewById(R.id.textViewNumber))
			.setText(vehicle.getVehicleNumber());
		((TextView) convertView.findViewById(R.id.textViewHeght))
			.setText("Высота\n" + vehicle.getHeight());
		((TextView) convertView.findViewById(R.id.textViewLength))
			.setText("Длина\n" + vehicle.getLength());
		((TextView) convertView.findViewById(R.id.textViewWidth))
			.setText("Ширина\n" + vehicle.getWidth());
		return convertView;
	}
}