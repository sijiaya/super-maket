package com.soft1841.sm.dao;
import com.soft1841.sm.entity.Member;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class MemberDAOTest {
    private MemberDAO memberDAO = DAOFactory.getMemberDAOInstance();
    @Test
    public void insertMember() throws SQLException {
        Member member = new Member();
        member.setNumber(2019007);
        member.setName("李莉");
        member.setAddress("浙江杭州");
        member.setPhone("18893027961");
        member.setIntegral("60");
        System.out.println(memberDAO.insertMember(member));

    }


    @Test
    public  void  selectAllMember() throws SQLException {
       List<Member> memberList = memberDAO.selectAllMember();
       memberList.forEach(entity -> System.out.println(entity));

    }
    @Test
    public void deleteById() throws SQLException {
        memberDAO.deleteMemberById((long) 1);
    }
}