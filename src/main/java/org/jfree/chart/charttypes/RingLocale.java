package org.jfree.chart.charttypes;

import java.util.Locale;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.PieDataset;

public class RingLocale implements IChart{

	private PieDataset _dataset;
    private Locale _locale;
    
    /**
     * Initialises a ring chart with default settings.
     * <P>
     * The chart object returned by this method uses a {@link RingPlot}
     * instance as the plot.
     *
     * @param dataset  the dataset for the chart ({@code null} permitted).
     * @param locale  the locale ({@code null} not permitted).
     *
     *
     * @since 1.0.7
     */
    public RingLocale(PieDataset dataset, Locale locale) {
    	_dataset = dataset;
    	_locale = locale;
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
     *
     * @since 1.0.7
     */
	@Override
	public JFreeChart createChart(String title) {
		RingPlot plot = new RingPlot(_dataset);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(_locale));
        plot.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        plot.setToolTipGenerator(new StandardPieToolTipGenerator(_locale));
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
