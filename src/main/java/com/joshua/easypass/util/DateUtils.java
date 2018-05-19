package com.joshua.easypass.util;

import java.time.LocalDate;

public class DateUtils {
	
	
	public static String currentYear() {
		LocalDate localDate = LocalDate.now();
		return String.valueOf(localDate.getYear());
	}

	public static String currentDate() {
		LocalDate localDate = LocalDate.now();
		return localDate.toString().replaceAll("-", "");
	}
}
