package com.soft1841.sm.service;

import com.soft1841.sm.entity.Type;
import java.util.List;

/**
 * @author 郭瑞昌
 * 2018.12.25
 * 22.37
 */
public interface TypeService {
    /**
     * 查询所有商品类别
     * @return
     */
    List<Type> selectAllType();
    /**
     * 删除类别
     * @param id
     */
    void deleteType(long id);
    /**
     * 根据id查询分类信息
     *
     * @param id
     * @return Book
     */
    Type getType(long id);
}
