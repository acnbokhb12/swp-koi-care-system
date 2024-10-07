/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Fish;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public ArrayList<Fish> getAllFish(int accountID) {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Fish Where AccID LIKE ? ";
        ArrayList<Fish> listFish = new ArrayList<>();

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setInt(1, accountID);
                rs = ptm.executeQuery();
                if (rs != null) {
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

                        // Add the fish object to the list
                        listFish.add(new Fish(fishID, accID, pondID, fishImage, fishName,
                                descriptionKoi, bodyShape, age, length, weight, gender));
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

        return listFish;
    }
}
