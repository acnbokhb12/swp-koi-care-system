/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.model;

/**
 *
 * @author ASUS
 */
public class OrderStatus {
    
    private int orderStatusID;
    private String orderStatusName;

    public OrderStatus() {
    }

    public OrderStatus(int orderStatusID, String orderStatusName) {
        this.orderStatusID = orderStatusID;
        this.orderStatusName = orderStatusName;
    }

    public int getOrderStatusID() {
        return orderStatusID;
    }

    public void setOrderStatusID(int orderStatusID) {
        this.orderStatusID = orderStatusID;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "orderStatusID=" + orderStatusID +
                ", orderStatusName='" + orderStatusName + '\'' +
                '}';
    }
}