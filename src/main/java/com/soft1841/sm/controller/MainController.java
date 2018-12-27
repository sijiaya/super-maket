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

public class MainController  implements Initializable {
    @FXML
    private StackPane MainController;
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
    public void listDefault() throws Exception {
        switchView("default.fxml");
    }

    public void listType() throws Exception {
        switchView("type.fxml");
    }

    public void listGoods() throws Exception {
        switchView("goods.fxml");
    }

    public void listAdmin() throws Exception {
        switchView("admin.fxml");
    }
    public void listReader() throws Exception{
        switchView("reader.fxml");
    }



    //封装一个切换视图的方法，用来根据fxml文件切换视图内容
    private void switchView(String fileName) throws Exception {
        //清除主面板之前内容
        ObservableList<Node> list = MainController.getChildren();
        MainController.getChildren().removeAll(list);
        //读取新的布局文件加入主面板
        AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/" + fileName)).load();
        MainController.getChildren().add(anchorPane);
    }
}
