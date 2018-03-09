package com.yc.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("dateConverter")
public class DateConverter implements Converter<String
, Date> {

	@Override
	public Date convert(String str) {
		Date date = null;
		SimpleDateFormat sdf = null;
		if(str.contains(":")) {
			sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else if(!str.contains(":")) {
			sdf=new SimpleDateFormat("yyyy-MM-dd");
		}else if(str.contains("/")) {
			sdf=new SimpleDateFormat("yyyy/MM/dd");
		}
		
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
