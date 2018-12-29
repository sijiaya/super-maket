package com.soft1841.sm.controller;

import com.soft1841.sm.service.AdminService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAnalysisController implements Initializable {
    @FXML
    private StackPane pieCharPane;
    private String[] address = {"山西" ,"浙江","江苏","贵州"};
    private AdminService adminService = ServiceFactory.getAdminsServiceInstance();
    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initPieChart();

    }

    private void initPieChart() {
        for (String address:address
             ) {
            int count = adminService.countByAddress(address);
            pieChartData.add(new PieChart.Data(address,count));

        }
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("按地址统计饼图");
       pieCharPane.getChildren().add(chart);
    }
}
