package com.soft1841.sm.entity;
public class Admin {
    private Integer id;
    private Integer job_id;
    private String password;
    private String name;
    private String avatar;
    private String address;

    public Admin(Integer id, Integer job_id, String password, String name, String avatar, String address) {
        this.id = id;
        this.job_id = job_id;
        this.password = password;
        this.name = name;
        this.avatar = avatar;
        this.address = address;
    }

    public Admin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
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
        return "Admin{" +
                "id=" + id +
                ", job_id=" + job_id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
