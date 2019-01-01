package com.soft1841.sm.service;

import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class AdminLoginServiceTest {
    private AdminService adminLoginService = ServiceFactory.getAdminsServiceInstance();


    @Test
    public void login(){
        boolean flag = adminLoginService.login(111,"aaa");
        assertEquals(true,flag);
    }

}