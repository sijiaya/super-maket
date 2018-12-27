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
        goods.setName("测试新商品");
        goodsService.addGoods(goods);
    }


    @Test
    public void deleteGoods() {
        goodsService.deleteGoods(10);
    }
}
