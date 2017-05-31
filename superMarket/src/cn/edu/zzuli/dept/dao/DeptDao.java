package cn.edu.zzuli.dept.dao;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import cn.edu.zzuli.dao.BaseDao;
import cn.edu.zzuli.dept.vo.Dept;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日下午3:15:51 TODO
 */
public class DeptDao extends BaseDao {

	public List<Dept> findAll() {

		String sql = "select * from dept";

		return queryBeanList(Dept.class, sql);
	}

	public List<Dept> getDeptByCondition(String type, String info) {

		String sql = "select * from dept";

		if (!StringUtils.isNullOrEmpty(info)) {

			sql += " where " + type + " like '%" + info + "%'";
		}

		return queryBeanList(Dept.class, sql);
	}

	public void saveDept(Dept dept) {

		String sql = "insert into dept (name,principal,description) value(?,?,?)";

		update(sql, dept.getName(), dept.getPrincipal(), dept.getDescription());

	}

	public Dept getDeptById(String id) {

		String sql = "select * from dept where id = ?";

		return queryBean(Dept.class, sql, id);
	}

	public void updateDept(Dept dept) {

		String sql = "update dept set name = ?,principal = ?,description = ? where id = ?";

		update(sql, dept.getName(), dept.getPrincipal(), dept.getDescription(), dept.getId());

	}

	public void deleteDeptById(String id) {

		String sql = "delete from dept where id = ?";

		update(sql, id);
	}

}
