/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.dao.OrderDAO;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.Order;
import com.swp.koiCareSystem.model.OrderItem;
import com.swp.koiCareSystem.model.OrderStatus;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class OrderService {

    private OrderDAO od;

    public OrderService() {
        this.od = new OrderDAO();
    }

    public boolean saveOrder(int userID, ArrayList<OrderItem> items, String cusName, String phone, String address) {
        float total = 0;
        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }
        LocalDateTime now = LocalDateTime.now();
        int status = 1;
        Order order = new Order();
        order.setCustomerID(userID);
        order.setCustomerName(cusName);
        order.setPhone(phone);
        order.setAddressOrder(address);
        order.setTotal(total);
        order.setOrderDate(now);
        order.setOrderStatusId(status);
        boolean suc = od.checkout(order, items);
        return suc;
    }

//    public static void main(String[] args) {
//        OrderService ods = new OrderService();
//        int userId = 5;
//        ArrayList<OrderItem> items = new ArrayList<>();
//        boolean is = ods.saveOrder(1, items, "kahnh", "01234567890", "Thu duc");
//        System.out.println(is);
//    }
    public int countOrders() {
        return od.countOrders();
    }

    public ArrayList<Order> getAllOrders(int index) {
        return od.getAllOrders(index);
    }

    public int countOrderItems(int orderId) {
        return od.countOrderItemsByOrderId(orderId);
    }

    public ArrayList<OrderItem> getOrderItemsByOrderId(int orderId, int index) {
        return od.getOrderItemsByOrderId(orderId, index);
    }

    public Order getOrderById(int orderId) {
        return od.getOrderById(orderId);
    }

    public boolean deleteOrder(int orderId) {
        return od.deleteOrder(orderId);
    }

    public String updateOrderStatusByOrderId(int orderId, int newStatusId) {
        int currentStatus = od.getOrderStatusByOrderId(orderId);

        if ((currentStatus == 1 && newStatusId == 2) || (currentStatus == 2 && newStatusId == 3)) {
            return od.updateOrderStatusByOrderId(orderId, newStatusId)
                    ? "Order status updated to " + (newStatusId == 2 ? "Processing." : "Done.")
                    : "Failed to update order status.";
        }

        if (currentStatus == 3) {
            return "Order is already completed and cannot be changed.";
        }

        return "Invalid status transition from " + (currentStatus == 1 ? "Pending" : "Processing")
                + " to " + (newStatusId == 2 ? "Processing" : "Done") + ".";
    }

    public ArrayList<OrderStatus> getAllOrderStatuses() {
        return od.getAllOrderStatuses();
    }

    public int countOrdersByCustomerNames(String userName) {
        return od.countOrdersByCustomerNames(userName);
    }

    public ArrayList<Order> searchOrdersByCustomerNames(String userName, int index) {
        return od.searchOrdersByCustomerNames(userName, index);
    }

    public int countOrdersByStatus(int statusID) {
        return od.countOrdersByStatus(statusID);
    }

    public ArrayList<Order> searchOrdersByStatus(int statusID, int index) {
        return od.searchOrdersByStatus(statusID, index);
    }

    public int countOrdersByAddress(String address) {
        return od.countOrdersByAddress(address);

    }

    public ArrayList<Order> searchOrdersByAddress(String address, int index) {
        return od.searchOrdersByAddress(address, index);
    }

    public int countOrdersByPhone(String phone) {
        return od.countOrdersByPhone(phone);
    }

    public ArrayList<Order> searchOrdersByPhone(String phone, int index) {
        return od.searchOrdersByPhone(phone, index);
    }
    public ArrayList<Order> getPurchaseHistoryByAccID(int accId){
        return  od.getPurchaseHistoryByAccId(accId);
    }
    public float countTotalAmountOrder() {
        return od.countTotalAmountOrder();
    }

    public int countTotalCustomersOrder() {
        return od.countTotalCustomersOrder();
    }

    public OrderItem getMostOrderedProductWithDetails() {
        return od.getMostOrderedProductWithDetails();
    }

    public int countOrdersForProduct(int productId) {
        return od.countOrdersForProduct(productId);
    }

    public Account getTopSpender() {
        return od.getTopSpender();
    }

    public ArrayList<Order> getAmountPast5Month() {
        return od.getAmountPast5Month();
    }

    public ArrayList<Order> getAmountPast7Days() {
        return od.getAmountPast7Days();
    }    
    
}
