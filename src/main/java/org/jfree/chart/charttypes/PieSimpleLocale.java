package org.jfree.chart.charttypes;

import java.util.Locale;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.PieDataset;

public class PieSimpleLocale implements IChart{

	private PieDataset _dataset;
    private Locale _locale;
    
    /**
     * Initialises a pie chart with default settings.
     * <P>
     * The chart object returned by this method uses a {@link PiePlot} instance
     * as the plot.
     *
     * @param dataset  the dataset for the chart ({@code null} permitted).
     * @param locale  the locale ({@code null} not permitted).
     *
     *
     * @since 1.0.7
     */
    public PieSimpleLocale(PieDataset dataset,
            Locale locale) {
    	_dataset = dataset;
    	_locale = locale;
	}
    
    /**
     * Creates a pie chart with default settings.
     * <P>
     * The chart object returned by this method uses a {@link PiePlot} instance
     * as the plot.
     *
     * @param dataset  the dataset for the chart ({@code null} permitted).
     * @param locale  the locale ({@code null} not permitted).
     *
     * @return A pie chart.
     *
     * @since 1.0.7
     */
	@Override
	public JFreeChart createChart(String title) {
		PiePlot plot = new PiePlot(_dataset);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(_locale));
        plot.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        plot.setToolTipGenerator(new StandardPieToolTipGenerator(_locale));
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;

	}

}
