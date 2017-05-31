package cn.edu.zzuli.store.service;

import java.util.Date;
import java.util.List;

import cn.edu.zzuli.store.dao.StoreDao;
import cn.edu.zzuli.store.vo.Store;
import cn.edu.zzuli.utils.Format;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午8:28:51 TODO
 */
public class StoreService {

	public List<Store> findAll() {

		StoreDao dao = new StoreDao();

		return dao.findAll();
	}

	public List<Store> getStoreByCondition(int condition, String info) {
		StoreDao dao = new StoreDao();

		String type = "";

		if (condition == 0) {
			type = "id";
		} else if (condition == 1) {
			type = "khm";
		} else if (condition == 2) {
			type = "orderNum";
		} else if (condition == 3) {
			type = "productName";
		} else if (condition == 4) {
			type = "pushDate";
		}

		return dao.getStoreByCondition(type, info);

	}

	public void saveStore(Store store) {

		store.setOrderNum(Format.numberFormat());
		store.setPushDate(new Date());
		store.setStatus(0);
		StoreDao dao = new StoreDao();

		dao.saveStore(store);

	}

	public Store getStoreById(String id) {

		StoreDao dao = new StoreDao();

		Store store = dao.getStoreById(id);

		return store;
	}

	public void updateStore(Store store) {

		store.setPushDate(new Date());
		StoreDao dao = new StoreDao();

		dao.updateStore(store);

	}

	public void deleteStoreById(String id) {
		StoreDao dao = new StoreDao();

		dao.deleteStoreById(id);

	}

	public void pushStore(String id) {

		StoreDao dao = new StoreDao();

		dao.pushStore(id);
	}

}
