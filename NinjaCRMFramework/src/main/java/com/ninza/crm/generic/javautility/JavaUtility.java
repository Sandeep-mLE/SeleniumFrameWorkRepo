package com.ninza.crm.generic.javautility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int randomNumber(int key) {
		Random r = new Random();
		int data = r.nextInt(5000);
		return data;
	}
	
	public String getPresentDate() {
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		String date = sim.format(d);
		return date;
	}

	public String getFutureDate(int key) {
		Date d = new Date();// java.util
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		sim.format(d);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, key);
		String expDate1 = sim.format(cal.getTime());
		return expDate1;
	}

}
