package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.MemberDAO;
import com.soft1841.sm.entity.Member;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {

   private Member convertMerber(Entity entity){
        Member member = new Member();
        member.setId(entity.getLong("id"));
        member.setNumber(entity.getLong("number"));
        member.setName(entity.getStr("name"));
        member.setAddress(entity.getStr("address"));
        member.setPhone(entity.getStr("phone"));
        member.setIntegral(entity.getInt("integral"));
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
    public int deleteById(Long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_members").set("id",id)
        );
    }


    @Override
    public List<Member> selectAllMember() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_members ");
        List<Member> memberList = new ArrayList<>();
        for (Entity entity:entityList
        ) {
            memberList.add(convertMerber(entity));
        }
        return memberList;
    }


}
