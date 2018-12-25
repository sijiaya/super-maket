package com.soft1841.sm.service;

import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SellerLoginServiceTest {
    private SellerLoginService sellerLoginService = ServiceFactory.getSellerServiceInstance();

    @Test
    public void login() {
        boolean flag = sellerLoginService.login("201802","Bbb222");
        assertEquals(true,flag);
    }
}