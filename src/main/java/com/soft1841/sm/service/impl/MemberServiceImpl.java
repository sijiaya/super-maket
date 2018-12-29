package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.MemberDAO;
import com.soft1841.sm.entity.Member;
import com.soft1841.sm.service.MemberService;
import com.soft1841.sm.utils.DAOFactory;

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
    public Long addMember(Member member) {
        long result = 0;
        try {
            result = memberDAO.insertMember(member);
        }catch (SQLException e){
            System.err.println("新增会员出现异常");
        }
        return result;
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
     * 根据会员号查询会员
     *
     * @param number
     * @return
     */
    @Override
    public Member getMember(long number) {
        Member member = new Member();
        try {
            member = memberDAO.getMemberByNumber(number);
        }catch (SQLException e){
            System.err.println("根据会员号查询会员信息");
        }
        return member;
    }

    /**
     * 修改会员信息
     * @param member
     */
    @Override
    public void updateMember(Member member) {
        try {
            memberDAO.updateMember(member);
        } catch (SQLException e) {
            System.err.println("修改会员信息出现异常");
        }
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
}