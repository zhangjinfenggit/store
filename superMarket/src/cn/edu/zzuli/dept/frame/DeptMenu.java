package cn.edu.zzuli.dept.frame;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class DeptMenu extends JPanel {

	public DeptMenu() {

		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("部门管理");
		node1.add(new DefaultMutableTreeNode("部门信息"));
		node1.add(new DefaultMutableTreeNode("部门日志"));

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
