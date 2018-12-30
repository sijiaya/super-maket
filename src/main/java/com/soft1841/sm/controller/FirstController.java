package com.soft1841.sm.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstController implements Initializable {
    @FXML
    private StackPane FirstController;
    private Stage primaryStage;
    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    public void close(){
        primaryStage.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void listA() throws Exception {
        switchView("admin_analysis.fxml");
    }
    public void listM() throws Exception {
        switchView("member_analysis.fxml");
    }

    public void switchView(String fileName) throws Exception {
        //清除主面板之前内容
        ObservableList<Node> list = FirstController.getChildren();
        FirstController.getChildren().removeAll(list);
        //读取新的布局文件加入主面板
        AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/" + fileName)).load();
        FirstController.getChildren().add(anchorPane);
    }
}
