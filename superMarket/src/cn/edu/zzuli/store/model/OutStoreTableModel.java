package cn.edu.zzuli.store.model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import cn.edu.zzuli.store.service.OutStoreService;
import cn.edu.zzuli.store.vo.OutStore;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年6月1日下午3:19:14 TODO
 */
@SuppressWarnings("all")
public class OutStoreTableModel extends AbstractTableModel {

	private Vector<String> columns;
	public static Vector<Vector> rows;
	private Vector<String> row;
	private List<OutStore> OutStores;

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

		columns.add("商品名");
		columns.add("入库时间");
		columns.add("重量");
		columns.add("备注");

		OutStoreService service = new OutStoreService();
		OutStores = service.findAll();

		if (OutStores != null) {
			for (OutStore OutStore : OutStores) {

				row = new Vector<String>();
				row.add(OutStore.getId() + "");
				row.add(OutStore.getDid() + "");

				row.add(OutStore.getWareName());
				row.add(OutStore.getOutTime());
				row.add(OutStore.getWeight() + "");
				row.add(OutStore.getRemark());

				rows.add(row);
			}
		}
	}

	public OutStoreTableModel(List<OutStore> OutStores) {

		this.OutStores = OutStores;
		rows = new Vector<Vector>();
		columns = new Vector<String>();

		columns.add("编号");
		columns.add("仓库编号");

		columns.add("商品名");
		columns.add("出库时间");
		columns.add("重量");
		columns.add("备注");

		if (OutStores != null) {
			for (OutStore OutStore : OutStores) {

				row = new Vector<String>();
				row.add(OutStore.getId() + "");
				row.add(OutStore.getDid() + "");

				row.add(OutStore.getWareName());
				row.add(OutStore.getOutTime());
				row.add(OutStore.getWeight() + "");
				row.add(OutStore.getRemark());

				rows.add(row);
			}
		}
	}

	public OutStoreTableModel() {
		initInfo();
	}
}
