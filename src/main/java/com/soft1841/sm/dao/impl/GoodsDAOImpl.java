package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.entity.Goods;

import java.sql.SQLException;
import java.util.List;

public class GoodsDAOImpl implements GoodsDAO {
    @Override
    public List<Entity> selectGoods() throws SQLException {
        return Db.use().query("SELECT * FROM t_goods" );
    }

    @Override
    public Long insertGoods(Goods goods) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_goods")
                        .set("type_id", goods.getTypeId())
                        .set("name", goods.getName())
                        .set("price", goods.getPrice())
                        .set("vipPrice", goods.getVipPrice())
                        .set("description", goods.getDescription())
                        .set("picture",goods.getPicture())
        );
    }
}
