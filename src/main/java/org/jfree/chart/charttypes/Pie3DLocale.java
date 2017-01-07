package org.jfree.chart.charttypes;

import java.util.Locale;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.PieDataset;

public class Pie3DLocale implements IChart{

	private PieDataset _dataset;
    private Locale _locale;
    
    /**
     * Initialises a 3D pie chart using the specified dataset.  The chart object
     * returned by this method uses a {@link PiePlot3D} instance as the
     * plot.
     *
     * @param dataset  the dataset for the chart ({@code null} permitted).
     * @param locale  the locale ({@code null} not permitted).
     *
     *
     * @since 1.0.7
     */
    public Pie3DLocale(PieDataset dataset, Locale locale) {
    	_dataset = dataset;
    	_locale = locale;
	}
    
    /**
     * Creates a 3D pie chart using the specified dataset.  The chart object
     * returned by this method uses a {@link PiePlot3D} instance as the
     * plot.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A pie chart.
     *
     * @since 1.0.7
     */
	@Override
	public JFreeChart createChart(String title) {
		PiePlot3D plot = new PiePlot3D(_dataset);
        plot.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        plot.setToolTipGenerator(new StandardPieToolTipGenerator(_locale));
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
