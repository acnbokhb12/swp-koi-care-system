/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.service.AccountService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class AccountDAO {

    private static final Logger logger = Logger.getLogger(AccountDAO.class.getName());
    private final AccountService acs = new AccountService();

    public boolean isEmailExist(String email) throws SQLException, ClassNotFoundException {
        String query = "SELECT Email FROM Account WHERE Email = ?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    public boolean isPhoneNumberExist(String phoneNumber) throws SQLException {
        String query = "SELECT PhoneNumber FROM Account WHERE PhoneNumber = ?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, phoneNumber);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Error checking phone number existence", ex);
        }
        return false;
    }

    public boolean registerUser(Account account) throws SQLException, Exception {
        String sql = "INSERT INTO Account (Email, Password, FullName, PhoneNumber, UserRole, Gender, idStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, account.getEmail());
            // Sử dụng phương thức hashPassword cho việc băm mật khẩu
            pstmt.setString(2, account.getPassword());
            pstmt.setString(3, account.getFullName());
            pstmt.setString(4, account.getPhoneNumber());
            pstmt.setString(5, account.getUserRole());
            pstmt.setString(6, account.getGender());
            pstmt.setInt(7, account.getAccountStatus());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error registering user: " + e.getMessage(), e);
            throw e;
        }
    }

    public Account checkLogin(String email, String password) {
        String sql = "SELECT * FROM Account WHERE Email = ?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String encryptedPasswordFromDB = rs.getString("Password");
                String hashedInputPassword = AccountService.hashPassword(password);

                if (encryptedPasswordFromDB.equals(hashedInputPassword)) {
                    Account account = new Account();
                    account.setEmail(email);
                    account.setPassword(encryptedPasswordFromDB); // Lưu trữ mật khẩu đã băm
                    account.setUserRole(rs.getString("UserRole"));
                    return account;
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during login check", e);
        }
        return null;
    }
}
