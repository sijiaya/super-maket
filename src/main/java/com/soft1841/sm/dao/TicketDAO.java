package com.soft1841.sm.dao;

import com.soft1841.sm.entity.Ticket;
import com.sun.xml.internal.stream.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * 小票增、查
 */
public interface TicketDAO {

    /**
     * 新增收银小票，返回自增
     * @param ticket
     * @return
     */
    Long insertTicket(Ticket ticket) throws SQLException;

    /**
     * 通过小票id查询明细
     * @param id
     * @return
     * @throws SQLException
     */
    Entity getTicketById(Long id) throws SQLException;

    /**
     * 查询所有小票
     * @return
     * @throws SQLException
     */
    List<Entity> getAllTicket() throws SQLException;
}
