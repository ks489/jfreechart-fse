package org.jfree.chart.charttypes;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieLocale implements IChart{

	private PieDataset _dataset;
    private PieDataset _previousDataset;
    private int _percentDiffForMaxScale;
    private boolean _greenForIncrease;
    private Locale _locale;
    private boolean _subTitle;
    private boolean _showDifference;
    
    public PieLocale(PieDataset dataset,
            PieDataset previousDataset, int percentDiffForMaxScale,
            boolean greenForIncrease, Locale locale, boolean subTitle,
            boolean showDifference) {
    	_dataset = dataset;
    	_previousDataset = previousDataset;
    	_percentDiffForMaxScale = percentDiffForMaxScale;
    	_greenForIncrease = greenForIncrease;
    	_locale = locale;
    	_subTitle = subTitle;
    	_showDifference = showDifference;
	}
    
    /**
     * Creates a pie chart with default settings that compares 2 datasets.
     * The color of each section will be determined by the move from the value
     * for the same key in {@code previousDataset}. ie if value1 &gt; value2
     * then the section will be in green (unless {@code greenForIncrease}
     * is {@code false}, in which case it would be {@code red}).
     * Each section can have a shade of red or green as the difference can be
     * tailored between 0% (black) and percentDiffForMaxScale% (bright
     * red/green).
     * <p>
     * For instance if {@code percentDiffForMaxScale} is 10 (10%), a
     * difference of 5% will have a half shade of red/green, a difference of
     * 10% or more will have a maximum shade/brightness of red/green.
     * <P>
     * The chart object returned by this method uses a {@link PiePlot} instance
     * as the plot.
     * <p>
     * Written by <a href="mailto:opensource@objectlab.co.uk">Benoit
     * Xhenseval</a>.
     *
     * @param dataset  the dataset for the chart ({@code null} permitted).
     * @param previousDataset  the dataset for the last run, this will be used
     *                         to compare each key in the dataset
     * @param percentDiffForMaxScale scale goes from bright red/green to black,
     *                               percentDiffForMaxScale indicate the change
     *                               required to reach top scale.
     * @param greenForIncrease  an increase since previousDataset will be
     *                          displayed in green (decrease red) if true.
     * @param locale  the locale ({@code null} not permitted).
     * @param subTitle displays a subtitle with color scheme if true
     * @param showDifference  create a new dataset that will show the %
     *                        difference between the two datasets.
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

        List<Comparable> keys = _dataset.getKeys();
        DefaultPieDataset series = null;
        if (_showDifference) {
            series = new DefaultPieDataset();
        }

        double colorPerPercent = 255.0 / _percentDiffForMaxScale;
        for (Comparable key : keys) {
            Number newValue = _dataset.getValue(key);
            Number oldValue = _previousDataset.getValue(key);

            if (oldValue == null) {
                if (_greenForIncrease) {
                    plot.setSectionPaint(key, Color.GREEN);
                } else {
                    plot.setSectionPaint(key, Color.RED);
                }
                if (_showDifference) {
                    assert series != null; // suppress compiler warning
                    series.setValue(key + " (+100%)", newValue);
                }
            } else {
                double percentChange = (newValue.doubleValue()
                        / oldValue.doubleValue() - 1.0) * 100.0;
                double shade = (Math.abs(percentChange) 
                        >= _percentDiffForMaxScale ? 255
                        : Math.abs(percentChange) * colorPerPercent);
                if (_greenForIncrease
                        && newValue.doubleValue() > oldValue.doubleValue()
                        || !_greenForIncrease && newValue.doubleValue()
                        < oldValue.doubleValue()) {
                    plot.setSectionPaint(key, new Color(0, (int) shade, 0));
                } else {
                    plot.setSectionPaint(key, new Color((int) shade, 0, 0));
                }
                if (_showDifference) {
                    assert series != null; // suppress compiler warning
                    series.setValue(key + " (" + (percentChange >= 0 ? "+" : "")
                            + NumberFormat.getPercentInstance().format(
                            percentChange / 100.0) + ")", newValue);
                }
            }
        }

        if (_showDifference) {
            plot.setDataset(series);
        }

        JFreeChart chart =  new JFreeChart(title, plot);

        if (_subTitle) {
            TextTitle subtitle = new TextTitle("Bright "
                    + (_greenForIncrease ? "red" : "green") + "=change >=-"
                    + _percentDiffForMaxScale
                    + "%, Bright " + (!_greenForIncrease ? "red" : "green")
                    + "=change >=+" + _percentDiffForMaxScale + "%",
                    new Font("SansSerif", Font.PLAIN, 10));
            chart.addSubtitle(subtitle);
        }
        return chart;
	}

}
