package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.PieDataset;

public class PieSimple implements IChart{

	private PieDataset _dataset;
	
	/**
     * Initialises a pie chart with default settings.
     * <P>
     * The chart object returned by this method uses a {@link PiePlot} instance
     * as the plot.
     *
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
	public PieSimple(PieDataset dataset) {
		_dataset = dataset;
	}
	
	/**
     * Creates a pie chart with default settings.
     * <P>
     * The chart object returned by this method uses a {@link PiePlot} instance
     * as the plot.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A pie chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		PiePlot plot = new PiePlot(_dataset);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator());
        plot.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        plot.setToolTipGenerator(new StandardPieToolTipGenerator());
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
