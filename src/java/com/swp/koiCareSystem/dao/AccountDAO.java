package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDAO {

    public boolean isEmailExist(String email) throws SQLException, ClassNotFoundException {
        String query = "SELECT Email FROM Accounts WHERE Email = ?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    public boolean isPhoneNumberExist(String phoneNumber) throws SQLException {
        String query = "SELECT PhoneNumber FROM Accounts WHERE PhoneNumber = ?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, phoneNumber);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean registerUser(Account account) throws SQLException, Exception {
        String sql = "INSERT INTO Accounts (Email, UserImage, Password, FullName, PhoneNumber, UserRole, Gender, idStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, account.getEmail());
            pstmt.setString(2, account.getProfileImage());
            pstmt.setString(3, account.getPassword());
            pstmt.setString(4, account.getFullName());
            pstmt.setString(5, account.getPhoneNumber());
            pstmt.setString(6, account.getUserRole());
            pstmt.setString(7, account.getGender());
            pstmt.setInt(8, account.getAccountStatus());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public Account checkLogin(String email, String hashedPassword) throws SQLException, ClassNotFoundException {
        String sql = "SELECT AccID, Email, UserImage, Password, FullName, PhoneNumber, UserRole, Address, Gender, idStatus FROM Accounts WHERE Email = ? AND Password = ?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, hashedPassword);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Account account = new Account(
                        rs.getInt("AccID"),
                        rs.getString("Email"),
                        rs.getString("UserImage"),
                        rs.getString("Password"),
                        rs.getString("FullName"),
                        rs.getString("PhoneNumber"),
                        rs.getString("UserRole"),
                        rs.getString("Address"),
                        rs.getString("Gender"),
                        rs.getInt("idStatus")
                );
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getUserById(int userId) throws SQLException, ClassNotFoundException {
        Account account = null;
        Connection conn = DatabaseConnectionManager.getConnection();
        String sql = "SELECT FullName, Email, PhoneNumber, Address, Gender, Password FROM Accounts WHERE AccID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            account = new Account();
            account.setFullName(rs.getString("FullName"));
            account.setEmail(rs.getString("Email"));
            account.setPhoneNumber(rs.getString("PhoneNumber"));
            account.setAddress(rs.getString("Address"));
            account.setGender(rs.getString("Gender"));
            account.setPassword(rs.getString("Password"));
        }
        return account;
    }

    public static boolean updateAccount(Account account) throws ClassNotFoundException {
        boolean isUpdated = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DatabaseConnectionManager.getConnection();
            String sql = "UPDATE Accounts SET FullName = ?, Email = ?, PhoneNumber = ?, Address = ?, Password = ?, Gender = ? WHERE AccID = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, account.getFullName());
            stmt.setString(2, account.getEmail());
            stmt.setString(3, account.getPhoneNumber());
            stmt.setString(4, account.getAddress());
            stmt.setString(5, account.getPassword());
            stmt.setString(6, account.getGender());
            stmt.setInt(7, account.getUserID());

            isUpdated = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

}
