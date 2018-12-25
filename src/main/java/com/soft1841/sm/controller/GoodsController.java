package com.soft1841.sm.controller;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.DAOFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class GoodsController implements Initializable {
    //布局文件中的表格视图对象，用来显示数据库中读取的所有图书信息
    @FXML
    private TableView<Goods> goodsTable;

    //布局文件中的下拉框组件对象，用来显示数据库中读取的所有图书类别
    @FXML
    private ComboBox<Type> typeComboBox;

    //布局文件中的输入文本框对象，用来输入搜索关键词
    @FXML
    private TextField keywordsField;

    //图书模型数据集合，可以实时相应数据变化，无需刷新
    private ObservableList<Goods> goodsData = FXCollections.observableArrayList();

    //图书类型模型数据集合
    private ObservableList<Type> typeData = FXCollections.observableArrayList();

    //图书DAO对象，从DAO工厂通过静态方法获得
    private GoodsDAO goodsDAO = DAOFactory.getGoodsDAOInstance();

    //图书类型DAO对象
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();

    //图书实体集合，存放数据库图书表各种查询的结果
    private List<Entity> goodsList = null;

    //类别实体集合，存放数据库类别表查询结果
    private List<Entity> typeList = null;

    //表格中的编辑列
    private TableColumn<Goods, Goods> editCol = new TableColumn<>("操作");

    //表格中的删除列
    private TableColumn<Goods, Goods> delCol = new TableColumn<>("操作");

    //初始化方法，通过调用对图书表格和列表下拉框的两个封装方法，实现数据初始化
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initComBox();
    }



    private void initTable() {
        goodsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //1.调用底层查询所有图书的方法，
        try {
            goodsList = goodsDAO.selectGoods();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //将实体集合作为参数，调用显示数据的方法，可以在界面的表格中显示图书模型集合的值
        showGoodsData(goodsList);
        //2.编辑列的相关设置
        editCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        editCol.setCellFactory(param -> new TableCell<Goods, Goods>() {
            //通过ComponentUtil工具类的静态方法，传入按钮文字和样式，获得一个按钮对象
            private final Button editButton = ComponentUtil.getButton("编辑", "blue-theme");
            @Override
            protected void updateItem(Goods goods, boolean empty) {
                super.updateItem(goods, empty);
                if (goods == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(editButton);
                //点击编辑按钮，弹出窗口，输入需要修改的图书价格
                editButton.setOnAction(event -> {
                    TextInputDialog dialog = new TextInputDialog("请输入价格");
                    dialog.setTitle("商品管理界面");
                    dialog.setHeaderText("商品名：" + goods.getName());
                    dialog.setContentText("请输入新的价格:");
                    Optional<String> result = dialog.showAndWait();
                    //确认输入了内容，避免NPE
                    if (result.isPresent()) {
                        //获取输入的新价格并转化成Double数据
                        String priceString = result.get();
                        goods.setPrice(Double.parseDouble(priceString));
                        //更新图书信息
                        goodsDAO.updateGoods(goods);
                    }