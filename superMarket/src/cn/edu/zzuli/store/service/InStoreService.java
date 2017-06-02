package cn.edu.zzuli.store.service;

import java.util.List;

import cn.edu.zzuli.store.dao.InStoreDao;
import cn.edu.zzuli.store.vo.InStore;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年6月1日下午3:18:05 TODO
 */

public class InStoreService {

	public List<InStore> findAll() {

		InStoreDao dao = new InStoreDao();

		return dao.findAll();
	}

	public List<InStore> getInStoreByCondition(int condition, String info) {
		InStoreDao dao = new InStoreDao();

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

		return dao.getInStoreByCondition(type, info);

	}

	public void saveInStore(InStore InStore) {

		InStoreDao dao = new InStoreDao();

		dao.saveInStore(InStore);

	}

	public InStore getInStoreById(String id) {

		InStoreDao dao = new InStoreDao();

		InStore InStore = dao.getInStoreById(id);

		return InStore;
	}

	public void updateInStore(InStore InStore) {

		InStoreDao dao = new InStoreDao();

		dao.updateInStore(InStore);

	}

	public void deleteInStoreById(String id) {
		InStoreDao dao = new InStoreDao();

		dao.deleteInStoreById(id);

	}

	public void pushInStore(String id) {

		InStoreDao dao = new InStoreDao();

		dao.pushInStore(id);
	}

	public List<InStore> getInStoreByCondition(String did, String joinDate) {
		InStoreDao dao = new InStoreDao();

		return dao.getInStoreByCondition(did, joinDate);
	}

}
