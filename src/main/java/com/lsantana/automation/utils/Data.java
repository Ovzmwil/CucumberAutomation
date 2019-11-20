package com.lsantana.automation.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class Data {
	
	private static Date date = new Date();
	private static Random random = new Random();
	
	public static LocalDate getRandomReturningDate() {
	
		Integer plusDays = random.nextInt(4) + 1;
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		return localDate.plusDays(plusDays.longValue());
	}
	
	public static LocalDate getDepartingDate() {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.plusDays(1);
	}
	
	public static String getRandomCardNumber() {
		//16
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < 17; i++) {
			builder = getRandomCharNumber(builder);
		}
		
		return builder.toString();
	}
	
	private static StringBuilder getRandomCharNumber(StringBuilder builder) {
		builder.append(String.valueOf(random.nextInt(9)));
		return builder;
	}

}
