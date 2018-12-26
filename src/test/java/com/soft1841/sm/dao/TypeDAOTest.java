package com.soft1841.sm.dao;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 郭瑞昌
 * 这是TypeDAO的单元测试
 */
public class TypeDAOTest {
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();
    @Test
    public void selectType() throws SQLException {
        List<Type> typeList = typeDAO.selectAllTypes();
        typeList.forEach(entity -> System.out.println(entity));
    }
}