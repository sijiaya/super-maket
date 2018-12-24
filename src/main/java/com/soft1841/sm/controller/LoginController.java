package com.soft1841.sm.controller;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.LoginDAO;
import com.soft1841.sm.utils.DAOFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    //登录接口方法的引用
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
        //获取用户输入的用户名以及密码
        String use = account.getText().trim();
        String psd = password.getText().trim();
        //返回Entity类型，使用LoginDAO中的方法查询用户输入的账号
        Entity user = loginDAO.getUserByName(use);
        //若用户输入的用户名不为空值，则执行
        if(null != user){
            //如果用户输入的密码与数据库查询出来的数据中的密码一致，则登录成功并跳转
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
                mainStage.getIcons().add(new Image("/img/logo.png"));
                mainStage.setTitle("后台管理系统");
                mainStage.setMaximized(true);
                mainStage.setScene(scene);
                mainStage.show();
            }else{
                //如果用户输入的密码与数据库中根据用户名查询的密码不一致，则报错误
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("登录失败");
                alert.setContentText("密码错误，登录失败");
                alert.show();
            }
        }else{
            //如果数据库中不存在该用户或者用户为空值，则警告
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("用户名不存在");
            alert.setContentText("该用户名不存在，请重新输入");
            alert.show();
        }
    }
}
