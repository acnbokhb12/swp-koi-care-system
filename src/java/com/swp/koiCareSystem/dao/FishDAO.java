package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Fish;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                String sql = "SELECT * FROM Fish WHERE AccID = ? AND isActive = 1";
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
    public Fish getFishInforByID(String  fishID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Fish fish = null;

        String sql = "SELECT * FROM Fish WHERE FishID = ?";
        try {
            conn = DatabaseConnectionManager.getConnection(); 
            ps = conn.prepareStatement(sql);
            ps.setString(1, fishID);
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

     
 public boolean DeleteFishByID(String fishID) {
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
public void updateFish(Fish fish) {
    Connection conn = null;
    PreparedStatement ptm = null;

    try {
        conn = DatabaseConnectionManager.getConnection(); 
        if (conn != null) { 
            String sql = "UPDATE Fish SET FishName = ?, DescriptionKoi = ?, BodyShape = ?, " +
                         "Age = ?, Length = ?, Weight = ?, Gender = ?, isActive = ? WHERE FishID = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, fish.getFishName());          
            ptm.setString(2, fish.getDescriptionKoi());    
            ptm.setString(3, fish.getBodyShape());          
            ptm.setFloat(4, fish.getAge());               
            ptm.setFloat(5, fish.getLength());             
            ptm.setFloat(6, fish.getWeight());           
            ptm.setString(7, fish.getGender());             
            ptm.setBoolean(8, fish.isIsActive());             
            ptm.setInt(9, fish.getFishID());               

            ptm.executeUpdate();
        }
    } catch (SQLException e) {
        System.out.println("Error updating fish: " + e.getMessage()); 
    } catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
    } finally {
        try {
            if (ptm != null) {
                ptm.close(); 
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
}


//    // TEST DAO
//    public static void main(String[] args) {
//        FishDAO fdao = new FishDAO();
//
//        // Test retrieving all fish for a specific account ID
//        ArrayList<Fish> list = fdao.getAllFish(5);
//        for (Fish i : list) {
//            System.out.println(i);
//        }
  public static void main(String[] args) {
        FishDAO fishDAO = new FishDAO();
        String testFishID = "5"; // Replace with a valid FishID to test

        Fish fish = fishDAO.getFishInforByID(testFishID);
        System.out.println(fish);
    }
}
      

