package com.soft1841.sm.dao.impl;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Type;
import java.sql.SQLException;
import java.util.List;

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
    public List<Entity> selectAllTypes() throws SQLException {
        return Db.use().query("SELECT * FROM t_type");
    }


    @Override
    public Entity getTypeById(Long id) throws SQLException {
        return Db.use().queryOne("SELECT * FROM t_type WHERE id = ?", id);
    }


    @Override
    public int updateType(Type type) throws SQLException {
        return Db.use().update(
                Entity.create().set("type_name",type.getName())
                .set("type_cover",type.getCover()),
                Entity.create("t_type").set("id",type.getId())
        );
    }
}
