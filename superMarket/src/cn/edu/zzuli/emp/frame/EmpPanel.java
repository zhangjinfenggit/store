package cn.edu.zzuli.emp.frame;

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

import cn.edu.zzuli.emp.model.EmpTableModel;
import cn.edu.zzuli.emp.service.EmpService;
import cn.edu.zzuli.emp.vo.Emp;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午11:17:51 TODO
 */
public class EmpPanel extends JPanel {
	private JTextField textField_1;
	public JTable table = null;
	public EmpService service;
	private JComboBox comboBox = null;

	public EmpPanel(final JFrame frame) {
		service = new EmpService();
		this.setSize(994, 577);
		setLayout(null);

		JPanel panel = new EmpMenu();
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

		JLabel label = new JLabel("员工名称");
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
				List<Emp> Emps = service.getEmpByCondition(condition, info);

				table.setModel(new EmpTableModel(Emps));

				table.repaint();
			}
		});
		btnNewButton.setBounds(343, 29, 75, 23);
		panel_2.add(btnNewButton);

		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new EmpAddDialog(frame, table);
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
				String id = ((EmpTableModel.rows.get(row)).get(0).toString());

				new EmpAlterDialog(frame, table, id);
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
				String id = ((EmpTableModel.rows.get(row)).get(0).toString());
				service.deleteEmpById(id);
				table.setModel(new EmpTableModel());
				table.repaint();
			}
		});
		button_2.setBounds(598, 29, 80, 23);
		panel_2.add(button_2);
		String[] s = { "部门名称", "手机", "姓名", "职务" };
		comboBox = new JComboBox(s);

		comboBox.setBounds(96, 30, 80, 21);
		panel_2.add(comboBox);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 83, 822, 494);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		table = new JTable(new EmpTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new TitledBorder(new EtchedBorder()));
		scrollPane.setBounds(0, 0, 822, 494);
		panel_3.add(scrollPane);

	}

	public JPanel getThis() {
		return this;
	}
}
