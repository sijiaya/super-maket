package com.soft1841.sm.controller;

import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.service.AdminService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
   @FXML
   private FlowPane flowPane;
    private AdminService adminService = ServiceFactory.getAdminsServiceInstance();
    private List<Admin> adminList = new ArrayList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
adminList = adminService.getAllAdmins();
showAdmins(adminList);
    }
    private void showAdmins(List<Admin> adminList){
        flowPane.getChildren().clear();
        for (Admin admin: adminList
             ) {
            HBox hBox = new HBox();
            hBox.setPrefSize(300, 240);
            hBox.getStyleClass().add("box");
            hBox.setSpacing(30);
            //左边垂直布局放头像和身份
            VBox leftBox = new VBox();
            leftBox.setAlignment(Pos.TOP_CENTER);
            leftBox.setSpacing(30);
            ImageView imageView = new ImageView(new Image(admin.getAvatar()));
            imageView.setFitWidth(80);
            imageView.setFitHeight(80);
            Circle circle = new Circle();
            circle.setCenterX(40.0);
            circle.setCenterY(40.0);
            circle.setRadius(40.0);
            imageView.setClip(circle);
            Label nameLabel = new Label("姓名:"+admin.getName());
            leftBox.getChildren().addAll(imageView, nameLabel);
            //右边垂直布局放家庭住址
            VBox rightBox = new VBox();
            rightBox.setSpacing(15);
            Label addressLabel = new Label("籍贯："+admin.getAddress());
//            Label idLabel = new Label(admin.getJob_id());
            nameLabel.getStyleClass().add("font-title");
            rightBox.getChildren().addAll(addressLabel);
            //左右两个垂直布局加入水平布局
            hBox.getChildren().addAll(leftBox, rightBox);
            //水平布局加入大的内容容器
            flowPane.getChildren().add(hBox);
        }
    }
    }
