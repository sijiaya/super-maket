package com.soft1841.sm.dao.impl;


import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.MemberDAO;
import com.soft1841.sm.entity.Member;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 会员的DAO实现类
 */
public class MemberDAOImpl implements MemberDAO {

    private Member convertMember(Entity entity){
        Member member = new Member();
        member.setId(entity.getLong("id"));
        member.setNumber(entity.getStr("number"));
        member.setName(entity.getStr("name"));
        member.setAddress(entity.getStr("address"));
        member.setPhone(entity.getStr("phone"));
        member.setIntegral(entity.getStr("integral"));
        return member;
   }


    @Override
    public Long insertMember(Member member) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_members ")
                .set("number",member.getNumber())
                .set("name",member.getName())
                .set("address",member.getAddress())
                .set("phone",member.getPhone())
                .set("integral",member.getIntegral())
        );
    }



    @Override
    public List<Member> selectAllMember() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_members ");
        List<Member> memberList = new ArrayList<>();
        for (Entity entity:entityList
        ) {
            memberList.add(convertMember(entity));
        }
        return memberList;
    }

    @Override
    public int updateMember(Member member) throws SQLException {
        return 0;
    }

    @Override
    public Member getMemberByNumber(long number) throws SQLException {
        return null;
    }

    @Override
    public int deleteMemberById(String number) throws SQLException {
        return Db.use().del(
                Entity.create("t_members").set("id",number)
        );
    }

    @Override
    public int countByIntegral(int integral) throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_members WHERE integral = ? ", integral).intValue();
    }

}
