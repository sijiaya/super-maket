package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.LoginDAO;
import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.service.LoginService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {
    private LoginDAO loginDAO = DAOFactory.getLoginDAOInstance();
    @Override
    public boolean login(String user, String password) {
        Admin admin = null;
        try {
            admin = loginDAO.getUserByName(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (admin != null){
            if (password.equals(admin.getPassword())){
                return true;
            }
        }
        return false;
    }
}
