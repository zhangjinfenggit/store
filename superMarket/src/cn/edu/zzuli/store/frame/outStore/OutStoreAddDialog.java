package cn.edu.zzuli.store.frame.outStore;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.edu.zzuli.store.model.OutStoreTableModel;
import cn.edu.zzuli.store.service.OutStoreService;
import cn.edu.zzuli.store.vo.OutStore;
import cn.edu.zzuli.utils.Format;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午10:17:51 TODO
 */
public class OutStoreAddDialog extends JDialog {
	private JTextField textField_1;
	private JTextField textField_5;
	private JLabel label_6;
	private JButton btnNewButton;
	private JButton button;
	private JComboBox comboBox = null;
	private JTextArea textArea = null;

	public JDialog getJDialog() {
		return this;
	}

	public OutStoreAddDialog(JFrame frame, final JTable table) {

		super(frame, false);

		this.setVisible(true);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("仓库编号：");
		label.setFont(new Font("宋体", Font.PLAIN, 13));
		label.setBounds(308, 97, 72, 23);
		getContentPane().add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 148, 131, 21);
		getContentPane().add(textField_1);

		JLabel label_1 = new JLabel("商品名：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 13));
		label_1.setBounds(76, 97, 72, 23);
		getContentPane().add(label_1);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(132, 98, 131, 21);
		getContentPane().add(textField_5);

		label_6 = new JLabel("重量：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 13));
		label_6.setBounds(91, 147, 72, 23);
		getContentPane().add(label_6);

		String[] s = { "1", "2", "3", "4", "5", "6" };
		comboBox = new JComboBox(s);
		comboBox.setBounds(378, 98, 113, 21);
		getContentPane().add(comboBox);

		textArea = new JTextArea();
		textArea.setBounds(132, 192, 370, 96);
		getContentPane().add(textArea);

		btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String name = textField_5.getText();
				String weight = textField_1.getText();
				String did = comboBox.getSelectedItem().toString();
				String remark = textArea.getText();
				OutStore OutStore = new OutStore();
				OutStore.setDid(Integer.parseInt(did));
				OutStore.setOutTime(Format.dateFormat());

				OutStore.setRemark(remark);
				OutStore.setWareName(name);
				OutStore.setWeight(Double.parseDouble(weight));

				OutStoreService service = new OutStoreService();
				service.saveOutStore(OutStore);
				table.setModel(new OutStoreTableModel());
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

		JLabel label_10 = new JLabel("添加出库信息");
		label_10.setFont(new Font("宋体", Font.BOLD, 18));
		label_10.setBounds(218, 10, 312, 30);
		getContentPane().add(label_10);

		JLabel label_2 = new JLabel("备注：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 13));
		label_2.setBounds(91, 192, 72, 23);
		getContentPane().add(label_2);

	}
}
