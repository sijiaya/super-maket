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
                Entity.create("t_member")
                .set("number",member.getNumber())
                .set("name",member.getName())
                .set("address",member.getAddress())
                .set("phone",member.getPhone())
                .set("integral",member.getIntegral())
        );
    }


    @Override
    public List<Member> selectAllMember() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_member ");
        List<Member> memberList = new ArrayList<>();
        for (Entity entity:entityList
        ) {
            memberList.add(convertMember(entity));
        }
        return memberList;
    }

    /**
     * 更新会员信息
     *
     * @param member
     * @return
     * @throws SQLException
     */
    @Override
    public int updateMember(Member member) throws SQLException {
        //修改会员的地址，电话，积分
        return Db.use().update(
                Entity.create()
                        .set("address",member.getAddress())
                        .set("phone",member.getPhone())
                        .set("integral",member.getIntegral()),
                Entity.create("t_member").set("id",member.getId())
        );
    }

    /**
     * 通过会员号查询
     *
     * @param number
     * @return
     * @throws SQLException
     */
    @Override
    public Member getMemberByNumber(long number) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM t_member WHERE number = ?",number);
        return convertMember(entity);
    }

    /**
     * 根据id删除会员
     *
     * @param number
     * @throws SQLException
     */
    @Override
    public int deleteMemberById(String number) throws SQLException {
        return Db.use().del(
                Entity.create("t_member").set("number", number)
        );
    }

    @Override
    public int countByIntegral(int integral) throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_member WHERE integral = ? ", integral).intValue();
    }




}