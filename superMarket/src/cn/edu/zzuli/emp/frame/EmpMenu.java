package cn.edu.zzuli.emp.frame;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class EmpMenu extends JPanel {

	public EmpMenu() {

		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("人员管理");
		node1.add(new DefaultMutableTreeNode("员工信息"));
		node1.add(new DefaultMutableTreeNode("员工日志"));

		final JTree tree = new JTree(node1);

		this.add(tree);

		// 添加选择事件
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (node == null)
					return;

				System.out.println(node.getUserObject().toString());
			}
		});
	}
}
