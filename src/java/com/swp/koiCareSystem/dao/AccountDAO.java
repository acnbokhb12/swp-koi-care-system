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

    public boolean isKoiCareIDExist(String kcid) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT count(*) FROM Accounts WHERE [KoiCareID]  = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, kcid);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
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

    public boolean checkEmail(String email) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT count(*) FROM Accounts WHERE  [Email]  = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    return rs.getInt(1) > 0;
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

    public boolean registerUser(Account account) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO Accounts (KoiCareID, UserImage, Password, FullName, UserRole, idStatus) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, account.getKoiCareID());
                pstmt.setString(2, account.getProfileImage());
                pstmt.setString(3, account.getPassword());
                pstmt.setString(4, account.getFullName());
                pstmt.setString(5, account.getUserRole());
                pstmt.setInt(6, account.getAccountStatus());

                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
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

    public Account checkLogin(String email, String hashedPassword) throws SQLException, ClassNotFoundException {
        String sql = "select [AccID] ,[Email] ,[KoiCareID], UserImage, FullName, PhoneNumber, UserRole, Address, Gender, idStatus\n"
                + "from Accounts\n"
                + "where ([Email] = ? or [KoiCareID] = ?) and [Password] = ?";
        Account acc = null;
        try (Connection conn = DatabaseConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, email);
            pstmt.setString(3, hashedPassword);
            ResultSet rs = pstmt.executeQuery();

            if (rs!= null && rs.next()) {
                acc = new Account();
                acc.setUserID(rs.getInt("AccID"));
                acc.setEmail(rs.getString("Email"));
                acc.setKoiCareID(rs.getString("KoiCareID"));
                acc.setProfileImage(rs.getString("UserImage"));
                acc.setFullName(rs.getString("FullName"));
                acc.setPhoneNumber(rs.getString("PhoneNumber"));
                acc.setUserRole(rs.getString("UserRole"));
                acc.setAddress(rs.getString("Address"));
                acc.setGender(rs.getString("Gender"));
                acc.setAccountStatus(rs.getInt("idStatus")); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }

    public Account getUserById(int userId) {
        Account account = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT FullName, Email, PhoneNumber, Address, Gender FROM Accounts WHERE AccID = ?";

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, userId);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    account = new Account();
                    account.setFullName(rs.getString("FullName"));
                    account.setEmail(rs.getString("Email"));
                    account.setPhoneNumber(rs.getString("PhoneNumber"));
                    account.setAddress(rs.getString("Address"));
                    account.setGender(rs.getString("Gender"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    public boolean registerWithGoogleAcc(Account account) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO Accounts (Email, UserImage, Password, FullName, UserRole, idStatus) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, account.getEmail());
                pstmt.setString(2, account.getProfileImage());
                pstmt.setString(3, account.getPassword());
                pstmt.setString(4, account.getFullName());
                pstmt.setString(5, account.getUserRole());
                pstmt.setInt(6, account.getAccountStatus());

                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public Account getAccountByEmail(String email) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Account acc = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT * FROM Accounts WHERE  [Email]  = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    acc = new Account();
                    acc.setEmail(rs.getString(2));
                    acc.setKoiCareID(rs.getString(3));
                    acc.setProfileImage(rs.getString(4));
                    acc.setFullName(rs.getString(6));
                    acc.setPhoneNumber(rs.getString(7));
                    acc.setUserRole(rs.getString(8));
                    acc.setAddress(rs.getString(9));
                    acc.setGender(rs.getString(10));
                    acc.setAccountStatus(rs.getInt(11));
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
        return acc;
    }

    public static void main(String[] args) {
        AccountDAO acd = new AccountDAO();
//        boolean c = acd.isKoiCareIDExist("rikawa1");
        Account c = acd.getAccountByEmail("acnbokhb@gmail.com");
        System.out.println(c);
    }

}
