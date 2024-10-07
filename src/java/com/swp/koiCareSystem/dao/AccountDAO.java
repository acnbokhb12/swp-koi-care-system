/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class AccountDAO {

    public Account checkLogin(String userID, int password) throws SQLException {
        Account acc = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT FullName, UserRole FROM Account WHERE Email = ? AND Password = ?";
        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setInt(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    int role = rs.getInt("role");
                    acc = new Account(role, sql, userID, userID, fullName, fullName, userID, userID, sql, password);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return acc;
    }

    public ArrayList<Account> getListAccount(String search) throws SQLException {
        ArrayList<Account> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM FullName = ? ";

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString(1);
                    String fullName = rs.getString(2);
                    int role = rs.getInt(3);
                    int password = rs.getInt(4);
                    list.add(new Account(role, sql, userID, userID, fullName, fullName, userID, userID, search, password));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

}
