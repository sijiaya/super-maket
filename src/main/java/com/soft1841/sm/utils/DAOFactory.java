package com.soft1841.sm.utils;

import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.dao.SellerDAO;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.dao.impl.GoodsDAOImpl;
import com.soft1841.sm.dao.impl.SellerDAOImpl;
import com.soft1841.sm.dao.impl.TypeDAOImpl;

public class DAOFactory {
    /**
     * 静态方法，返回接口类的实现
     */
    public static GoodsDAO getGoodsDAOInstance(){
        return new GoodsDAOImpl();
    }
    public static TypeDAO getTypeDAOInstance(){
        return new TypeDAOImpl();
    }
    public static SellerDAO getSellerDAOInstance(){
        return new SellerDAOImpl();
    }
}
