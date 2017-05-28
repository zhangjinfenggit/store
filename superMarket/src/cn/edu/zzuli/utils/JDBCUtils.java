package cn.edu.zzuli.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC 工具类，抽取公共方法
 * 
 * @author seawind
 * 
 */
public class JDBCUtils {
	// 获得数据库连接 --- 通过c3p0连接池
	// 自动读取c3p0-config.xml
	private static DataSource dataSource = new ComboPooledDataSource();

	// 返回数据库连接池
	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
