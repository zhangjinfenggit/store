package cn.edu.zzuli.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月30日下午8:12:04 TODO
 */
public class Format {

	public static String dateFormat() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

		return sdf.format(new Date());
	}

	public static String numberFormat() {

		return UUID.randomUUID().toString().replace("-", "").substring(12);
	}

	public static String getLocalDate() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  hh:mm:ss");

		return sdf.format(new Date());
	}
}
