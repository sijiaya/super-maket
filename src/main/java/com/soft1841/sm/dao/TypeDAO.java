package com.soft1841.sm.dao;


import com.soft1841.sm.entity.Type;

import java.sql.SQLException;
import java.util.List;

/**
 * 商品类别
 */
public interface TypeDAO {
    /**
     * 新增商品类别
     * @param type
     * @return
     * @throws SQLException
     */
    Long insertType(Type type) throws SQLException;



    /**
     * 查询所有类别
     * @return
     * @throws SQLException
     */
    List<Type> selectAllTypes() throws SQLException;

    /**
     * 根据id查询类别信息
     * @param id
     * @return
     * @throws SQLException
     */
    Type getTypeById(long id) throws SQLException;

    /**
     *更新类别
     * @param type
     * @return
     */
    int updateType(Type type) throws SQLException;

    /**
     * 根据id删除类别
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteTypeById(Long id)throws SQLException;
}
