package com.soft1841.sm.service;

import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class AdminLoginServiceTest {
    private AdminLoginService adminLoginService = ServiceFactory.getAdminServiceInstance();


    @Test
    public void login(){
        boolean flag = adminLoginService.login(10001036,"aaa111");
        assertEquals(true,flag);
    }

}