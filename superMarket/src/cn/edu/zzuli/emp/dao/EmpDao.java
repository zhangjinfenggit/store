package cn.edu.zzuli.emp.dao;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import cn.edu.zzuli.dao.BaseDao;
import cn.edu.zzuli.emp.vo.Emp;

public class EmpDao extends BaseDao {

	public List<Emp> findAll() {

		String sql = "select * from emp";

		return queryBeanList(Emp.class, sql);
	}

	public List<Emp> getEmpByCondition(String type, String info) {
		String sql = "select * from emp";

		if (!StringUtils.isNullOrEmpty(info)) {
			sql += " where " + type + " like '%" + info + "%'";
		}

		return queryBeanList(Emp.class, sql);
	}

	public void saveEmp(Emp emp) {

		String sql = "insert into emp(name,age,sex,dept,duty,tel,fax,address,email,phone) values(?,?,?,?,?,?,?,?,?,?)";

		update(sql, emp.getName(), emp.getAge(), emp.getSex(), emp.getDept(), emp.getDuty(), emp.getTel(), emp.getFax(),
				emp.getAddress(), emp.getEmail(), emp.getPhone());
	}

	public Emp getEmpById(String id) {

		String sql = "select * from emp where id = ?";

		return queryBean(Emp.class, sql, id);
	}

	public void updateEmp(Emp emp) {

		String sql = "update emp set name=?,age=?,sex=?,dept=?,duty=?,tel=?,fax=?,address=?,email=?,phone=? where id = ?";

		update(sql, emp.getName(), emp.getAge(), emp.getSex(), emp.getDept(), emp.getDuty(), emp.getTel(), emp.getFax(),
				emp.getAddress(), emp.getEmail(), emp.getPhone(), emp.getId());
	}

	public void deleteEmpById(String id) {

		String sql = "delete from emp where id = ?";
		update(sql, id);
	}

}
