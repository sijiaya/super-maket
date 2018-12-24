package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Seller;

import java.sql.SQLException;
import java.util.List;

/**
 * 收银员的增删改查
 */
public interface SellerDAO {

    /**
     * 新增收银员
     * @param seller
     * @return
     */
    Integer insertSeller(Seller seller) throws SQLException;

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
    List<Entity> selectAllSeller() throws SQLException;

    /**
     * 根据工号查询某个收银员
     * @param workId
     * @return
     * @throws SQLException
     */
    Entity getSellerById(Long workId) throws SQLException;


    /**
     * 根据工号更新员工数据
     * @param workId
     * @return
     * @throws SQLException
     */
    int updateSeller(Long workId) throws SQLException;
}
