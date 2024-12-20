/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Order {

    private int id;
    private int customerID;
    private LocalDateTime orderDate;
    private String customerName;
    private String phone;
    private String addressOrder;
    private int orderStatusId;
    private float total;
    private ArrayList<OrderItem> orderItems;
    private boolean isActive;
    private OrderStatus orderS;

    public Order() {
    }

    public Order(int id, int customerID, LocalDateTime orderDate, String customerName, String phone, String addressOrder, int orderStatus, float total, ArrayList<OrderItem> orderItems, boolean isActive) {
        this.id = id;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.phone = phone;
        this.addressOrder = addressOrder;
        this.orderStatusId = orderStatus;
        this.total = total;
        this.orderItems = orderItems;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressOrder() {
        return addressOrder;
    }

    public void setAddressOrder(String addressOrder) {
        this.addressOrder = addressOrder;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    public void addOrderItem(OrderItem orderItem){
        this.orderItems.add(orderItem);
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public OrderStatus getOrderS() {
        return orderS;
    }

    public void setOrderS(OrderStatus orderS) {
        this.orderS = orderS;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerID=" + customerID + ", orderDate=" + orderDate + ", customerName=" + customerName + ", phone=" + phone + ", addressOrder=" + addressOrder + ", orderStatusId=" + orderStatusId + ", total=" + total + ", orderItems=" + orderItems + ", isActive=" + isActive + ", orderS=" + orderS + '}';
    }
    
    
}
