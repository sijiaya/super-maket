package com.soft1841.sm.entity;


import cn.hutool.db.Entity;
import javafx.beans.property.SimpleLongProperty;

public class Seller{
    private Long id;
    private Long work_id;
    private String password;
    private String name;
    private String avatar;
    private String address;

    public Seller(Long id, Long work_id, String password, String name, String avatar, String address) {
        this.id = id;
        this.work_id = work_id;
        this.password = password;
        this.name = name;
        this.avatar = avatar;
        this.address = address;
    }

    public Seller() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWork_id() {
        return work_id;
    }

    public void setWork_id(Long work_id) {
        this.work_id = work_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", work_id=" + work_id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
