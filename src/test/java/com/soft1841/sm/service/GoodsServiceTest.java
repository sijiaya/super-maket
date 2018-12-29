package com.soft1841.sm.service;

import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import java.util.List;

public class GoodsServiceTest {
    private GoodsService goodsService = ServiceFactory.getGoodServiceInstance();

    @Test
    public void selectAllGoods(){
        List<Goods> goodsList = goodsService.getAllGoods();
        goodsList.forEach(goods -> System.out.println(goods));
    }

    @Test
    public void getGoodsByTypeId(){
        System.out.println(goodsService.getGoodsByTypeId(1));
    }

    @Test
    public void addGoods(){
        Goods goods = new Goods();
        goods.setTypeId(1);
        goods.setName("冰箱1");
        goods.setPrice(22.22);
        goods.setVip(20);
        goods.setDescription("冰箱家电测试");
        goods.setPicture("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1545470537&di=cbd7f8af34d92646f3ec820d64fa5423&src=http://img002.hc360.cn/m6/M0E/0A/EF/wKhQoVWLUkmESjdNAAAAAPoQGGo387.jpg");
        goods.setBarcode(1111111);
        goods.setInventory(12);
        System.out.println(goodsService.addGoods(goods));
    }


    @Test
    public void deleteGoods() {
        goodsService.deleteGoods(10);
    }

    @Test
   public  void countType(){
    goodsService.countByType(1);
    }
}

