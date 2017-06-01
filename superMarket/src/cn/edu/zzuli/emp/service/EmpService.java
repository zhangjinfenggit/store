package cn.edu.zzuli.emp.service;

import java.util.List;

import cn.edu.zzuli.emp.dao.EmpDao;
import cn.edu.zzuli.emp.vo.Emp;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日下午5:40:43 TODO
 */
public class EmpService {

	public List<Emp> findAll() {

		EmpDao dao = new EmpDao();

		return dao.findAll();
	}

	public List<Emp> getEmpByCondition(int condition, String info) {

		String type = "";
		if (condition == 0) {
			type += "dept";
		} else if (condition == 1) {
			type += "phone";
		} else if (condition == 2) {
			type += "name";
		} else if (condition == 3) {
			type += "duty";
		}

		EmpDao dao = new EmpDao();

		return dao.getEmpByCondition(type, info);
	}

	public void saveEmp(Emp emp) {

		EmpDao dao = new EmpDao();
		dao.saveEmp(emp);

	}

	public cn.edu.zzuli.emp.vo.Emp getEmpById(String id) {

		EmpDao dao = new EmpDao();

		return dao.getEmpById(id);
	}

	public void updateEmp(cn.edu.zzuli.emp.vo.Emp emp) {

		EmpDao dao = new EmpDao();

		dao.updateEmp(emp);
	}

	public void deleteEmpById(String id) {
		EmpDao dao = new EmpDao();

		dao.deleteEmpById(id);
	}

}
