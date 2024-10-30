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

    public boolean createNewAccount(Account account) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO Accounts (Email, KoiCareID, UserImage, Password, FullName, PhoneNumber, UserRole, Address, Gender, idStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = DatabaseConnectionManager.getConnection(); // Lấy kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(sql); // Tạo PreparedStatement để thực hiện câu truy vấn

            // Đặt các tham số cho PreparedStatement
            ps.setString(1, account.getEmail());
            ps.setString(2, account.getKoiCareID());
            ps.setString(3, account.getProfileImage());
            ps.setString(4, account.getPassword());
            ps.setString(5, account.getFullName());
            ps.setString(6, account.getPhoneNumber());
            ps.setString(7, account.getUserRole());
            ps.setString(8, account.getAddress());
            ps.setString(9, account.getGender());
            ps.setInt(10, account.getAccountStatus()); // Giả sử idStatus là kiểu int

            // Thực hiện câu truy vấn và kiểm tra số hàng bị ảnh hưởng
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu có ít nhất một hàng bị ảnh hưởng
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông báo lỗi nếu có
            return false; // Trả về false nếu có lỗi
        } finally {
            try {
                // Đóng tài nguyên
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // In ra lỗi trong quá trình đóng
            }
        }
    }

    public int countAllAccounts() {
        ArrayList<Account> listAccounts = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement psm = null;
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
//========================================================================
    //TEST CREATE

    public static void main(String[] args) {
        // Thiết lập đối tượng Account mới
        Account newAccount = new Account();
        newAccount.setEmail("test@example.com");
        newAccount.setKoiCareID("Koi123");
        newAccount.setProfileImage("image.png");
        newAccount.setPassword("password");
        newAccount.setFullName("Full Name");
        newAccount.setPhoneNumber("123456789");
        newAccount.setUserRole("User");
        newAccount.setAddress("123 Street");
        newAccount.setGender("Male");
        newAccount.setAccountStatus(1); // Giả sử idStatus là kiểu int

        // Tạo đối tượng AccountDAO để gọi phương thức createNewAccount
        AccountDAO accountDAO = new AccountDAO();

        // Gọi phương thức tạo tài khoản mới và lưu kết quả
        boolean isCreated = accountDAO.createNewAccount(newAccount);

        // Kiểm tra và in ra kết quả
        if (isCreated) {
            System.out.println("New account created successfully.");
        } else {
            System.out.println("Failed to create new account.");
        }
    }

    //================================================================
    // TEST : GELL LIST ACCOUNT
//    public static void main(String[] args) {
//        AccountDAO accountDAO = new AccountDAO(); // Initialize the DAO
//        // Test retrieving all accounts from the database
//        ArrayList<Account> accounts = accountDAO.getAllAccounts();
//
//        // Loop through the result and print each account's details
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
//    }
    // COUNT  ACCOUNT
//    public static void main(String[] args) {
//        AccountDAO accountDAO = new AccountDAO(); // Initialize the DAO
//        int count = accountDAO.countAllAccounts();
//        System.out.println(count);
//
//    }
//    public static void main(String[] args) {
//        AccountDAO accountDAO = new AccountDAO(); 
//        List<Account> accl = accountDAO.getAccounts(2);
//        for (Account a : accl) {
//
//            System.out.println(a);
//
//        }
//    }
    //================================================================
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

                int rowAffect = pst.executeUpdate();
                if (rowAffect > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        AccountDAO acd = new AccountDAO();
////        boolean c = acd.isKoiCareIDExist("rikawa1");
////        Account c = acd.getAccountByEmail("acnbokhb@gmail.com");
//        Account acc = new Account();
//        acc.setFullName("Khánh");
//        acc.setPhoneNumber("0908765567");
//        acc.setAddress("12 đường cây keo");
//        acc.setGender("Men");
////                acc.setKoiCareID("21212");
//        acc.setUserID(9);
//        boolean c = acd.updateAccount(acc);
//        System.out.println(c);
//    }
}
