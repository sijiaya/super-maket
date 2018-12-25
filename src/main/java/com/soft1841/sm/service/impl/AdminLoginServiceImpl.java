package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.AdminDAO;
import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.service.AdminLoginService;
import com.soft1841.sm.utils.DAOFactory;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class AdminLoginServiceImpl implements AdminLoginService {
    //获取AdminDAO接口方法
    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();

    @Override
    public boolean login(Integer job_id, String password){
        Admin admin = null;
        try {
            //调用SellDAO方法中的查询方法，查询工号
            admin = adminDAO.getUserByName(job_id);
        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("错误");
            alert.setContentText("用户名不存在");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //根据工号查询成功
        if (admin != null){
            //比较密码
            if (password.equals(admin.getPassword())){
                return true;
            }
        }
        return false;
    }
}
