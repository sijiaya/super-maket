package com.soft1841.sm.utils;
import com.soft1841.sm.service.SellerLoginService;
import com.soft1841.sm.service.impl.SellerLoginServiceImpl;

public class ServiceFactory {
    public static SellerLoginService getSellerServiceInstance(){
        return new SellerLoginServiceImpl();
    }
}
