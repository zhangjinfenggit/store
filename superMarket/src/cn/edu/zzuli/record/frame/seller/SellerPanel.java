package cn.edu.zzuli.record.frame.seller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import cn.edu.zzuli.record.model.SellerTableModel;
import cn.edu.zzuli.record.service.SellerService;
import cn.edu.zzuli.record.vo.Seller;

public class SellerPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	public JTable table = null;
	public SellerService service;

	public SellerPanel(final JFrame frame) {

		this.setSize(994, 577);
		setLayout(null);

		JPanel panel = new SellerMenu();
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

		JLabel label = new JLabel("销售商名称");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(22, 29, 75, 23);
		panel_2.add(label);

		textField = new JTextField();
		textField.setBounds(97, 29, 113, 23);
		panel_2.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("地址");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(233, 29, 40, 23);
		panel_2.add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(270, 29, 100, 23);
		panel_2.add(textField_1);

		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service = new SellerService();
				String name = textField.getText();
				String address = textField_1.getText();

				List<Seller> sellers = service.getSellerByNameAndAddress(name, address);

				table.setModel(new SellerTableModel(sellers));

				table.repaint();
			}
		});
		btnNewButton.setBounds(390, 29, 75, 23);
		panel_2.add(btnNewButton);

		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new SellerAddDialog(frame, table);
			}
		});
		button.setBounds(469, 29, 75, 23);
		panel_2.add(button);

		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(getThis(), "请选择一行");
					return;
				}
				String id = ((SellerTableModel.rows.get(row)).get(0).toString());

				new SellerAlterDialog(frame, table, id);
			}
		});
		button_1.setBounds(548, 29, 75, 23);
		panel_2.add(button_1);

		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(getThis(), "请选择一行");
					return;
				}
				String id = ((SellerTableModel.rows.get(row)).get(0).toString());
				SellerService service = new SellerService();
				service.deleteSellerById(id);
				table.setModel(new SellerTableModel());
				table.repaint();
			}
		});
		button_2.setBounds(627, 29, 80, 23);
		panel_2.add(button_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 83, 822, 494);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		table = new JTable(new SellerTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new TitledBorder(new EtchedBorder()));
		scrollPane.setBounds(0, 0, 822, 494);
		panel_3.add(scrollPane);

	}

	public JPanel getThis() {
		return this;
	}

}
