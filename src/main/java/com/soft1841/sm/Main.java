package com.soft1841.sm;

import com.soft1841.sm.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = fxmlLoader.load();
        LoginController controller = fxmlLoader.getController();
        //将当前主舞台传递给控制器对象
        controller.setPrimaryStage(primaryStage);
        primaryStage.setTitle("账号注册登录");
        primaryStage.setScene(new Scene(root, 500, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
