package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.LoginDAO;

import java.sql.SQLException;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {

    @Override
    public List<Entity> selectAdmin(String user, String psd) throws SQLException {
        return Db.use().query("SELECT * FROM t_user WHERE account = ? and password = ?",user,psd);
    }

    @Override
    public Entity getUserByName(String name) throws SQLException {
        return Db.use().queryOne("select * from t_user where account = ?" ,name);
    }
}
