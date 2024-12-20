/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.Order;
import com.swp.koiCareSystem.model.OrderItem;
import com.swp.koiCareSystem.model.OrderStatus;
import com.swp.koiCareSystem.model.Product;
import com.swp.koiCareSystem.service.OrderService;
import com.swp.koiCareSystem.service.ProductService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
                pst.setInt(7, od.getOrderStatusId());
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
                        + "WHERE o.[OrderID] = ? AND o.isActive = 1";

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
                    item.setProductID(rs.getInt("ProductID"));
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

    public ArrayList<OrderStatus> getAllOrderStatuses() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<OrderStatus> listStatus = new ArrayList<>();
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT DISTINCT os.orderStatusID, os.orderStatusName "
                        + "FROM OrderStatus os";
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
                String sql = "SELECT COUNT(*) FROM Orders WHERE [UserNameOrdered] LIKE ? AND [isActive] = 1";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + userName + "%");
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
                String sql = "SELECT o.[OrderID], o.[AccID], o.[OrderStatusID], o.[OrderDate], "
                        + "o.[UserNameOrdered], o.[PhoneOrdered], o.[AddressOrdered], "
                        + "o.[TotalAmount], os.[OrderStatusName] "
                        + "FROM [Koi_Care_System_At_Home].[dbo].[Orders] o "
                        + "JOIN [Koi_Care_System_At_Home].[dbo].[OrderStatus] os ON o.[OrderStatusID] = os.[OrderStatusID] "
                        + "WHERE o.[UserNameOrdered] LIKE ? AND o.[isActive] = 1 "
                        + "ORDER BY o.[OrderDate] DESC "
                        + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";

                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + userName + "%");
                pst.setInt(2, distance);
                rs = pst.executeQuery();

                while (rs.next()) {
                    Order order = new Order();
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

                    listO.add(order);
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

    public int countOrdersByStatus(int statusID) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) FROM Orders WHERE [OrderStatusID] = ? AND [isActive] = 1";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, statusID);
                rs = pst.executeQuery();

                if (rs.next()) {
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

    public ArrayList<Order> searchOrdersByStatus(int statusID, int index) {
        ArrayList<Order> listO = new ArrayList<>();
        int offset = (index - 1) * 10;

        String sql = "SELECT o.[OrderID], o.[AccID], o.[OrderStatusID], o.[OrderDate], "
                + "o.[UserNameOrdered], o.[PhoneOrdered], o.[AddressOrdered], "
                + "o.[TotalAmount], os.[OrderStatusName] "
                + "FROM [Koi_Care_System_At_Home].[dbo].[Orders] o "
                + "JOIN [Koi_Care_System_At_Home].[dbo].[OrderStatus] os ON o.[OrderStatusID] = os.[OrderStatusID] "
                + "WHERE o.[OrderStatusID] = ? AND o.[isActive] = 1 "
                + "ORDER BY o.[OrderDate] DESC "
                + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";

        try (Connection cn = DatabaseConnectionManager.getConnection();
                PreparedStatement pst = cn.prepareStatement(sql)) {

            pst.setInt(1, statusID);
            pst.setInt(2, offset);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Order order = new Order();
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

                    listO.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listO;
    }

    public int countOrdersByAddress(String address) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) FROM Orders WHERE [AddressOrdered] LIKE ? AND [isActive] = 1";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + address + "%");
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

    public ArrayList<Order> searchOrdersByAddress(String address, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Order> listO = new ArrayList<>();
        int distance = (index - 1) * 10;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT o.[OrderID], o.[AccID], o.[OrderStatusID], o.[OrderDate], "
                        + "o.[UserNameOrdered], o.[PhoneOrdered], o.[AddressOrdered], "
                        + "o.[TotalAmount], os.[OrderStatusName] "
                        + "FROM [Koi_Care_System_At_Home].[dbo].[Orders] o "
                        + "JOIN [Koi_Care_System_At_Home].[dbo].[OrderStatus] os ON o.[OrderStatusID] = os.[OrderStatusID] "
                        + "WHERE o.[AddressOrdered] LIKE ? AND o.[isActive] = 1 "
                        + "ORDER BY o.[OrderDate] DESC "
                        + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";

                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + address + "%");
                pst.setInt(2, distance);
                rs = pst.executeQuery();

                while (rs.next()) {
                    Order order = new Order();
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

                    listO.add(order);
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

    public int countOrdersByPhone(String phone) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) FROM Orders WHERE [PhoneOrdered] LIKE ? AND [isActive] = 1";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + phone + "%"); // Partial match on phone
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

    public ArrayList<Order> searchOrdersByPhone(String phone, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Order> listO = new ArrayList<>();
        int distance = (index - 1) * 10;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT o.[OrderID], o.[AccID], o.[OrderStatusID], o.[OrderDate], "
                        + "o.[UserNameOrdered], o.[PhoneOrdered], o.[AddressOrdered], "
                        + "o.[TotalAmount], os.[OrderStatusName] "
                        + "FROM [Koi_Care_System_At_Home].[dbo].[Orders] o "
                        + "JOIN [Koi_Care_System_At_Home].[dbo].[OrderStatus] os ON o.[OrderStatusID] = os.[OrderStatusID] "
                        + "WHERE o.[PhoneOrdered] LIKE ? AND o.[isActive] = 1 "
                        + "ORDER BY o.[OrderDate] DESC "
                        + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";

                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + phone + "%");
                pst.setInt(2, distance);
                rs = pst.executeQuery();

                while (rs.next()) {
                    Order order = new Order();
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

                    listO.add(order);
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

    public ArrayList<Order> getPurchaseHistoryByAccId(int accId) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Order> listPurchaseHistory = new ArrayList<>();
        ProductService prds = new ProductService();
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select [OrderID],[AccID],[UserNameOrdered],[PhoneOrdered],[AddressOrdered],[OrderDate],[TotalAmount] ,[isActive] , ord.OrderStatusID, ords.OrderStatusName\n"
                        + "from [dbo].[Orders] as ord inner join [dbo].[OrderStatus] as ords on ord.OrderStatusID = ords.OrderStatusID\n"
                        + "where [AccID] = ? order by [OrderID] desc ";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, accId);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Order ord = new Order();
                        int orderId = rs.getInt("OrderID");
                        ord.setId(orderId);
                        ord.setCustomerID(rs.getInt("AccID"));
                        ord.setCustomerName("UserNameOrdered");
                        ord.setPhone(rs.getString("PhoneOrdered"));
                        ord.setAddressOrder("AddressOrdered");
                        Timestamp timestamp = rs.getTimestamp("OrderDate");
                        LocalDateTime dateTime = timestamp.toLocalDateTime();
                        ord.setOrderDate(dateTime);
                        ord.setTotal(rs.getFloat("TotalAmount")); 
                        ord.setOrderStatusId(rs.getInt("OrderStatusID"));
//                        Status Order
                        OrderStatus ordeStatus = new OrderStatus();
                        ordeStatus.setOrderStatusID(rs.getInt("OrderStatusID"));
                        ordeStatus.setOrderStatusName(rs.getString("OrderStatusName"));
                        ord.setOrderS(ordeStatus);
                        String sql2 = "select* from [dbo].[OrderItem] where [OrderID] = ?";
                        PreparedStatement pst2 = cn.prepareStatement(sql2);
                        pst2.setInt(1, orderId);
                        ResultSet rs2 = pst2.executeQuery();
                        ArrayList<OrderItem> listOrderItem = new ArrayList<>();
                        if(rs2!=null){                            
                            while(rs2.next()){
                                OrderItem item = new OrderItem();
                                item.setId(rs2.getInt(1));
                                item.setOrderID(orderId);
                                Product product = prds.getProductByIdWithoutIsActive(rs2.getInt(3));
                                item.setProductID(product.getProductID());
                                item.setProduct(product);
                                item.setQuantity(rs2.getInt(4));
                                item.setUnitPrice(rs2.getFloat(5));
                                item.setTotalPrice(rs2.getFloat(6));
                                listOrderItem.add(item); 
                            }
                        }
                        ord.setOrderItems(listOrderItem); 
                        listPurchaseHistory.add(ord); 
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
        return listPurchaseHistory;
    }
    public float countTotalAmountOrder() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        float totalAmount = 0;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT SUM(TotalAmount) FROM Orders WHERE OrderStatusID = 3 AND isActive = 1";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    totalAmount = rs.getFloat(1);
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
        return totalAmount;
    }
    public int countTotalCustomersOrder() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int totalCustomers = 0;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(DISTINCT AccID) FROM Orders WHERE OrderStatusID = 3 AND isActive = 1";
                pst = cn.prepareStatement(sql);

                rs = pst.executeQuery();

                if (rs != null && rs.next()) {
                    totalCustomers = rs.getInt(1);
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
        return totalCustomers;
    }
    public OrderItem getMostOrderedProductWithDetails() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        OrderItem mostOrderedItem = null;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT TOP 1 ProductID, COUNT(OrderID) AS OrderCount "
                        + "FROM OrderItem "
                        + "GROUP BY ProductID "
                        + "ORDER BY OrderCount DESC;";

                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();

                if (rs.next()) {
                    int mostOrderedProductID = rs.getInt("ProductID");

                    ProductDAO pd = new ProductDAO();
         Product mostOrderedProduct = pd.getProductById(mostOrderedProductID);

                    mostOrderedItem = new OrderItem();
                    mostOrderedItem.setProduct(mostOrderedProduct);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các tài nguyên
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
        return mostOrderedItem;
    }
    
    public int countOrdersForProduct(int productId) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int orderCount = 0;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(OrderID) AS OrderCount "
                        + "FROM OrderItem "
                        + "WHERE ProductID = ?";

                pst = cn.prepareStatement(sql);
                pst.setInt(1, productId);
                rs = pst.executeQuery();

                if (rs.next()) {
                    orderCount = rs.getInt("OrderCount");
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
        return orderCount;
    }
    public Account getTopSpender() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int AccID = 0;
        Account topSpender = null;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT TOP 1 AccID "
                        + "FROM Orders "
                        + "WHERE OrderStatusID = 3 AND isActive = 1 "
                        + "GROUP BY AccID "
                        + "ORDER BY SUM(TotalAmount) DESC";

                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();

                if (rs != null && rs.next()) {
                    AccID = rs.getInt("AccID");
                    AccountDAO ad = new AccountDAO();
                    topSpender = ad.getAccountInformationByID(AccID);
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
        return topSpender;
    }
public ArrayList<Order> getAmountPast5Month() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Order> listOrder = new ArrayList<>();

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT OrderDate, TotalAmount "
                        + "FROM [dbo].[Orders] "
                        + "WHERE OrderDate >= DATEADD(MONTH, -5, GETDATE()) "
                        + "AND isActive = 1 "
                        + "ORDER BY OrderDate ASC";

                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {
                    LocalDateTime orderDate = rs.getTimestamp("OrderDate").toLocalDateTime();
                    float totalAmount = rs.getFloat("TotalAmount");

                    Order order = new Order();
                    order.setOrderDate(orderDate);
                    order.setTotal(totalAmount);

                    listOrder.add(order);
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
        return listOrder;
    }

public ArrayList<Order> getAmountPast7Days() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Order> listOrder = new ArrayList<>();

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT OrderDate, TotalAmount "
                        + "FROM [dbo].[Orders] "
                        + "WHERE OrderDate >= DATEADD(DAY, -7, GETDATE()) " 
                        + "AND isActive = 1 "
                        + "ORDER BY OrderDate ASC";

                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {
                    LocalDateTime orderDate = rs.getTimestamp("OrderDate").toLocalDateTime();
                    float totalAmount = rs.getFloat("TotalAmount");

                    Order order = new Order();
                    order.setOrderDate(orderDate);
                    order.setTotal(totalAmount);
         listOrder.add(order);
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
        return listOrder;
    }      

                    
                    
    public static void main(String[] args) {
        OrderDAO ordao = new OrderDAO();
        ArrayList<Order> list = ordao.getPurchaseHistoryByAccId(5);
        for(Order o : list){
            System.out.println(o);
        }
    }
}
