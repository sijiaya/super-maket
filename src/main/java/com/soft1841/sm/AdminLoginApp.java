package com.soft1841.sm;

////import com.soft1841.sm.controller.AdminLoginController;
//import com.soft1841.sm.controller.AdminLoginController;
import com.soft1841.sm.controller.AdminLoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminLoginApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("管理员登录");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AdminLogin.fxml"));
        Parent root = fxmlLoader.load();
        AdminLoginController controller = fxmlLoader.getController();
        //将当前主舞台传递给控制器对象
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}