package model;

import manager.ProductManager;

import java.io.Serializable;

public class Product implements Serializable {
    private int id ;
    private String name;
    private int price;
    private String manufacturer;
    private String describe;

    public Product(int id,String name, int price, String manufacturer, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "\tProduct : " +
                "\tId=" + id +
                ", Name = " + name +
                ", Price = " + price +
                ", Manufacturer = " + manufacturer +
                ", Describe = " + describe ;

    }
}
