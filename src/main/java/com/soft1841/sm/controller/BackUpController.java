package com.soft1841.sm.controller;
import javafx.fxml.Initializable;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author 郭瑞昌
 * 修改辛苦，请留名
 */
public class BackUpController implements Initializable {
    /**
     * 备份数据库db
     * @param root
     * @param pwd
     * @param dbName
     * @param backPath
     * @param backName
     */
    public static void dbBackUp(String root,String pwd,String dbName,String backPath,String backName) throws Exception {
        String pathSql = backPath+backName;
        File fileSql = new File(pathSql);
        //创建备份sql文件
        if (!fileSql.exists()){
            fileSql.createNewFile();
        }
        //Mysql数据库备份命令mysqldump -hlocalhost -uroot -p123456 db > /home/back.sql
        StringBuffer sb = new StringBuffer();
        sb.append("mysqldump");
        sb.append(" -hlocalhost");
        sb.append(" -u"+root);
        sb.append(" -p"+pwd);
        sb.append(" "+dbName+" >");
        sb.append(pathSql);
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /k d:\\"+ sb.toString());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String backName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date())+".sql";
        try {
            BackUpController.dbBackUp("root","root","db_supermarket","d:/",backName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
