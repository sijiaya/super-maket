package com.soft1841.sm.service;

import com.soft1841.sm.entity.Seller;

import java.util.List;

public interface SellerService {

    /**
     * 获取所有收银员
     * @return
     */
    List<Seller>  getAllSellers();

    /**
     * 新增收银员
     * @param Seller
     * @return
     */
    Long addSeller(Seller Seller);
    /**
     * 根据id删除收银员
     * @param id
     */
    void deleteSeller(long id);
}
