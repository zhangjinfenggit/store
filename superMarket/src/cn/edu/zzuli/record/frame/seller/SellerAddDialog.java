package cn.edu.zzuli.record.frame.seller;

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

import cn.edu.zzuli.record.model.SellerTableModel;
import cn.edu.zzuli.record.service.SellerService;
import cn.edu.zzuli.record.vo.Seller;

public class SellerAddDialog extends JDialog {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JButton btnNewButton;
	private JButton button;
	private JTextField textField_9;

	public JDialog getJDialog() {
		return this;
	}

	public SellerAddDialog(JFrame frame, final JTable table) {

		super(frame, false);

		this.setVisible(true);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("姓名：");
		label.setFont(new Font("宋体", Font.PLAIN, 13));
		label.setBounds(57, 49, 72, 23);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(95, 50, 131, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 82, 131, 21);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(95, 113, 131, 21);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(95, 144, 131, 21);
		getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(95, 175, 131, 21);
		getContentPane().add(textField_4);

		JLabel label_1 = new JLabel("地址：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 13));
		label_1.setBounds(306, 53, 72, 23);
		getContentPane().add(label_1);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(345, 50, 131, 21);
		getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(345, 145, 131, 21);
		getContentPane().add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(345, 82, 131, 21);
		getContentPane().add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(345, 113, 131, 21);
		getContentPane().add(textField_8);

		label_2 = new JLabel(" 联系人：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 13));
		label_2.setBounds(37, 113, 72, 23);
		getContentPane().add(label_2);

		label_3 = new JLabel("联系电话：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 13));
		label_3.setBounds(284, 143, 72, 23);
		getContentPane().add(label_3);

		label_4 = new JLabel("邮编：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 13));
		label_4.setBounds(306, 81, 72, 23);
		getContentPane().add(label_4);

		label_5 = new JLabel("网址：");
		label_5.setFont(new Font("宋体", Font.PLAIN, 13));
		label_5.setBounds(306, 112, 72, 23);
		getContentPane().add(label_5);

		label_6 = new JLabel("传真：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 13));
		label_6.setBounds(57, 81, 72, 23);
		getContentPane().add(label_6);

		label_7 = new JLabel("银行账号：");
		label_7.setFont(new Font("宋体", Font.PLAIN, 13));
		label_7.setBounds(31, 175, 72, 23);
		getContentPane().add(label_7);

		label_8 = new JLabel("邮箱：");
		label_8.setFont(new Font("宋体", Font.PLAIN, 13));
		label_8.setBounds(57, 143, 72, 23);
		getContentPane().add(label_8);

		label_9 = new JLabel("备注：");
		label_9.setFont(new Font("宋体", Font.PLAIN, 13));
		label_9.setBounds(57, 222, 72, 23);
		getContentPane().add(label_9);

		final JTextArea textArea = new JTextArea();
		textArea.setBounds(95, 222, 381, 83);
		getContentPane().add(textArea);

		btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String name = textField.getText();
				String address = textField_5.getText();
				String fax = textField_1.getText();
				String postCode = textField_7.getText();
				String connecter = textField_2.getText();
				String wsite = textField_8.getText();
				String email = textField_3.getText();
				String ltel = textField_6.getText();
				String account = textField_4.getText();
				String description = textArea.getText();
				String khm = textField_9.getText();

				Seller seller = new Seller();

				seller.setName(name);
				seller.setAccount(account);
				seller.setAddress(address);
				seller.setConnecter(connecter);
				seller.setContel(ltel);
				seller.setDescription(description);
				seller.setEmail(email);
				seller.setFax(fax);
				seller.setKhm(name);
				seller.setWsite(wsite);
				seller.setPostCode(postCode);

				SellerService service = new SellerService();
				service.saveSeller(seller);
				table.setModel(new SellerTableModel());
				;
				table.repaint();
				getJDialog().dispose();

			}
		});
		btnNewButton.setBounds(153, 333, 93, 23);
		getContentPane().add(btnNewButton);

		button = new JButton("退出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getJDialog().dispose();
			}
		});
		button.setBounds(308, 333, 93, 23);
		getContentPane().add(button);

		JLabel label_10 = new JLabel("添加销售商信息");
		label_10.setFont(new Font("宋体", Font.BOLD, 18));
		label_10.setBounds(205, 0, 312, 30);
		getContentPane().add(label_10);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(345, 175, 131, 21);
		getContentPane().add(textField_9);

		JLabel label_11 = new JLabel("客户姓名：");
		label_11.setFont(new Font("宋体", Font.PLAIN, 13));
		label_11.setBounds(284, 178, 72, 23);
		getContentPane().add(label_11);
	}
}
