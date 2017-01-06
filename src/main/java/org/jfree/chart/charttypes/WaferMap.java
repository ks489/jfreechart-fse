package org.jfree.chart.charttypes;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.WaferMapPlot;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.data.general.WaferMapDataset;

public class WaferMap implements IChart {

	private WaferMapDataset _dataset;
	
	/**
     * Initialises a wafer map chart.
     *
     * @param dataset  the dataset (<code>null</code> permitted).
     *
     */
	public WaferMap(WaferMapDataset dataset){
		_dataset = dataset;
	}
	
	/**
     * Creates a wafer map chart.
     *
     * @param title  the chart title (<code>null</code> permitted).
     *
     * @return A wafer map chart.
     */
	@Override
	public JFreeChart createChart(String title) {
		WaferMapPlot plot = new WaferMapPlot(_dataset);
        WaferMapRenderer renderer = new WaferMapRenderer();
        plot.setRenderer(renderer);

        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
	}
	
}
