package com.soft1841.sm.dao;
import com.soft1841.sm.entity.Seller;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

public class SellerDAOTest {
    private SellerDAO sellerDAO = DAOFactory.getSellerDAOInstance();
    @Test
    public void updateSeller() throws SQLException {
        Seller seller = new Seller();
        seller.setId(1l);
        seller.setPassword("name");
        seller.setName("ceshi");
        sellerDAO.updateSeller(seller);
    }

    @Test
    public void selectAllSeller() throws SQLException{
        List<Seller> sellerList = sellerDAO.selectAllSeller();
        sellerList.forEach(seller -> System.out.println(seller));
    }

    @Test
    public void insertSeller() throws SQLException {
        Seller seller = new Seller();
        seller.setWork_id(Long.valueOf(1));
        seller.setPassword("123456");
        seller.setName("测试");
        seller.setAvatar("https://hhhhh.com/jph");
        seller.setAddress("山西");
        System.out.println(sellerDAO.insertSeller(seller));
    }

    @Test
    public void deleteSeller() throws SQLException {
        sellerDAO.deleteSeller(Long.valueOf(5));
    }
}