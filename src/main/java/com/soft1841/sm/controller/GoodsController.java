package com.soft1841.sm.controller;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.DAOFactory;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
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
    private ObservableList<Type> typeData = FXCollections.observableArrayList();
    private GoodsService goodsService =ServiceFactory.getGoodServiceInstance();
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
    private List<Goods> goodsList = null;
    private List<Type> typeList = null;


    public void newGoodsStage(ActionEvent actionEvent) {
    }
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
        typeList = typeService.selectAllType();
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
    }

    private void showGoodData(List<Goods> goodsList) {
       goodsData.addAll(goodsList);
       goodsTable.setItems(goodsData);



    }

    }


