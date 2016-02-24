package com.pd.app;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dozer.CustomConverter;

/**
 * 
 * @author prakash_dayaramani
 *
 */
public class CustomTimestampConverter implements CustomConverter {

	private static final String[] formats = { "yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:ssZ",
			"yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
			"yyyy-MM-dd HH:mm:ss", "MM/dd/yyyy HH:mm:ss", "MM/dd/yyyy'T'HH:mm:ss.SSS'Z'", "MM/dd/yyyy'T'HH:mm:ss.SSSZ",
			"MM/dd/yyyy'T'HH:mm:ss.SSS", "MM/dd/yyyy'T'HH:mm:ssZ", "MM/dd/yyyy'T'HH:mm:ss", "yyyy:MM:dd HH:mm:ss",
			"yyyyMMdd", "hh:mm:ss", "EEE, dd MMM yyyy HH:mm:ss z", "yyyy.MM.dd G 'at' HH:mm:ss z", "EEE, MMM d, ''yy",
			"h:mm a", "hh 'o''clock' a, zzzz", "K:mm a, z", "yyyyy.MMMMM.dd GGG hh:mm aaa",
			"EEE, d MMM yyyy HH:mm:ss Z","yyMMddHHmmssZ","yyyy-MM-dd'T'HH:mm:ss.SSSXXX","YYYY-'W'ww-u" };

	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		// Already tried DateTimeConversion utils from Apache,Dozer and Spring
		// those are useless in this scenario
		if (sourceFieldValue == null) {
			return null;
		}
		if (sourceFieldValue instanceof String) {
			String s = (String) sourceFieldValue;
			return parse(s);
		}

		return null;
	}

	public static Timestamp parse(String d) {
		if (d != null) {
			for (String parse : formats) {
				SimpleDateFormat sdf = new SimpleDateFormat(parse);
				try {
					Date parsedDate = sdf.parse(d);
					if (parsedDate != null) {
						return new Timestamp(parsedDate.getTime());
					}
				} catch (ParseException e) {
					// Do nothing because next format might give us a value
				}
			}
		}

		// None of the formats gave value, throw runtime exception
		throw new RuntimeException(
				"No format found for timestamp value " + d + " please define this format in CustomTimeStampConverter");
	}

}
