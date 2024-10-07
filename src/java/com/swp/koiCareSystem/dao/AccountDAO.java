package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    // Method to check login
    public Account checkLogin(String email, String password) {
        Account acc = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String sql = "SELECT FullName, UserRole FROM Account WHERE Email = ? AND Password = ?";

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, email);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs != null) {
                    if (rs.next()) {
                        String fullName = rs.getString("FullName");
                        String userImage = rs.getString("UserImage");
                        String phoneNumber = rs.getString("PhoneNumber");
                        String userRole = rs.getString("UserRole");
                        String address = rs.getString("Address");
                        String gender = rs.getString("Gender");
                        int idStatus = rs.getInt("idStatus");

                        acc = new Account(idStatus, email, userImage, password, fullName, phoneNumber, userRole, address, gender, idStatus);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ptm != null) {
                    ptm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return acc;
    }

    // Method to get list of accounts
    public List<Account> getListAccount(String search) {
        List<Account> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Account WHERE Email LIKE ?";

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int accID = rs.getInt("AccID");
                    String email = rs.getString("Email");
                    String userImage = rs.getString("UserImage");
                    String password = rs.getString("Password");
                    String fullName = rs.getString("FullName");
                    String phoneNumber = rs.getString("PhoneNumber");
                    String userRole = rs.getString("UserRole");
                    String address = rs.getString("Address");
                    String gender = rs.getString("Gender");
                    int idStatus = rs.getInt("idStatus");

                    // Add each account to the list
                    list.add(new Account(accID, email, userImage, password, fullName, phoneNumber, userRole, address, gender, idStatus));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ptm != null) {
                    ptm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
