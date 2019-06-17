package com.galichfactory.souzgruz.specialClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeFormater {
	static SimpleDateFormat old = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.getDefault());
	static SimpleDateFormat fresh = new SimpleDateFormat("d MMMM yyyy г. HH:mm", Locale.getDefault());
	public static String format(String s){
		
		try {
			return fresh.format(old.parse(s));
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}
}
