package com.soft1841.sm.service;

import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginServiceTest {
    private SellerLoginService loginService = ServiceFactory.getSellerServiceInstance();
    @Test
    public void login() {
        boolean flag = loginService.login("admin","soft1841");
        assertEquals(true,flag);
    }
}