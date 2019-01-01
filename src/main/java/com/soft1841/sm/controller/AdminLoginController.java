package com.soft1841.sm.controller;
/**
 * 管理员登录控制器
 * @author sijia
 */
import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.service.AdminService;
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

public class AdminLoginController {
    //登录接口方法的引用
    private AdminService adminService = ServiceFactory.getAdminsServiceInstance();
    private Stage primaryStage;

    @FXML
    private TextField account;

    @FXML
    private PasswordField password;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void Login() throws IOException, InterruptedException {
        //获取用户输入的用户名和密码
        long job_id = Long.parseLong(account.getText().trim());
        String psd = password.getText().trim();
        //返回布尔类型，使用adminLoginService方法查询用户输入的账号密码是否一致，并返回一个布尔值
        boolean flag = adminService.login(job_id, psd);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("信息提示");
        //当flag为true则执行下列语句
        if (flag) {
            alert.setContentText("恭喜你登录成功,1秒后跳转到管理界面");
            alert.show();
            Thread.sleep(1000);
            alert.close();
            primaryStage.close();
            Stage mainStage = new Stage();
            //查出该admin信息
            Admin admin = adminService.getAdminByJob_ID(job_id);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/backstage.fxml"));
            AnchorPane root = fxmlLoader.load();
            BackController controller = fxmlLoader.getController();
            controller.setAdmin(admin);
            //将当前主舞台传递给控制器对象
            controller.setPrimaryStage(primaryStage);
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/css/style.css");
            mainStage.getIcons().add(new Image("/img/logo.png"));
            mainStage.setTitle("管理员界面");
            mainStage.setMaximized(true);
            mainStage.setScene(scene);
            mainStage.show();
        } else {
            alert.setTitle("登录失败");
            alert.setContentText("密码错误或用户不存在，登录失败");
            alert.show();
        }
    }

    public void loginBtnOnAction(){
        try {
            loginBtnOnAction();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}