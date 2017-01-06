package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.data.xy.XYDataset;

public class XYStepArea implements IChart{
	
	private String _xAxisLabel;
	private String _yAxisLabel;
	private XYDataset _dataset;
	
	/**
     * Initialises a filled stepped XY plot with default settings.
     *
     * @param xAxisLabel  a label for the X-axis ({@code null} permitted).
     * @param yAxisLabel  a label for the Y-axis ({@code null} permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
	public XYStepArea(String xAxisLabel, String yAxisLabel, XYDataset dataset) {
		_xAxisLabel = xAxisLabel;
		_yAxisLabel = yAxisLabel;
		_dataset = dataset;
	}
	
	/**
     * Creates a filled stepped XY plot with default settings.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		NumberAxis xAxis = new NumberAxis(_xAxisLabel);
        xAxis.setAutoRangeIncludesZero(false);
        NumberAxis yAxis = new NumberAxis(_yAxisLabel);

        XYToolTipGenerator toolTipGenerator = new StandardXYToolTipGenerator();
        XYItemRenderer renderer = new XYStepAreaRenderer(
                XYStepAreaRenderer.AREA_AND_SHAPES, toolTipGenerator,
                null);

        XYPlot plot = new XYPlot(_dataset, xAxis, yAxis, null);
        plot.setRenderer(renderer);
        plot.setDomainCrosshairVisible(false);
        plot.setRangeCrosshairVisible(false);
        JFreeChart chart = new JFreeChart(title, plot);
        
        return chart;
	}

}
