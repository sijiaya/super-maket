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
import java.util.ResourceBundle;

public class GoodsController implements Initializable {
    //布局文件中的表格视图对象，显示数据库中读取的所有商品信息
    @FXML
    private TableView<Goods> goodsTable;

    //布局文件中的下拉框组件对象，用来显示数据库中读取的所有商品类别
    @FXML
    private ComboBox<Type> typeComboBox;

    //布局文件中输入文本框对象，用来输入搜索关键词
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

    public void search(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initComBox();

    }

    private void initComBox() {
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
