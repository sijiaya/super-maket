package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.entity.Goods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class GoodsDAOImpl implements GoodsDAO {
    @Override
    public List<Goods> selectGoods() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods " );
        List<Goods> goodsList = new ArrayList<>();
        for (Entity entity:entityList
             ) {
            goodsList.add(convertGoods(entity));
        }
        return goodsList;
        }
    @Override
    public Long insertGoods(Goods goods) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_goods")
                        .set("type_id", goods.getTypeId())
                        .set("name", goods.getName())
                        .set("price", goods.getPrice())
                        .set("vip", goods.getVip())
                        .set("description", goods.getDescription())
                        .set("picture",goods.getPicture())
                .set("barcode",goods.getBarcode())
                .set("inventory",goods.getInventory())
        );
    }

    @Override
    public List<Goods> selectGoodsByTypeId(int typeId) throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods WHERE type_id = ? ",typeId);
        List<Goods> goodsList = new ArrayList<>();
        for (Entity entity:entityList
        ) {
            goodsList.add(convertGoods(entity));
        }
        return goodsList;
    }

    @Override
    public List<Goods> selectGoodsByBarcode(Long barcode) throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods WHERE barcode = ? ",barcode);
        List<Goods> goodsList = new ArrayList<>();
        for (Entity entity:entityList
        ) {
            goodsList.add(convertGoods(entity));
        }
        return goodsList;
    }

    @Override
    public List<Goods> selectGoodLike(String keywords) throws SQLException {
        List<Entity> entityList=Db.use().findLike("t_goods","name",keywords, Condition.LikeType.Contains);
        List<Goods> goodsList = new ArrayList<>();
        for (Entity entity:entityList
        ) {
            goodsList.add(convertGoods(entity));
        }
        return goodsList;
    }

    /**
     * 根据id删除商品
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteGoodsById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_goods").set("id",id)
        );
    }

    @Override
    public int countByType(long typeId) throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_goods WHERE type_id = ? ", typeId).intValue();
    }

    @Override
    public int updategoods(Goods goods) throws SQLException {
       return Db.use().update(
             Entity.create().set("number",goods.getNumber())
               .set("subtotal",goods.getSubtotal()),
               Entity.create("t_goods").set("barcode",goods.getBarcode())
       );

    }

    private Goods convertGoods(Entity entity) {
        Goods goods = new Goods();
        goods.setId(entity.getLong("id"));
        goods.setTypeId(entity.getLong("type_id"));
        goods.setBarcode(entity.getLong("barcode"));
        goods.setName(entity.getStr("name"));
        goods.setPrice(entity.getDouble("price"));
        goods.setVip(entity.getDouble("vip"));
        goods.setDescription(entity.getStr("description"));
        goods.setPicture(entity.getStr("picture"));
        goods.setInventory(entity.getInt("inventory"));
        goods.setNumber(entity.getLong("number"));
        goods.setSubtotal(entity.getDouble("subtotal"));
        return goods;
    }
}
