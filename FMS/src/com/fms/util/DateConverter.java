package com.fms.util;

import java.text.SimpleDateFormat;

public class DateConverter {
	
	public static java.sql.Date convertToSqlDate (final java.util.Date date) {
		SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
		final String strDate = sft.format(date);
		return java.sql.Date.valueOf(strDate);
	}

}
