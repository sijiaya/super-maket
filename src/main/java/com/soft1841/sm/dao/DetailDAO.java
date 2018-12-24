package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Detail;

import java.sql.SQLException;
import java.util.List;

/**
 * 小票收银明细的增、查
 */
public interface DetailDAO {
    /**
     * 新增收银明细，返回自增主键
     * @param detail
     * @return
     */
    Long insertDetail(Detail detail) throws SQLException;

    /**
     * 通过小票id查询明细
     * @param receiptId
     * @return
     */
    Entity getDetailReceiptId(Long receiptId) throws SQLException;

    /**
     * 获取所有收银明细信息
     * @return
     * @throws SQLException
     */
    List<Entity> getAllDetail() throws SQLException;
}
