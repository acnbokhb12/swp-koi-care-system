package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Fish;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fish Data Access Object for interacting with the Fish database table.
 */
public class FishDAO {

    // Retrieve all fish associated with a specific account ID
    public ArrayList<Fish> getAllFish(int accountID) {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ArrayList<Fish> listFish = new ArrayList<>();

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM Fish WHERE AccID = ? AND isActive = 1 order by FishID desc";
                ptm = conn.prepareStatement(sql);
                ptm.setInt(1, accountID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int fishID = rs.getInt("FishID");
                    int accID = rs.getInt("AccID");
                    int pondID = rs.getInt("PondID");
                    String fishImage = rs.getString("FishImage");
                    String fishName = rs.getString("FishName");
                    String descriptionKoi = rs.getString("DescriptionKoi");
                    String bodyShape = rs.getString("BodyShape");
                    float age = rs.getFloat("Age");
                    float length = rs.getFloat("Length");
                    float weight = rs.getFloat("Weight");
                    String gender = rs.getString("Gender");

                    // Create a new Fish object and add it to the list
                    listFish.add(new Fish(fishID, accID, pondID, fishImage, fishName,
                            descriptionKoi, bodyShape, age, length, weight, gender));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        return listFish;
    }

    // SHOW INFORMATION BY ID
    public Fish getFishInforByID(int fishID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Fish fish = null;

        String sql = "SELECT * FROM Fish WHERE FishID = ? AND isActive = 1";
        try {
            conn = DatabaseConnectionManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, fishID);
            rs = ps.executeQuery();

            if (rs.next()) {
                fish = new Fish(
                        rs.getInt("FishID"),
                        rs.getInt("AccID"),
                        rs.getInt("PondID"),
                        rs.getString("FishImage"),
                        rs.getString("FishName"),
                        rs.getString("DescriptionKoi"),
                        rs.getString("BodyShape"),
                        rs.getFloat("Age"),
                        rs.getFloat("Length"),
                        rs.getFloat("Weight"),
                        rs.getString("Gender")
                );
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
        return fish;
    }

    //DELETE
    public boolean deleteFishByID(String fishID) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE Fish SET isActive = 0 WHERE FishID = ?";
        try {
            conn = DatabaseConnectionManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, fishID);

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //EDIT
    public boolean updateFishInformationByID(Fish fish) {
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                String sql = "UPDATE Fish SET FishName = ?, BodyShape = ?, Age = ?, Length = ?, Weight = ?, Gender = ?, DescriptionKoi = ?, PondID = ? WHERE FishID = ?";
                ptm = conn.prepareStatement(sql);

                ptm.setString(1, fish.getFishName());
                ptm.setString(2, fish.getBodyShape());
                ptm.setFloat(3, (float) fish.getAge());
                ptm.setFloat(4, (float) fish.getLength());
                ptm.setFloat(5, (float) fish.getWeight());
                ptm.setString(6, fish.getGender());
                ptm.setString(7, fish.getDescriptionKoi());
                if (fish.getPondID() != 0) {
                    ptm.setInt(8, fish.getPondID());
                } else {
                    ptm.setNull(8, java.sql.Types.INTEGER);
                }
                ptm.setInt(9, fish.getFishID());

                int affectedRows = ptm.executeUpdate();
                return affectedRows > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
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
        return false;
    }

    public boolean updateFishImageByFishID(int fishID, String fishImage) {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                String sql = "UPDATE Fish\n"
                        + "SET [FishImage] = ?\n"
                        + "WHERE [FishID] = ?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, fishImage);
                pst.setInt(2, fishID);

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
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean addNewFish(Fish fish) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO Fish (AccID,PondID ,FishImage, FishName, DescriptionKoi, BodyShape, Age, Length, Weight, Gender, isActive) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = DatabaseConnectionManager.getConnection();
            ps = conn.prepareStatement(sql);

            // Set parameters for the prepared statement
            ps.setInt(1, fish.getAccID());

            if (fish.getPondID() != 0) {
                ps.setInt(2, fish.getPondID());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }

            ps.setString(3, fish.getFishImage());
            ps.setString(4, fish.getFishName());
            ps.setString(5, fish.getDescriptionKoi());
            ps.setString(6, fish.getBodyShape());
            ps.setFloat(7, fish.getAge());
            ps.setFloat(8, fish.getLength());
            ps.setFloat(9, fish.getWeight());
            ps.setString(10, fish.getGender());
            ps.setBoolean(11, fish.isIsActive());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                // Close resources
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace(); // Print any errors that occur during closing
            }
        }
    }

    public int countFishInPondByPondId(int pondID) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select count(*) from Fish where PondID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, pondID);
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

    public boolean checkFishIsExist(int fishId) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean isExist = false;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select [isActive] from [dbo].[Fish] where [FishID] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, fishId);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    isExist = rs.getBoolean(1);
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
        return isExist;
    }

    public boolean checkFishIsExistInPondById(int fishId, int pondId) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select*   from Ponds p inner join Fish f on p.PondID = f.PondID where f.FishID = ? and p.PondID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, fishId);
                pst.setInt(2, pondId);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
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

    //MANAGE
    
    //COUNT
    public int countFishs(int accID) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT count(*) FROM Fish WHERE [isActive] = 1 AND AccID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, accID);
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
//Phân Trang
    public ArrayList<Fish> getFishsByAccID(int accID, int index) {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ArrayList<Fish> listFish = new ArrayList<>();
        int distance = (index - 1) * 10;

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                String sql = "SELECT *\n"
                        + "FROM Fish f\n"
                        + "JOIN Accounts a ON f.AccID = a.AccID\n"
                        + "WHERE f.AccID = ? AND a.UserRole = 'customer'\n"
                        + "ORDER BY f.FishID\n"
                        + "OFFSET ? ROWS\n"
                        + "FETCH NEXT 10 ROWS ONLY;";
                ptm = conn.prepareStatement(sql);
                ptm.setInt(1, accID);
                ptm.setInt(2, distance);

                rs = ptm.executeQuery();
                while (rs.next()) {
                    int fishID = rs.getInt("FishID");
                    int pondID = rs.getInt("PondID");
                    String fishImage = rs.getString("FishImage");
                    String fishName = rs.getString("FishName");
                    String descriptionKoi = rs.getString("DescriptionKoi");
                    String bodyShape = rs.getString("BodyShape");
                    float age = rs.getFloat("Age");
                    float length = rs.getFloat("Length");
                    float weight = rs.getFloat("Weight");
                    String gender = rs.getString("Gender");

                    listFish.add(new Fish(fishID, accID, pondID, fishImage, fishName,
                            descriptionKoi, bodyShape, age, length, weight, gender));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        return listFish; // Trả về danh sách các đối tượng Fish
    }
//Details
    public Fish getFishDetailByFishID(int fishID) {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        Fish fish = null;

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM Fish f "
                        + "JOIN Accounts a ON f.AccID = a.AccID "
                        + "WHERE f.FishID = ? AND a.UserRole = 'customer';";
                ptm = conn.prepareStatement(sql);
                ptm.setInt(1, fishID);

                rs = ptm.executeQuery();
                if (rs.next()) {
                    int accID = rs.getInt("AccID");
                    int pondID = rs.getInt("PondID");
                    String fishImage = rs.getString("FishImage");
                    String fishName = rs.getString("FishName");
                    String descriptionKoi = rs.getString("DescriptionKoi");
                    String bodyShape = rs.getString("BodyShape");
                    float age = rs.getFloat("Age");
                    float length = rs.getFloat("Length");
                    float weight = rs.getFloat("Weight");
                    String gender = rs.getString("Gender");

                    fish = new Fish(fishID, accID, pondID, fishImage, fishName,
                            descriptionKoi, bodyShape, age, length, weight, gender);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        return fish;
    }

/*
//    // TEST DAO
    public static void main(String[] args) {
        FishDAO fdao = new FishDAO();

        // Test retrieving all fish for a specific account ID
        ArrayList<Fish> list = fdao.getAllFish(5);
        for (Fish i : list) {
            System.out.println(i);
        }
    public static void main(String[] args) {
        FishDAO fishDAO = new FishDAO();
        String testFishID = "5"; // Replace with a valid FishID to test

<<<<<<< HEAD
//        Fish fish = fishDAO.getFishInforByID(testFishID);
    ArrayList<Fish> fishs = fishDAO.getAllFish(5);
       for(Fish f : fishs){
           System.out.println(f);
       }
    }
        Fish fish = fishDAO.getFishInforByI;
        System.out.println(fish);
>>>>>>> CRUDFish
}
     //===========================================

 //TEST UPDATE  -- pass
 
  public static void main(String[] args) {
        // Tạo một đối tượng Fish với thông tin cần thiết
        Fish fishToUpdate = new Fish();
        fishToUpdate.setFishID(1); // Giả sử bạn có FishID = 1
        fishToUpdate.setFishName("Koi Blue");
        fishToUpdate.setBodyShape("Streamlined");
        fishToUpdate.setAge(3.0f);
        fishToUpdate.setLength(50.0f);
        fishToUpdate.setWeight(5.0f);
        fishToUpdate.setGender("Male");
        fishToUpdate.setDescriptionKoi("Beautiful blue koi fish.");

        // Tạo một đối tượng FishDAO để cập nhật thông tin
        FishDAO fishDAO = new FishDAO();
        boolean isUpdated = fishDAO.updateFishInformationByID(fishToUpdate);

        // In kết quả cập nhật
        if (isUpdated) {
            System.out.println("Fish information updated successfully.");
        } else {
            System.out.println("Failed to update fish information.");
        }
    }
     //===========================================

  //TEST CREATE -- pass
  public static void main(String[] args) {
    Fish newFish = new Fish();
    newFish.setAccID(1);
    newFish.setFishImage("image_url_or_path"); 
    newFish.setFishName("Koi Gold");
    newFish.setBodyShape("Oval");
    newFish.setAge(2.0f);
    newFish.setLength(30.0f);
    newFish.setWeight(3.5f);
    newFish.setGender("Male");
    newFish.setDescriptionKoi("Beautiful gold koi fish.");
    newFish.setIsActive(true); 

  
    FishDAO fishDAO = new FishDAO();
    boolean isCreated = fishDAO.createNewFish(newFish);

  
    if (isCreated) {
        System.out.println("New fish created successfully.");
    } else {
        System.out.println("Failed to create new fish.");
    }
}*/
//    public static void main(String[] args) {
//        FishDAO fd = new FishDAO();
//        boolean i = fd.checkFishIsExistInPondById(110, 19);
//        System.out.println(i);
//    }
    //===========================================
    //TEST
    // COUNT  ACCOUNT
//    public static void main(String[] args) {
//        FishDAO fd = new FishDAO(); // Initialize the DAO
//        int count = fd.countFishs();
//        System.out.println(count);
//
//    }
//    public static void main(String[] args) {
//        FishDAO fd = new FishDAO(); // Initialize the DAO
//        List<Fish> fl = fd.getAllFishs(1);
//        for(Fish f : fl){
//            
//            System.out.println(f);
//            
//        }
//    }
    //====================================================
// TEST COUNT FISH BY ACCOUNT
public static void main(String[] args) {
    FishDAO fd = new FishDAO(); // Khởi tạo DAO
    
    // Test phương thức countFishs
    int accID = 9; // accID bạn muốn kiểm tra
    int count = fd.countFishs(accID); // Gọi phương thức countFishs với accID
    System.out.println("Số lượng cá của tài khoản " + accID + ": " + count); // In kết quả
}
//// TEST GET FISH BY ACCOUNT ID
//public static void main(String[] args) {
//    FishDAO fd = new FishDAO(); // Khởi tạo DAO
//    
//    // Test phương thức getFishsByAccID
//    int accID = 5; // accID bạn muốn kiểm tra
//    int index = 1; // Số trang bạn muốn kiểm tra (phân trang)
//    List<Fish> fishList = fd.getFishsByAccID(accID, index); // Gọi phương thức getFishsByAccID
//
//    // In danh sách cá trả về
//    for (Fish f : fishList) {
//        System.out.println(f); // In ra từng đối tượng cá
//    }
//}
// FISH DETAIL
//    public static void main(String[] args) {
//        FishDAO fd = new FishDAO(); 
//        int fishID = 1; 
//        Fish fish = fd.getFishDetailByFishID(fishID); 
//        
//        if (fish != null) {
//            System.out.println("Thông tin cá với ID " + fishID + ":");
//            System.out.println("Tên: " + fish.getFishName());
//            System.out.println("Hình ảnh: " + fish.getFishImage());
//            System.out.println("Mô tả: " + fish.getDescriptionKoi());
//            System.out.println("Hình dáng: " + fish.getBodyShape());
//            System.out.println("Tuổi: " + fish.getAge());
//            System.out.println("Chiều dài: " + fish.getLength());
//            System.out.println("Cân nặng: " + fish.getWeight());
//            System.out.println("Giới tính: " + fish.getGender());
//        } else {
//            System.out.println("Không tìm thấy cá với ID " + fishID);
//        }
//    }
    //=====================================================
}
