/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.AccountStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class AccountDAO {

    public ArrayList<Account> getAccounts() {
        ArrayList<Account> listAccounts = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        String sql
                = "SELECT *  FROM Accounts WHERE UserRole = 'customer'";
        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {

                PreparedStatement ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Account account = new Account();
                    account.setUserID(rs.getInt("AccID"));
                    account.setEmail(rs.getString("Email"));
                    account.setKoiCareID(rs.getString("KoiCareID"));
                    account.setProfileImage(rs.getString("UserImage"));
                    account.setPassword(rs.getString("Password"));
                    account.setFullName(rs.getString("FullName"));
                    account.setPhoneNumber(rs.getString("PhoneNumber"));
                    account.setUserRole(rs.getString("UserRole"));
                    account.setAddress(rs.getString("Address"));
                    account.setGender(rs.getString("Gender"));
                    account.setAccountStatus(rs.getInt("idStatus"));

                    listAccounts.add(account);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAccounts;
    }

    public int countAllAccounts() {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement psm = null; // Declare psm outside the try block
        String sql = "SELECT count(*) FROM Accounts WHERE UserRole = 'customer'";

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(sql);
                rs = psm.executeQuery();
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
                if (psm != null) {
                    psm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public ArrayList<Account> getAccounts(int index) {
        ArrayList<Account> listAcc = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        int distance = (index - 1) * 5;

        String sql
                = "SELECT * \n"
                + "FROM Accounts \n"
                + "WHERE UserRole = 'customer' \n"
                + "ORDER BY AccID \n"
                + "OFFSET ? ROWS \n"
                + "FETCH NEXT 5 ROWS ONLY;";
        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {

                ps = conn.prepareStatement(sql);
                ps.setInt(1, distance);

                rs = ps.executeQuery();
                while (rs.next()) {
                    Account account = new Account();
                    account.setUserID(rs.getInt("AccID"));
                    account.setEmail(rs.getString("Email"));
                    account.setKoiCareID(rs.getString("KoiCareID"));
                    account.setProfileImage(rs.getString("UserImage"));
                    account.setPassword(rs.getString("Password"));
                    account.setFullName(rs.getString("FullName"));
                    account.setPhoneNumber(rs.getString("PhoneNumber"));
                    account.setUserRole(rs.getString("UserRole"));
                    account.setAddress(rs.getString("Address"));
                    account.setGender(rs.getString("Gender"));
                    account.setAccountStatus(rs.getInt("idStatus"));

                    listAcc.add(account);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listAcc;
    }

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

            if (rs != null && rs.next()) {
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

    public boolean isPhoneNumberExist(String phoneNumber) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT count(*) FROM Accounts WHERE PhoneNumber = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, phoneNumber);
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

    public boolean updateAccount(Account account) {
        String sql = "UPDATE Accounts SET "
                + "FullName = ?, PhoneNumber = ?, Address = ?, Gender = ?, KoiCareID = ? "
                + "WHERE AccID = ?";

        boolean updateSuccess = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, account.getFullName());
            pstmt.setString(2, account.getPhoneNumber());
            pstmt.setString(3, account.getAddress());
            pstmt.setString(4, account.getGender());
            pstmt.setString(5, account.getKoiCareID());
            pstmt.setInt(6, account.getUserID());

            int rowsUpdated = pstmt.executeUpdate();
            updateSuccess = rowsUpdated > 0;

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
        return updateSuccess;
    }

    public String getPasswordByAccID(int accID) {
        String sql = "SELECT Password FROM Accounts WHERE AccID = ?";
        String password = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, accID);
                rs = pstmt.executeQuery();
                if (rs != null && rs.next()) {
                    password = rs.getString("Password");
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
        return password;
    }

    public boolean updatePassword(int accID, String newPassword) {
        String sql = "UPDATE Accounts SET Password = ? WHERE AccID = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, newPassword);
                pstmt.setInt(2, accID);

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
                    acc.setUserID(rs.getInt(1));
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

    public boolean updateImgByAccountID(int acid, String img) {
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "update Accounts\n"
                        + "set [UserImage] = ?\n"
                        + "where [AccID] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, img);
                pst.setInt(2, acid);

   
                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
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
        return false;
    }
    public boolean updatePasswordWithEmail(String newPassword, String email) {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = DatabaseConnectionManager.getConnection();
            String sql = "UPDATE Accounts SET Password = ? WHERE Email = ?";
            pst = conn.prepareStatement(sql);

            pst.setString(1, newPassword);
            pst.setString(2, email);

            int rowCount = pst.executeUpdate();
            return rowCount > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //ADMIN ACCOUNT
    public int countAccountsToAdmin() {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement psm = null;
        String sql = "SELECT count(*) FROM Accounts WHERE isActive = 1";

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(sql);
                rs = psm.executeQuery();
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
                if (psm != null) {
                    psm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public ArrayList<Account> getAccountsToAdmin(int index) {
        ArrayList<Account> listAcc = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        int distance = (index - 1) * 10;

        String sql = "SELECT a.AccID, a.Email, a.KoiCareID, a.UserImage, a.Password, a.FullName, "
                + "a.PhoneNumber, a.UserRole, a.Address, a.Gender, a.idStatus, s.name AS StatusName, a.isActive "
                + "FROM Accounts a "
                + "JOIN AccountStatus s ON a.idStatus = s.idStatus "
                + "WHERE a.isActive = 1 "
                + "ORDER BY a.AccID "
                + "OFFSET ? ROWS "
                + "FETCH NEXT 10 ROWS ONLY;";
        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {

                ps = conn.prepareStatement(sql);
                ps.setInt(1, distance);

                rs = ps.executeQuery();
                while (rs.next()) {
                    Account account = new Account();
                    account.setUserID(rs.getInt("AccID"));
                    account.setEmail(rs.getString("Email"));
                    account.setKoiCareID(rs.getString("KoiCareID"));
                    account.setProfileImage(rs.getString("UserImage"));
                    account.setPassword(rs.getString("Password"));
                    account.setFullName(rs.getString("FullName"));
                    account.setPhoneNumber(rs.getString("PhoneNumber"));
                    account.setUserRole(rs.getString("UserRole"));
                    account.setAddress(rs.getString("Address"));
                    account.setGender(rs.getString("Gender"));
                    account.setAccountStatus(rs.getInt("idStatus"));

                    AccountStatus accStatus = new AccountStatus();
                    accStatus.setStatusID(rs.getInt("idStatus"));
                    accStatus.setStatusName(rs.getString("StatusName"));
                    account.setAccstatus(accStatus);

                    listAcc.add(account);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listAcc;
    }

//ADMIN ACCOUNT STATUS
    public ArrayList<AccountStatus> getAllAccountStatuses() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<AccountStatus> listStatus = new ArrayList<>();
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT idStatus, name FROM AccountStatus";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    AccountStatus status = new AccountStatus();
                    status.setStatusID(rs.getInt("idStatus"));
                    status.setStatusName(rs.getString("name"));
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

    public ArrayList<Account> searchAccountsByStatus(int statusID, int index) {
        ArrayList<Account> listA = new ArrayList<>();
        int offset = (index - 1) * 10;

        String sql = "SELECT a.[AccID], a.[Email], a.[KoiCareID], a.[UserImage], a.[FullName], "
                + "a.[PhoneNumber], a.[UserRole], a.[Address], a.[Gender], a.[idStatus], "
                + "a.[isActive], s.[name] "
                + "FROM [Koi_Care_System_At_Home].[dbo].[Accounts] a "
                + "JOIN [Koi_Care_System_At_Home].[dbo].[AccountStatus] s ON a.[idStatus] = s.[idStatus] "
                + "WHERE a.[idStatus] = ? AND a.[isActive] = 1 "
                + "ORDER BY a.[FullName] ASC "
                + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";

        try (Connection cn = DatabaseConnectionManager.getConnection();
                PreparedStatement pst = cn.prepareStatement(sql)) {

            pst.setInt(1, statusID);
            pst.setInt(2, offset);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Account account = new Account();
                    account.setUserID(rs.getInt("AccID"));
                    account.setEmail(rs.getString("Email"));
                    account.setKoiCareID(rs.getString("KoiCareID"));
                    account.setProfileImage(rs.getString("UserImage"));
                    account.setFullName(rs.getString("FullName"));
                    account.setPhoneNumber(rs.getString("PhoneNumber"));
                    account.setUserRole(rs.getString("UserRole"));
                    account.setAddress(rs.getString("Address"));
                    account.setGender(rs.getString("Gender"));

                    AccountStatus status = new AccountStatus();
                    status.setStatusID(rs.getInt("idStatus"));
                    status.setStatusName(rs.getString("name"));

                    account.setAccstatus(status);

                    listA.add(account);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listA;
    }

    public int countAccountsByStatus(int statusID) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) FROM Accounts WHERE [idStatus] = ? AND [isActive] = 1";
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

//CRETAE
    public boolean createNewAccount(Account account) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO Accounts (Email, KoiCareID, UserImage, Password, FullName, PhoneNumber, UserRole, Address, Gender, idStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = DatabaseConnectionManager.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, account.getEmail());
            ps.setString(2, account.getKoiCareID());
            ps.setString(3, account.getProfileImage());
            ps.setString(4, account.getPassword());
            ps.setString(5, account.getFullName());
            ps.setString(6, account.getPhoneNumber());
            ps.setString(7, account.getUserRole());
            ps.setString(8, account.getAddress());
            ps.setString(9, account.getGender());
            ps.setInt(10, account.getAccountStatus());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // DELETE
    public boolean deleteAccountByID(int accountID) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean isDeleted = false;

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                String sql = "UPDATE Accounts SET isActive = 0 WHERE AccID = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, accountID);

                int affectedRows = ps.executeUpdate();
                isDeleted = (affectedRows > 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isDeleted;
    }

    public Account getAccountInformationByID(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account account = null;
        String sql = "SELECT a.AccID, a.Email, a.KoiCareID, a.UserImage, a.Password, a.FullName, "
                + "a.PhoneNumber, a.UserRole, a.Address, a.Gender, a.idStatus, a.isActive, s.name AS StatusName "
                + "FROM Accounts a "
                + "LEFT JOIN AccountStatus s ON a.idStatus = s.idStatus "
                + "WHERE a.AccID = ?";
        try {
            conn = DatabaseConnectionManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs != null && rs.next()) {
                account = new Account();
                account.setUserID(rs.getInt("AccID"));
                account.setEmail(rs.getString("Email"));
                account.setKoiCareID(rs.getString("KoiCareID"));
                account.setProfileImage(rs.getString("UserImage"));
                account.setPassword(rs.getString("Password"));
                account.setFullName(rs.getString("FullName"));
                account.setPhoneNumber(rs.getString("PhoneNumber"));
                account.setUserRole(rs.getString("UserRole"));
                account.setAddress(rs.getString("Address"));
                account.setGender(rs.getString("Gender"));
                account.setAccountStatus(rs.getInt("isActive"));

                AccountStatus accStatus = new AccountStatus();
                accStatus.setStatusID(rs.getInt("idStatus"));
                accStatus.setStatusName(rs.getString("StatusName"));
                account.setAccstatus(accStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return account;
    }

    //UPDATE 
    // INFORMATION
    public boolean updateInformationAccount(Account account) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                String sql = "UPDATE Accounts SET Email = ?,  FullName = ?, PhoneNumber = ?, UserRole = ?, Address = ?, Gender = ?, KoiCareID =? WHERE AccID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, account.getEmail()); 
                ps.setString(2, account.getFullName());
                ps.setString(3, account.getPhoneNumber());
                ps.setString(4, account.getUserRole());
                ps.setString(5, account.getAddress());
                ps.setString(6, account.getGender());
                ps.setString(7, account.getKoiCareID());
                ps.setInt(8, account.getUserID());

                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

//SEARCH==============================================================
    //PHONE
    public int countAccountByPhoneNumber(String phone) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) FROM Accounts WHERE [PhoneNumber] LIKE ? AND [isActive] = 1";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + phone + "%");
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

    public ArrayList<Account> searchAccountByPhoneNumber(String phone, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Account> listA = new ArrayList<>();
        int distance = (index - 1) * 10;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT a.*, asStatus.name AS StatusName "
                        + "FROM Accounts a "
                        + "JOIN AccountStatus asStatus ON a.idStatus = asStatus.idStatus "
                        + "WHERE a.PhoneNumber LIKE ? AND a.isActive = 1 "
                        + "ORDER BY a.FullName DESC "
                        + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";

                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + phone + "%");
                pst.setInt(2, distance);
                rs = pst.executeQuery();

                while (rs.next()) {
                    Account account = new Account();
                    account.setUserID(rs.getInt("AccID"));
                    account.setEmail(rs.getString("Email"));
                    account.setKoiCareID(rs.getString("KoiCareID"));
                    account.setProfileImage(rs.getString("UserImage"));
                    account.setPassword(rs.getString("Password"));
                    account.setFullName(rs.getString("FullName"));
                    account.setPhoneNumber(rs.getString("PhoneNumber"));
                    account.setUserRole(rs.getString("UserRole"));
                    account.setAddress(rs.getString("Address"));
                    account.setGender(rs.getString("Gender"));
                    account.setAccountStatus(rs.getInt("isActive"));

                    AccountStatus accStatus = new AccountStatus();
                    accStatus.setStatusID(rs.getInt("idStatus"));
                    accStatus.setStatusName(rs.getString("StatusName"));  
                    account.setAccstatus(accStatus);

                    listA.add(account);
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
        return listA;
    }

//NAME
    public int countAccountByFullName(String fullName) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) FROM Accounts "
                        + "WHERE [FullName] LIKE ? AND [isActive] = 1";

                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + fullName + "%");
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

    public ArrayList<Account> searchAccountByFullName(String fullName, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Account> listA = new ArrayList<>();
        int distance = (index - 1) * 10;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT a.*, asStatus.name AS StatusName "
                        + "FROM Accounts a "
                        + "JOIN AccountStatus asStatus ON a.idStatus = asStatus.idStatus "
                        + "WHERE a.FullName LIKE ? AND a.isActive = 1 "
                        + "ORDER BY a.FullName ASC "
                        + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";

                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + fullName + "%");
                pst.setInt(2, distance);
                rs = pst.executeQuery();

                while (rs.next()) {
                    Account account = new Account();
                    account.setUserID(rs.getInt("AccID"));
                    account.setEmail(rs.getString("Email"));
                    account.setKoiCareID(rs.getString("KoiCareID"));
                    account.setProfileImage(rs.getString("UserImage"));
                    account.setPassword(rs.getString("Password"));
                    account.setFullName(rs.getString("FullName"));
                    account.setPhoneNumber(rs.getString("PhoneNumber"));
                    account.setUserRole(rs.getString("UserRole"));
                    account.setAddress(rs.getString("Address"));
                    account.setGender(rs.getString("Gender"));
                    account.setAccountStatus(rs.getInt("isActive"));

                    AccountStatus accStatus = new AccountStatus();
                    accStatus.setStatusID(rs.getInt("idStatus"));
                    accStatus.setStatusName(rs.getString("StatusName")); 
                    account.setAccstatus(accStatus);

                    listA.add(account);
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
        return listA;
    }

//Email
    public int countAccountByEmail(String email) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) FROM Accounts "
                        + "WHERE [Email] LIKE ? AND [isActive] = 1";

                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + email + "%");
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

    public ArrayList<Account> searchAccountByEmail(String email, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Account> listA = new ArrayList<>();
        int distance = (index - 1) * 10;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT a.*, asStatus.name AS StatusName "
                        + "FROM Accounts a "
                        + "JOIN AccountStatus asStatus ON a.idStatus = asStatus.idStatus "
                        + "WHERE a.Email LIKE ? AND a.isActive = 1 "
                        + "ORDER BY a.Email ASC "
                        + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";

                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + email + "%");
                pst.setInt(2, distance);
                rs = pst.executeQuery();

                while (rs.next()) {
                    Account account = new Account();
                    account.setUserID(rs.getInt("AccID"));
                    account.setEmail(rs.getString("Email"));
                    account.setKoiCareID(rs.getString("KoiCareID"));
                    account.setProfileImage(rs.getString("UserImage"));
                    account.setPassword(rs.getString("Password"));
                    account.setFullName(rs.getString("FullName"));
                    account.setPhoneNumber(rs.getString("PhoneNumber"));
                    account.setUserRole(rs.getString("UserRole"));
                    account.setAddress(rs.getString("Address"));
                    account.setGender(rs.getString("Gender"));
                    account.setAccountStatus(rs.getInt("isActive"));

                    AccountStatus accStatus = new AccountStatus();
                    accStatus.setStatusID(rs.getInt("idStatus"));
                    accStatus.setStatusName(rs.getString("StatusName"));
                    account.setAccstatus(accStatus);

                    listA.add(account);
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
        return listA;
    }

    public static void main(String[] args) {
        AccountDAO test = new AccountDAO();
        test.testUpdateImgByAccountID();
    }

    public void testUpdateImgByAccountID() {
        AccountDAO accountDAO = new AccountDAO();

        int testAccountId = 10; 
     
        Account account = new Account();
            account.setUserID(9);
            account.setEmail("ddd");
            account.setFullName("ddd");
            account.setAddress("dd");
            account.setGender("dd");
            account.setPhoneNumber("0123");
            account.setUserRole("Customer");
            account.setKoiCareID("ddd");
         boolean a = accountDAO.updateInformationAccount(account);
        if (a) {
            System.out.println("Test passed: Image updated successfully.");
        } else {
            System.out.println("Test failed: Image update was unsuccessful.");
        }
    }

}
