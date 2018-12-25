package com.soft1841.sm.utils;

import com.soft1841.sm.controller.MainController;
import com.soft1841.sm.controller.SellerLoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BackstageApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/backstage.fxml"));
        Parent root = fxmlLoader.load();
        MainController controller = fxmlLoader.getController();
        //将当前主舞台传递给控制器对象
        controller.getClass();
        primaryStage.setTitle("收银员登录");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

