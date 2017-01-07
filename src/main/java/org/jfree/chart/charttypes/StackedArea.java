package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.StackedAreaRenderer;
import org.jfree.data.category.CategoryDataset;

public class StackedArea implements IChart{

	private String _categoryAxisLabel;
	private String _valueAxisLabel;
    private CategoryDataset _dataset;
    
    /**
     * Initialises a stacked area chart with default settings.  The chart object
     * returned by this method uses a {@link CategoryPlot} instance as the
     * plot, with a {@link CategoryAxis} for the domain axis, a
     * {@link NumberAxis} as the range axis, and a {@link StackedAreaRenderer}
     * as the renderer.
     *
     * @param categoryAxisLabel  the label for the category axis
     *                           ({@code null} permitted).
     * @param valueAxisLabel  the label for the value axis ({@code null}
     *                        permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
    public StackedArea(String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset) {
    	_categoryAxisLabel = categoryAxisLabel;
    	_valueAxisLabel = valueAxisLabel;
    	_dataset = dataset;
	}
    
    /**
     * Creates a stacked area chart with default settings.  The chart object
     * returned by this method uses a {@link CategoryPlot} instance as the
     * plot, with a {@link CategoryAxis} for the domain axis, a
     * {@link NumberAxis} as the range axis, and a {@link StackedAreaRenderer}
     * as the renderer.
     *
     * @param title  the chart title ({@code null} permitted).
     * @return A stacked area chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		CategoryAxis categoryAxis = new CategoryAxis(_categoryAxisLabel);
        categoryAxis.setCategoryMargin(0.0);
        ValueAxis valueAxis = new NumberAxis(_valueAxisLabel);

        StackedAreaRenderer renderer = new StackedAreaRenderer();
        renderer.setDefaultToolTipGenerator(
                    new StandardCategoryToolTipGenerator());

        CategoryPlot plot = new CategoryPlot(_dataset, categoryAxis, valueAxis,
                renderer);
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
