/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Pond;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PondDAO {

    public ArrayList<Pond> getAllPond() {
        ArrayList<Pond> listPonds = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String sql = "SELECT *  Where AccID LIKE ?";

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                rs = ptm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int pondID = rs.getInt("PondID");
                        int accID = rs.getInt("AccID");
                        String image = rs.getString("Image");
                        String name = rs.getString("Name");
                        int numberOfFish = rs.getInt("NumberOfFish");
                        float volume = rs.getFloat("Volume");
                        float depth = rs.getFloat("Depth");
                        float pumpPower = rs.getFloat("PumpPower");
                        int drainCount = rs.getInt("DrainCount");
                        int skimmer = rs.getInt("Skimmer");

                        // Add the pond object to the list
                        listPonds.add(new Pond(pondID, accID, image, name, numberOfFish,
                                volume, depth, pumpPower, drainCount, skimmer));
                    }
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

        return listPonds;
    }

//     public ArrayList<Pond> GetAllPond(){
//        ArrayList<Pond> listP = new ArrayList<>();
//        return listP;
//    }
}
