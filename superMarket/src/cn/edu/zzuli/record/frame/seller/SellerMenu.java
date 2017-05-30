package cn.edu.zzuli.record.frame.seller;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class SellerMenu extends JPanel {

	public SellerMenu() {

		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("基本档案管理");
		node1.add(new DefaultMutableTreeNode("销售商管理"));
		node1.add(new DefaultMutableTreeNode("供应商管理"));
		node1.add(new DefaultMutableTreeNode("仓库管理"));
		node1.add(new DefaultMutableTreeNode("职务管理"));

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
