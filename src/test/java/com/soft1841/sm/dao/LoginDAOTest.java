package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class LoginDAOTest {
    private SellerDAO loginDAO = DAOFactory.getSellerDAOInstance();
    @Test
    public void selectAdmin() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的密码");
        String mima = scanner.nextLine();
//        List<Entity> smima = loginDAO.selectAdmin("");
        if (mima == "soft1841"){
            System.out.println("密码输入正确");
        }

    }
}