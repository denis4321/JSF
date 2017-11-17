/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statistics;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author prokopiukd
 */
@Named
@ManagedBean
public class ChartView implements Serializable {

    @Inject
    private BlockchainService blockchainService;// = new BlockchainService();

    private LineChartModel lineModel1;

    @PostConstruct
    public void init() {
        createLineModels();
    }

    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        Map<String, Float> blocks = blockchainService.getBlocks();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Blocks");
        int index = 0;
        for (String key : blocks.keySet()) {
            series1.set(++index, blocks.get(key));
        }
        model.addSeries(series1);
        return model;
    }

    public void addBlock() {
        blockchainService.makeBlock();
    }
}
