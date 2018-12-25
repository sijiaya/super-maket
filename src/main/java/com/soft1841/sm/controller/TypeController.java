package com.soft1841.sm.controller;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.DAOFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * 这是商品类别展示的控制器
 * @author 郭瑞昌
 * 2018-12-25
 */
public class TypeController implements Initializable {
    //获得Type.fxml布局文件的表格对象
    @FXML
    private TableView<Type> typeTable;
    //定义observablelist数据集合
    private ObservableList<Type> typeData = FXCollections.observableArrayList();

    //通过工厂获得TypeDAO的实例
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();

    //定义实体集合存放数据库查询结果
    private List<Entity> entityList = null;
    private TableColumn<Type, Type> delCol = new TableColumn<>("操作");
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //水平方向不显示滚动条
        typeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //表格最后加入删除按钮
        delCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delCol.setCellFactory(param -> new TableCell<Type,Type>(){
            private final Button deleteButton = ComponentUtil.getButton("删除","warning-theme");
            @Override
            protected void updateItem(Type type, boolean empty) {
                super.updateItem(type, empty);
                if(type == null){
                    setGraphic(null);
                    return;
                }
                setGraphic(deleteButton);
                //点击删除按钮从这一行删除，并且在数据库中也同时删除
                deleteButton.setOnAction(event -> {
                    //删除操作之前，弹出确认对话框，点击确认按钮才删除
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("确认对话框");
                    alert.setHeaderText("请确认");
                    alert.setContentText("确定要删除这行记录吗?");
                    Optional<ButtonType> result = alert.showAndWait();
                    //点击了确认按钮，执行删除操作，同时移除一行模型数据
                    if (result.get() == ButtonType.OK){
                        typeData.remove(type);
                        try {
                            typeDAO.deleteTypeById(type.getId());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        //删除列加入表格
        typeTable.getColumns().add(delCol);
        try{
            entityList = typeDAO.selectAllTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showTypeData(entityList);
        typeTable.setRowFactory(tv -> {
            TableRow<Type> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                //判断鼠标双击了一行
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    //获得该行的图书ID属性
                    long id = row.getItem().getId();
                    Type type = new Type();
                    try {
                        //通过ID到数据库查询到该分类的完整信息，因为表格中没有显示全，如
                        //分类封面
                        Entity entity = typeDAO.getTypeById(id);
                        type.setId(entity.getLong("id"));
                        type.setName(entity.getStr("name"));
                        type.setCover(entity.getStr("cover"));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    //创建一个新的分类界面窗口
                    Stage typeInfoStage = new Stage();
                    typeInfoStage.setTitle("分类详情界面");
                    //用VBox显示具体分类信息
                    VBox vBox = new VBox();
                    vBox.setSpacing(10);
                    vBox.setAlignment(Pos.CENTER);
                    vBox.setPrefSize(600, 400);
                    vBox.setPadding(new Insets(10, 10, 10, 50));
                    ImageView typeImgView = new ImageView(new Image(type.getCover()));
                    typeImgView.setFitHeight(150);
                    typeImgView.setFitWidth(120);
                    Label typenameLabel = new Label(type.getName());
                    vBox.getChildren().addAll(typeImgView, typenameLabel);
                    Scene scene = new Scene(vBox, 300, 350);
                    //因为是一个新的窗口，需要重新读入一下样式表，这个界面就可以使用style.css样式表中的样式了
                    scene.getStylesheets().add("/css/style.css");
                    typeInfoStage.setScene(scene);
                    typeInfoStage.show();
                }
            });
            return row;
        });
    }

    public void addType(){
        Stage stage = new Stage();
        VBox vBox = new VBox();
        vBox.setSpacing(30);
        TextField textField = new TextField("请输入商品类别名称");
        TextField textField1 = new TextField("https://");
        Button button = new Button("确认添加");
        button.setOnAction(event -> {
            if (textField != null && textField1 != null) {
                String typeName = textField.getText().trim();
                String typeCover = textField1.getText().trim();
                //创建一个Type对象，返回主键并插入数据库
                Type type = new Type();
                type.setCover(typeCover);
                type.setName(typeName);
                long id = 0;
                try {
                    id = typeDAO.insertType(type);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                type.setId(id);
                //加入ObservableList，刷新视图，不用重新查询数据库也可以立刻看到结果
                typeData.add(type);
            }
        });
        vBox.getChildren().addAll(textField,textField1,button);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        }
    private void showTypeData(List<Entity> entityList){
        //遍历实体集合
        for (Entity entity:entityList
        ) {
            //取出属性，创建Type的对象
            Type type = new Type();
            type.setId(entity.getInt("id"));
            type.setName(entity.getStr("name"));
            //加入ObservableList模型数据集合
            typeData.add(type);
        }
        typeTable.setItems(typeData);
    }
}
