package cn.edu.zzuli.user.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import cn.edu.zzuli.store.frame.inStore.InStorePanel;
import cn.edu.zzuli.utils.Format;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月24日上午9:17:51 TODO
 */
@SuppressWarnings("all")
public class MainFrame {

	public JFrame frame;

	public JTable table = null;
	public JPanel center = null;

	public MainFrame() {

		frame = new JFrame();
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u6587\u4EF6");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("\u5E2E\u52A9");
		menuBar.add(mnNewMenu_1);
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		// getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 994, 651);
		panel.setBorder(new TitledBorder(new EtchedBorder()));

		frame.getContentPane().add(panel);

		final JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(139, 0, 36, 41);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.black));
				lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBorder(null);
			}
		});
		panel.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u6863\u68482.png")));
		panel.add(lblNewLabel);

		final JLabel label = new JLabel("New label");
		label.setBounds(299, 0, 36, 41);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setBorder(BorderFactory.createLineBorder(Color.black));
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label.setBorder(null);
			}
		});
		label.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u6B63\u5E38\u91C7\u8D2D\u8BA2\u5355.png")));
		panel.add(label);

		final JLabel label_1 = new JLabel("New label");
		label_1.setBounds(463, -1, 36, 42);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setBorder(BorderFactory.createLineBorder(Color.black));
				label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setBorder(null);
			}
		});
		label_1.setIcon(new ImageIcon(MainFrame.class.getResource("/img/库存管理.png")));
		panel.add(label_1);

		final JLabel label_3 = new JLabel("New label");
		label_3.setBounds(621, 0, 36, 41);
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_3.setBorder(BorderFactory.createLineBorder(Color.black));
				label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_3.setBorder(null);
			}
		});
		label_3.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u4EBA\u5458\u7BA1\u7406.png")));
		panel.add(label_3);

		final JLabel label_4 = new JLabel("New label");
		label_4.setBounds(783, 0, 36, 41);
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_4.setBorder(BorderFactory.createLineBorder(Color.black));
				label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_4.setBorder(null);
			}

		});
		label_4.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u90E8\u95E8\u7BA1\u7406.png")));
		panel.add(label_4);

		JLabel lblNewLabel_1 = new JLabel("\u57FA\u672C\u6863\u6848");
		lblNewLabel_1.setBounds(132, 41, 54, 15);
		panel.add(lblNewLabel_1);

		JLabel label_5 = new JLabel("\u91C7\u8D2D\u8BA2\u5355");
		label_5.setBounds(291, 41, 54, 15);
		panel.add(label_5);

		JLabel label_6 = new JLabel("库存管理");
		label_6.setBounds(457, 40, 54, 15);
		panel.add(label_6);

		JLabel label_8 = new JLabel("\u4EBA\u5458\u7BA1\u7406");
		label_8.setBounds(618, 41, 54, 15);
		panel.add(label_8);

		JLabel label_9 = new JLabel("\u90E8\u95E8\u7BA1\u7406");
		label_9.setBounds(776, 41, 54, 15);
		panel.add(label_9);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 64, 994, 555);
		panel_1.setBorder(new TitledBorder(new EtchedBorder()));
		panel_1.setLayout(null);

		center = new InStorePanel(frame);
		center.setBounds(0, 0, 990, 555);
		center.setBorder(new TitledBorder(new EtchedBorder()));
		center.setOpaque(false);

		panel_1.add(center);
		panel_1.setBorder(new TitledBorder(new EtchedBorder()));
		panel.add(panel_1);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 618, 994, 33);
		panel_2.setBorder(new TitledBorder(new EtchedBorder()));
		panel_2.setOpaque(true);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new EtchedBorder()));
		scrollPane.setBorder(new TitledBorder(new EtchedBorder()));
		panel_2.add(scrollPane);

		final JLabel lblNewLabel_2 = new JLabel("", JLabel.CENTER);
		lblNewLabel_2.setForeground(Color.BLUE);
		scrollPane.setViewportView(lblNewLabel_2);

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				lblNewLabel_2.setText(Format.getLocalDate());
				lblNewLabel_2.repaint();
			}
		}, 0, 1000);

		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
