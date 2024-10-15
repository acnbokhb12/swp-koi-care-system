/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Fish;
import com.swp.koiCareSystem.model.Pond;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PondDAO {

    public ArrayList<Pond> getAllPond(int accountID) {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ArrayList<Pond> listPonds = new ArrayList<>();

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM Ponds  Where AccID LIKE ? AND isActive = 1";
                ptm = conn.prepareStatement(sql);
                ptm.setInt(1, accountID);
                rs = ptm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int pondID = rs.getInt("PondID");
                        int accID = rs.getInt("AccID");
                        String image = rs.getString("PondImage");
                        String name = rs.getString("PondName");
                        String desc = rs.getString("Description");
                        int numberOfFish = rs.getInt("NumberOfFish");
                        float volume = rs.getFloat("Volume");
                        float depth = rs.getFloat("Depth");
                        float pumpPower = rs.getFloat("PumpPower");
                        int drainCount = rs.getInt("DrainCount");
                        int skimmer = rs.getInt("Skimmer");

                        // Add the pond object to the list
                        listPonds.add(new Pond(pondID, accID, image, name, desc, numberOfFish,
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
    public Pond getPondInforByID(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Ponds WHERE PondID = ?";
        try {
            conn = DatabaseConnectionManager.getConnection(); // Open connection to the database
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            // Check if a record was found
            if (rs.next()) {
                // Create a new Pond object with the retrieved data
                return new Pond(
                        rs.getInt("PondID"),
                        rs.getInt("AccID"),
                        rs.getString("PondImage"),
                        rs.getString("PondName"),
                        rs.getString("Description"),
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
        return null; // Return null if no pond found
    }

    public boolean deletePondByID(String pondID) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE Ponds SET isActive = 0 WHERE PondID = ?";
        try {
            conn = DatabaseConnectionManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pondID);

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

    public boolean createNewPond(Pond pond) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO Ponds (AccID, PondImage, PondName, Description, NumberOfFish, Volume, Depth, PumpPower, DrainCount, Skimmer, isActive) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DatabaseConnectionManager.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, pond.getAccID());
            ps.setString(2, pond.getImage());
            ps.setString(3, pond.getName());
            ps.setString(4, pond.getDescriptionPond());
            ps.setInt(5, pond.getNumberOfFish());
            ps.setFloat(6, (float) pond.getVolume());
            ps.setFloat(7, (float) pond.getDepth());
            ps.setFloat(8, (float) pond.getPumpPower());
            ps.setInt(9, pond.getDrainCount());
            ps.setInt(10, pond.getSkimmer());
            ps.setBoolean(11, pond.isIsActive());

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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean updatePondInformationByID(Pond pond) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE Ponds SET PondName=?, Description=?, NumberOfFish=?, Volume=?, Depth=?, PumpPower=?, DrainCount=?, Skimmer=? WHERE PondID=?";
        try {
            conn = DatabaseConnectionManager.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, pond.getName());
            ps.setString(2, pond.getDescriptionPond());
            ps.setInt(3, pond.getNumberOfFish());
            ps.setFloat(4, (float) pond.getVolume());
            ps.setFloat(5, (float) pond.getDepth());
            ps.setFloat(6, (float) pond.getPumpPower());
            ps.setInt(7, pond.getDrainCount());
            ps.setInt(8, pond.getSkimmer());
            ps.setInt(9, pond.getPondID());

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

    public boolean updatePondImageByPondID(int pondID, String pondImage) {
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "UPDATE Ponds\n"
                        + "SET PondImage = ?\n"
                        + "WHERE PondID = ?";

                pst = cn.prepareStatement(sql);
                pst.setString(1, pondImage);
                pst.setInt(2, pondID);

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

    public ArrayList<Fish> getAllFishInPondByID(int pondId) {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ArrayList<Fish> listFish = new ArrayList<>();

        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM Fish  Where PondID = ? AND isActive = 1";
                ptm = conn.prepareStatement(sql);
                ptm.setInt(1, pondId);
                rs = ptm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int fishID = rs.getInt("FishID");
                        String fishImage = rs.getString("FishImage");
                        String fishName = rs.getString("FishName");

                        listFish.add(new Fish(fishID, fishImage, fishName));
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
