package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.xy.XYDataset;

public class Polar implements IChart{

	private XYDataset _dataset;
	
	/**
     * Initialises a polar plot for the specified dataset (x-values interpreted as
     * angles in degrees).  The chart object returned by this method uses a
     * {@link PolarPlot} instance as the plot, with a {@link NumberAxis} for
     * the radial axis.
     *
     * @param dataset  the dataset (<code>null</code> permitted).
     *
     */
	public Polar(XYDataset dataset) {
		_dataset = dataset;
	}
	
	/**
     * Creates a polar plot for the specified dataset (x-values interpreted as
     * angles in degrees).  The chart object returned by this method uses a
     * {@link PolarPlot} instance as the plot, with a {@link NumberAxis} for
     * the radial axis.
     *
     * @param title  the chart title (<code>null</code> permitted).
     *
     * @return A chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		PolarPlot plot = new PolarPlot();
        plot.setDataset(_dataset);
        NumberAxis rangeAxis = new NumberAxis();
        rangeAxis.setAxisLineVisible(false);
        rangeAxis.setTickMarksVisible(false);
        rangeAxis.setTickLabelInsets(new RectangleInsets(0.0, 0.0, 0.0, 0.0));
        plot.setAxis(rangeAxis);
        plot.setRenderer(new DefaultPolarItemRenderer());
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
