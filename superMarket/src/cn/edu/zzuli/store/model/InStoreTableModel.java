package cn.edu.zzuli.store.model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import cn.edu.zzuli.store.service.InStoreService;
import cn.edu.zzuli.store.vo.InStore;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午8:22:51 TODO
 */
@SuppressWarnings("all")
public class InStoreTableModel extends AbstractTableModel {

	private Vector<String> columns;
	public static Vector<Vector> rows;
	private Vector<String> row;
	private List<InStore> InStores;

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
		columns.add("仓库编号");
		columns.add("订单号");
		columns.add("商品名");
		columns.add("入库时间");
		columns.add("重量");
		columns.add("备注");

		InStoreService service = new InStoreService();
		InStores = service.findAll();

		if (InStores != null) {
			for (InStore InStore : InStores) {

				row = new Vector<String>();
				row.add(InStore.getId() + "");
				row.add(InStore.getDid() + "");
				row.add(InStore.getOid());
				row.add(InStore.getWareName());
				row.add(InStore.getJoinTime());
				row.add(InStore.getWeight() + "");
				row.add(InStore.getRemark());

				rows.add(row);
			}
		}
	}

	public InStoreTableModel(List<InStore> InStores) {

		this.InStores = InStores;
		rows = new Vector<Vector>();
		columns = new Vector<String>();

		columns.add("编号");
		columns.add("仓库编号");
		columns.add("订单号");
		columns.add("商品名");
		columns.add("入库时间");
		columns.add("重量");
		columns.add("备注");

		if (InStores != null) {
			for (InStore InStore : InStores) {

				row = new Vector<String>();
				row.add(InStore.getId() + "");
				row.add(InStore.getDid() + "");
				row.add(InStore.getOid());
				row.add(InStore.getWareName());
				row.add(InStore.getJoinTime());
				row.add(InStore.getWeight() + "");
				row.add(InStore.getRemark());

				rows.add(row);
			}
		}
	}

	public InStoreTableModel() {
		initInfo();
	}
}
