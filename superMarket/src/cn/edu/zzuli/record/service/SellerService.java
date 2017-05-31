package cn.edu.zzuli.record.service;

import java.util.List;

import cn.edu.zzuli.record.dao.SellerDao;
import cn.edu.zzuli.record.vo.Seller;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日下午3:23:16 TODO
 */
public class SellerService {

	public List<Seller> findAll() {

		SellerDao dao = new SellerDao();

		return dao.findAll();
	}

	public List<Seller> getSellerByNameAndAddress(String name, String address) {

		SellerDao dao = new SellerDao();

		List<Seller> list = dao.getSellerByNameAndAddress(name, address);

		return list;
	}

	public void saveSeller(Seller seller) {

		SellerDao dao = new SellerDao();

		dao.save(seller);
	}

	public void deleteSellerById(String id) {

		SellerDao dao = new SellerDao();

		dao.deleteSellerById(id);
	}

	public Seller getSellerById(String id) {
		SellerDao dao = new SellerDao();

		return dao.getSellerById(id);
	}

	public void updateSeller(Seller seller) {
		SellerDao dao = new SellerDao();

		dao.updateSeller(seller);
	}

}
