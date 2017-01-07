package org.jfree.chart.charttypes;

import java.text.DateFormat;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.data.category.IntervalCategoryDataset;

public class Gantt implements IChart{

	private String _categoryAxisLabel;
	private String _dateAxisLabel;
    private IntervalCategoryDataset _dataset;
    
    /**
     * Initialises a Gantt chart using the supplied attributes plus default values
     * where required.  The chart object returned by this method uses a
     * {@link CategoryPlot} instance as the plot, with a {@link CategoryAxis}
     * for the domain axis, a {@link DateAxis} as the range axis, and a
     * {@link GanttRenderer} as the renderer.
     *
     * @param categoryAxisLabel  the label for the category axis
     *                           ({@code null} permitted).
     * @param dateAxisLabel  the label for the date axis
     *                       ({@code null} permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
    public Gantt(String categoryAxisLabel, String dateAxisLabel, IntervalCategoryDataset dataset) {
		_categoryAxisLabel = categoryAxisLabel;
		_dateAxisLabel = dateAxisLabel;
		_dataset = dataset;
	}
    
    /**
     * Creates a Gantt chart using the supplied attributes plus default values
     * where required.  The chart object returned by this method uses a
     * {@link CategoryPlot} instance as the plot, with a {@link CategoryAxis}
     * for the domain axis, a {@link DateAxis} as the range axis, and a
     * {@link GanttRenderer} as the renderer.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A Gantt chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		CategoryAxis categoryAxis = new CategoryAxis(_categoryAxisLabel);
        DateAxis dateAxis = new DateAxis(_dateAxisLabel);

        CategoryItemRenderer renderer = new GanttRenderer();
        renderer.setDefaultToolTipGenerator(
                new IntervalCategoryToolTipGenerator(
                "{3} - {4}", DateFormat.getDateInstance()));

        CategoryPlot plot = new CategoryPlot(_dataset, categoryAxis, dateAxis,
                renderer);
        plot.setOrientation(PlotOrientation.HORIZONTAL);
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
