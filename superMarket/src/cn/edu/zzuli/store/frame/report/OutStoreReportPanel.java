package cn.edu.zzuli.store.frame.report;

import java.awt.Font;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import cn.edu.zzuli.store.service.OutStoreService;
import cn.edu.zzuli.store.vo.OutStore;

public class OutStoreReportPanel {

	private OutStoreService service = null;

	List<OutStore> list = null;

	public JPanel createPieChart3D() {

		service = new OutStoreService();
		list = service.findAll();
		// 创建主题样式
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
		// 设置轴向的字体
		standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
		// 应用主题样式
		ChartFactory.setChartTheme(standardChartTheme);

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		if (list != null) {
			for (OutStore inStore : list) {
				dataset.setValue(inStore.getWeight(), inStore.getWareName(), inStore.getOutTime());
			}
		}

		JFreeChart chart = ChartFactory.createBarChart("商品出库图", "商品名", "日期", dataset, PlotOrientation.VERTICAL, true,
				true, true);
		CategoryPlot cp = chart.getCategoryPlot();
		cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
		cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置

		ChartPanel panel = new ChartPanel(chart);

		return panel;
	}

}
