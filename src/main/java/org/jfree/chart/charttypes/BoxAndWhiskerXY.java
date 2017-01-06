package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;

public class BoxAndWhiskerXY implements IChart {

	private String _timeAxisLabel;
	private String _valueAxisLabel;
	private BoxAndWhiskerXYDataset _boxAndWhiskerXYDataset;
	
	/**
     * Initialises and returns a default instance of a box and whisker chart.
     *
     * @param timeAxisLabel  a label for the time axis (<code>null</code>
     *                       permitted).
     * @param valueAxisLabel  a label for the value axis (<code>null</code>
     *                        permitted).
     * @param dataset  the dataset for the chart (<code>null</code> permitted).
     *
     */
	public BoxAndWhiskerXY(String timeAxisLabel, String valueAxisLabel, BoxAndWhiskerXYDataset boxAndWhiskerXYDataset){
		_timeAxisLabel = timeAxisLabel;
		_valueAxisLabel = valueAxisLabel;
		_boxAndWhiskerXYDataset = boxAndWhiskerXYDataset;
	}	
	
	/**
     * Creates and returns a default instance of a box and whisker chart.
     *
     * @param title  the chart title (<code>null</code> permitted).
     *
     * @return A box and whisker chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		ValueAxis timeAxis = new DateAxis(_timeAxisLabel);
        NumberAxis valueAxis = new NumberAxis(_valueAxisLabel);
        valueAxis.setAutoRangeIncludesZero(false);
        XYBoxAndWhiskerRenderer renderer = new XYBoxAndWhiskerRenderer(10.0);
        XYPlot plot = new XYPlot(_boxAndWhiskerXYDataset, timeAxis, valueAxis, renderer);
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
