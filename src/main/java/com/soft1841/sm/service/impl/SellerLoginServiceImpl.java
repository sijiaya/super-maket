package com.soft1841.sm.service.impl;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.SellerDAO;
import com.soft1841.sm.entity.Seller;
import com.soft1841.sm.service.SellerLoginService;
import com.soft1841.sm.utils.DAOFactory;
import javafx.scene.control.Alert;

import java.sql.SQLException;

/**
 * author By Ytker
 */
public class SellerLoginServiceImpl implements SellerLoginService {
    //获取SellerDAO接口方法
    private SellerDAO sellerDAO = DAOFactory.getSellerDAOInstance();
    @Override
    public boolean login(String work_id, String password) {
        //定义Seller的空值，方便后续使用
        Seller seller = null;
        try {
            //调用SellDAO方法中的查询方法，查询此ID
            seller = sellerDAO.getUserByName(work_id);
        } catch (NullPointerException e) {
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("错误");
            alert.setContentText("用户名不存在");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //如果上面的Seller在数据库中有值，则执行下列
        if (seller != null){
            //对比根据工号ID查询出来的密码与用户输入的密码是否一致
            if (password.equals(seller.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePasswd(String password) {
        Seller seller = null;
        try {
            seller = sellerDAO.getPasswordByWork_id(password);
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("错误");
            alert.setContentText("旧密码输入错误");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (seller != null){
            //对比根据工号ID查询出来的密码与用户输入的密码是否一致
            if (password.equals(seller.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void updatePassword(Seller seller) {
        try {
            sellerDAO.updateSeller(seller);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
