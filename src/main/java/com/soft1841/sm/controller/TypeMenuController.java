package com.soft1841.sm.controller;

import com.soft1841.sm.entity.Admin;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TypeMenuController implements Initializable {
    @FXML
    private StackPane stackPane;
    private Admin admin;
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public void listTypeLook() throws Exception {
        switchView("type_look.fxml");
    }
    public void listTypeAnalysis() throws Exception {
        switchView("type_analysis.fxml");
    }


    //封装一个切换视图的方法，用来根据fxml文件切换视图内容
    public void switchView(String fileName) throws Exception {
        //清除主面板之前内容
        ObservableList<Node> list = stackPane.getChildren();
        stackPane.getChildren().removeAll(list);
        //读取新的布局文件加入主面板
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + fileName));
        AnchorPane root = fxmlLoader.load();
//        DefaultController defaultController = fxmlLoader.getController();
//        //将admin传到defaultController
//        defaultController.setAdmin(admin);
        stackPane.getChildren().add(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = new FXMLLoader(getClass().getResource("/fxml/type_analysis.fxml")).load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stackPane.getChildren().add(anchorPane);
    }
}
