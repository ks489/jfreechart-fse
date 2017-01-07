package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.PieDataset;

public class Ring implements IChart{

	private PieDataset _dataset;
	
	/**
     * Initialises a ring chart with default settings.
     * <P>
     * The chart object returned by this method uses a {@link RingPlot}
     * instance as the plot.
     *
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
	public Ring(PieDataset dataset) {
		_dataset = dataset;
	}
	
	/**
     * Creates a ring chart with default settings.
     * <P>
     * The chart object returned by this method uses a {@link RingPlot}
     * instance as the plot.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A ring chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		RingPlot plot = new RingPlot(_dataset);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator());
        plot.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        plot.setToolTipGenerator(new StandardPieToolTipGenerator());
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
