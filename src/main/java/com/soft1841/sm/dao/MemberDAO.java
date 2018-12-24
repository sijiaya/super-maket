package com.soft1841.sm.dao;

import cn.hutool.db.Entity;

import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.List;

public interface MemberDAO {
    /**
     * 新增会员
     * @param member
     * @return
     */
    Long insertMember(Member member) throws SQLException;

    /**
     * 删除会员
     * @param number
     * @return
     */
    int deleteMember(String number) throws SQLException;

    /**
     * 查询所有会员
     * @return
     * @throws SQLException
     */
    List<Entity> selectAllMember() throws SQLException;

    /**
     * 更新会员信息
     * @param number
     * @return
     * @throws SQLException
     */
    int updateMember(String number) throws SQLException;
}
