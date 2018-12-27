package com.soft1841.sm.service;

import com.soft1841.sm.entity.Goods;

import java.util.List;

public interface GoodsService {



    /**
     * 新增商品
     * @param goods
     * @return
     */
    Long addGoods(Goods goods);

    /**
     *
     * @return
     */
    List<Goods> getAllGoods();

    /**
     *
     * @param typeId
     * @return
     */
    List<Goods> getGoodsByTypeId(int typeId);

    /**
     *
     * @param keywords
     * @return
     */
    List<Goods> getGoodsLike(String keywords);

}
