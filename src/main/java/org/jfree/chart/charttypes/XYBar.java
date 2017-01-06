package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.IntervalXYDataset;

public class XYBar implements IChart {

	private String _xAxisLabel;
    private boolean _dateAxis;
    private String _yAxisLabel;
    private IntervalXYDataset _dataset;
    
    /**
     * Initialises and returns a default instance of an XY bar chart.
     * <P>
     * The chart object returned by this method uses an {@link XYPlot} instance
     * as the plot, with a {@link DateAxis} for the domain axis, a
     * {@link NumberAxis} as the range axis, and a {@link XYBarRenderer} as the
     * renderer.
     *
     * @param xAxisLabel  a label for the X-axis ({@code null} permitted).
     * @param dateAxis  make the domain axis display dates?
     * @param yAxisLabel  a label for the Y-axis ({@code null} permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
    public XYBar(String xAxisLabel, boolean dateAxis, String yAxisLabel, IntervalXYDataset dataset) {
    	_xAxisLabel = xAxisLabel;
    	_dateAxis = dateAxis;
    	_yAxisLabel = yAxisLabel;
    	_dataset = dataset;    	
	}
    
    /**
     * Creates and returns a default instance of an XY bar chart.
     * <P>
     * The chart object returned by this method uses an {@link XYPlot} instance
     * as the plot, with a {@link DateAxis} for the domain axis, a
     * {@link NumberAxis} as the range axis, and a {@link XYBarRenderer} as the
     * renderer.
     *
     * @param xAxisLabel  a label for the X-axis ({@code null} permitted).
     * @param dateAxis  make the domain axis display dates?
     * @param yAxisLabel  a label for the Y-axis ({@code null} permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     * @return An XY bar chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		ValueAxis domainAxis;
        if (_dateAxis) {
            domainAxis = new DateAxis(_xAxisLabel);
        }
        else {
            NumberAxis axis = new NumberAxis(_xAxisLabel);
            axis.setAutoRangeIncludesZero(false);
            domainAxis = axis;
        }
        ValueAxis valueAxis = new NumberAxis(_yAxisLabel);

        XYBarRenderer renderer = new XYBarRenderer();
        XYToolTipGenerator tt;
        if (_dateAxis) {
            tt = StandardXYToolTipGenerator.getTimeSeriesInstance();
        }
        else {
            tt = new StandardXYToolTipGenerator();
        }
        renderer.setDefaultToolTipGenerator(tt);

        XYPlot plot = new XYPlot(_dataset, domainAxis, valueAxis, renderer);

        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
