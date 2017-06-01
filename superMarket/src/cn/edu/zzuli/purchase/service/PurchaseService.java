package cn.edu.zzuli.purchase.service;

import java.util.Date;
import java.util.List;

import cn.edu.zzuli.purchase.dao.PurchaseDao;
import cn.edu.zzuli.purchase.vo.Purchase;
import cn.edu.zzuli.utils.Format;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午8:28:51 TODO
 */
public class PurchaseService {

	public List<Purchase> findAll() {

		PurchaseDao dao = new PurchaseDao();

		return dao.findAll();
	}

	public List<Purchase> getPurchaseByCondition(int condition, String info) {
		PurchaseDao dao = new PurchaseDao();

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

		return dao.getPurchaseByCondition(type, info);

	}

	public void savePurchase(Purchase Purchase) {

		Purchase.setOrderNum(Format.numberFormat());
		Purchase.setPushDate(new Date());
		Purchase.setStatus(0);
		PurchaseDao dao = new PurchaseDao();

		dao.savePurchase(Purchase);

	}

	public Purchase getPurchaseById(String id) {

		PurchaseDao dao = new PurchaseDao();

		Purchase Purchase = dao.getPurchaseById(id);

		return Purchase;
	}

	public void updatePurchase(Purchase Purchase) {

		Purchase.setPushDate(new Date());
		PurchaseDao dao = new PurchaseDao();

		dao.updatePurchase(Purchase);

	}

	public void deletePurchaseById(String id) {
		PurchaseDao dao = new PurchaseDao();

		dao.deletePurchaseById(id);

	}

	public void pushPurchase(String id) {

		PurchaseDao dao = new PurchaseDao();

		dao.pushPurchase(id);
	}

}
