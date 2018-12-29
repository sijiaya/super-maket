package com.soft1841.sm.dao;

import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AdminDAOTest {
    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();
    @Test
    public void selectAllAdmin() throws SQLException {
        List<Admin> adminList = adminDAO.selectAllAdmin();
        adminList.forEach(admin -> System.out.println(admin));
    }

    @Test
    public void countByAddress()throws SQLException{
        int n = adminDAO.countByAddress("山西");
        System.out.println(n);
    }
}