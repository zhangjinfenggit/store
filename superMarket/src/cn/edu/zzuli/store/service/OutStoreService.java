package cn.edu.zzuli.store.service;

import java.util.List;

import cn.edu.zzuli.store.dao.OutStoreDao;
import cn.edu.zzuli.store.vo.OutStore;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年6月1日下午3:17:50 TODO
 */
public class OutStoreService {

	public List<OutStore> findAll() {

		OutStoreDao dao = new OutStoreDao();

		return dao.findAll();
	}

	public List<OutStore> getOutStoreByCondition(int condition, String info) {
		OutStoreDao dao = new OutStoreDao();

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

		return dao.getOutStoreByCondition(type, info);

	}

	public void saveOutStore(OutStore OutStore) {

		OutStoreDao dao = new OutStoreDao();

		dao.saveOutStore(OutStore);

	}

	public OutStore getOutStoreById(String id) {

		OutStoreDao dao = new OutStoreDao();

		OutStore OutStore = dao.getOutStoreById(id);

		return OutStore;
	}

	public void updateOutStore(OutStore OutStore) {

		OutStoreDao dao = new OutStoreDao();

		dao.updateOutStore(OutStore);

	}

	public void deleteOutStoreById(String id) {
		OutStoreDao dao = new OutStoreDao();

		dao.deleteOutStoreById(id);

	}

	public void pushOutStore(String id) {

		OutStoreDao dao = new OutStoreDao();

		dao.pushOutStore(id);
	}

	public List<OutStore> getOutStoreByCondition(String did, String joinDate) {
		OutStoreDao dao = new OutStoreDao();

		return dao.getOutStoreByCondition(did, joinDate);
	}

}
