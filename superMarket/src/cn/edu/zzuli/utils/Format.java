package cn.edu.zzuli.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Format {

	public static String dateFormat() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

		return sdf.format(new Date());
	}

	public static String numberFormat() {

		return UUID.randomUUID().toString().replace("-", "").substring(12);
	}
}
