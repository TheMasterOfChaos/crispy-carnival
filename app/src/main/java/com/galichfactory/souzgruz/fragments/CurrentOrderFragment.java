package com.galichfactory.souzgruz.fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.galichfactory.souzgruz.R;
import com.galichfactory.souzgruz.specialClasses.CurrentPointView;


public class CurrentOrderFragment extends Fragment {
	public CurrentPointView cpv;
	
	public CurrentOrderFragment() {
		// Required empty public constructor
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_current_order, container, false);
	}
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		cpv = view.findViewById(R.id.currentPointsRecycler);
	}
}
