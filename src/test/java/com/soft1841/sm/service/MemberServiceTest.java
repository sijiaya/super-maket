package com.soft1841.sm.service;

import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Member;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import java.util.List;

public class MemberServiceTest {
    private MemberService memberService =ServiceFactory.getMemberServiceInstance();

    @Test
    public void selectAllMember(){
        List<Member> memberList = memberService.getAllMember();
        memberList.forEach(member -> System.out.println(member));
    }


    @Test
    public void addMember(){
        Member member = new Member();
        member.setId(7);
        member.setNumber(11111);
        member.setName("撒地方");
        member.setAddress("撒地方是否");
        member.setPhone("54444444");
        member.setIntegral(134);
        System.out.println(memberService.addMember(member));
    }
    @Test
    public void deleteMember(){
        memberService.deleteMember(7);
    }
}
