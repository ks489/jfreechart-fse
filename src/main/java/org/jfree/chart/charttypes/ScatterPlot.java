package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;

public class ScatterPlot implements IChart{

	private String _xAxisLabel;
    private String _yAxisLabel;
    private XYDataset _dataset;
    
    /**
     * Initialises a scatter plot with default settings.  The chart object
     * returned by this method uses an {@link XYPlot} instance as the plot,
     * with a {@link NumberAxis} for the domain axis, a  {@link NumberAxis}
     * as the range axis, and an {@link XYLineAndShapeRenderer} as the
     * renderer.
     *
     * @param xAxisLabel  a label for the X-axis ({@code null} permitted).
     * @param yAxisLabel  a label for the Y-axis ({@code null} permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
    public ScatterPlot(String xAxisLabel, String yAxisLabel, XYDataset dataset) {
    	_xAxisLabel = xAxisLabel;
    	_yAxisLabel = yAxisLabel;
    	_dataset = dataset;
	}
    
    /**
     * Creates a scatter plot with default settings.  The chart object
     * returned by this method uses an {@link XYPlot} instance as the plot,
     * with a {@link NumberAxis} for the domain axis, a  {@link NumberAxis}
     * as the range axis, and an {@link XYLineAndShapeRenderer} as the
     * renderer.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A scatter plot.
     */
	@Override
	public JFreeChart createChart(String title) {
		NumberAxis xAxis = new NumberAxis(_xAxisLabel);
        xAxis.setAutoRangeIncludesZero(false);
        NumberAxis yAxis = new NumberAxis(_yAxisLabel);
        yAxis.setAutoRangeIncludesZero(false);

        XYPlot plot = new XYPlot(_dataset, xAxis, yAxis, null);
        XYItemRenderer renderer = new XYLineAndShapeRenderer(false, true);
        XYToolTipGenerator toolTipGenerator = new StandardXYToolTipGenerator();
        renderer.setDefaultToolTipGenerator(toolTipGenerator);
        plot.setRenderer(renderer);

        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
