package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Member;

;
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
     *
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(Long id) throws SQLException;



    /**
     * 查询所有会员
     * @return
     * @throws SQLException
     */
    List<Member> selectAllMember() throws SQLException;


}
