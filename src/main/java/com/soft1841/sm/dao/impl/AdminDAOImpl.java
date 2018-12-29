package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.AdminDAO;
import com.soft1841.sm.entity.Admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {


    @Override
    public Integer insertAdmin(Admin admin) throws SQLException {
        return null;
    }


    @Override
    public int deleteAdmin(Long jobId) throws SQLException {
        return 0;
    }

    //查询所有管理者
    @Override
    public List<Admin> selectAllAdmin() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_admin ");
        List<Admin> adminList = new ArrayList<>();
        for (Entity entity : entityList) {
            adminList.add(convertAdmin(entity));
        }
        return adminList;
    }


    @Override
    public Entity getAdminById(Long jobId) throws SQLException {
        return null;
    }


    @Override
    public int updateAdmin(Long jobId) throws SQLException {
        return 0;
    }


    /**
     * 从数据库查询用户输入的用户名
     * @param job_id
     * @return
     * @throws SQLException
     */
    @Override
    public Admin getUserByName(Integer job_id) throws SQLException {
        //定义entity返回类型，查询sql语句
        Entity entity = Db.use().queryOne("SELECT * FROM t_admin WHERE job_id = ?", job_id);
        //使用convertAdmin方法将entity型转为Admin
        return convertAdmin(entity);
    }

    @Override
    public int countByAddress(String address) throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_admin WHERE address = ? ", address).intValue();
    }

    private Admin convertAdmin(Entity entity){
        //给Admin定义数据库中的列名
        Admin admin = new Admin(entity.getInt("id"),
                entity.getInt("job_id"),entity.getStr("password"),
                entity.getStr("name"),entity.getStr("avatar"),
                entity.getStr("address"));
        return admin;
    }
}
