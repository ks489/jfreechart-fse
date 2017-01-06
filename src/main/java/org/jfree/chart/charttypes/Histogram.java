package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.IntervalXYDataset;

public class Histogram implements IChart {
	
	private String _xAxisLabel;
	private String _yAxisLabel;
	private IntervalXYDataset _dataset;
	
	/**
     * Initialises a histogram chart.  This chart is constructed with an
     * {@link XYPlot} using an {@link XYBarRenderer}.  The domain and range
     * axes are {@link NumberAxis} instances.
     *
     * @param xAxisLabel  the x axis label (<code>null</code> permitted).
     * @param yAxisLabel  the y axis label (<code>null</code> permitted).
     * @param dataset  the dataset (<code>null</code> permitted).
     *
     */
	public Histogram(String xAxisLabel, String yAxisLabel, IntervalXYDataset dataset) {
		_xAxisLabel = xAxisLabel;
		_yAxisLabel = yAxisLabel;
		_dataset = dataset;
	}
	
	/**
     * Creates a histogram chart.  This chart is constructed with an
     * {@link XYPlot} using an {@link XYBarRenderer}.  The domain and range
     * axes are {@link NumberAxis} instances.
     *
     * @param title  the chart title (<code>null</code> permitted).
     *
     * @return The chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		NumberAxis xAxis = new NumberAxis(_xAxisLabel);
        xAxis.setAutoRangeIncludesZero(false);
        ValueAxis yAxis = new NumberAxis(_yAxisLabel);

        XYItemRenderer renderer = new XYBarRenderer();
        renderer.setDefaultToolTipGenerator(new StandardXYToolTipGenerator());

        XYPlot plot = new XYPlot(_dataset, xAxis, yAxis, renderer);
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
