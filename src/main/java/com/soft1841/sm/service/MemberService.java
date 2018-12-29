package com.soft1841.sm.service;

import com.soft1841.sm.entity.Member;

import java.util.List;

public interface MemberService {
    /**
     * 新增会员
     * @param member
     * @return
     */
    Long addMember(Member member);

    /**
     * 获取所有会员
     * @return
     */
    List<Member> getAllMember();



    /**
     * 根据会员号查询会员
     * @param number
     * @return
     */
    Member getMember(long number);


    void updateMember(Member member);

    /**
     * 根据会员号删除
     * @param number
     */
    void deleteMember(String number);

    /**
     *
     * @param integral
     * @return
     */
    int countByIntegral(int integral);

}