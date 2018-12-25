package com.soft1841.sm.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private StackPane mainContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //显示默认主页数据
    public void listDefault() throws Exception {
        switchView("default.fxml");
    }

    //显示商品类别数据
    public void listCategory() throws Exception {
        switchView("category.fxml");
    }

    //显示商品数据
    public void listCommodity() throws Exception {
        switchView("commodity.fxml");
    }

    //显示收银员数据
    public void listCashier() throws Exception {
        switchView("cashier.fxml");
    }

    //显示会员数据
    public void listMember() throws Exception {
        switchView("member.fxml");
    }

    //显示小票数据
    public void listCashier_check() throws Exception {
        switchView("cashier_check.fxml");
    }

    //显示收银明细
    public void listRegister_detail() throws Exception {
        switchView("register_detail.fxml");
    }


    //封装一个切换视图的方法：用来根据fxml文件切换视图内容
    private void switchView(String fileName) throws Exception {
        //清除主面板之前内容
        ObservableList<Node> list = mainContainer.getChildren();
        mainContainer.getChildren().removeAll(list);
        //读取新的布局文件加入主面板
        AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/" + fileName)).load();
        mainContainer.getChildren().add(anchorPane);
    }
}