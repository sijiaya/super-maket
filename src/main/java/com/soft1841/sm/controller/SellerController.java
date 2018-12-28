package com.soft1841.sm.controller;

import com.soft1841.sm.entity.Seller;
import com.soft1841.sm.service.SellerLoginService;
import com.soft1841.sm.service.SellerService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
public class SellerController implements Initializable {
    @FXML
    private FlowPane flowPane;
    private SellerService sellerService = ServiceFactory.getSellersServiceInstance();
    private List<Seller> sellerList = new ArrayList<>();
    private SellerLoginService sellerLoginService = ServiceFactory.getSellerServiceInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sellerList = sellerService.getAllSellers();
        showSellers(sellerList);
    }

    private void showSellers(List<Seller> sellerList) {
        flowPane.getChildren().clear();
        for (Seller seller : sellerList
        ) {
            HBox hBox = new HBox();
            hBox.setPrefSize(300, 240);
            hBox.getStyleClass().add("box");
            hBox.setSpacing(30);
            //左边垂直布局放头像和身份
            VBox leftBox = new VBox();
            leftBox.setAlignment(Pos.TOP_CENTER);
            leftBox.setSpacing(30);
            ImageView imageView = new ImageView(new Image(seller.getAvatar()));
            //商品图片大小
            imageView.setFitWidth(80);
            imageView.setFitHeight(80);
            //给收银员头像设置圆形
            Circle circle = new Circle();
            circle.setCenterX(40.0);
            circle.setCenterY(40.0);
            circle.setRadius(40.0);
            imageView.setClip(circle);
            Label nameLabel = new Label("姓名:" + seller.getName());
            leftBox.getChildren().addAll(imageView, nameLabel);
            //右边垂直布局放家庭住址
            VBox rightBox = new VBox();
            rightBox.setSpacing(50);
            Label addressLabel = new Label("籍贯：" + seller.getAddress());
            nameLabel.getStyleClass().add("font-title");
            Button delButton = new Button("删除");
            Button updateButton = new Button("修改");
            //修改功能，根据用户输入旧密码是否正确并提供友好的报错
            updateButton.getStyleClass().add("warm-theme");
            delButton.getStyleClass().add("warning-theme");
            rightBox.getChildren().addAll(addressLabel, delButton, updateButton);
            updateButton.setOnAction(event -> {
                Stage stage = new Stage();
                VBox vBox = new VBox();
                vBox.setSpacing(30);
                vBox.setPadding(new Insets(20,20,20,20));
                TextField textField = new TextField("请输入旧密码");
                TextField textField1 = new TextField("请输入新密码");
                Button button = new Button("确认修改");
                String use = String.valueOf(seller.getWork_id());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                button.setOnAction(event1 -> {
                    String oldPsd = textField.getText();
                    String newPsd = textField1.getText();
                    boolean update = sellerLoginService.updatePasswd(oldPsd);
                    if (update) {
                        Seller seller1 = new Seller();
                        long id = seller.getId();
                        seller1.setId(id);
                        seller1.setPassword(newPsd);
                        sellerService.updateSeller(seller1);
                        alert.setTitle("修改成功");
                        alert.setContentText("恭喜您修改成功，您的新密码为" + newPsd);
                        alert.show();
                    } else {
                        alert.setTitle("修改失败");
                        alert.setContentText("修改失败，旧密码输入错误,系统将关闭此界面");
                        alert.show();
                        stage.close();
                    }
                });
                vBox.getChildren().addAll(textField, textField1, button);
                Scene scene = new Scene(vBox);
                stage.setScene(scene);
                stage.show();
            });
            delButton.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("确认对话框");
                alert.setContentText("确定要删除这行记录吗?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    long id = seller.getId();
                    //删除掉这行记录
                    sellerService.deleteSeller(id);
                    //从流式面板移除当前这个人的布局
                    flowPane.getChildren().remove(hBox);
                }
            });
            //左右两个垂直布局加入水平布局
            hBox.getChildren().addAll(leftBox, rightBox);
            //水平布局加入大的内容容器
            flowPane.getChildren().add(hBox);
        }
    }

    public void addSeller() {
        Stage stage = new Stage();
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(20, 20, 20, 20));
        TextField textField = new TextField("收银员工号");
        TextField textField1 = new TextField("登录密码");
        TextField textField2 = new TextField("收银员姓名");
        TextField textField3 = new TextField("收银员头像");
        TextField textField4 = new TextField("收银员地址");
        Button button = new Button("确认添加");
        vBox.getChildren().addAll(textField, textField1, textField2, textField3, textField4, button);
        button.setOnAction(event -> {
            Seller seller = new Seller();
            String work_id = textField.getText();
            String password = textField1.getText();
            String name = textField2.getText();
            String avatar = textField3.getText();
            String address = textField4.getText();
            seller.setWork_id(Long.valueOf(work_id));
            seller.setPassword(password);
            seller.setName(name);
            seller.setAvatar(avatar);
            seller.setAddress(address);
            long id = 0;
            id = sellerService.addSeller(seller);
            seller.setId(id);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("添加成功");
            alert.show();
            stage.close();
            sellerList = sellerService.getAllSellers();
            showSellers(sellerList);
        });
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
}

