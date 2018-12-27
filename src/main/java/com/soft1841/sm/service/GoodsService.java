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

    /**
     * 获取所有商品
>>>>>>> origin/master
     * @return
     */
    List<Goods> getAllGoods();

    /**
<<<<<<< HEAD
     *
=======
     * 根据商品编号查询
>>>>>>> origin/master
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



    /**
     * 删除商品
     * @param id
     */
    void deleteGoods(long id);
}

