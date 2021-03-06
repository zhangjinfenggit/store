package cn.edu.zzuli.purchase.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.edu.zzuli.purchase.model.PurchaseTableModel;
import cn.edu.zzuli.purchase.service.PurchaseService;
import cn.edu.zzuli.purchase.vo.Purchase;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午8:27:51 TODO
 */
public class PurchaseAlterDialog extends JDialog {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_7;
	private JLabel label_4;
	private JLabel label_6;
	private JButton btnNewButton;
	private JButton button;
	private PurchaseService service = null;
	private Purchase Purchase = null;

	public JDialog getJDialog() {
		return this;
	}

	public PurchaseAlterDialog(JFrame frame, final JTable table, String id) {

		super(frame, false);
		service = new PurchaseService();
		Purchase = service.getPurchaseById(id);

		this.setVisible(true);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("客户名：");
		label.setFont(new Font("宋体", Font.PLAIN, 13));
		label.setBounds(82, 110, 72, 23);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(132, 111, 131, 21);
		getContentPane().add(textField);
		textField.setText(Purchase.getKhm());
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText(Purchase.getCount() + "");
		textField_1.setBounds(132, 172, 131, 21);
		getContentPane().add(textField_1);

		JLabel label_1 = new JLabel("商品名：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 13));
		label_1.setBounds(318, 110, 72, 23);
		getContentPane().add(label_1);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setText(Purchase.getProductName());
		textField_5.setBounds(371, 111, 131, 21);
		getContentPane().add(textField_5);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setText(Purchase.getPrice() + "");
		textField_7.setBounds(371, 172, 131, 21);
		getContentPane().add(textField_7);

		label_4 = new JLabel("金额：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 13));
		label_4.setBounds(329, 171, 72, 23);
		getContentPane().add(label_4);

		label_6 = new JLabel("数量：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 13));
		label_6.setBounds(95, 171, 72, 23);
		getContentPane().add(label_6);

		btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String khm = textField.getText();
				String productName = textField_5.getText();
				int count = Integer.parseInt(textField_1.getText());
				double price = Double.parseDouble(textField_7.getText());

				Purchase.setKhm(khm);
				Purchase.setProductName(productName);
				Purchase.setCount(count);
				Purchase.setPrice(price);

				PurchaseService service = new PurchaseService();
				service.updatePurchase(Purchase);
				table.setModel(new PurchaseTableModel());
				table.repaint();
				getJDialog().dispose();

			}
		});
		btnNewButton.setBounds(186, 312, 93, 23);
		getContentPane().add(btnNewButton);

		button = new JButton("退出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getJDialog().dispose();
			}
		});
		button.setBounds(357, 312, 93, 23);
		getContentPane().add(button);

		JLabel label_10 = new JLabel("修改订单信息");
		label_10.setFont(new Font("宋体", Font.BOLD, 18));
		label_10.setBounds(218, 10, 312, 30);
		getContentPane().add(label_10);
	}

}
