package com.soft1841.sm.dao;

import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * 商品类别
 */
public interface TypeDAO {
    List<Entity> selectType() throws SQLException;
}
