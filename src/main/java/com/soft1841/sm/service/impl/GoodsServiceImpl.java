package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDAO goodsDAO = DAOFactory.getGoodsDAOInstance();
    @Override
    public Long addGoods(Goods goods) {
        long result = 0;
        try {
            result = goodsDAO.insertGoods(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
