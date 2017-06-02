package cn.edu.zzuli.store.frame;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import cn.edu.zzuli.store.frame.inStore.InStorePanel;
import cn.edu.zzuli.store.frame.outStore.OutStorePanel;
import cn.edu.zzuli.store.frame.report.InStoreReportPanel;
import cn.edu.zzuli.store.frame.report.OutStoreReportPanel;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年6月1日下午7:55:04 TODO
 */
public class StorePanel extends JPanel {
	private JTextField textField_1;
	public JTable table = null;
	private JTextField textField;
	private JPanel in = null, out = null;
	private CardLayout card = null;

	private JPanel panel_1 = null;
	private JPanel panel_2 = null;
	private JPanel panel_3 = null;

	public StorePanel(final JFrame frame) {
		card = new CardLayout();

		this.setSize(994, 577);
		setLayout(null);

		panel_1 = new JPanel(card);

		panel_2 = new InStoreReportPanel().createPieChart3D();
		panel_1.add(panel_2, "2");

		in = new InStorePanel(frame);
		panel_1.add(in, "0");
		out = new OutStorePanel(frame);
		panel_1.add(out, "1");

		panel_3 = new OutStoreReportPanel().createPieChart3D();
		panel_1.add(panel_3, "3");
		panel_1.setBounds(176, 0, 808, 547);
		add(panel_1);

		JPanel panel = new StoreMenu(panel_1, card, panel_2, panel_3);
		panel.setBorder(new TitledBorder(new EtchedBorder()));
		panel.setBounds(0, 0, 175, 547);
		add(panel);
	}

}
