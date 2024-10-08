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

    public ArrayList<Pond> getAllPond(int accountID) {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Ponds  Where AccID LIKE ?";
        ArrayList<Pond> listPonds = new ArrayList<>();

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setInt(1, accountID);
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
    
    
    public Pond getPondInforByID(String id) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "SELECT * FROM Ponds WHERE PondID = ?";
    try {
        conn = DatabaseConnectionManager.getConnection(); // Open connection to the database
        ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        rs = ps.executeQuery();

        // Check if a record was found
        if (rs.next()) {
            // Create a new Pond object with the retrieved data
            return new Pond(
                    rs.getInt("PondID"),
                    rs.getInt("AccID"),
                    rs.getString("Image"),
                    rs.getString("Name"),
                    rs.getInt("NumberOfFish"),
                    rs.getFloat("Volume"),
                    rs.getFloat("Depth"),
                    rs.getFloat("PumpPower"),
                    rs.getInt("DrainCount"),
                    rs.getInt("Skimmer")
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return null; // Return null if no pond found
}


    public static void main(String[] args) {
        PondDAO pondDAO = new PondDAO();

        String testPondID = "1"; // Adjust the ID based on available data in your database
        Pond pond = pondDAO.getPondInforByID(testPondID);

        if (pond != null) {
            System.out.println("Pond ID: " + pond.getPondID());
            System.out.println("Account ID: " + pond.getAccID());
            System.out.println("Image: " + pond.getImage());
            System.out.println("Name: " + pond.getName());
            System.out.println("Number of Fish: " + pond.getNumberOfFish());
            System.out.println("Volume: " + pond.getVolume());
            System.out.println("Depth: " + pond.getDepth());
            System.out.println("Pump Power: " + pond.getPumpPower());
            System.out.println("Drain Count: " + pond.getDrainCount());
            System.out.println("Skimmer: " + pond.getSkimmer());
        } else {
            System.out.println("No pond found with ID: " + testPondID);
        }
    }

//     public static void main(String[] args) {
//        PondDAO ponddao = new PondDAO();
//
//        ArrayList<Pond> list = ponddao.getAllPond(5);
//        for (Pond i : list) {
//            System.out.println(i);
//        }
//
//    }
}
