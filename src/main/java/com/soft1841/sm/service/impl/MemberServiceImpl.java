package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.dao.MemberDAO;
import com.soft1841.sm.entity.Member;
import com.soft1841.sm.service.MemberService;
import com.soft1841.sm.utils.DAOFactory;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberServiceImpl implements MemberService {

    private MemberDAO memberDAO = DAOFactory.getMemberDAOInstance();

    /**
     * 新增会员
     *
     * @param member
     * @return
     */
    @Override
    public Member addMember(Member member) {
        long result = 0;
        try {
            result = memberDAO.insertMember(member);
        }catch (SQLException e){
            System.err.println("新增会员出现异常");
        }
        return member;
    }

    /**
     * 获取所有会员
     *
     * @return
     */
    @Override
    public List<Member> getAllMember() {
        List<Member> memberList = new ArrayList<>();
        try {
            memberList = memberDAO.selectAllMember();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return memberList;
    }

    /**
     * 根据会员号删除
     *
     * @param number
     */
    @Override
    public void deleteMember(String number) {
        try {
            memberDAO.deleteMemberById(number);
        }catch (SQLException e){
            System.err.println("删除会员出现异常");
        }
    }

    @Override
    public int countByIntegral(int integral) {
        int result = 0;
        try {
            result = memberDAO.countByIntegral(integral);
        } catch (SQLException e) {
            System.err.println("根据积分统计会员信息出现异常");
        }
        return result;
    }
}
