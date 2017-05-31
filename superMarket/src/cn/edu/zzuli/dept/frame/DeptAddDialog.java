package cn.edu.zzuli.dept.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.edu.zzuli.dept.model.DeptTableModel;
import cn.edu.zzuli.dept.service.DeptService;
import cn.edu.zzuli.dept.vo.Dept;

public class DeptAddDialog extends JDialog {

	private JTextField textField;
	private JTextField textField_5;
	private JLabel label_9;
	private JButton btnNewButton;
	private JButton button;

	public JDialog getJDialog() {
		return this;
	}

	public DeptAddDialog(JFrame frame, final JTable table) {

		super(frame, false);

		this.setVisible(true);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("部门名称：");
		label.setFont(new Font("宋体", Font.PLAIN, 13));
		label.setBounds(69, 106, 72, 23);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(132, 107, 131, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("负责人：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 13));
		label_1.setBounds(289, 106, 72, 23);
		getContentPane().add(label_1);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(341, 107, 131, 21);
		getContentPane().add(textField_5);

		label_9 = new JLabel("描述：");
		label_9.setFont(new Font("宋体", Font.PLAIN, 13));
		label_9.setBounds(69, 171, 72, 23);
		getContentPane().add(label_9);

		final JTextArea textArea = new JTextArea();
		textArea.setBounds(107, 171, 381, 83);
		getContentPane().add(textArea);

		btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String name = textField.getText();
				String principal = textField_5.getText();
				String description = textArea.getText();

				Dept Dept = new Dept();

				Dept.setName(name);
				Dept.setDescription(description);
				Dept.setPrincipal(principal);

				DeptService service = new DeptService();
				service.saveDept(Dept);
				table.setModel(new DeptTableModel());

				table.repaint();
				getJDialog().dispose();

			}
		});
		btnNewButton.setBounds(160, 301, 93, 23);
		getContentPane().add(btnNewButton);

		button = new JButton("退出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getJDialog().dispose();
			}
		});
		button.setBounds(313, 301, 93, 23);
		getContentPane().add(button);

		JLabel label_10 = new JLabel("添加部门信息");
		label_10.setFont(new Font("宋体", Font.BOLD, 18));
		label_10.setBounds(212, 31, 312, 30);
		getContentPane().add(label_10);
	}
}
