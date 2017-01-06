package org.jfree.chart.charttypes;

import org.jfree.chart.ChartTheme;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.GradientBarPainter;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.GradientXYBarPainter;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.util.ParamChecks;

public class ChartFactoryClient implements IChart {
	
	private ChartTheme _currentTheme = new StandardChartTheme("JFree");
	
	public ChartTheme getChartTheme(){
		return _currentTheme;
	}
	
	public void setChartTheme(ChartTheme theme){
		ParamChecks.nullNotPermitted(theme, "theme");
        _currentTheme = theme;

        if (theme instanceof StandardChartTheme) {
            StandardChartTheme sct = (StandardChartTheme) theme;
            if (sct.getName().equals("Legacy")) {
                BarRenderer.setDefaultBarPainter(new StandardBarPainter());
                XYBarRenderer.setDefaultBarPainter(new StandardXYBarPainter());
            }
            else {
                BarRenderer.setDefaultBarPainter(new GradientBarPainter());
                XYBarRenderer.setDefaultBarPainter(new GradientXYBarPainter());
            }
        }
	}
	
	private IChart _chart;
	public ChartFactoryClient(IChart chart){
		_chart = chart;
	}
	
	@Override
	public JFreeChart createChart(String title) {
		JFreeChart jChart = _chart.createChart(title);
		_currentTheme.apply(jChart);
		return jChart;
	}

}
