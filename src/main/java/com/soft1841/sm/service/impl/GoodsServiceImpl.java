package com.soft1841.sm.service.impl;


import cn.hutool.db.Entity;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDAO goodsDAO =DAOFactory.getGoodsDAOInstance();
    @Override
    public List<Goods> getAllGoods() {
        List<Goods> goodsList = new ArrayList<>();
        try {
            goodsList = goodsDAO.selectGoods();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    @Override
    public List<Goods> getGoodsByTypeId(int typeId) {
        List<Goods>goodsList = new ArrayList<>();
        try {
            goodsList = goodsDAO.selectGoodsByTypeId(typeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  goodsList;
    }

    @Override
    public List<Goods> getGoodsLike(String keywords) {
        List<Goods>goodsList = new ArrayList<>();
        try {
            goodsList = goodsDAO.selectGoodLike(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  goodsList;
    }
}











