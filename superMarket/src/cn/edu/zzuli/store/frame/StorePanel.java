package cn.edu.zzuli.store.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import cn.edu.zzuli.store.model.StoreTableModel;
import cn.edu.zzuli.store.service.StoreService;
import cn.edu.zzuli.store.vo.Store;

public class StorePanel extends JPanel {
	private JTextField textField_1;
	public JTable table = null;
	public StoreService service;
	private JComboBox comboBox = null;

	public StorePanel(final JFrame frame) {
		service = new StoreService();
		this.setSize(994, 577);
		setLayout(null);

		JPanel panel = new StoreMenu();
		panel.setBorder(new TitledBorder(new EtchedBorder()));
		panel.setBounds(0, 0, 175, 577);
		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder()));
		panel_1.setBounds(172, 0, 822, 577);
		add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder()));
		panel_2.setBounds(0, 0, 822, 83);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("客户名称");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(31, 29, 75, 23);
		panel_2.add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(192, 29, 141, 23);
		panel_2.add(textField_1);

		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int condition = comboBox.getSelectedIndex();
				String info = textField_1.getText();
				List<Store> Stores = service.getStoreByCondition(condition, info);

				table.setModel(new StoreTableModel(Stores));

				table.repaint();
			}
		});
		btnNewButton.setBounds(343, 29, 75, 23);
		panel_2.add(btnNewButton);

		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new StoreAddDialog(frame, table);
			}
		});
		button.setBounds(428, 29, 75, 23);
		panel_2.add(button);

		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(getThis(), "请选择一行");
					return;
				}
				String id = ((StoreTableModel.rows.get(row)).get(0).toString());

				new StoreAlterDialog(frame, table, id);
			}
		});
		button_1.setBounds(513, 29, 75, 23);
		panel_2.add(button_1);

		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(getThis(), "请选择一行");
					return;
				}
				String id = ((StoreTableModel.rows.get(row)).get(0).toString());
				service.deleteStoreById(id);
				table.setModel(new StoreTableModel());
				table.repaint();
			}
		});
		button_2.setBounds(598, 29, 80, 23);
		panel_2.add(button_2);
		String[] s = { "编号", "客户名", "订单号", "商品名", "交货日期" };
		comboBox = new JComboBox(s);

		comboBox.setBounds(96, 30, 80, 21);
		panel_2.add(comboBox);

		JButton button_3 = new JButton("入库");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(getThis(), "请选择一行");
					return;
				}
				String id = ((StoreTableModel.rows.get(row)).get(0).toString());
				int confirm = JOptionPane.showConfirmDialog(getThis(), "确定要入库么？");

				if (confirm == 0) {
					service.pushStore(id);
					table.setModel(new StoreTableModel());
					table.repaint();
				}

			}
		});
		button_3.setBounds(688, 29, 80, 23);
		panel_2.add(button_3);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 83, 822, 494);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		table = new JTable(new StoreTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new TitledBorder(new EtchedBorder()));
		scrollPane.setBounds(0, 0, 822, 494);
		panel_3.add(scrollPane);

	}

	public JPanel getThis() {
		return this;
	}
}
