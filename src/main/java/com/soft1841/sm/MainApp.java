package com.soft1841.sm;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/add_goods.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 2000, 1000));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}