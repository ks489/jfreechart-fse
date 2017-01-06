package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;

public class TimeSeries implements IChart {
	
	private String _timeAxisLabel;
	private String _valueAxisLabel;
	private XYDataset _dataset;
	
	/**
     * Initialises and returns a time series chart.  A time series chart is an
     * {@link XYPlot} with a {@link DateAxis} for the x-axis and a
     * {@link NumberAxis} for the y-axis.  The default renderer is an
     * {@link XYLineAndShapeRenderer}.
     * <P>
     * A convenient dataset to use with this chart is a
     * {@link org.jfree.data.time.TimeSeriesCollection}.
     *
     * @param timeAxisLabel  a label for the time axis ({@code null}
     *                       permitted).
     * @param valueAxisLabel  a label for the value axis ({@code null}
     *                        permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
	public TimeSeries(String timeAxisLabel, String valueAxisLabel, XYDataset dataset) {
		_timeAxisLabel = timeAxisLabel;
		_valueAxisLabel = valueAxisLabel;
		_dataset = dataset;
	}
	
	/**
     * Creates and returns a time series chart.  A time series chart is an
     * {@link XYPlot} with a {@link DateAxis} for the x-axis and a
     * {@link NumberAxis} for the y-axis.  The default renderer is an
     * {@link XYLineAndShapeRenderer}.
     * <P>
     * A convenient dataset to use with this chart is a
     * {@link org.jfree.data.time.TimeSeriesCollection}.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A time series chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		ValueAxis timeAxis = new DateAxis(_timeAxisLabel);
        timeAxis.setLowerMargin(0.02);  // reduce the default margins
        timeAxis.setUpperMargin(0.02);
        NumberAxis valueAxis = new NumberAxis(_valueAxisLabel);
        valueAxis.setAutoRangeIncludesZero(false);  // override default
        XYPlot plot = new XYPlot(_dataset, timeAxis, valueAxis, null);

        XYToolTipGenerator toolTipGenerator
                = StandardXYToolTipGenerator.getTimeSeriesInstance();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true,
                false);
        renderer.setDefaultToolTipGenerator(toolTipGenerator);
        plot.setRenderer(renderer);

        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
