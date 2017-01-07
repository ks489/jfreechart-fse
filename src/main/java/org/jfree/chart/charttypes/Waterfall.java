package org.jfree.chart.charttypes;

import java.awt.Color;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.WaterfallBarRenderer;
import org.jfree.chart.ui.Layer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.CategoryDataset;

public class Waterfall implements IChart{

	private String _categoryAxisLabel;
	private String _valueAxisLabel;
    private CategoryDataset _dataset;
    
    /**
     * Initialises a waterfall chart.  The chart object returned by this method
     * uses a {@link CategoryPlot} instance as the plot, with a
     * {@link CategoryAxis} for the domain axis, a {@link NumberAxis} as the
     * range axis, and a {@link WaterfallBarRenderer} as the renderer.
     *
     * @param categoryAxisLabel  the label for the category axis
     *                           ({@code null} permitted).
     * @param valueAxisLabel  the label for the value axis ({@code null}
     *                        permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
    public Waterfall(String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset) {
		_categoryAxisLabel = categoryAxisLabel;
		_valueAxisLabel = valueAxisLabel;
		_dataset = dataset;
	}
    
    /**
     * Creates a waterfall chart.  The chart object returned by this method
     * uses a {@link CategoryPlot} instance as the plot, with a
     * {@link CategoryAxis} for the domain axis, a {@link NumberAxis} as the
     * range axis, and a {@link WaterfallBarRenderer} as the renderer.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A waterfall chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		CategoryAxis categoryAxis = new CategoryAxis(_categoryAxisLabel);
        categoryAxis.setCategoryMargin(0.0);

        ValueAxis valueAxis = new NumberAxis(_valueAxisLabel);

        WaterfallBarRenderer renderer = new WaterfallBarRenderer();
        // FIXME create a new method for the horizontal version
//        if (orientation == PlotOrientation.HORIZONTAL) {
//            ItemLabelPosition position = new ItemLabelPosition(
//                    ItemLabelAnchor.CENTER, TextAnchor.CENTER,
//                    TextAnchor.CENTER, Math.PI / 2.0);
//            renderer.setBasePositiveItemLabelPosition(position);
//            renderer.setBaseNegativeItemLabelPosition(position);
//         }
        ItemLabelPosition position = new ItemLabelPosition(
                ItemLabelAnchor.CENTER, TextAnchor.CENTER,
                TextAnchor.CENTER, 0.0);
        renderer.setDefaultPositiveItemLabelPosition(position);
        renderer.setDefaultNegativeItemLabelPosition(position);
        StandardCategoryToolTipGenerator generator
                = new StandardCategoryToolTipGenerator();
        renderer.setDefaultToolTipGenerator(generator);

        CategoryPlot plot = new CategoryPlot(_dataset, categoryAxis, valueAxis,
                renderer);
        plot.clearRangeMarkers();
        Marker baseline = new ValueMarker(0.0);
        baseline.setPaint(Color.BLACK);
        plot.addRangeMarker(baseline, Layer.FOREGROUND);
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
