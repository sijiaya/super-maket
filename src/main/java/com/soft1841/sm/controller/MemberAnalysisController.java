package com.soft1841.sm.controller;

import com.soft1841.sm.entity.Member;
import com.soft1841.sm.service.MemberService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import org.apache.poi.util.Internal;

import javax.swing.event.TreeModelEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MemberAnalysisController implements Initializable {
    @FXML
    private StackPane barChartPane;
    private int[] integrals = {70,15,120,40,50,60};
    private MemberService memberService= ServiceFactory.getMemberServiceInstance();
    private ObservableList<BarChart.Data> barChartData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initBarChart();
    }

    private void initBarChart() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc =
                new BarChart<>(xAxis, yAxis);
        bc.setTitle("根据积分统计柱形图");
        xAxis.setLabel("积分");
        yAxis.setLabel("数量");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2018年统计数据");
        for (int integral :integrals) {
            int count =memberService.countByIntegral(integral);
           barChartData.add(new XYChart.Data(integral,count));
        }


        barChartPane.getChildren().add(bc);
    }
}
