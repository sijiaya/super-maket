package com.soft1841.sm.service;


import com.soft1841.sm.entity.Member;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import java.util.List;

public class MemberServiceTest {
    private MemberService memberService = ServiceFactory.getMemberInstance();


    @Test
    public void selectAllMember(){
        List<Member> memberList = memberService.getAllMember();
        memberList.forEach(member -> System.out.println(member));
    }

    @Test
    public void deleteMemberById(){
        memberService.deleteMember("25");
    }

    @Test
    public void insertMember(){
        Member member = new Member();
        member.setNumber("20180404");
        member.setName("李四");
        member.setAddress("浙江温州");
        member.setPhone("241475215");
        member.setIntegral("67");
        System.out.println(memberService.addMember(member));
    }

    @Test
    public void countByInteral() {
        System.out.println(memberService.countByIntegral(70));
    }
}