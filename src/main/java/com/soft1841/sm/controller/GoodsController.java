package com.soft1841.sm.controller;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.utils.DAOFactory;
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
    private GoodsDAO goodsDAO= DAOFactory.getGoodsDAOInstance();
    private TypeDAO typeDAO=DAOFactory.getTypeDAOInstance();
    private List<Entity> goodsList = null;
    private List<Entity> typeList = null;


    public void newGoodsStage(ActionEvent actionEvent) {
    }
    //根据关键词搜索方法
    public void search() {
        goodsTable.getItems().removeAll(goodsData);
        String keywords = keywordsField.getText().trim();
        try{
            goodsList =goodsDAO.selectGoodLike(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showGoodData(goodsList);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initComBox();

    }

    private void initComBox() {
        //到数据库查询所有的类别
        try{
            typeList = typeDAO.selectAllTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Entity entity : typeList) {
            Type type = new Type();
            type.setId(entity.getLong("id"));
            type.setName(entity.getStr("name"));
            typeData.add(type);
        }
        typeComboBox.setItems(typeData);
        typeComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                    goodsTable.getItems().removeAll(goodsData);
                    try {
                        {
                            goodsList=goodsDAO.selectGoodsByTypeId((int) newValue.getId());
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    showGoodData(goodsList);
                }
        );
    }


    private void initTable() {
        goodsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        try{
            goodsList =goodsDAO.selectGoods();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showGoodData(goodsList);
    }

    private void showGoodData(List<Entity> goodsList) {
        for(Entity entity : goodsList){
           Goods goods = new Goods();
           goods.setId(entity.getLong("id"));
           goods.setName(entity.getStr("name"));
           goods.setPrice(entity.getDouble("price"));

           goodsData.add(goods);

        }
        goodsTable.setItems(goodsData);
    }


}