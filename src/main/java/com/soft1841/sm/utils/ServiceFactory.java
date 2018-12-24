package com.soft1841.sm.utils;

import com.soft1841.sm.service.LoginService;
import com.soft1841.sm.service.impl.LoginServiceImpl;

public class ServiceFactory {
    public static LoginService getLoginServiceInstance(){
        return new LoginServiceImpl();
    }
}
