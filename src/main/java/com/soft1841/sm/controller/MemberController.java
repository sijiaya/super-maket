package com.soft1841.sm.controller;

import com.soft1841.sm.dao.MemberDAO;
import com.soft1841.sm.entity.Member;
import com.soft1841.sm.service.MemberService;
import com.soft1841.sm.utils.ServiceFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * 会员信息控制器
 * @author sijia
 */
public class MemberController implements Initializable {
        @FXML
        private FlowPane memberPane;

        //会员Service对象
        private MemberService memberService = ServiceFactory.getMemberServiceInstance();
        private List<Member> memberList = new ArrayList<>();

        //会员模型数据集合，可以实时相应数据变化，无需刷新
        private ObservableList<Member> memberData = FXCollections.observableArrayList();

    @Override
        public void initialize(URL location, ResourceBundle resources) {
            memberList = memberService.getAllMember();
            showMember(memberList);
        }

        private void showMember(List<Member> memberList) {
            //移除之前的记录
            memberPane.getChildren().clear();
            for (Member member : memberList) {
                HBox hBox = new HBox();
                hBox.setPrefSize(350, 220);
                hBox.getStyleClass().add("box");
                hBox.setSpacing(30);
                //左边垂直放会员信息
                VBox leftBox = new VBox();
                leftBox.setSpacing(30);
                //显示会员姓名
                Label nameLabel = new Label("姓名：" + member.getName());
                nameLabel.getStyleClass().add("font-title");
                Label addressLabel = new Label("住址：" + member.getAddress());
                Label phoneLabel = new Label("联系方式：" + member.getPhone());
                Label integralLabel = new Label("积分：" + member.getIntegral());
                leftBox.getChildren().addAll(nameLabel,addressLabel,phoneLabel,integralLabel);


                //右边放入按钮
                VBox rightBox = new VBox();
                rightBox.setSpacing(50);
                Button delBtn = new Button("删除");
                Button updateButton = new Button("修改");
                ///修改功能
                updateButton.getStyleClass().add("warm-theme");
                delBtn.getStyleClass().add("warning-theme");
                rightBox.getChildren().addAll(addressLabel, delBtn, updateButton);

                updateButton.setOnAction(event -> {
                    Stage stage = new Stage();
                    stage.setTitle("修改会员信息");
                    VBox vBox = new VBox();
                    vBox.setSpacing(30);
                    vBox.setPadding(new Insets(20,20,20,20));
                    TextField textField = new TextField("请输入地址");
                    TextField textField1 = new TextField("请输入电话");
                    TextField textField2 = new TextField("请输入积分");
                    Button button = new Button("确认修改");
                    button.setOnAction(event1 -> {
                        String arString = textField.getText();
                        String phString = textField1.getText();
                        String igString = textField2.getText();
                        member.setAddress(arString);
                        member.setPhone(phString);
                        member.setIntegral(igString);

                        long id = 0;
                        id = memberService.addMember(member);
                        member.setId(id);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("修改成功");
                        alert.show();
                        stage.close();
                        System.out.println(member.getAddress()+member.getPhone()+member.getIntegral());
                        memberService.updateMember(member);
                        stage.close();

                    });
                    vBox.getChildren().addAll(textField,textField1,textField2,button);
                    Scene scene = new Scene(vBox);
                    stage.setScene(scene);
                    stage.show();
                });

                //删除按钮
                delBtn.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("确认对话框");
                    alert.setContentText("确定要删除这行记录吗?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        String number = member.getNumber();
                        //删除掉这行记录
                        memberService.deleteMember(number);
                        //从流式面板移除当前这个人的布局
                        memberPane.getChildren().remove(hBox);
                    }
                });
                //左右两个垂直布局加入水平布局
                hBox.getChildren().addAll(leftBox, rightBox);
                //水平布局加入大的内容容器
                memberPane.getChildren().add(hBox);
            }
        }


        //新增会员方法
        public void addMember(){
            Stage stage = new Stage();
            stage.setTitle("新增会员界面");
            VBox vBox = new VBox();
            vBox.setSpacing(10);
            vBox.setPadding(new Insets(10,10,10,10));
            Label infoLabel = new Label("会 员 信 息：");
            infoLabel.setPrefWidth(600);
            infoLabel.setMinHeight(60);
            infoLabel.setAlignment(Pos.CENTER);
            infoLabel.getStyleClass().addAll("gray-theme","font-title");
            TextField numberLabel = new TextField();
            numberLabel.setPromptText("请输入会员号");
            TextField nameLabel = new TextField();
            nameLabel.setPromptText("请输入姓名");
            TextField addressLabel = new TextField();
            addressLabel.setPromptText("请输入地址");
            TextField phoneLabel = new TextField();
            phoneLabel.setPromptText("请输入电话");
            TextField integralLabel = new TextField();
            integralLabel.setPromptText("请输入积分");
            Button button = new Button("确认添加");
            FlowPane flowPane = new FlowPane();
            button.setPrefWidth(120);
            button.getStyleClass().addAll("gray-theme" , "btn-radius");
            flowPane.getChildren().add(button);
            flowPane.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(infoLabel,numberLabel,nameLabel,addressLabel,phoneLabel,integralLabel,button);
            Scene scene = new Scene(vBox ,330,370);
            scene.getStylesheets().add("css/style.css");
            stage.setScene(scene);
            stage.show();
            button.setOnAction(event -> {
                Member member = new Member();
                String numberString = numberLabel.getText();
                String nameString =  nameLabel.getText();
                String addressString = addressLabel.getText();
                String phoneString = phoneLabel.getText();
                String integralString = integralLabel.getText();
                member.setNumber(numberString);
                member.setName(nameString);
                member.setAddress(addressString);
                member.setPhone(phoneString);
                member.setIntegral(integralString);
                long id = 0;
                id = memberService.addMember(member);
                member.setId(id);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("添加成功");
                alert.show();
                stage.close();
                memberList = memberService.getAllMember();
                showMember(memberList);
            });
            stage.setScene(scene);
            stage.show();
        }
    }