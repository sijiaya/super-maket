package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Seller;

import java.sql.SQLException;
import java.util.List;

/**
 * 收银员的增删改查
 * author By Ytker
 */
public interface SellerDAO {

    /**
     * 新增收银员
     * @param seller
     * @return
     */
    Long insertSeller(Seller seller) throws SQLException;

    /**
     * 根据工号删除收银员
     * @param workId
     * @return
     * @throws SQLException
     */
    int deleteSeller(Long workId) throws SQLException;

    /**
     * 查询所有收银员
     * @return
     * @throws SQLException
     */
    List<Seller> selectAllSeller() throws SQLException;

    /**
     * 根据工号查询某个收银员
     * @param workId
     * @return
     * @throws SQLException
     */
    Entity getSellerById(Long workId) throws SQLException;


    /**
     * 根据工号更新员工数据
     * @param seller
     * @return
     * @throws SQLException
     */
    int updateSeller(Seller seller) throws SQLException;
    /**
     * 定义查询类型，获取数据库中的用户名
     * 登录方面
     * @param work_id
     * @return
     * @throws SQLException
     */
    Seller getUserByName(String work_id) throws SQLException;
    Seller getPasswordByWork_id(String password) throws SQLException;
}
