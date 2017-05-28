package cn.edu.zzuli.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.zzuli.utils.JDBCUtils;

public class BaseDao {
	Connection connection = null;
	QueryRunner queryRunner = null;

	// 增删改数据
	public int update(String sql, Object... params) {
		int flag = 0;
		try {
			connection = JDBCUtils.getConnection();
			queryRunner = new QueryRunner();

			flag = queryRunner.update(connection, sql, params);

			connection.setAutoCommit(false);

			DbUtils.commitAndCloseQuietly(connection);
		} catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(connection);
			e.printStackTrace();
		}
		return flag;
	}

	// 查找数据
	public <T> T queryBean(Class<T> c, String sql, Object... params) {

		T t = null;
		try {
			connection = JDBCUtils.getConnection();
			connection.setAutoCommit(false);
			queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			t = queryRunner.query(sql, new BeanHandler<T>(c), params);
			DbUtils.commitAndClose(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	// 查找数据
	public <T> List<T> queryBeanList(Class<T> c, String sql, Object... params) {
		List<T> list = null;
		try {
			connection = JDBCUtils.getConnection();
			connection.setAutoCommit(false);
			queryRunner = new QueryRunner(JDBCUtils.getDataSource());

			list = queryRunner.query(sql, new BeanListHandler<T>(c), params);

			DbUtils.commitAndClose(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
