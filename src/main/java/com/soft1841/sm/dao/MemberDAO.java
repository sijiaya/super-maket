package com.soft1841.sm.dao;

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
     * 查询所有会员
     * @return
     * @throws SQLException
     */
    List<Member> selectAllMember() throws SQLException;

    /**
     * 更新会员信息
     * @param member
     * @return
     * @throws SQLException
     */
    int updateMember(Member member) throws SQLException;


    /**
     * 通过会员号查询
     * @param number
     * @return
     * @throws SQLException
     */
    Member getMemberByNumber(long number) throws SQLException;

    /**
     * 根据id删除会员
     * @param number
     * @throws SQLException
     */
    int deleteMemberById(String number) throws SQLException;

    /**
     *
     * @param integral
     * @return
     * @throws SQLException
     */
    int countByIntegral(int integral)throws SQLException;


    /**
     *
     * @param integral
     * @return
     * @throws SQLException
     */
    int countByIntegral(int integral)throws SQLException;

}
