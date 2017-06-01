package cn.edu.zzuli.purchase.model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import cn.edu.zzuli.purchase.service.PurchaseService;
import cn.edu.zzuli.purchase.vo.Purchase;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午8:22:51 TODO
 */
@SuppressWarnings("all")
public class PurchaseTableModel extends AbstractTableModel {

	private Vector<String> columns;
	public static Vector<Vector> rows;
	private Vector<String> row;
	private List<Purchase> Purchases;

	@Override
	public int getRowCount() {

		return rows.size();
	}

	@Override
	public int getColumnCount() {

		return columns.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		return (((Vector) (rows.get(rowIndex))).get(columnIndex));
	}

	@Override

	public String getColumnName(int column) {

		return (String) this.columns.get(column);
	}

	public void initInfo() {

		rows = new Vector<Vector>();
		columns = new Vector<String>();

		columns.add("编号");
		columns.add("客户名");
		columns.add("订单号");
		columns.add("交货日期");
		columns.add("商品名");
		columns.add("金额");
		columns.add("数量");
		columns.add("是否入库");

		PurchaseService service = new PurchaseService();
		Purchases = service.findAll();

		if (Purchases != null) {
			for (Purchase Purchase : Purchases) {

				row = new Vector<String>();
				row.add(Purchase.getId() + "");
				row.add(Purchase.getKhm());
				row.add(Purchase.getOrderNum());
				row.add(Purchase.getPushDate().toString());
				row.add(Purchase.getProductName());
				row.add(Purchase.getPrice() + "");
				row.add(Purchase.getCount() + "");
				if (Purchase.getStatus() == 0) {
					row.add("未入库");
				} else {
					row.add("已入库");
				}
				rows.add(row);
			}
		}
	}

	public PurchaseTableModel(List<Purchase> Purchases) {

		this.Purchases = Purchases;
		rows = new Vector<Vector>();
		columns = new Vector<String>();

		columns.add("编号");
		columns.add("客户名");
		columns.add("订单号");
		columns.add("交货日期");
		columns.add("商品名");
		columns.add("金额");
		columns.add("数量");
		columns.add("是否入库");

		if (Purchases != null) {
			for (Purchase Purchase : Purchases) {

				row = new Vector<String>();
				row.add(Purchase.getId() + "");
				row.add(Purchase.getKhm());
				row.add(Purchase.getOrderNum());
				row.add(Purchase.getPushDate().toString());
				row.add(Purchase.getProductName());
				row.add(Purchase.getPrice() + "");
				row.add(Purchase.getCount() + "");
				if (Purchase.getStatus() == 0) {
					row.add("未入库");
				} else {
					row.add("已入库");
				}
				rows.add(row);
			}
		}
	}

	public PurchaseTableModel() {
		initInfo();
	}
}
