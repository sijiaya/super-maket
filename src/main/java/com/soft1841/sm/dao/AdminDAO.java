package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public interface AdminDAO {

    /**
     * 新增管理员
     * @param admin
     * @return
     * @throws SQLException
     */
    Integer insertAdmin(Admin admin) throws SQLException;

    /**
     * 用工号删除管理员
     * @param jobId
     * @return
     * @throws SQLException
     */
    int deleteAdmin(Long jobId) throws SQLException;

    /**
     * 查询所有管理员
     * @return
     * @throws SQLException
     */
    List<Entity> selectAllAdmin() throws SQLException;

    /**
     * 根据工号查询某个管理员
     * @param jobId
     * @return
     * @throws SQLException
     */
    Entity getAdminById(Long jobId) throws SQLException;

    /**
     * 根据工号更新管理员信息
     * @param jobId
     * @return
     * @throws SQLException
     */
    int updateAdmin(Long jobId) throws SQLException;

    /**
     * 定义查询类型，获取数据库中的用户名
     * 登录
     * @param job_id
     * @return
     * @throws SQLException
     */
    Admin getUserByName(Integer job_id) throws SQLException;
}
