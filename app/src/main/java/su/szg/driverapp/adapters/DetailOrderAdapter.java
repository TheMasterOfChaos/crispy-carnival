package su.szg.driverapp.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import su.szg.driverapp.R;
import su.szg.driverapp.specialClasses.Cargo;
import su.szg.driverapp.specialClasses.Order;
import su.szg.driverapp.specialClasses.Point;
import su.szg.driverapp.specialClasses.TimeFormater;

import java.util.ArrayList;
import java.util.List;

public class DetailOrderAdapter extends RecyclerView.Adapter<DetailOrderAdapter.DetailsViewHolder> {
	
	Order order;
	List<Point> pointList = new ArrayList<>();
	Cargo cargo;
	
	public DetailOrderAdapter(Order order, List<Point> pointList, Cargo cargo) {
		this.pointList = pointList;
		this.cargo = cargo;
		this.order = order;
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
		detailsViewHolder.length.setText(cargo.getLength());
		detailsViewHolder.width.setText(cargo.getWidth());
		detailsViewHolder.height.setText(cargo.getHeight());
		detailsViewHolder.mass.setText(String.valueOf(Double.valueOf(cargo.getMass())/1000));
		detailsViewHolder.date.setText(TimeFormater.format(order.getOrderDateTime()));
		detailsViewHolder.adres.setText(pointList.get(i).getLocation());
		detailsViewHolder.number.setText(Integer.valueOf(i + 1).toString() + "");
		detailsViewHolder.title.setText("Пункт №" + (i + 1));
		detailsViewHolder.notes.setText(order.getComment());
	}
	
	@Override
	public int getItemCount() {
		return pointList.size();
	}
	
	public class DetailsViewHolder extends RecyclerView.ViewHolder {
		TextView date, adres, mass, height, width, length, notes, number, title;
		public DetailsViewHolder(@NonNull View itemView) {
			super(itemView);
			number = itemView.findViewById(R.id.tvPointNumber);
			date = itemView.findViewById(R.id.tvDate);
			adres = itemView.findViewById(R.id.tvAddress);
			mass = itemView.findViewById(R.id.tvMass);
			height = itemView.findViewById(R.id.tvHeight);
			length = itemView.findViewById(R.id.tvLength);
			notes = itemView.findViewById(R.id.tvNotes);
            width = itemView.findViewById(R.id.tvWidth);
            title = itemView.findViewById(R.id.tvWhyWeNeedThis);
		}
		
	}
}
