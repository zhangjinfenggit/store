package cn.edu.zzuli.record.dao;

import java.util.List;

import cn.edu.zzuli.dao.BaseDao;
import cn.edu.zzuli.record.vo.Seller;

public class SellerDao extends BaseDao {

	public List<Seller> findAll() {

		String sql = "select * from seller";

		return queryBeanList(Seller.class, sql);
	}

	public List<Seller> getSellerByNameAndAddress(String name, String address) {

		String sql = "select * from seller where name like '%" + name + "%' and address like '%" + address + "%'";

		return queryBeanList(Seller.class, sql);
	}

	public void save(Seller seller) {

		String sql = "insert into seller (name,khm,address,connecter,contel,fax,email,wsite,account,description,postCode) values(?,?,?,?,?,?,?,?,?,?,?)";

		update(sql, seller.getName(), seller.getKhm(), seller.getAddress(), seller.getConnecter(), seller.getContel(),
				seller.getFax(), seller.getEmail(), seller.getWsite(), seller.getAccount(), seller.getDescription(),
				seller.getPostCode());
	}

	public void deleteSellerById(String id) {

		String sql = "delete from seller where sid = ?";

		update(sql, id);
	}

	public Seller getSellerById(String id) {

		String sql = "select * from seller where sid = ?";

		return queryBean(Seller.class, sql, id);

	}

	public void updateSeller(Seller seller) {

		String sql = "update seller set name=?,khm=?,address=?,connecter=?,contel=?,fax=?,email=?,wsite=?,account=?,description=?,postCode=?  where sid = ?";

		update(sql, seller.getName(), seller.getKhm(), seller.getAddress(), seller.getConnecter(), seller.getContel(),
				seller.getFax(), seller.getEmail(), seller.getWsite(), seller.getAccount(), seller.getDescription(),
				seller.getPostCode(), seller.getSid());

	}

}
