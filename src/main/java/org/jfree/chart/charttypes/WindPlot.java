package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.WindItemRenderer;
import org.jfree.data.xy.WindDataset;

public class WindPlot implements IChart {
	
	private String _xAxisLabel;
	private String _yAxisLabel;
	private WindDataset _dataset;
	
	/**
     * Initialises a wind plot with default settings.
     *
     * @param xAxisLabel  a label for the x-axis (<code>null</code> permitted).
     * @param yAxisLabel  a label for the y-axis (<code>null</code> permitted).
     * @param dataset  the dataset for the chart (<code>null</code> permitted).
     */
	public WindPlot(String xAxisLabel, String yAxisLabel, WindDataset dataset){
		_xAxisLabel = xAxisLabel;
		_yAxisLabel = yAxisLabel;
		_dataset = dataset;
	}
	
	/**
     * Creates a wind plot with default settings.
     *
     * @param title  the chart title (<code>null</code> permitted).
     *
     * @return A wind plot.
     */
	@Override
	public JFreeChart createChart(String title) {
		ValueAxis xAxis = new DateAxis(_xAxisLabel);
        ValueAxis yAxis = new NumberAxis(_yAxisLabel);
        yAxis.setRange(-12.0, 12.0);

        WindItemRenderer renderer = new WindItemRenderer();
        renderer.setDefaultToolTipGenerator(new StandardXYToolTipGenerator());
        XYPlot plot = new XYPlot(_dataset, xAxis, yAxis, renderer);
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}
}
