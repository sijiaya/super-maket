package com.soft1841.sm.service.impl;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 郭瑞昌
 * 2018.12.25
 * 22.39
 * 分类显示业务逻辑层的实现
 */
public class TypeServiceImpl implements TypeService {
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();
    @Override
    public List<Type> selectAllType() {
        List<Type> typeList = new ArrayList<>();
        //调用底层TypeDAO的查询类别方法，得到一个typeList

        return typeList;
    }

    @Override
    public void deleteType(long id) {
        try {
            //调用底层DAO的删除类别方法
            typeDAO.deleteTypeById(id);
        } catch (SQLException e) {
            System.err.println("删除类别出现异常!");
        }
    }

    @Override
    public Type getType(long id) {
        Type type = new Type();
        try {
            type = typeDAO.getTypeById(id);
        } catch (SQLException e) {
            System.err.println("查询单个类别信息出现异常");
        }
        return type;
    }

    /**
     * 添加类别
     *
     * @param type
     * @return
     */
    @Override
    public Long addType(Type type) {
        long result = 0;
        try {
            result = typeDAO.insertType(type);
        }catch (SQLException e){
            System.err.println("新增商品类别出现异常");
        }
        return result;
    }

    @Override
    public List<Type> getAllTypes() {
        List<Type> typeList = new ArrayList<>();
        try {
            //调用底层DAO的查询所有类别的方法，得到一个typeList，薄层封装
            typeList = typeDAO.selectAllTypes();
        } catch (SQLException e) {
            //友好处理异常
            System.err.println("查询所有类别出现异常!");
        }
        return typeList;
    }
}
