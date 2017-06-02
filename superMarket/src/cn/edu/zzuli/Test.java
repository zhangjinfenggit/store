package cn.edu.zzuli;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

public class Test {

	public JPanel createPieChart3D() {
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
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("苹果", 250);
		dataset.setValue("桔子", 350);
		dataset.setValue("梨子", 200);
		dataset.setValue("香蕉", 50);
		dataset.setValue("荔枝", 150);
		JFreeChart chart = ChartFactory.createPieChart3D("水果产量比率图", dataset, true, true, true);
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		// 设置开始角度
		plot.setStartAngle(150D);
		// 设置方向为"顺时针方向"
		plot.setDirection(Rotation.CLOCKWISE);
		// 设置透明度，0.5F为半透明，1为不透明，0为全透明
		plot.setForegroundAlpha(1F);
		// 没有数据的时候显示的内容
		plot.setNoDataMessage("无数据显示");
		// 背景色设置
		plot.setBackgroundPaint(ChartColor.WHITE);

		ChartPanel panel = new ChartPanel(chart);

		return panel;

	}

	public static void main(String[] args) {

		new Test().createPieChart3D();

	}
}
