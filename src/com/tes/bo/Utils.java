package com.tes.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

	public static int longOfTwoDate(Date first, Date second) throws ParseException {
		if(first.getTime()>second.getTime()) {
			return 0;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(first);
		int cnt = 0;
		while (calendar.getTime().compareTo(second) != 0) {
			calendar.add(Calendar.DATE, 1);
			cnt++;
		}
		return cnt;

	}
	
	public static void main(String[] args) throws ParseException {
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		         String first = "2017-2-2";
		         String second = "2017-3-22";
		        Date firstdate = format.parse(first);
	         Date seconddate = format.parse(second);
		        // int cnt = longOfTwoDate(firstdate, seconddate);
		         int cnt = longOfTwoDate( seconddate,firstdate);
		        System.out.println(cnt);
	}
}
