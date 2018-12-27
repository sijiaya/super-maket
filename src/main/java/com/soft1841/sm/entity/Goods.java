package com.soft1841.sm.entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Goods {
    private final SimpleLongProperty id = new SimpleLongProperty();
    private final SimpleLongProperty typeId = new SimpleLongProperty();
    private final SimpleLongProperty barcode = new SimpleLongProperty();
    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleDoubleProperty price = new SimpleDoubleProperty();
    private final SimpleDoubleProperty vip = new SimpleDoubleProperty();
    private final SimpleStringProperty description = new SimpleStringProperty("");
    private final SimpleStringProperty picture = new SimpleStringProperty("");
    private final SimpleIntegerProperty inventory=new SimpleIntegerProperty();

    public Goods() {
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

    public long getTypeId() {
        return typeId.get();
    }

    public SimpleLongProperty typeIdProperty() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId.set(typeId);
    }

    public long getBarcode() {
        return barcode.get();
    }

    public SimpleLongProperty barcodeProperty() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode.set(barcode);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public double getVip() {
        return vip.get();
    }

    public SimpleDoubleProperty vipProperty() {
        return vip;
    }

    public void setVip(double vip) {
        this.vip.set(vip);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getPicture() {
        return picture.get();
    }

    public SimpleStringProperty pictureProperty() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture.set(picture);
    }

    public int getInventory() {
        return inventory.get();
    }

    public SimpleIntegerProperty inventoryProperty() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory.set(inventory);
    }


    }
