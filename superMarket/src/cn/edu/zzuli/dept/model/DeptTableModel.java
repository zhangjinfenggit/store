package cn.edu.zzuli.dept.model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import cn.edu.zzuli.dept.service.DeptService;
import cn.edu.zzuli.dept.vo.Dept;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日下午3:39:53 TODO
 */
@SuppressWarnings("all")
public class DeptTableModel extends AbstractTableModel {

	private Vector<String> columns;
	public static Vector<Vector> rows;
	private Vector<String> row;
	private List<Dept> Depts;

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
		columns.add("部门名称");
		columns.add("负责人");
		columns.add("描述");

		DeptService service = new DeptService();
		Depts = service.findAll();

		if (Depts != null) {
			for (Dept Dept : Depts) {

				row = new Vector<String>();
				row.add(Dept.getId() + "");
				row.add(Dept.getName());
				row.add(Dept.getPrincipal());
				row.add(Dept.getDescription());
				rows.add(row);
			}
		}
	}

	public DeptTableModel(List<Dept> Depts) {

		this.Depts = Depts;
		rows = new Vector<Vector>();
		columns = new Vector<String>();

		columns.add("编号");
		columns.add("部门名称");
		columns.add("负责人");
		columns.add("描述");

		if (Depts != null) {
			for (Dept Dept : Depts) {

				row = new Vector<String>();
				row.add(Dept.getId() + "");
				row.add(Dept.getName());
				row.add(Dept.getPrincipal());
				row.add(Dept.getDescription());
				rows.add(row);
			}
		}
	}

	public DeptTableModel() {
		initInfo();
	}
}
