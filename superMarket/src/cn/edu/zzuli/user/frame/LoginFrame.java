package cn.edu.zzuli.user.frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.edu.zzuli.user.service.UserService;
import cn.edu.zzuli.utils.MyBackground;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月24日上午8:20:51 TODO
 */
@SuppressWarnings("all")
public class LoginFrame {

	private JFrame frame;
	private MainFrame dialog;
	private JTextField textField;
	private JPasswordField textField_1;
	private JButton btnNewButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 420, 442, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �Զ��岼��
		frame.getContentPane().setLayout(null);
		// ȥ��߿�
		frame.setUndecorated(true);
		FileInputStream stream;
		Image im = null;
		FileInputStream stream1 = null;
		try {
			stream1 = new FileInputStream("img/2.png");
			im = ImageIO.read(stream1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel panel_1 = new MyBackground(im);
		panel_1.setBackground(Color.WHITE);
		panel_1.setOpaque(true);
		panel_1.setBounds(0, 0, 442, 360);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		frame.setLocationRelativeTo(null);
		textField = new JTextField();
		textField.setBounds(137, 211, 198, 34);
		textField.setOpaque(false);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setOpaque(false);
		textField_1.setBounds(137, 244, 198, 31);
		panel_1.add(textField_1);

		btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ********************************
				String username = textField.getText();
				char[] pwd = textField_1.getPassword();
				String password = new String(pwd);

				UserService service = new UserService();

				if (service.cheakAccount(username, password)) {

					frame.dispose();
					dialog = new MainFrame();

				} else {
					JOptionPane.showMessageDialog(frame, "\u8D26\u53F7\u6216\u5BC6\u7801\u9519\u8BEF");
					textField.setText("");
					textField_1.setText("");
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(132, 312, 203, 38);
		panel_1.add(btnNewButton);

		JCheckBox checkBox = new JCheckBox("\u4FDD\u5B58\u5BC6\u7801");
		checkBox.setBounds(132, 283, 103, 23);
		panel_1.add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("\u81EA\u52A8\u767B\u5F55");
		checkBox_1.setBounds(260, 281, 103, 23);
		panel_1.add(checkBox_1);
		try {
			stream1 = new FileInputStream("img/2.jpg");
			System.out.println(stream1);
			im = ImageIO.read(stream1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel panel = new MyBackground(im);
		/*
		 * frame.addMouseMotionListener(new MouseMotionAdapter() {
		 * 
		 * @Override public void mouseDragged(MouseEvent e) {
		 * frame.setLocation(e.getX(), e.getY()); } });
		 */
		;
		panel.setBounds(0, 0, 442, 201);
		panel_1.add(panel);
		panel.setLayout(null);

		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/img/\u5173\u95ED (1).png")));
		lblNewLabel.setBounds(410, 0, 25, 25);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/img/\u6700\u5C0F\u5316.png")));
		lblNewLabel_1.setBounds(385, 0, 15, 25);
		panel.add(lblNewLabel_1);

		final JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u6CE8\u518C");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setForeground(new Color(0, 191, 255));
				lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setForeground(new Color(30, 144, 255));
			}
		});
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setBounds(354, 220, 54, 15);

		panel_1.add(lblNewLabel_2);

		final JLabel lblNewLabel_3 = new JLabel("\u627E\u56DE\u5BC6\u7801");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3.setForeground(new Color(0, 191, 255));
				// �������
				lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setForeground(new Color(30, 144, 255));
			}
		});
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setBounds(354, 252, 54, 15);

		panel_1.add(lblNewLabel_3);

	}
}
