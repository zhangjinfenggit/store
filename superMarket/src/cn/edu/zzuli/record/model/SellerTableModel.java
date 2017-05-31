package cn.edu.zzuli.record.model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import cn.edu.zzuli.record.service.SellerService;
import cn.edu.zzuli.record.vo.Seller;

@SuppressWarnings("all")
/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日下午3:23:36 TODO
 */
public class SellerTableModel extends AbstractTableModel {

	private Vector<String> columns;
	public static Vector<Vector> rows;
	private Vector<String> row;
	private List<Seller> Sellers;

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
		columns.add("销售商名");
		columns.add("客户名");
		columns.add("地址");
		columns.add("联系人");
		columns.add("联系电话");
		columns.add("传真");
		columns.add("邮编");
		columns.add("银行账号");
		columns.add("网址");
		columns.add("Email");
		columns.add("备注");

		SellerService service = new SellerService();
		Sellers = service.findAll();

		if (Sellers != null) {
			for (Seller Seller : Sellers) {

				row = new Vector<String>();
				row.add(Seller.getSid());
				row.add(Seller.getKhm());
				row.add(Seller.getAddress());
				row.add(Seller.getConnecter());
				row.add(Seller.getContel());
				row.add(Seller.getAddress());
				row.add(Seller.getFax());
				row.add(Seller.getPostCode());
				row.add(Seller.getAccount());
				row.add(Seller.getWsite());
				row.add(Seller.getEmail());
				row.add(Seller.getDescription());
				rows.add(row);
			}
		}
	}

	public SellerTableModel(List<Seller> Sellers) {

		this.Sellers = Sellers;
		rows = new Vector<Vector>();
		columns = new Vector<String>();

		columns.add("编号");
		columns.add("销售商名");
		columns.add("客户名");
		columns.add("地址");
		columns.add("联系人");
		columns.add("联系电话");
		columns.add("传真");
		columns.add("邮编");
		columns.add("银行账号");
		columns.add("网址");
		columns.add("Email");
		columns.add("备注");

		if (Sellers != null) {
			for (Seller Seller : Sellers) {

				row = new Vector<String>();
				row.add(Seller.getSid());
				row.add(Seller.getKhm());
				row.add(Seller.getAddress());
				row.add(Seller.getConnecter());
				row.add(Seller.getContel());
				row.add(Seller.getAddress());
				row.add(Seller.getFax());
				row.add(Seller.getPostCode());
				row.add(Seller.getAccount());
				row.add(Seller.getWsite());
				row.add(Seller.getEmail());
				row.add(Seller.getDescription());
				rows.add(row);
			}
		}
	}

	public SellerTableModel() {
		initInfo();
	}
}
