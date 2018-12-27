package com.soft1841.sm.service;

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

}