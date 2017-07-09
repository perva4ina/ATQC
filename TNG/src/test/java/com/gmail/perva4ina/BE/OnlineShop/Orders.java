package com.gmail.perva4ina.BE.OnlineShop;

import java.util.HashSet;
import java.util.Set;

public class Orders {

    private int orderID;
    private int customerID;
    private Set<Product> products = new HashSet<>();

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
