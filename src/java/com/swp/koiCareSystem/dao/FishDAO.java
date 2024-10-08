package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Fish;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql = "SELECT * FROM Fish WHERE AccID = ?";
        ArrayList<Fish> listFish = new ArrayList<>();

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
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

    // Retrieve fish information by ID
    public Fish getFishInforByID(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Fish WHERE FishID = ?";
        try {
            conn = DatabaseConnectionManager.getConnection(); // Open connection to the database
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            // Check if a record was found
            while (rs.next()) {
                // Create a new Fish fishInforobject with the retrieved data
                return new Fish(
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

        }
        return null; // Return the fish object, or null if not found

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
        String testFishID = "1"; // Replace with a valid FishID to test

        Fish fish = fishDAO.getFishInforByID(testFishID);
        if (fish != null) {
            System.out.println("Fish ID: " + fish.getFishID());
            System.out.println("Account ID: " + fish.getAccID());
            System.out.println("Pond ID: " + fish.getPondID());
            System.out.println("Fish Image: " + fish.getFishImage());
            System.out.println("Fish Name: " + fish.getFishName());
            System.out.println("Description: " + fish.getDescriptionKoi());
            System.out.println("Body Shape: " + fish.getBodyShape());
            System.out.println("Age: " + fish.getAge() + " years");
            System.out.println("Length: " + fish.getLength() + " cm");
            System.out.println("Weight: " + fish.getWeight() + " kg");
            System.out.println("Gender: " + fish.getGender());
        } else {
            System.out.println("No fish found with ID: " + testFishID);
        }
    }
}
      

