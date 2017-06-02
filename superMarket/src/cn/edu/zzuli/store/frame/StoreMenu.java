package cn.edu.zzuli.store.frame;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年6月1日下午7:54:44 TODO
 */
public class StoreMenu extends JPanel {

	public StoreMenu(final JPanel panel_1, final CardLayout card, final JPanel panel_2, final JPanel panel_3) {

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

				if (node.getUserObject().toString().equals("入库管理")) {
					card.show(panel_1, "0");
				} else if (node.getUserObject().toString().equals("出库管理")) {
					card.show(panel_1, "1");
				} else if (node.getUserObject().toString().equals("入库报表")) {
					card.show(panel_1, "2");
					panel_2.repaint();
				} else if (node.getUserObject().toString().equals("出库报表")) {
					card.show(panel_1, "3");
					panel_3.repaint();
				}
			}
		});
	}

}
