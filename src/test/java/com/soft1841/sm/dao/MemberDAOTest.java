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
        member.setNumber("2019007");
        member.setName("黄兴");
        member.setAddress("江苏省南京市");
        member.setPhone("18893027777");
        member.setIntegral("80");
        System.out.println(memberDAO.insertMember(member));

    }


    @Test
    public  void  selectAllMember() throws SQLException {
       List<Member> memberList = memberDAO.selectAllMember();
       memberList.forEach(entity -> System.out.println(entity));

    }
    @Test
    public void deleteById() throws SQLException {
        memberDAO.deleteMemberById("2019007");
    }

    @Test
    public void updateMember() throws SQLException{
        Member member = new Member();
        member.setId(27);
        member.setAddress("浙江省杭州市");
        member.setPhone("18023424355");
        member.setIntegral("150");
        memberDAO.updateMember(member);
    }
    @Test
    public void countByInIntegral() throws SQLException {
int n= memberDAO.countByIntegral(70);
    }
}