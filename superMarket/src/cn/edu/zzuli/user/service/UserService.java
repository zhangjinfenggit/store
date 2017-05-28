package cn.edu.zzuli.user.service;

import cn.edu.zzuli.user.dao.UserDao;
import cn.edu.zzuli.user.vo.User;

public class UserService {

	/**
	 * 用户登录
	 * 
	 * @param username
	 *            用户名
	 * @param pwd
	 *            密码
	 * @return boolean
	 */
	public boolean cheakAccount(String username, String pwd) {

		UserDao dao = new UserDao();
		String sql = "select *from user where username=? and password = ?";

		User user = dao.queryBean(User.class, sql, username, pwd);

		if (user != null) {
			return true;
		}

		return false;
	}

}
