package com.soft1841.sm.service;

import com.soft1841.sm.dao.SellerDAO;
import com.soft1841.sm.entity.Seller;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import java.util.List;



public class SellerServiceTest {
    private SellerService sellerService = ServiceFactory.getSellersServiceInstance();

    @Test
    public void getAllSellers() {
        List<Seller> sellerList = sellerService.getAllSellers();
        sellerList.forEach(seller -> System.out.println(seller));
    }

    @Test
    public void addSeller() {
        Seller seller = new Seller();
        seller.setWork_id(Long.valueOf(10));
        seller.setPassword("sdas");
        seller.setName("测试");
        seller.setAvatar("https://sdsa");
        seller.setAddress("测试地址");
        System.out.println(sellerService.addSeller(seller));
    }

    @Test
    public void deleteSeller() {
        sellerService.deleteSeller(4);
    }
}