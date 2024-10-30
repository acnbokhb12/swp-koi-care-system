/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.OrderDAO;
import com.swp.koiCareSystem.model.Order;
import com.swp.koiCareSystem.model.OrderItem;
import com.swp.koiCareSystem.model.OrderStatus;
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
        order.setOrderStatus(status);
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

        switch (currentStatus) {
            case 1:
                if (newStatusId == 2) {
                    if (od.updateOrderStatusByOrderId(orderId, newStatusId)) {
                        return "Order status updated to Proccessing.";
                    } else {
                        return "Failed to update order status.";
                    }
                } else {
                    return "Invalid status transition from Pending to Proccessing";
                }

            case 2:
                if (newStatusId == 3) {
                    if (od.updateOrderStatusByOrderId(orderId, newStatusId)) {
                        return "Order status updated to Done.";
                    } else {
                        return "Failed to update order status.";
                    }
                } else {
                    return "Invalid status transition from Proccessing to Done";
                }

            case 3:
                return "Order is already completed and cannot be changed.";

            default:
                return "Invalid order status.";
        }
    }

    public ArrayList<String> getListCustomerNames() {
        return od.getListCustomerNames();
    }

    public ArrayList<OrderStatus> getAllOrderStatuses() {
        return od.getAllOrderStatuses();
    }

    public int countOrdersByCustomerNames(String userName) {
        return od.countOrdersByCustomerNames(userName);
    }

    public ArrayList<Order> searchOrdersByCustomerNames(String userName, int index) {
        return od.searchOrdersByCustomerName(userName, index);
    }
}
