package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.AdminDAO;
import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.service.AdminService;
import com.soft1841.sm.utils.DAOFactory;
import javafx.scene.control.Alert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();

    @Override
    public List<Admin> getAllAdmins() {
        List<Admin> adminList = new ArrayList<>();
        try {
            adminList = adminDAO.selectAllAdmin();
        } catch (SQLException e) {
            System.err.println("查询管理员信息出现异常");
        }
        return adminList;
    }

    @Override
    public Admin getAdminByJob_ID(Long jobId) {
        Admin admin = new Admin();
        try {
            admin = adminDAO.getAdminById(jobId);
        } catch (SQLException e) {
         System.err.println("根据id查询管理员出现异常");
        }
        return admin;
    }

    @Override
    public boolean login(long job_id, String password) {
            Admin admin = null;
            try {
                //调用SellDAO方法中的查询方法，查询工号
                admin = adminDAO.getUserByName(job_id);
            } catch (NullPointerException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("错误");
                alert.setContentText("用户名不存在");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //根据工号查询成功
            if (admin != null) {
                //比较密码
                if (password.equals(admin.getPassword())) {
                    return true;
                }
            }
            return false;
        }

    @Override
    public int countByAddress(String address) {
        int result = 0;
        try {
            result = adminDAO.countByAddress(address);
        } catch (SQLException e) {
            System.err.println("根据地址统计管理员信息出现异常");
        }
        return result;
    }
}
