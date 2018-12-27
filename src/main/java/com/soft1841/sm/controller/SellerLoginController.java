package com.soft1841.sm.controller;

import com.soft1841.sm.service.SellerLoginService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author By 郭瑞昌
 */
public class SellerLoginController {
    //登录接口方法的引用
    private SellerLoginService sellerLoginService = ServiceFactory.getSellerServiceInstance();
    private Stage primaryStage;
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;
    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    public void Login() throws IOException, InterruptedException, SQLException {
        //获取用户输入的用户名以及密码
        String use = account.getText().trim();
        String psd = password.getText().trim();
        //返回布尔值类型，使用LoginService中的方法查询用户输入的账号与密码是否一致并返回一个布尔值
       boolean flag = sellerLoginService.login(use,psd);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("信息提示");
        //若flag返回为true，则执行下列语句
            if (flag) {
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
                scene.getStylesheets().add("/css/style.css");
                mainStage.setTitle("收银员管理界面");
                mainStage.setScene(scene);
                mainStage.show();
            } else {
                //若flag返回值为false，则为不存在该用户或者密码错误
                alert.setTitle("登录失败");
                alert.setContentText("密码错误或用户名不存在，登录失败");
                alert.show();
            }

    }
}
