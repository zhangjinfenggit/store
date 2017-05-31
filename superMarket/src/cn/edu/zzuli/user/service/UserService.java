package cn.edu.zzuli.user.service;

import cn.edu.zzuli.user.dao.UserDao;
import cn.edu.zzuli.user.vo.User;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月24日上午10:17:1 TODO
 */
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
