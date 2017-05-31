package cn.edu.zzuli.store.dao;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import cn.edu.zzuli.dao.BaseDao;
import cn.edu.zzuli.store.vo.Store;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午8:17:51 TODO
 */
public class StoreDao extends BaseDao {

	public List<Store> findAll() {

		String sql = "select * from store";

		return queryBeanList(Store.class, sql);
	}

	public List<Store> getStoreByCondition(String type, String info) {

		String sql = "select * from store ";

		if (!StringUtils.isNullOrEmpty(info)) {
			sql += " where  " + type + " like '%" + info + "%'";
		}

		return queryBeanList(Store.class, sql);
	}

	public void saveStore(Store store) {

		String sql = "insert into store (khm,orderNum,pushDate,productName,price,count,status) values(?,?,?,?,?,?,?)";

		update(sql, store.getKhm(), store.getOrderNum(), store.getPushDate(), store.getProductName(), store.getPrice(),
				store.getCount(), store.getStatus());
	}

	public Store getStoreById(String id) {

		String sql = "select * from store where id = ?";

		return queryBean(Store.class, sql, id);
	}

	public void updateStore(Store store) {

		String sql = "update store set khm= ?,productName = ?,price = ?,count = ?  where id = ?";

		update(sql, store.getKhm(), store.getProductName(), store.getPrice(), store.getCount(), store.getId());

	}

	public void deleteStoreById(String id) {

		String sql = "delete from store where id = ?";
		update(sql, id);
	}

	public void pushStore(String id) {

		String sql = "update store set status = 1 where id = ?";
		update(sql, id);

	}

}
