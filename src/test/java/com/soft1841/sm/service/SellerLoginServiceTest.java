package com.soft1841.sm.service;

import com.soft1841.sm.entity.Seller;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SellerLoginServiceTest {
    private SellerLoginService sellerLoginService = ServiceFactory.getSellerServiceInstance();

    @Test
    public void login() {
        boolean flag = sellerLoginService.login("111","111");
        assertEquals(true,flag);
    }

    @Test
    public void updatePasswd() {
        boolean flag = sellerLoginService.updatePasswd("name2");
        assertEquals(true,flag);
    }

    @Test
    public void updatePassword() {
        Seller seller = new Seller();
        seller.setId(1l);
        seller.setPassword("ceshi");
        sellerLoginService.updatePassword(seller);
    }
}