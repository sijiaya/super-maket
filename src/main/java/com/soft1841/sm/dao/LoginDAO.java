package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public interface LoginDAO {
   /**
    * 此方法暂时无用，写到用户中心资料显示可能会用到
    * @param user
    * @param psd
    * @return
    * @throws SQLException
    */
   List<Entity> selectAdmin(String user, String psd) throws SQLException;

   /**
    * 定义查询类型，获取数据库中的用户名
    * @param name
    * @return
    * @throws SQLException
    */
   Admin getUserByName(String name) throws SQLException;
}
