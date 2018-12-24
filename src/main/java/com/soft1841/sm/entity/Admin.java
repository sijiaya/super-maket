package com.soft1841.sm.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Admin {
    private SimpleIntegerProperty id;
    private SimpleStringProperty user;
    private SimpleStringProperty password;

    public Admin(SimpleIntegerProperty id, SimpleStringProperty user, SimpleStringProperty password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public Admin() {
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getUser() {
        return user.get();
    }

    public SimpleStringProperty userProperty() {
        return user;
    }

    public void setUser(String user) {
        this.user.set(user);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", user=" + user +
                ", password=" + password +
                '}';
    }
}
