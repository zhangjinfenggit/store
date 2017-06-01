package cn.edu.zzuli.emp.model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import cn.edu.zzuli.emp.service.EmpService;
import cn.edu.zzuli.emp.vo.Emp;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日下午3:39:53 TODO
 */
@SuppressWarnings("all")
public class EmpTableModel extends AbstractTableModel {

	private Vector<String> columns;
	public static Vector<Vector> rows;
	private Vector<String> row;
	private List<Emp> Emps;

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
		columns.add("姓名");
		columns.add("年龄");
		columns.add("性别");
		columns.add("部门");
		columns.add("职务");
		columns.add("手机");
		columns.add("办公电话");
		columns.add("传真");
		columns.add("邮箱");
		columns.add("住址");

		EmpService service = new EmpService();
		Emps = service.findAll();

		if (Emps != null) {
			for (Emp Emp : Emps) {

				row = new Vector<String>();
				row.add(Emp.getId() + "");
				row.add(Emp.getName());
				row.add(Emp.getAge() + "");
				row.add(Emp.getSex());
				row.add(Emp.getDept() + "");
				row.add(Emp.getDuty());
				row.add(Emp.getPhone());
				row.add(Emp.getTel());
				row.add(Emp.getFax());
				row.add(Emp.getEmail());
				row.add(Emp.getAddress());
				rows.add(row);
			}
		}
	}

	public EmpTableModel(List<Emp> Emps) {

		this.Emps = Emps;
		rows = new Vector<Vector>();
		columns = new Vector<String>();

		columns.add("编号");
		columns.add("姓名");
		columns.add("年龄");
		columns.add("性别");
		columns.add("部门");
		columns.add("职务");
		columns.add("手机");
		columns.add("办公电话");
		columns.add("传真");
		columns.add("邮箱");
		columns.add("住址");

		if (Emps != null) {
			for (Emp Emp : Emps) {

				row = new Vector<String>();
				row.add(Emp.getId() + "");
				row.add(Emp.getName());
				row.add(Emp.getAge() + "");
				row.add(Emp.getSex());
				row.add(Emp.getDept() + "");
				row.add(Emp.getDuty());
				row.add(Emp.getPhone());
				row.add(Emp.getTel());
				row.add(Emp.getFax());
				row.add(Emp.getEmail());
				row.add(Emp.getAddress());
				rows.add(row);
			}
		}
	}

	public EmpTableModel() {
		initInfo();
	}
}
