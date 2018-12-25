package com.soft1841.sm.utils;
import com.soft1841.sm.service.AdminLoginService;
import com.soft1841.sm.service.SellerLoginService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.service.impl.AdminLoginServiceImpl;
import com.soft1841.sm.service.impl.SellerLoginServiceImpl;
import com.soft1841.sm.service.impl.TypeServiceImpl;

public class ServiceFactory {
    public static SellerLoginService getSellerServiceInstance(){
        return new SellerLoginServiceImpl();



    }

    public static AdminLoginService getAdminServiceInstance() {
        return new AdminLoginServiceImpl();
    }
    public static TypeService getTypeServiceInstance(){
        return new TypeServiceImpl();
    }
}


