package cn.edu.zzuli.store.frame.inStore;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午11:17:51 TODO
 */
public class InStoreMenu extends JPanel {

	public InStoreMenu() {

		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("仓库管理");
		node1.add(new DefaultMutableTreeNode("入库管理"));
		node1.add(new DefaultMutableTreeNode("入库报表"));
		node1.add(new DefaultMutableTreeNode("出库管理"));
		node1.add(new DefaultMutableTreeNode("出库报表"));
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
