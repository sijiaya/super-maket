package com.soft1841.sm.controller;

import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.service.AdminService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DefaultController implements Initializable {
    private AdminService adminService = ServiceFactory.getAdminsServiceInstance();
@FXML
private FlowPane quickPane;
    @FXML
    private ImageView Goodimg;
    //轮播图资源数组
    String[] imgPath = {"good1.jpg", "good2.jpg", "good3.jpg","good4.jpg"};
    @FXML
    private FlowPane adminPane;
    private List<Admin> adminList = new ArrayList<>();
    private Admin admin;
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                VBox vBox = new VBox();
                vBox.setSpacing(20);
                vBox.setPadding(new Insets(20,20,20,20));
//             ImageView imageView = new ImageView(new Image(admin.getAvatar()));
                Circle circle = new Circle();
                circle.setCenterX(40);
                circle.setCenterY(40);
                circle.setRadius(40);
//              imageView.setClip(circle);
  Label nameLabel = new Label("昵称");
                Label addLabel = new Label("家住:");
                Button button = new Button("修改个人信息");
                button.getStyleClass().add("default-theme");
                vBox.getChildren().addAll(nameLabel,addLabel,button);
                adminPane.getChildren().add(vBox);
            }
        });
        //新建一个线程，用来轮播
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //循环读取图片数组
                    for (int i = 0; i < imgPath.length; i++) {
                        //用每个资源创建一个图片对象
                        Image image = new Image("/img/" + imgPath[i]);
                        //开启一个UI线程
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                //将创建的Image对象设置给ImageView
                                Goodimg.setImage(image);
                            }
                        });
                        try {
                            //休眠2秒
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //轮播到最后一张图的时候，回到第一张重新播放
                        if (i == imgPath.length - 1) {
                            i = 0;
                        }
                    }
                }
            }
        }).start();
    }
    public void showAdmins(List<Admin> adminList){
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
            adminPane.getChildren().add(hBox);
        }
    }
    public void backup() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("数据备份");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/backup.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void  addGoods() throws IOException {
        Stage addGoodsStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/add_goods.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root,600,700);
        scene.getStylesheets().add("/css/style.css");
        addGoodsStage.setTitle("新增商品界面");
        addGoodsStage.setResizable(false);
        addGoodsStage.setScene(scene);
        addGoodsStage.show();
    }
}
