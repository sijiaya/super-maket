package com.soft1841.sm.service;

import com.soft1841.sm.entity.Member;

import java.util.List;

/**
 * 会员接口
 */
public interface MemberService {
    /**
     * 查询所有会员
     * @return
     */
    List<Member> getAllMember();

    /**
     * 删除会员
     * @param id
     */
    void deleteMember(long id);

    /**
     * 新增一个
     * @param member
     * @return
     */
    Long addMember(Member member);

}
