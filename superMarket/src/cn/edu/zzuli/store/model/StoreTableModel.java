package cn.edu.zzuli.store.model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import cn.edu.zzuli.store.service.StoreService;
import cn.edu.zzuli.store.vo.Store;

@SuppressWarnings("all")
public class StoreTableModel extends AbstractTableModel {

	private Vector<String> columns;
	public static Vector<Vector> rows;
	private Vector<String> row;
	private List<Store> Stores;

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

		StoreService service = new StoreService();
		Stores = service.findAll();

		if (Stores != null) {
			for (Store Store : Stores) {

				row = new Vector<String>();
				row.add(Store.getId() + "");
				row.add(Store.getKhm());
				row.add(Store.getOrderNum());
				row.add(Store.getPushDate().toString());
				row.add(Store.getProductName());
				row.add(Store.getPrice() + "");
				row.add(Store.getCount() + "");
				if (Store.getStatus() == 0) {
					row.add("未入库");
				} else {
					row.add("已入库");
				}
				rows.add(row);
			}
		}
	}

	public StoreTableModel(List<Store> Stores) {

		this.Stores = Stores;
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

		if (Stores != null) {
			for (Store Store : Stores) {

				row = new Vector<String>();
				row.add(Store.getId() + "");
				row.add(Store.getKhm());
				row.add(Store.getOrderNum());
				row.add(Store.getPushDate().toString());
				row.add(Store.getProductName());
				row.add(Store.getPrice() + "");
				row.add(Store.getCount() + "");
				if (Store.getStatus() == 0) {
					row.add("未入库");
				} else {
					row.add("已入库");
				}
				rows.add(row);
			}
		}
	}

	public StoreTableModel() {
		initInfo();
	}
}
