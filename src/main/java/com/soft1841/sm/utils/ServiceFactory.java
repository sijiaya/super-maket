package com.soft1841.sm.utils;
import com.soft1841.sm.service.*;
import com.soft1841.sm.service.impl.*;

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
    public static GoodsService getGoodServiceInstance(){
        return new GoodsServiceImpl();
    }
    public static AdminService getAdminsServiceInstance(){
        return new AdminServiceImpl();
    }
}



