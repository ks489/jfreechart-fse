package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.data.xy.XYDataset;

public class XYArea implements IChart{
	
	private String _xAxisLabel;
    private String _yAxisLabel;
    private XYDataset _dataset;
    
    /**
     * Initialises an area chart using an {@link XYDataset}.
     * <P>
     * The chart object returned by this method uses an {@link XYPlot} instance
     * as the plot, with a {@link NumberAxis} for the domain axis, a
     * {@link NumberAxis} as the range axis, and a {@link XYAreaRenderer} as
     * the renderer.
     *
     * @param xAxisLabel  a label for the X-axis ({@code null} permitted).
     * @param yAxisLabel  a label for the Y-axis ({@code null} permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
    public XYArea(String xAxisLabel, String yAxisLabel, XYDataset dataset) {
		_xAxisLabel = xAxisLabel;
		_yAxisLabel = yAxisLabel;
		_dataset = dataset;
	}
    
    /**
     * Creates an area chart using an {@link XYDataset}.
     * <P>
     * The chart object returned by this method uses an {@link XYPlot} instance
     * as the plot, with a {@link NumberAxis} for the domain axis, a
     * {@link NumberAxis} as the range axis, and a {@link XYAreaRenderer} as
     * the renderer.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return An XY area chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		NumberAxis xAxis = new NumberAxis(_xAxisLabel);
        xAxis.setAutoRangeIncludesZero(false);
        NumberAxis yAxis = new NumberAxis(_yAxisLabel);
        XYPlot plot = new XYPlot(_dataset, xAxis, yAxis, null);
        plot.setForegroundAlpha(0.5f);

        XYToolTipGenerator tipGenerator = new StandardXYToolTipGenerator();
        plot.setRenderer(new XYAreaRenderer(XYAreaRenderer.AREA, tipGenerator,
                null));
        JFreeChart chart = new JFreeChart(title, plot);

        return chart;
	}

}
