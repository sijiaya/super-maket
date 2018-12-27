package com.soft1841.sm.service;

import com.soft1841.sm.entity.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getAllGoods();
    List<Goods> getGoodsByTypeId(int typeId);
    List<Goods> getGoodsLike(String keywords);
}
