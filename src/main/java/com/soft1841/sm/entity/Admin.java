package com.soft1841.sm.entity;
public class Admin {
    private Integer id;
    private String user;
    private String password;

    public Admin(Integer id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public Admin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
