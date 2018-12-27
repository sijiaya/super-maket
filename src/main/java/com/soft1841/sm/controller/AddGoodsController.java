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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddGoodsController implements Initializable {
    private ObservableList<Goods> goodsDate = FXCollections.observableArrayList();

    public ObservableList<Goods> getGoodsDate() {
        return goodsDate;
    }

    public void setGoodsDate(ObservableList<Goods> goodsDate) {
        this.goodsDate = goodsDate;
    }

    @FXML
    private ComboBox<Type> goodsType;

    @FXML
    private TextField goodsName, goodsPrice, goodsVipPrice, goodsDescription,goodsPicture,goodsBarcode,goodsInventory;


    private ObservableList<Type> typeDate = FXCollections.observableArrayList();
    private GoodsService goodsService = ServiceFactory.getGoodServiceInstance();
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
    private List<Type> typeList = null;
    private Long typeId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeList = typeService.getAllTypes();
        typeDate.addAll(typeList);
        goodsType.setItems(typeDate);
        goodsType.getSelectionModel().selectedItemProperty().addListener((option, oldValue, newValue) -> {
                    typeId = newValue.getId();
                }
        );
    }

    public void addGoods() {
        String name = goodsName.getText();
        String price = goodsPrice.getText();
        String vip = goodsVipPrice.getText();
        String description = goodsDescription.getText();
        String picture = goodsPicture.getText();
        String barcode = goodsBarcode.getText();
        String inventory = goodsInventory.getText();
        System.out.println(price);
        Goods goods = new Goods();
        goods.setTypeId(typeId);
        goods.setName(name);
        goods.setPrice(Double.parseDouble(price));
        goods.setVip(Double.parseDouble(vip));
        goods.setDescription(description);
        goods.setPicture(picture);
        goods.setBarcode(Long.parseLong(barcode));
        goods.setInventory(Integer.parseInt(inventory));
        long id = goodsService.addGoods(goods);
        goods.setId(id);
        this.getGoodsDate().add(goods);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示信息");
        alert.setHeaderText("新增商品成功");
        alert.showAndWait();
        Stage stage = (Stage) goodsName.getScene().getWindow();
        stage.close();
    }

}


