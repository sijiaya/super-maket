package com.soft1841.sm.dao.impl;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 郭瑞昌
 *TypeDAO的实现类
 */
public class TypeDAOImpl implements TypeDAO {
    /**
     * 2018-12-25
     * 13.42
     * 修改插入语句，增加了添加分类图片
     * @param type
     * @return
     * @throws SQLException
     */
    @Override
    public Long insertType(Type type) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_type").set("name",type.getName())
                .set("cover",type.getCover())
        );
    }

    @Override
    public int deleteTypeById(Long id) throws SQLException {
        return Db.use().del(Entity.create("t_type").set("id",id));
    }


    @Override
    public List<Type> selectAllTypes() throws SQLException {
        //查询得到List<Entity>
        List<Entity> entityList =  Db.use().query("SELECT * FROM t_type ");
        //创建一个List<Type>，存放具体的商品类别
        List<Type> typeList = new ArrayList<>();
        //遍历entityList，将其转换为typeList
        for (Entity entity:entityList) {
            typeList.add(convertType(entity));
        }
      return typeList;
    }




    @Override
    public Type getTypeById(long id) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM t_type WHERE id = ? ", id);
        return convertType(entity);
    }


    @Override
    public int updateType(Type type) throws SQLException {
        return Db.use().update(
                Entity.create().set("type_name",type.getName())
                .set("type_cover",type.getCover()),
                Entity.create("t_type").set("id",type.getId())
        );
    }
    /**
     * 将Entity转化为Type型方法
     * @param entity
     * @return
     */
    private Type convertType(Entity entity) {
        Type type = new Type();
        type.setId(entity.getLong("id"));
        type.setName(entity.getStr("name"));
        type.setCover(entity.getStr("cover"));
        return type;
    }
}
