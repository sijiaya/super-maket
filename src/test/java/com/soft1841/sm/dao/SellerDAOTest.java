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

}