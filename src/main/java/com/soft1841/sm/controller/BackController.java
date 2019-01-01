package com.soft1841.sm.controller;
import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.service.AdminService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BackController implements Initializable {
    private AdminService adminService = ServiceFactory.getAdminsServiceInstance();
    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView adminAvatar;
    @FXML
            private Label adminName;
    @FXML
    private FlowPane adminPane;
    private Stage primaryStage;
    private Admin admin;
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    public void close() throws IOException {
        //关闭主界面
        Stage mainStage = (Stage) stackPane.getScene().getWindow();
        mainStage.close();
        //弹出登录界面
        Stage loginStage = new Stage();
        loginStage.setTitle("管理员登录");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AdminLogin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        loginStage.getIcons().add(new Image("/img/logo.png"));
        loginStage.setScene(scene);
        loginStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //开启一个UI线程 ,将登录界面传过来的管理员信息显示在主界面的右上角
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Image image = new Image(admin.getAvatar());
                adminAvatar.setImage(image);
                Circle circle = new Circle();
                circle.setCenterX(40);
                circle.setCenterY(40);
                circle.setRadius(40);
                adminAvatar.setClip(circle);
                //显示管理员姓名
                adminName.setText(admin.getName());
            }
        });

        try {
            AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/default.fxml")).load();
            stackPane.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        DefaultController defaultController = fxmlLoader.getController();
//        //将admin传到defaultController
//        defaultController.setAdmin(admin);
//       stackPane.getChildren().add(anchorPane);
    }
    public void listUser() throws Exception {
        switchView("user.fxml");
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
    public void listSeller() throws Exception{
        switchView("seller.fxml");
    }
    public void backup() throws Exception {
        switchView("backup.fxml");
    }
    public void listMember() throws Exception {
        switchView("member.fxml");
    }
    public void listCount() throws Exception {
        switchView("type_analysis.fxml");
    }
    public void system() throws Exception {
        switchView("system.fxml");
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
}
