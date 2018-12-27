package com.soft1841.sm.utils;

import com.soft1841.sm.dao.*;
import com.soft1841.sm.dao.impl.*;
import com.soft1841.sm.entity.Member;

import java.sql.SQLException;
import java.util.List;

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


    public static AdminDAO getAdminDAOInstance(){return new AdminDAOImpl(); }
    public static MemberDAO getMemberDAOInstance(){return new MemberDAOImpl(); }
}
