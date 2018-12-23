package com.soft1841.sm.dao;

import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

public interface LoginDAO {
   List<Entity> selectAdmin(String user, String psd) throws SQLException;

   Entity getUserByName(String name) throws SQLException;
}
