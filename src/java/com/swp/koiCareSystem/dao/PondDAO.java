/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Pond;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PondDAO {

    public ArrayList<Pond> getAllPond() throws SQLException {
        ArrayList<Pond> listPonds = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Ponds"; // Assuming the table name is Ponds

        try {
            conn = DatabaseConnectionManager.getConnection(); // Your method to get DB connection
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int pondID = rs.getInt("PondID");
                    int accID = rs.getInt("AccID");
                    String image = rs.getString("Image");
                    String name = rs.getString("Name");
                    int numberOfFish = rs.getInt("NumberOfFish");
                    double volume = rs.getDouble("Volume");
                    double depth = rs.getDouble("Depth");
                    double pumpPower = rs.getDouble("PumpPower");
                    int drainCount = rs.getInt("DrainCount");
                    int skimmer = rs.getInt("Skimmer");

                    // Add the pond object to the list
                    listPonds.add(new Pond(pondID, accID, image, name, numberOfFish, 
                                               volume, depth, pumpPower, drainCount, skimmer));
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
        return listPonds;
    }

//     public ArrayList<Pond> GetAllPond(){
//        ArrayList<Pond> listP = new ArrayList<>();
//        return listP;
//    }
     
}
