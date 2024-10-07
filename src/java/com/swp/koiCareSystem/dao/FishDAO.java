/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Fish;
import com.swp.koiCareSystem.model.FishDevelopment;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author PC
 */
public class FishDAO {

//    public ArrayList<Fish> GetAllFish() {
//        ArrayList<Fish> listF = new ArrayList<>();
//        return listF;
//    }



    public ArrayList<Fish> getAllFish() throws SQLException {
        ArrayList<Fish> listFish = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Fish"; 

        try {
            conn = DatabaseConnectionManager.getConnection(); 
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int fishID = rs.getInt("FishID");
                    int accID = rs.getInt("AccID");
                    int pondID = rs.getInt("PondID");
                    String fishImage = rs.getString("FishImage");
                    String fishName = rs.getString("FishName");
                    String descriptionKoi = rs.getString("DescriptionKoi");
                    String bodyShape = rs.getString("BodyShape");
                    double age = rs.getDouble("Age");
                    double length = rs.getDouble("Length");
                    double weight = rs.getDouble("Weight");
                    String gender = rs.getString("Gender");

                    // Add the fish object to the list
                    listFish.add(new Fish(fishID, accID, pondID, fishImage, fishName, 
                                              descriptionKoi, bodyShape, age, length, weight, gender));
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
        return listFish;
    }

//    public ArrayList<FishDevelopment> GetAllFishDevelopment() {
//        ArrayList<FishDevelopment> listFD = new ArrayList<>();
//        return listFD;
//    }



    public ArrayList<FishDevelopment> getAllFishDevelopment() throws SQLException {
        ArrayList<FishDevelopment> listFishDevelopment = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM FishDevelopment"; 

        try {
            conn = DatabaseConnectionManager.getConnection(); 
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int fishDevelopmentID = rs.getInt("FishDevelopmentID");
                    int fishID = rs.getInt("FishID");
                    java.time.LocalDate dateGrowth = rs.getDate("DateGrowth").toLocalDate(); 
                    double length = rs.getDouble("Length");
                    double weight = rs.getDouble("Weight");

                    // Add the fish development object to the list
                    listFishDevelopment.add(new FishDevelopment(fishDevelopmentID, fishID, dateGrowth, length, weight));
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
        return listFishDevelopment;
    }
}

   
