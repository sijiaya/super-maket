package com.soft1841.sm.service;

import com.soft1841.sm.dao.AdminDAO;
import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.utils.DAOFactory;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AdminServiceTest {
    private AdminService adminService = ServiceFactory.getAdminsServiceInstance();
    @Test
    public void getAllAdmins() {
    List<Admin> adminList = adminService.getAllAdmins();
    adminList.forEach(admin -> System.out.println(admin));
    }
    @Test
    public void countByAddress(){

       adminService.countByAddress("山西");

    }
}