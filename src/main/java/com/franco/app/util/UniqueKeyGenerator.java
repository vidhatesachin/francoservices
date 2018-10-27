package com.franco.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UniqueKeyGenerator {

	/**
	 * generate unique string
	 * @param date
	 * @return string
	 */
	public static String generateUniqueKey(Date date){
		final SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmSS");
	    date = new Date();
	    final String uniqueString = sdf.format(date);
		return uniqueString;
	}
	
}
