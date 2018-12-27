package com.soft1841.sm.service.impl;
import com.soft1841.sm.dao.SellerDAO;
import com.soft1841.sm.entity.Seller;
import com.soft1841.sm.service.SellerService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerServiceImpl implements SellerService {
    private SellerDAO sellerDAO = DAOFactory.getSellerDAOInstance();

    @Override
    public List<Seller> getAllSellers(){
        List<Seller> sellerList = new ArrayList<>();
        try {
            sellerList = sellerDAO.selectAllSeller();
    }catch (SQLException e) {
            System.err.println("查询收银员信息出现异常");
        }
        return sellerList;
    }
}
