package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.data.xy.OHLCDataset;

public class Candlestick implements IChart {
	
	private String _timeAxisLabel;
	private String _valueAxisLabel;
	private OHLCDataset _dataset;
	
	/**
     * Initialises and returns a default instance of a candlesticks chart.
     *
     * @param timeAxisLabel  a label for the time axis ({@code null}
     *                       permitted).
     * @param valueAxisLabel  a label for the value axis ({@code null}
     *                        permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
	public Candlestick(String timeAxisLabel, String valueAxisLabel, OHLCDataset dataset) {
		_timeAxisLabel = timeAxisLabel;
		_valueAxisLabel = valueAxisLabel;
		_dataset = dataset;
	}
	
	/**
     * Creates and returns a default instance of a candlesticks chart.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A candlestick chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		ValueAxis timeAxis = new DateAxis(_timeAxisLabel);
        NumberAxis valueAxis = new NumberAxis(_valueAxisLabel);
        XYPlot plot = new XYPlot(_dataset, timeAxis, valueAxis, null);
        plot.setRenderer(new CandlestickRenderer());
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
