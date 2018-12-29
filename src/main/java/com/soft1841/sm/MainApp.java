package com.soft1841.sm;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        //给舞台设置标题
        primaryStage.setTitle("电脑管家");
        //创建场景,并将舞步读入的布局文件的更节点加入其中
        Scene scene = new Scene(root,1112,600);
        //将外部的样式表读入
        scene.getStylesheets().add(MainApp.class.getResource("/css/style.css").toExternalForm());
        //场景加入舞台,并可见
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}