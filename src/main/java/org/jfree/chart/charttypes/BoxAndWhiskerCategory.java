package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;

public class BoxAndWhiskerCategory implements IChart{
	
	private String _categoryAxisLabel;
	private String _valueAxisLabel;
    private BoxAndWhiskerCategoryDataset _dataset;
    
    /**
     * Initialises and returns a default instance of a box and whisker chart
     * based on data from a {@link BoxAndWhiskerCategoryDataset}.
     * @param categoryAxisLabel  a label for the category axis
     *     (<code>null</code> permitted).
     * @param valueAxisLabel  a label for the value axis (<code>null</code>
     *     permitted).
     * @param dataset  the dataset for the chart (<code>null</code> permitted).
     *
     * @since 1.0.4
     */
    public BoxAndWhiskerCategory(String categoryAxisLabel, String valueAxisLabel, BoxAndWhiskerCategoryDataset dataset){
    	_categoryAxisLabel = categoryAxisLabel;
    	_valueAxisLabel = valueAxisLabel;
    	_dataset = dataset;
    }
    
    /**
     * Creates and returns a default instance of a box and whisker chart
     * based on data from a {@link BoxAndWhiskerCategoryDataset}.
     *
     * @param title  the chart title (<code>null</code> permitted).
     *
     * @return A box and whisker chart.
     *
     * @since 1.0.4
     */
	@Override
	public JFreeChart createChart(String title) {
		CategoryAxis categoryAxis = new CategoryAxis(_categoryAxisLabel);
        NumberAxis valueAxis = new NumberAxis(_valueAxisLabel);
        valueAxis.setAutoRangeIncludesZero(false);

        BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
        renderer.setDefaultToolTipGenerator(new BoxAndWhiskerToolTipGenerator());

        CategoryPlot plot = new CategoryPlot(_dataset, categoryAxis, valueAxis,
                renderer);
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
