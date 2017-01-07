package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;

public class StackedBar implements IChart{

	private String _domainAxisLabel;
	private String _rangeAxisLabel;
    private CategoryDataset _dataset;
    
    /**
     * Initialises a stacked bar chart with default settings.  The chart object
     * returned by this method uses a {@link CategoryPlot} instance as the
     * plot, with a {@link CategoryAxis} for the domain axis, a
     * {@link NumberAxis} as the range axis, and a {@link StackedBarRenderer}
     * as the renderer.
     *
     * @param domainAxisLabel  the label for the category axis
     *                         ({@code null} permitted).
     * @param rangeAxisLabel  the label for the value axis
     *                        ({@code null} permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
    public StackedBar(String domainAxisLabel, String rangeAxisLabel, CategoryDataset dataset) {
		_domainAxisLabel = domainAxisLabel;
		_rangeAxisLabel = rangeAxisLabel;
		_dataset = dataset;		
	}
    
    /**
     * Creates a stacked bar chart with default settings.  The chart object
     * returned by this method uses a {@link CategoryPlot} instance as the
     * plot, with a {@link CategoryAxis} for the domain axis, a
     * {@link NumberAxis} as the range axis, and a {@link StackedBarRenderer}
     * as the renderer.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A stacked bar chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		CategoryAxis categoryAxis = new CategoryAxis(_domainAxisLabel);
        ValueAxis valueAxis = new NumberAxis(_rangeAxisLabel);

        StackedBarRenderer renderer = new StackedBarRenderer();
        renderer.setDefaultToolTipGenerator(
                new StandardCategoryToolTipGenerator());

        CategoryPlot plot = new CategoryPlot(_dataset, categoryAxis, valueAxis,
                renderer);
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
