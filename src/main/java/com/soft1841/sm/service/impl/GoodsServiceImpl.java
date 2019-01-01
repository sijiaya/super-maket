package com.soft1841.sm.service.impl;


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
    public Long addGoods(Goods goods) {
        long result = 0;
        try {
            result = goodsDAO.insertGoods(goods);
        } catch (SQLException e) {
            System.err.println("新增图书出现异常");
        }
        return result;
    }

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
    public List<Goods> getGoodsByBarcode(long barcode) {
        List<Goods>goodsList = new ArrayList<>();
        try {
            goodsList = goodsDAO.selectGoodsByBarcode(barcode);
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

    @Override
    public void deleteGoods(long id) {
        try {
            goodsDAO.deleteGoodsById(id);
        } catch (SQLException e) {
            System.err.println("删除图书出现异常");
        }
    }

    @Override
    public int countByType(long typeId) {
        int result = 0;
        try {
            result = goodsDAO.countByType(typeId);
        } catch (SQLException e) {
            System.err.println("根据类别统计图书信息出现异常");
        }
        return result;
    }
    @Override
    public void updateGoods(Goods goods) {
        try{
            goodsDAO.updategoods(goods);
        } catch (SQLException e) {
            System.err.println("修改商品信息出现异常");
        }
    }
}









