package com.soft1841.sm.controller;

import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author  亢悦忻
 */
public class XtsyController implements Initializable{
    @FXML
    private TableView<Goods> goodTable;
    @FXML
    private TextField barcodeField;
    @FXML
    private Button dBtn;
    @FXML
    private TextField numberTextField;
    private ObservableList<Type> typeData = FXCollections.observableArrayList();
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
    private ObservableList<Goods> goodsData = FXCollections.observableArrayList();
    private GoodsService goodsService= ServiceFactory.getGoodServiceInstance();
    private List<Goods> goodsList=null;
    private TableColumn<Goods, Goods> delCol = new TableColumn<>("操作");
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       initTable();


    }

    private void initTable() {
        goodTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
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
                    alert.setHeaderText("商品名：" + goods.getName());
                    alert.setContentText("确定要删除这行记录吗?");
                    Optional<ButtonType> result = alert.showAndWait();
                    //点击了确认按钮，执行删除操作，同时移除一行模型数据
                    if (result.get() == ButtonType.OK) {
                        goodsData.remove(goods);
                    }
                });
            }
        });
        //将除列加入图书表格
        goodTable.getColumns().add(delCol);
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
    public void delete(KeyEvent event){
        double x= dBtn.getLayoutX();
        double y= dBtn.getLayoutY();
        KeyCode keyCode = event.getCode();
        if (keyCode==KeyCode.DELETE);{
         System.out.println("删除");

        }
    }
    public void number(KeyEvent event){
        double x = numberTextField.getLayoutX();
        double y =numberTextField.getLayoutY();
        KeyCode keyCode = event.getCode();
        if (keyCode ==KeyCode.SPACE){
            Goods goods=new Goods();
            String barcode = barcodeField.getText().trim();
            String number =numberTextField.getText().trim();
            Double P= goods.getPrice();
            Double p=Double.parseDouble(number)*39.8;
            goods.setBarcode(Long.parseLong(barcode));
            goods.setNumber(Long.parseLong(number));
            goods.setSubtotal(p);
           goodsService.updateGoods(goods);


        }



    }
}
