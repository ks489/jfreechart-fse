package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.data.xy.TableXYDataset;

public class StackedXYArea implements IChart {
	
	private String _xAxisLabel;
	private String _yAxisLabel;
	private TableXYDataset _dataset;
	
	/**
     * Initialises a stacked XY area plot.  The chart object returned by this
     * method uses an {@link XYPlot} instance as the plot, with a
     * {@link NumberAxis} for the domain axis, a {@link NumberAxis} as the
     * range axis, and a {@link StackedXYAreaRenderer2} as the renderer.
     *
     * @param xAxisLabel  a label for the X-axis ({@code null} permitted).
     * @param yAxisLabel  a label for the Y-axis ({@code null} permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
	public StackedXYArea(String xAxisLabel, String yAxisLabel, TableXYDataset dataset) {
		_xAxisLabel = xAxisLabel;
		_yAxisLabel = yAxisLabel;
		_dataset = dataset;
	}
	
	/**
     * Creates a stacked XY area plot.  The chart object returned by this
     * method uses an {@link XYPlot} instance as the plot, with a
     * {@link NumberAxis} for the domain axis, a {@link NumberAxis} as the
     * range axis, and a {@link StackedXYAreaRenderer2} as the renderer.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A stacked XY area chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		 NumberAxis xAxis = new NumberAxis(_xAxisLabel);
	        xAxis.setAutoRangeIncludesZero(false);
	        xAxis.setLowerMargin(0.0);
	        xAxis.setUpperMargin(0.0);
	        NumberAxis yAxis = new NumberAxis(_yAxisLabel);
	        XYToolTipGenerator toolTipGenerator = new StandardXYToolTipGenerator();
	        StackedXYAreaRenderer2 renderer = new StackedXYAreaRenderer2(
	                toolTipGenerator, null);
	        renderer.setOutline(true);
	        XYPlot plot = new XYPlot(_dataset, xAxis, yAxis, renderer);

	        plot.setRangeAxis(yAxis);  // forces recalculation of the axis range

	        JFreeChart chart = new JFreeChart(title, plot);
	        return chart;
	}

}
