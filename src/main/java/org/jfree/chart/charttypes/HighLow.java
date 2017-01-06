package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.HighLowItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.data.xy.OHLCDataset;

public class HighLow implements IChart {
	
	private String _timeAxisLabel;
	private String _valueAxisLabel; 
	private OHLCDataset _dataset;
	
	/**
     * Initialises and returns a default instance of a high-low-open-close chart.
     *
     * @param timeAxisLabel  a label for the time axis ({@code null} permitted).
     * @param valueAxisLabel  a label for the value axis ({@code null}
     *                        permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
	public HighLow(String timeAxisLabel, String valueAxisLabel, OHLCDataset dataset) {
		_timeAxisLabel = timeAxisLabel;
		_valueAxisLabel = valueAxisLabel;
		_dataset = dataset;
	}
	
	/**
     * Creates and returns a default instance of a high-low-open-close chart.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A high-low-open-close chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		ValueAxis timeAxis = new DateAxis(_timeAxisLabel);
        NumberAxis valueAxis = new NumberAxis(_valueAxisLabel);
        HighLowRenderer renderer = new HighLowRenderer();
        renderer.setDefaultToolTipGenerator(new HighLowItemLabelGenerator());
        XYPlot plot = new XYPlot(_dataset, timeAxis, valueAxis, renderer);
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
