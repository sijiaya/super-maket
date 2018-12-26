package com.soft1841.sm.controller;

import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.utils.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import javax.swing.text.html.parser.Entity;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AddGoodsController implements Initializable {
    private ObservableList<Goods> goodsDate = FXCollections.observableArrayList();

    public ObservableList<Goods> getGoodsDate(){
        return goodsDate;
    }

    public void setGoodsDate(ObservableList<Goods> goodsDate){
        this.goodsDate = goodsDate;
    }

    @FXML
    private ComboBox<Type> goodsType;

    @FXML
    private TextField goodsName,goodsPrice;

    @FXML
    private TextArea goodsSummary;

    private ObservableList<Type> typeDate = FXCollections.observableArrayList();
    private GoodsDAO goodsDAO = DAOFactory.getGoodsDAOInstance();
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();
    private List<Type> typeList = null;
    private Long typeId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Entity> entityList;
        try {
            entityList = typeDAO.selectAllTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            
        }
        for (Entity entity : entityList) {
            Type type = new Type();
            type.setId(entity.getLong("id"));
            type.setTypeName(entity.getStr("type_name"));
            typeData.add(type);
        }
        goodsType.setItems(typeDate);
        goodsType.getSelectionModel().selectedIndexProperty().addListener((option,oldValue,newValue)->{
            typeId = newValue.getId;
                }
        );
    }
    public void addgoods() throws Exception{
        String name = goodsName.getText();
        String price = goodsPrice.getText();
        String summary = goodsSummary.getText();
        System.out.println(price);
        Goods goods = new Goods();
        goods.setTypeId(typeId);
        goods.setName(name);
        goods.setPrice(Double.parseDouble(price));
        long id = goodsDAO.insertGoods(goods);
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
