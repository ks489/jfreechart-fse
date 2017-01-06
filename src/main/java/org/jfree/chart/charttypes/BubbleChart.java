package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.ScaleType;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYZDataset;

public class BubbleChart implements IChart {
	
	private String _xAxisLabel;
    private String _yAxisLabel; 
    private XYZDataset _dataset;
    
    /**
     * Initialises a bubble chart with default settings.  The chart is composed of
     * an {@link XYPlot}, with a {@link NumberAxis} for the domain axis,
     * a {@link NumberAxis} for the range axis, and an {@link XYBubbleRenderer}
     * to draw the data items.
     *
     * @param xAxisLabel  a label for the X-axis ({@code null} permitted).
     * @param yAxisLabel  a label for the Y-axis ({@code null} permitted).
     * @param dataset  the dataset for the chart ({@code null} permitted).
     *
     */
    public BubbleChart(String xAxisLabel, String yAxisLabel, XYZDataset dataset) {
    	_xAxisLabel = xAxisLabel;
    	_yAxisLabel = yAxisLabel;
    	_dataset = dataset;    			
	}
    
    /**
     * Creates a bubble chart with default settings.  The chart is composed of
     * an {@link XYPlot}, with a {@link NumberAxis} for the domain axis,
     * a {@link NumberAxis} for the range axis, and an {@link XYBubbleRenderer}
     * to draw the data items.
     *
     * @param title  the chart title ({@code null} permitted).
     *
     * @return A bubble chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		NumberAxis xAxis = new NumberAxis(_xAxisLabel);
        xAxis.setAutoRangeIncludesZero(false);
        NumberAxis yAxis = new NumberAxis(_yAxisLabel);
        yAxis.setAutoRangeIncludesZero(false);

        XYPlot plot = new XYPlot(_dataset, xAxis, yAxis, null);

        XYItemRenderer renderer = new XYBubbleRenderer(ScaleType.Y_AXIS);
        renderer.setDefaultToolTipGenerator(new StandardXYZToolTipGenerator());
        plot.setRenderer(renderer);

        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}

}
