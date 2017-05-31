package cn.edu.zzuli.store.frame;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class StoreMenu extends JPanel {

	public StoreMenu() {

		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("入库管理");
		node1.add(new DefaultMutableTreeNode("入库管理"));
		node1.add(new DefaultMutableTreeNode("入库报表"));
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
