package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.CategoryDataset;

public class Bar implements IChart{

	private String _categoryAxisLabel;
	private String _valueAxisLabel;
    private CategoryDataset _dataset;
    
    /**
     * Initialises a bar chart with a vertical orientation.  The chart object
     * returned by this method uses a {@link CategoryPlot} instance as the
     * plot, with a {@link CategoryAxis} for the domain axis, a
     * {@link NumberAxis} as the range axis, and a {@link BarRenderer} as the
     * renderer.
     *
     * @param categoryAxisLabel  the label for the category axis ({@code null} 
     *     permitted).
     * @param valueAxisLabel  the label for the value axis ({@code null} 
     *     permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
    public Bar(String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset) {
    	_categoryAxisLabel = categoryAxisLabel;
    	_valueAxisLabel = valueAxisLabel;
    	_dataset = dataset;
	}
    
    /**
     * Creates a bar chart with a vertical orientation.  The chart object
     * returned by this method uses a {@link CategoryPlot} instance as the
     * plot, with a {@link CategoryAxis} for the domain axis, a
     * {@link NumberAxis} as the range axis, and a {@link BarRenderer} as the
     * renderer.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A bar chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		CategoryAxis categoryAxis = new CategoryAxis(_categoryAxisLabel);
        ValueAxis valueAxis = new NumberAxis(_valueAxisLabel);

        BarRenderer renderer = new BarRenderer();
        ItemLabelPosition position1 = new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER);
        renderer.setDefaultPositiveItemLabelPosition(position1);
        ItemLabelPosition position2 = new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER);
        renderer.setDefaultNegativeItemLabelPosition(position2);
        renderer.setDefaultToolTipGenerator(
                    new StandardCategoryToolTipGenerator());

        CategoryPlot plot = new CategoryPlot(_dataset, categoryAxis, valueAxis,
                renderer);
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
