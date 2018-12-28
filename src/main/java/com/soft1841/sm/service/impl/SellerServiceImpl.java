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

    @Override
    public Long addSeller(Seller seller) {
        long result = 0;
        try {
            result = sellerDAO.insertSeller(seller);
        } catch (SQLException e) {
            System.err.println("新增收银员出现异常");
        }
        return result;
    }

    @Override
    public void deleteSeller(long id) {
        try {
            sellerDAO.deleteSeller(id);
        } catch (SQLException e) {
            System.err.println("删除收银员信息失败");
        }
    }

    /**
     * 修改员工信息
     * @param seller
     */
    @Override
    public void updateSeller(Seller seller) {
        try {
            sellerDAO.updateSeller(seller);
        } catch (SQLException e) {
            System.err.println("修改收银员信息出现异常");
        }
    }
}
