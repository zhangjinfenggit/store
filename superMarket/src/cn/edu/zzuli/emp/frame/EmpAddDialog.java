package cn.edu.zzuli.emp.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.edu.zzuli.emp.model.EmpTableModel;
import cn.edu.zzuli.emp.service.EmpService;
import cn.edu.zzuli.emp.vo.Emp;

public class EmpAddDialog extends JDialog {

	private JTextField textField;
	private JTextField textField_5;
	private JButton btnNewButton;
	private JButton button;
	private JLabel label_2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private ButtonGroup buttonGroup = null;
	private JComboBox comboBox = null, comboBox_1 = null;

	public JDialog getJDialog() {
		return this;
	}

	public EmpAddDialog(JFrame frame, final JTable table) {

		super(frame, false);

		this.setVisible(true);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("姓名：");
		label.setFont(new Font("宋体", Font.PLAIN, 13));
		label.setBounds(91, 70, 72, 23);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(136, 71, 131, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("年龄：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 13));
		label_1.setBounds(287, 70, 72, 23);
		getContentPane().add(label_1);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(335, 71, 131, 21);
		getContentPane().add(textField_5);

		JLabel label_10 = new JLabel("添加员工信息");
		label_10.setFont(new Font("宋体", Font.BOLD, 18));
		label_10.setBounds(211, 10, 312, 30);
		getContentPane().add(label_10);

		label_2 = new JLabel("性别：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 13));
		label_2.setBounds(91, 103, 72, 23);
		getContentPane().add(label_2);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setBounds(146, 103, 62, 23);
		getContentPane().add(rdbtnNewRadioButton);

		JRadioButton radioButton = new JRadioButton("女");
		radioButton.setBounds(210, 103, 57, 23);
		getContentPane().add(radioButton);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton);
		buttonGroup.add(rdbtnNewRadioButton);

		JLabel label_3 = new JLabel("部门：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 13));
		label_3.setBounds(287, 103, 72, 23);
		getContentPane().add(label_3);
		String[] s1 = { "销售部", "采购部", "安保部", "清洁部", "开发部" };
		final JComboBox comboBox = new JComboBox(s1);
		comboBox.setBounds(335, 105, 131, 21);
		getContentPane().add(comboBox);

		JLabel label_4 = new JLabel("职务：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 13));
		label_4.setBounds(91, 136, 72, 23);
		getContentPane().add(label_4);

		String[] s2 = { "总经理", "收银员", "销售员", "保安", "清洁工" };
		comboBox_1 = new JComboBox(s2);
		comboBox_1.setBounds(136, 136, 131, 21);
		getContentPane().add(comboBox_1);

		JLabel label_5 = new JLabel("手机：");
		label_5.setFont(new Font("宋体", Font.PLAIN, 13));
		label_5.setBounds(287, 140, 72, 23);
		getContentPane().add(label_5);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(335, 137, 131, 21);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(136, 169, 131, 21);
		getContentPane().add(textField_2);

		JLabel label_6 = new JLabel("电话：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 13));
		label_6.setBounds(91, 169, 72, 23);
		getContentPane().add(label_6);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(335, 169, 131, 21);
		getContentPane().add(textField_3);

		JLabel label_7 = new JLabel("传真：");
		label_7.setFont(new Font("宋体", Font.PLAIN, 13));
		label_7.setBounds(287, 168, 72, 23);
		getContentPane().add(label_7);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(136, 204, 131, 21);
		getContentPane().add(textField_4);

		JLabel label_8 = new JLabel("邮箱：");
		label_8.setFont(new Font("宋体", Font.PLAIN, 13));
		label_8.setBounds(91, 207, 72, 23);
		getContentPane().add(label_8);

		JLabel label_9 = new JLabel("地址：");
		label_9.setFont(new Font("宋体", Font.PLAIN, 13));
		label_9.setBounds(287, 203, 72, 23);
		getContentPane().add(label_9);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(335, 204, 131, 21);
		getContentPane().add(textField_6);
		btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				String age = textField_5.getText();
				String sex = null;
				Enumeration<AbstractButton> radioBtns = buttonGroup.getElements();
				while (radioBtns.hasMoreElements()) {
					AbstractButton btn = radioBtns.nextElement();
					if (btn.isSelected()) {
						sex = btn.getText();
						break;
					}
				}
				String dept = comboBox.getSelectedItem().toString();
				String duty = comboBox_1.getSelectedItem().toString();
				String phone = textField_1.getText();
				String tel = textField_2.getText();
				String fax = textField_3.getText();
				String email = textField_4.getText();
				String address = textField_6.getText();

				Emp emp = new Emp();

				emp.setAddress(address);
				emp.setAge(Integer.parseInt(age));
				emp.setDept(dept);
				emp.setDuty(duty);
				emp.setEmail(email);
				emp.setFax(fax);
				emp.setName(name);
				emp.setPhone(phone);
				emp.setSex(sex);
				emp.setTel(tel);

				EmpService service = new EmpService();
				service.saveEmp(emp);
				table.setModel(new EmpTableModel());

				table.repaint();
				getJDialog().dispose();

			}
		});
		btnNewButton.setBounds(154, 286, 93, 23);
		getContentPane().add(btnNewButton);

		button = new JButton("退出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getJDialog().dispose();
			}
		});
		button.setBounds(348, 286, 93, 23);
		getContentPane().add(button);
	}
}
