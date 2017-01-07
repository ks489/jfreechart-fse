package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.util.ParamChecks;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.CategoryDataset;

public class MultiplePie implements IChart{

	private CategoryDataset _dataset;
	private TableOrder _order;
	
	/**
     * Initialises a chart that displays multiple pie plots.  The chart object
     * returned by this method uses a {@link MultiplePiePlot} instance as the
     * plot.
     *
     * @param dataset  the dataset ({@code null} permitted).
     * @param order  the order that the data is extracted (by row or by column)
     *               ({@code null} not permitted).
     *
     */
	public MultiplePie(CategoryDataset dataset, TableOrder order) {
		_dataset = dataset;
		_order = order;
	}
	
	/**
     * Creates a chart that displays multiple pie plots.  The chart object
     * returned by this method uses a {@link MultiplePiePlot} instance as the
     * plot.
     *
     * @param title  the chart title ({@code null} permitted).
     *               ({@code null} not permitted).
     *
     * @return A chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		ParamChecks.nullNotPermitted(_order, "order");
        MultiplePiePlot plot = new MultiplePiePlot(_dataset);
        plot.setDataExtractOrder(_order);
        plot.setBackgroundPainter(null);
        plot.setBorderPainter(null);

        PieToolTipGenerator tooltipGenerator
                = new StandardPieToolTipGenerator();
        PiePlot pp = (PiePlot) plot.getPieChart().getPlot();
        pp.setToolTipGenerator(tooltipGenerator);

        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
