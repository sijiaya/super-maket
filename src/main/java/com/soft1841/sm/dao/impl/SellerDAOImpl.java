package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.SellerDAO;
import com.soft1841.sm.entity.Seller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 收银员DAO的实现类
 */
public class SellerDAOImpl implements SellerDAO {

    @Override
    public Long insertSeller(Seller seller) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_seller")
                .set("work_id",seller.getWork_id())
                .set("password",seller.getPassword())
                .set("name",seller.getName())
                .set("avatar",seller.getAvatar())
                .set("address",seller.getAddress())
        );
    }

    @Override
    public int deleteSeller(Long workId) throws SQLException {
        return Db.use().del(
                Entity.create("t_seller").set("id",workId)
        );
    }

    @Override
    public List<Seller> selectAllSeller() throws SQLException {
        //查询得到List<Entity>
        List<Entity> entityList = Db.use().query("SELECT * FROM t_seller");
        //创建一个List<Seller>，存放收银员信息
        List<Seller> sellerList = new ArrayList<>();
        //遍历entityList，转换为typeList
        for (Entity entity:entityList) {
            sellerList.add(convertSeller(entity));
        }
        return sellerList;
    }

    /**
     * 根据工号查询某个收银员
     *
     * @param workId
     * @return
     * @throws SQLException
     */
    @Override
    public Entity getSellerById(Long workId) throws SQLException {
        return null;
    }


    @Override
    public int updateSeller(Seller seller) throws SQLException {
        return Db.use().update(
                Entity.create().set("password",seller.getPassword()),
                Entity.create("t_seller").set("id",seller.getId())
        );
    }

    /**
     * 单行SQL语句，从数据库查询用户输入的用户名
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

    /**
     * 根据用户输入的密码来查询数据库中是否存在，用来判定用户输入
     * 旧密码是否正确
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public Seller getPasswordByWork_id(String password) throws SQLException {
        Entity entity = Db.use().queryOne("select * from t_seller where password = ?" ,password);
        //使用convertSeller方法将entity型转化为Seller
        return convertSeller(entity);
    }

    private Seller convertSeller(Entity entity){
        //给Seller定义数据库中的列名
        Seller seller = new Seller(entity.getLong("id"),
                entity.getLong("work_id"),entity.getStr("password"),
                entity.getStr("name"),entity.getStr("avatar")
                ,entity.getStr("address"));
        return seller;
    }
}
