package com.galichfactory.souzgruz.specialClasses;

public class GeoPoint {
	int order_id;
	double latitude;
	double longitude;

	public GeoPoint(int order_id, double latitude, double longitude) {
		this.order_id = order_id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public GeoPoint(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
}
