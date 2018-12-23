package com.soft1841.sm.controller;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.LoginDAO;
import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.utils.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

import java.awt.print.Book;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private LoginDAO loginDAO = DAOFactory.getLoginDAOInstance();
    private Stage primaryStage;
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;
    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void Login() throws SQLException, IOException, InterruptedException {
        String use = account.getText().trim();
        String psd = password.getText().trim();
        Entity user = loginDAO.getUserByName(use);
        if(null != user){
            if(user.getStr("password").equals(psd)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("信息提示");
                alert.setContentText("恭喜你登陆成功，1S后您跳转到管理界面");
                alert.show();
                Thread.sleep(1000);
                alert.close();
                primaryStage.close();
                Stage mainStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/xtsy.fxml"));
                AnchorPane root = fxmlLoader.load();
                Scene scene = new Scene(root);
//                scene.getStylesheets().add("/css/login.css");
                mainStage.getIcons().add(new Image("/img/logo.png"));
                mainStage.setTitle("后台管理系统");
                mainStage.setMaximized(true);
                mainStage.setScene(scene);
                mainStage.show();
            }else{
                System.out.println("密码错误");
            }
        }else{
            System.out.println("用户名不存在");
        }
    }
}
