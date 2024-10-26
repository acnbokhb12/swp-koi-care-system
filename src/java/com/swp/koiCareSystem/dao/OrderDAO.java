/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Order;
import com.swp.koiCareSystem.model.OrderItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class OrderDAO {

    public boolean checkout(Order od, ArrayList<OrderItem> items) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int rowEffectV2 =0;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                LocalDateTime now = od.getOrderDate();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedNow = now.format(formatter);
                String sql = "insert into  [dbo].[Orders] ([AccID],[UserNameOrdered],[PhoneOrdered],[AddressOrdered],[TotalAmount],[OrderDate],[OrderStatusID]) \n"
                        + "values (?, ?,?,?,?,?,? )";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, od.getCustomerID());
                pst.setString(2, od.getCustomerName());
                pst.setString(3, od.getPhone());
                pst.setString(4, od.getAddressOrder());
                pst.setFloat(5, od.getTotal());
                pst.setString(6, formattedNow);
                pst.setInt(7, od.getOrderStatus());
                int rowEffect = pst.executeUpdate();
                String sql3 = "select top 1 [OrderID] from  [dbo].[Orders] order by [OrderID] desc";
                PreparedStatement pst3 = cn.prepareStatement(sql3);
                rs = pst3.executeQuery();
                if (rs != null && rs.next()) {
                    int orderId = rs.getInt("OrderId");
                    for (OrderItem odi : items) {
                        String sql2 = "insert into [dbo].[OrderItem] ([OrderID],[ProductID],[Quantity],[UnitPrice],[TotalPrice])\n"
                                + "values(?,?,?,?,?)";
                        PreparedStatement pst2 = cn.prepareStatement(sql2);
                        pst2.setInt(1, orderId);
                        pst2.setInt(2, odi.getProduct().getProductID());
                        pst2.setInt(3, odi.getQuantity());
                        pst2.setFloat(4, odi.getUnitPrice());
                        pst2.setFloat(5, odi.getTotalPrice());
                        rowEffectV2 = pst2.executeUpdate();
                    }
                }
                cn.setAutoCommit(true);
                cn.commit();
                if(rowEffectV2 >0 ){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
