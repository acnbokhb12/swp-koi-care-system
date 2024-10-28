/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.OrderDAO;
import com.swp.koiCareSystem.model.Order;
import com.swp.koiCareSystem.model.OrderItem;
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

    public static void main(String[] args) {
        // Tạo một đối tượng OrderService (giả sử nó đã được khởi tạo đúng cách)
        OrderService orderService = new OrderService();

        // Chỉ định chỉ số trang mà bạn muốn lấy (ví dụ: trang 1)
        int index = 1;

        // Gọi phương thức getAllOrders và lấy danh sách đơn hàng
        ArrayList<Order> orders = orderService.getAllOrders(index);

        // In danh sách đơn hàng
        if (orders.isEmpty()) {
            System.out.println("Không có đơn hàng nào.");
        } else {
            System.out.println("Danh sách đơn hàng:");
            for (Order order : orders) {
                System.out.println("Order ID: " + order.getId());
                System.out.println("Khách hàng: " + order.getCustomerName());
                System.out.println("Ngày đặt hàng: " + order.getOrderDate());
                System.out.println("Tổng tiền: " + order.getTotal());
                System.out.println("Trạng thái: " + (order.getOrderS() != null ? order.getOrderS().getOrderStatusName() : "Chưa xác định"));
                System.out.println("-----------------------------");
            }
        }
    }
}
