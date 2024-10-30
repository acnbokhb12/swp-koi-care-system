/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Order;
import com.swp.koiCareSystem.model.OrderItem;
import com.swp.koiCareSystem.model.OrderStatus;
import com.swp.koiCareSystem.model.Product;
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
        int rowEffectV2 = 0;
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
                if (rowEffectV2 > 0) {
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

    public int countOrders() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) FROM Orders WHERE isActive = 1";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    return rs.getInt(1);
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
        return 0;
    }

    public ArrayList<Order> getAllOrders(int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Order> listOrders = new ArrayList<>();
        int distance = (index - 1) * 10;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT o.OrderID, o.AccID, o.OrderStatusID, o.OrderDate, "
                        + "o.UserNameOrdered, o.PhoneOrdered, o.AddressOrdered, "
                        + "o.TotalAmount, o.isActive, os.OrderStatusName "
                        + "FROM Orders o "
                        + "JOIN OrderStatus os ON o.OrderStatusID = os.OrderStatusID "
                        + "WHERE o.isActive = 1 "
                        + "ORDER BY o.OrderID DESC "
                        + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, distance);
                rs = pst.executeQuery();

                while (rs != null && rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("OrderID"));
                    order.setCustomerID(rs.getInt("AccID"));
                    order.setOrderDate(rs.getTimestamp("OrderDate").toLocalDateTime());
                    order.setCustomerName(rs.getString("UserNameOrdered"));
                    order.setPhone(rs.getString("PhoneOrdered"));
                    order.setAddressOrder(rs.getString("AddressOrdered"));

                    OrderStatus orderS = new OrderStatus();
                    orderS.setOrderStatusID(rs.getInt("OrderStatusID"));
                    orderS.setOrderStatusName(rs.getString("OrderStatusName"));
                    order.setOrderS(orderS);

                    order.setTotal(rs.getFloat("TotalAmount"));
                    order.setIsActive(rs.getBoolean("isActive"));

                    listOrders.add(order);
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
        return listOrders;
    }

    public Order getOrderById(int orderId) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Order order = null;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT o.[OrderID], o.[AccID], o.[OrderDate], o.[UserNameOrdered], o.[PhoneOrdered], "
                        + "o.[AddressOrdered], o.[TotalAmount], os.[OrderStatusID], os.[OrderStatusName] "
                        + "FROM [Koi_Care_System_At_Home].[dbo].[Orders] o "
                        + "JOIN [Koi_Care_System_At_Home].[dbo].[OrderStatus] os ON o.[OrderStatusID] = os.[OrderStatusID] "
                        + "WHERE o.[OrderID] = ?";

                pst = cn.prepareStatement(sql);
                pst.setInt(1, orderId);
                rs = pst.executeQuery();

                if (rs.next()) {
                    order = new Order();
                    order.setId(rs.getInt("OrderID"));
                    order.setCustomerID(rs.getInt("AccID"));
                    order.setOrderDate(rs.getTimestamp("OrderDate").toLocalDateTime());
                    order.setCustomerName(rs.getString("UserNameOrdered"));
                    order.setPhone(rs.getString("PhoneOrdered"));
                    order.setAddressOrder(rs.getString("AddressOrdered"));
                    order.setTotal(rs.getFloat("TotalAmount"));

                    OrderStatus orderS = new OrderStatus();
                    orderS.setOrderStatusID(rs.getInt("OrderStatusID"));
                    orderS.setOrderStatusName(rs.getString("OrderStatusName"));

                    order.setOrderS(orderS);
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
        return order;
    }

    public int countOrderItemsByOrderId(int orderId) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) FROM [Koi_Care_System_At_Home].[dbo].[OrderItem] WHERE [OrderID] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, orderId);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    return rs.getInt(1);
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
        return 0;
    }

    public ArrayList<OrderItem> getOrderItemsByOrderId(int orderId, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<OrderItem> listOrderItems = new ArrayList<>();
        int offset = (index - 1) * 5;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT [OrderItemID], [OrderID], [ProductID], [Quantity], [UnitPrice], [TotalPrice] "
                        + "FROM [Koi_Care_System_At_Home].[dbo].[OrderItem] "
                        + "WHERE [OrderID] = ? "
                        + "ORDER BY [OrderItemID] DESC "
                        + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY;";

                pst = cn.prepareStatement(sql);
                pst.setInt(1, orderId);
                pst.setInt(2, offset);

                rs = pst.executeQuery();
                ProductDAO productDAO = new ProductDAO();

                while (rs.next()) {
                    OrderItem item = new OrderItem();
                    item.setId(rs.getInt("OrderItemID"));
                    item.setOrderID(rs.getInt("OrderID"));
                    item.setProduct(productDAO.getProductForOrderItemById(rs.getInt("ProductID")));
                    item.setQuantity(rs.getInt("Quantity"));
                    item.setUnitPrice(rs.getFloat("UnitPrice"));
                    item.setTotalPrice(rs.getFloat("TotalPrice"));
                    listOrderItems.add(item);
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
        return listOrderItems;
    }

    public boolean deleteOrder(int orderId) {
        Connection cn = null;
        PreparedStatement pst = null;
        boolean isDeleted = false;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "UPDATE Orders SET isActive = 0 WHERE OrderID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, orderId);
                int rowsAffected = pst.executeUpdate();
                isDeleted = (rowsAffected > 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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
        return isDeleted;
    }

    public int getOrderStatusByOrderId(int orderId) {
        int orderStatusId = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = DatabaseConnectionManager.getConnection();

            if (cn != null) {
                String sql = "SELECT OrderStatusID FROM Orders WHERE OrderID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, orderId);

                rs = pst.executeQuery();

                if (rs.next()) {
                    orderStatusId = rs.getInt("OrderStatusID");
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

        return orderStatusId;
    }

    public boolean updateOrderStatusByOrderId(int orderId, int newStatusId) {
        Connection cn = null;
        PreparedStatement pst = null;
        boolean isUpdated = false;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "UPDATE Orders SET OrderStatusID = ? WHERE OrderID = ?";
                pst = cn.prepareStatement(sql);

                pst.setInt(1, newStatusId);
                pst.setInt(2, orderId);

                int rowsAffected = pst.executeUpdate();
                isUpdated = (rowsAffected > 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isUpdated;
    }

    public ArrayList<Order> searchOrdersByCustomerName(String customerName, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Order> ordersList = new ArrayList<>();
        int distance = (index - 1) * 10;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT * FROM Orders o "
                        + "WHERE o.customerName LIKE ? AND o.isActive = 1 "
                        + "ORDER BY o.id DESC "
                        + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";

                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + customerName + "%");
                pst.setInt(2, distance);
                rs = pst.executeQuery();

                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setCustomerID(rs.getInt("customerID"));
                    order.setOrderDate(rs.getObject("orderDate", LocalDateTime.class));
                    order.setCustomerName(rs.getString("customerName"));
                    order.setPhone(rs.getString("phone"));
                    order.setAddressOrder(rs.getString("addressOrder"));
                    order.setOrderStatus(rs.getInt("orderStatus"));
                    order.setTotal(rs.getFloat("total"));
                    order.setIsActive(rs.getBoolean("isActive"));

                    ordersList.add(order);
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
        return ordersList;
    }

    public ArrayList<String> getListCustomerNames() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<String> listName = new ArrayList<>();
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT DISTINCT UserNameOrdered FROM Orders WHERE isActive = 1";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    listName.add(rs.getString("UserNameOrdered"));
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
        return listName;
    }

    public ArrayList<OrderStatus> getAllOrderStatuses() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<OrderStatus> listStatus = new ArrayList<>();
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT * FROM OrderStatus";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    OrderStatus status = new OrderStatus();
                    status.setOrderStatusID(rs.getInt("orderStatusID"));
                    status.setOrderStatusName(rs.getString("orderStatusName"));
                    listStatus.add(status);
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
        return listStatus;
    }

    public int countOrdersByCustomerNames(String userName) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) FROM Orders WHERE [UserNameOrdered] = ? AND [isActive] = 1";
                pst = cn.prepareStatement(sql);
                pst.setString(1, userName);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    return rs.getInt(1);
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
        return 0;
    }

    public ArrayList<Order> searchOrdersByCustomerNames(String userName, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Order> listO = new ArrayList<>();
        int distance = (index - 1) * 10;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT * FROM Orders WHERE [UserNameOrdered] = ? AND [isActive] = 1 "
                        + "ORDER BY OrderID "
                        + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
                pst = cn.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setInt(2, distance);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Order order = new Order();
                        order.setId(rs.getInt("OrderID"));
                        order.setCustomerID(rs.getInt("AccID"));
                        order.setOrderDate(rs.getTimestamp("OrderDate").toLocalDateTime());
                        order.setCustomerName(rs.getString("UserNameOrdered"));
                        order.setPhone(rs.getString("PhoneOrdered"));
                        order.setAddressOrder(rs.getString("AddressOrdered"));
                        order.setTotal(rs.getFloat("TotalAmount"));
                        order.setIsActive(rs.getBoolean("isActive"));

                        listO.add(order);
                    }
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
        return listO;
    }
}
