package cn.edu.zzuli.purchase.dao;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import cn.edu.zzuli.dao.BaseDao;
import cn.edu.zzuli.purchase.vo.Purchase;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午8:17:51 TODO
 */
public class PurchaseDao extends BaseDao {

	public List<Purchase> findAll() {

		String sql = "select * from Purchase";

		return queryBeanList(Purchase.class, sql);
	}

	public List<Purchase> getPurchaseByCondition(String type, String info) {

		String sql = "select * from Purchase ";

		if (!StringUtils.isNullOrEmpty(info)) {
			sql += " where  " + type + " like '%" + info + "%'";
		}

		return queryBeanList(Purchase.class, sql);
	}

	public void savePurchase(Purchase Purchase) {

		String sql = "insert into Purchase (khm,orderNum,pushDate,productName,price,count,status) values(?,?,?,?,?,?,?)";

		update(sql, Purchase.getKhm(), Purchase.getOrderNum(), Purchase.getPushDate(), Purchase.getProductName(),
				Purchase.getPrice(), Purchase.getCount(), Purchase.getStatus());
	}

	public Purchase getPurchaseById(String id) {

		String sql = "select * from Purchase where id = ?";

		return queryBean(Purchase.class, sql, id);
	}

	public void updatePurchase(Purchase Purchase) {

		String sql = "update Purchase set khm= ?,productName = ?,price = ?,count = ?  where id = ?";

		update(sql, Purchase.getKhm(), Purchase.getProductName(), Purchase.getPrice(), Purchase.getCount(),
				Purchase.getId());

	}

	public void deletePurchaseById(String id) {

		String sql = "delete from Purchase where id = ?";
		update(sql, id);
	}

	public void pushPurchase(String id) {

		String sql = "update Purchase set status = 1 where id = ?";
		update(sql, id);

	}

}
