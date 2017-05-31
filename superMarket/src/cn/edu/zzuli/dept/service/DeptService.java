package cn.edu.zzuli.dept.service;

import java.util.List;

import cn.edu.zzuli.dept.dao.DeptDao;
import cn.edu.zzuli.dept.vo.Dept;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日下午3:58:41 TODO
 */
public class DeptService {

	public List<Dept> findAll() {
		DeptDao dao = new DeptDao();

		return dao.findAll();
	}

	public List<Dept> getDeptByCondition(int condition, String info) {

		String type = "";
		if (condition == 0) {
			type = "name";
		} else if (condition == 1) {
			type = "principal";
		}
		DeptDao dao = new DeptDao();

		return dao.getDeptByCondition(type, info);
	}

	public void saveDept(Dept dept) {

		DeptDao dao = new DeptDao();
		dao.saveDept(dept);
	}

	public Dept getDeptById(String id) {

		DeptDao dao = new DeptDao();
		return dao.getDeptById(id);
	}

	public void updateDept(Dept dept) {

		DeptDao dao = new DeptDao();
		dao.updateDept(dept);
	}

	public void deleteDeptById(String id) {

		DeptDao dao = new DeptDao();
		dao.deleteDeptById(id);

	}

}
