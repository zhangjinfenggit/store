package cn.edu.zzuli.store.frame.outStore;

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

import cn.edu.zzuli.store.model.OutStoreTableModel;
import cn.edu.zzuli.store.service.OutStoreService;
import cn.edu.zzuli.store.vo.OutStore;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午11:17:51 TODO
 */
public class OutStorePanel extends JPanel {
	private JTextField textField_1;
	public JTable table = null;
	public OutStoreService service;
	private JTextField textField;

	public OutStorePanel(final JFrame frame) {
		service = new OutStoreService();
		this.setBounds(0, 0, 818, 577);
		setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder()));
		panel_1.setBounds(0, 0, 818, 577);
		add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder()));
		panel_2.setBounds(0, 0, 815, 83);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("仓库：");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(30, 29, 75, 23);
		panel_2.add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(73, 29, 106, 23);
		panel_2.add(textField_1);

		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String did = textField_1.getText();
				String joinDate = textField.getText();
				List<OutStore> OutStores = service.getOutStoreByCondition(did, joinDate);
				table.setModel(new OutStoreTableModel(OutStores));

				table.repaint();
			}
		});
		btnNewButton.setBounds(384, 29, 75, 23);
		panel_2.add(btnNewButton);

		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new OutStoreAddDialog(frame, table);
			}
		});
		button.setBounds(480, 29, 75, 23);
		panel_2.add(button);

		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(getThis(), "请选择一行");
					return;
				}
				String id = ((OutStoreTableModel.rows.get(row)).get(0).toString());

				new OutStoreAlterDialog(frame, table, id);
			}
		});
		button_1.setBounds(565, 29, 75, 23);
		panel_2.add(button_1);

		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(getThis(), "请选择一行");
					return;
				}
				String id = ((OutStoreTableModel.rows.get(row)).get(0).toString());
				service.deleteOutStoreById(id);
				table.setModel(new OutStoreTableModel());
				table.repaint();
			}
		});
		button_2.setBounds(650, 29, 80, 23);
		panel_2.add(button_2);

		JLabel label_1 = new JLabel("出库时间：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(189, 29, 75, 23);
		panel_2.add(label_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(256, 30, 106, 23);
		panel_2.add(textField);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 83, 822, 494);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		table = new JTable(new OutStoreTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new TitledBorder(new EtchedBorder()));
		scrollPane.setBounds(0, 0, 815, 494);
		panel_3.add(scrollPane);

	}

	public JPanel getThis() {
		return this;
	}
}
