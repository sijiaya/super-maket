package com.soft1841.sm.service;


import com.soft1841.sm.entity.Member;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import java.util.List;

public class MemberServiceTest {
    private MemberService memberService = ServiceFactory.getMemberServiceInstance();


    @Test
    public void selectAllMember(){
        List<Member> memberList = memberService.getAllMember();
        memberList.forEach(member -> System.out.println(member));
    }

    @Test
    public void deleteMemberById(){
        memberService.deleteMember("2019007");
    }

    @Test
    public void insertMember(){
        Member member = new Member();
        member.setNumber("20180404");
        member.setName("李四");
        member.setAddress("浙江省温州市");
        member.setPhone("241475215");
        member.setIntegral("67");
        System.out.println(memberService.addMember(member));
    }

    @Test
    public void updateMember(){
        Member member = new Member();
        member.setId(27);
        member.setAddress("浙江省杭州市");
        member.setPhone("18023424355");
        member.setIntegral("150");
        memberService.updateMember(member);
    }
@Test
    public void countByIntegral(){
        memberService.countByIntegral(70);
}
}