package com.example.testname.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testname.R;
import com.example.testname.specialClasses.Cargo;
import com.example.testname.specialClasses.Point;

import java.util.List;

public class DetailOrderAdapter extends RecyclerView.Adapter<DetailOrderAdapter.DetailsViewHolder> {

    List<Point> pointList;
    Cargo cargo;

    public DetailOrderAdapter(List<Point> pointList, Cargo cargo) {
        this.pointList = pointList;
        this.cargo = cargo;
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
        detailsViewHolder.mass.setText(cargo.getMass());
        detailsViewHolder.date.setText(pointList.get(i).getArriveDateTime());
        detailsViewHolder.adres.setText(pointList.get(i).getLocation());
        detailsViewHolder.number.setText(Integer.valueOf(i + 1).toString() + "");
    }

    @Override
    public int getItemCount() {
        return pointList.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {
        TextView date, adres, mass, height, width, length, notes, number;
        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.tvPointNumber);
            date = itemView.findViewById(R.id.tvDate);
            adres = itemView.findViewById(R.id.tvAdress);
            mass = itemView.findViewById(R.id.tvMass);
            height = itemView.findViewById(R.id.tvHeight);
            width = itemView.findViewById(R.id.tvWidth);
            length = itemView.findViewById(R.id.tvLength);
            notes = itemView.findViewById(R.id.notes_tv);
        }

    }
}
