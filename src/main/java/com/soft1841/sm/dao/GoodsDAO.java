package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Goods;

import java.sql.SQLException;
import java.util.List;

/**
 * 商品信息的增删改查
 */
public interface GoodsDAO {
    static void deleteBookById(long id) {
    }

    /**
     * 查看商品列表的DAO
     * @return
     * @throws SQLException
     */
    List<Entity> selectGoods() throws SQLException;

    /**
     * 往数据库中插入商品
     * @param goods
     * @return
     */
    Long insertGoods(Goods goods) throws SQLException;

    /**
     * 根据商品类别查询商品
     * @param typeId
     * @return
     * @throws SQLException
     */
    List<Entity> selectGoodsByTypeId(int typeId) throws SQLException;

    /**
     * 根据商品名关键词模糊查询商品
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<Entity> selectGoodLike(String keywords) throws SQLException;

    void updateGoods(Goods goods);
}
