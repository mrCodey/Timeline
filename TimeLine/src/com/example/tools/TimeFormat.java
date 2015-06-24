package com.example.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {
	public static String format(String format, String time) {
		String result = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("hhmmss");
		try {
			Date date = dateFormat.parse(time);
			SimpleDateFormat df = new SimpleDateFormat(format);
			result = df.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
