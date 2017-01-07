package org.jfree.chart.charttypes;

import java.awt.Font;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.util.ParamChecks;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.CategoryDataset;

public class MultiplePie3D implements IChart{

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
	public MultiplePie3D(CategoryDataset dataset, TableOrder order) {
		_dataset = dataset;
		_order = order;
	}
	
	/**
     * Creates a chart that displays multiple pie plots.  The chart object
     * returned by this method uses a {@link MultiplePiePlot} instance as the
     * plot.
     *
     * @param title  the chart title ({@code null} permitted).    
     * @return A chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		ParamChecks.nullNotPermitted(_order, "order");
        MultiplePiePlot plot = new MultiplePiePlot(_dataset);
        plot.setDataExtractOrder(_order);
        plot.setBackgroundPainter(null);
        plot.setBorderPainter(null);

        JFreeChart pieChart = new JFreeChart(new PiePlot3D(null));
        TextTitle seriesTitle = new TextTitle("Series Title",
                new Font("SansSerif", Font.BOLD, 12));
        seriesTitle.setPosition(RectangleEdge.BOTTOM);
        pieChart.setTitle(seriesTitle);
        pieChart.removeLegend();
        pieChart.setBackgroundPainter(null);
        plot.setPieChart(pieChart);

        PieToolTipGenerator tooltipGenerator
                = new StandardPieToolTipGenerator();
        PiePlot pp = (PiePlot) plot.getPieChart().getPlot();
            pp.setToolTipGenerator(tooltipGenerator);

        JFreeChart chart = new JFreeChart(title, plot);
        return chart;

	}

}
