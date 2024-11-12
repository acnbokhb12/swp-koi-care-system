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
                String sql = "UPDATE Accounts SET Email = ?, Password = ?, FullName = ?, PhoneNumber = ?, UserRole = ?, Address = ?, Gender = ? WHERE AccID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, account.getEmail());
                ps.setString(2, account.getPassword());
                ps.setString(3, account.getFullName());
                ps.setString(4, account.getPhoneNumber());
                ps.setString(5, account.getUserRole());
                ps.setString(6, account.getAddress());
                ps.setString(7, account.getGender());
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
        String newImagePath = "data:image/jpeg;base64,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";
        boolean result = accountDAO.updateImgByAccountID(testAccountId, newImagePath);

        if (result) {
            System.out.println("Test passed: Image updated successfully.");
        } else {
            System.out.println("Test failed: Image update was unsuccessful.");
        }
    }

}
