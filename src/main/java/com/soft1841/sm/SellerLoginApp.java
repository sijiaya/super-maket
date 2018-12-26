package com.soft1841.sm;

import com.soft1841.sm.controller.SellerLoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class SellerLoginApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/SellerLogin.fxml"));
        Parent root = fxmlLoader.load();
        SellerLoginController controller = fxmlLoader.getController();
        //将当前主舞台传递给控制器对象
        controller.setPrimaryStage(primaryStage);
        primaryStage.setTitle("收银员登录");
        Scene scene = new Scene(root,565,730);
        scene.getStylesheets().add("/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
