package com.soft1841.sm.service.impl;
import com.soft1841.sm.dao.SellerDAO;
import com.soft1841.sm.entity.Seller;
import com.soft1841.sm.service.SellerLoginService;
import com.soft1841.sm.utils.DAOFactory;
import java.sql.SQLException;

/**
 * author By Ytker
 */
public class SellerLoginServiceImpl implements SellerLoginService {
    //获取SellDAO接口方法
    private SellerDAO sellerDAO = DAOFactory.getSellerDAOInstance();
    @Override
    public boolean login(String work_id, String password) {
        //定义Seller的空值，方便后续使用
        Seller seller = null;
        try {
            //调用SellDAO方法中的查询方法，查询此ID
            seller = sellerDAO.getUserByName(work_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //如果上面的Seller在数据库中有值，则执行下列
        if (seller != null){
            //对比根据工号ID查询出来的密码与用户输入的密码是否一致
            if (password.equals(seller.getPassword())){
                return true;
            }
        }
        return false;
    }
}
