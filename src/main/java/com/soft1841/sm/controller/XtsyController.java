package com.soft1841.sm.controller;

import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class XtsyController implements Initializable{
    @FXML
    private TableView<Goods> goodTable;
    @FXML
    private TextField barcodeField;
    private ObservableList<Type> typeData = FXCollections.observableArrayList();
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
    private ObservableList<Goods> goodsData = FXCollections.observableArrayList();
    private GoodsService goodsService= ServiceFactory.getGoodServiceInstance();
    private List<Goods> goodsList=null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       initTable();


    }

    private void initTable() {
        goodTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    private void showGoodsData(List<Goods> goodsList) {
        goodsData.addAll(goodsList);
        goodTable.setItems(goodsData);
    }
    public void search(KeyEvent event){
        double x = barcodeField.getLayoutX();
        double y = barcodeField.getLayoutY();
        KeyCode keyCode = event.getCode();
        if (keyCode == KeyCode.ENTER){

            String barcode = barcodeField.getText().trim();
            goodsList=  goodsService.getGoodsByBarcode(Long.parseLong(barcode));
            showGoodsData(goodsList);

        }



    }
}
