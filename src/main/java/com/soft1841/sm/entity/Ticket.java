package com.soft1841.sm.entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;

import java.util.Date;

public class Ticket {
    private final SimpleLongProperty id = new SimpleLongProperty();
    private final SimpleLongProperty type_id = new SimpleLongProperty();
    private final SimpleLongProperty vip_id = new SimpleLongProperty();
    private Date time;
    private final SimpleDoubleProperty amount = new SimpleDoubleProperty();


    public Ticket() {
    }


    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public long getType_id() {
        return type_id.get();
    }

    public SimpleLongProperty type_idProperty() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id.set(type_id);
    }

    public long getVip_id() {
        return vip_id.get();
    }

    public SimpleLongProperty vip_idProperty() {
        return vip_id;
    }

    public void setVip_id(long vip_id) {
        this.vip_id.set(vip_id);
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getAmount() {
        return amount.get();
    }

    public SimpleDoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", type_id=" + type_id +
                ", vip_id=" + vip_id +
                ", time=" + time +
                ", amount=" + amount +
                '}';
    }
}
