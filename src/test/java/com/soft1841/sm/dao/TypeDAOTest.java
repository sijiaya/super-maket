package com.soft1841.sm.dao;


import cn.hutool.db.Entity;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TypeDAOTest {
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();
    @Test
    public void selectType() throws SQLException {
        List<Entity> typeList = typeDAO.selectAllTypes();
        typeList.forEach(entity -> System.out.println(entity));
    }
}