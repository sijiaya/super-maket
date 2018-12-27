package com.soft1841.sm.controller;

import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.ExcelExport;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class GoodsController implements Initializable {
    @FXML
    private TableView<Goods> goodsTable;
    @FXML
    private ComboBox<Type> typeComboBox;
    @FXML
    private TextField keywordsField;
    //图书模型数据集合，可以实时相应数据变化，无需刷新
    private ObservableList<Goods> goodsData = FXCollections.observableArrayList();
    //图书类型模型数据集合
    private ObservableList<Goods> goodsDate = FXCollections.observableArrayList();
    private ObservableList<Type> typeData = FXCollections.observableArrayList();

    private GoodsService goodsService =ServiceFactory.getGoodServiceInstance();
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
    private List<Goods> goodsList = null;
    private List<Type> typeList = null;
    //表格中的删除列
    private TableColumn<Goods, Goods> delCol = new TableColumn<>("操作");



    //根据关键词搜索方法
    public void search() {
        goodsTable.getItems().removeAll(goodsData);
        String keywords = keywordsField.getText().trim();
        goodsList=goodsService.getGoodsLike(keywords);
        showGoodData(goodsList);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initComBox();

    }


    private void initComBox() {
        typeList = typeService.getAllTypes();
        typeData.addAll(typeList);
        typeComboBox.setItems(typeData);
        typeComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            goodsTable.getItems().removeAll(goodsData);
            goodsList = goodsService.getGoodsByTypeId((int) newValue.getId());
            showGoodData(goodsList);
        });

    }




    private void initTable() {

        goodsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        goodsList=goodsService.getAllGoods();
        showGoodData(goodsList);
        delCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delCol.setCellFactory(param -> new TableCell<Goods, Goods>() {
            private final Button deleteButton = ComponentUtil.getButton("删除", "warning-theme");

            @Override
            protected void updateItem(Goods goods, boolean empty) {
                super.updateItem(goods, empty);
                if (goods == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(deleteButton);
                //点击删除按钮，需要将这一行从表格移除，同时从底层数据库真正删除
                deleteButton.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("确认对话框");
                    alert.setHeaderText("书名：" + goods.getName());
                    alert.setContentText("确定要删除这行记录吗?");
                    Optional<ButtonType> result = alert.showAndWait();
                    //点击了确认按钮，执行删除操作，同时移除一行模型数据
                    if (result.get() == ButtonType.OK) {
                        goodsData.remove(goods);
                        goodsService.deleteGoods(goods.getId());
                    }
                });
            }
        });
        //将除列加入图书表格
        goodsTable.getColumns().add(delCol);

    }

    private void showGoodData(List<Goods> goodsList) {
        goodsData.addAll(goodsList);
        goodsTable.setItems(goodsData);



    }

    public void newGoodsStage() throws Exception {
        Stage addGoodsStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/add_goods.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root,600,700);
        scene.getStylesheets().add("/css/style.css");
        AddGoodsController addGoodsController = fxmlLoader.getController();
        addGoodsController.setGoodsDate(goodsData);
        addGoodsStage.setTitle("新增商品界面");
        addGoodsStage.setResizable(false);
        addGoodsStage.setScene(scene);
        addGoodsStage.show();
    }
    //数据导出方法，采用hutool提供的工具类
    public void export() {
        ExcelExport.export(goodsList);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示信息");
        alert.setHeaderText("商品数据已导出!请到E盘根目录查看!");
        alert.showAndWait();
    }
}



