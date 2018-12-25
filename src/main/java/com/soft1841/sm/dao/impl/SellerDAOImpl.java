package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.SellerDAO;
import com.soft1841.sm.entity.Seller;

import java.sql.SQLException;
import java.util.List;

public class SellerDAOImpl implements SellerDAO {

    @Override
    public Integer insertSeller(Seller seller) throws SQLException {
        return null;
    }

    @Override
    public int deleteSeller(Long workId) throws SQLException {
        return 0;
    }

    @Override
    public List<Entity> selectAllSeller() throws SQLException {
        return null;
    }

    @Override
    public Entity getSellerById(Long workId) throws SQLException {
        return null;
    }

    @Override
    public int updateSeller(Long workId) throws SQLException {
        return 0;
    }

    /**
     * 单行SQL语句，从数据库i查询用户输入的用户名
     * @param work_id
     * @return
     * @throws SQLException
     */
    @Override
    public Seller getUserByName(String work_id) throws SQLException {
        //定义Entity返回类型，查询sql语句
        Entity entity = Db.use().queryOne("select * from t_seller where work_id = ?" ,work_id);
        //使用convertSeller方法将entity型转化为Seller
        return convertSeller(entity);
    }
    private Seller convertSeller(Entity entity){
        //给Seller定义数据库中的列名
        Seller seller = new Seller(entity.getLong("id"),entity.getLong("work_id"),entity.getStr("password"),
                entity.getStr("name"),entity.getStr("avatar"),entity.getStr("address"));
        return seller;
    }
}
