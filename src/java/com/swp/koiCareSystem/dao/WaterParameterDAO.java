/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Pond;
import com.swp.koiCareSystem.model.WaterParameter;
import com.swp.koiCareSystem.model.WaterParameterDescription;
import com.swp.koiCareSystem.model.WaterParameterDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class WaterParameterDAO {

    public ArrayList<WaterParameterDescription> getAllWaterParameterDescriptions() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<WaterParameterDescription> descs = new ArrayList<>();
        String query = "SELECT * FROM WaterParameterDescription";

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                pst = cn.prepareStatement(query);
                rs = pst.executeQuery();

                while (rs.next()) {
                    WaterParameterDescription desc = new WaterParameterDescription();
                    desc.setWaterParameterDescID(rs.getInt("WaterParameterDescID"));
                    desc.setName(rs.getString("name"));
                    desc.setSymbol(rs.getString("symbol"));
                    desc.setMinValue(rs.getDouble("minValue"));
                    desc.setMaxValue(rs.getDouble("maxValue"));
                    desc.setUnit(rs.getString("unit"));
                    desc.setOptimalRange(rs.getString("optimalRange"));
                    desc.setDescription(rs.getString("description"));

                    descs.add(desc);
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
        return descs;
    }

    public ArrayList<WaterParameter> getWaterParametersByAccID(int accID) {
        Connection cn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        PreparedStatement stmt4 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;
        ArrayList<WaterParameter> listParameters = new ArrayList<>();

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                // Step 1: Fetch Water Parameters for the given Account ID
                String sql1 = "SELECT WaterParameterID, PondID, MeasurementDate, Note, isActive "
                        + "FROM dbo.WaterParameter "
                        + "WHERE AccID = ? AND isActive = 1";
                stmt1 = cn.prepareStatement(sql1);
                stmt1.setInt(1, accID);
                rs1 = stmt1.executeQuery();

                // Step 2: Process each Water Parameter
                while (rs1.next()) {
                    int waterParameterID = rs1.getInt("WaterParameterID");
                    int pondID = rs1.getInt("PondID");
                    LocalDateTime measurementDate = rs1.getTimestamp("MeasurementDate").toLocalDateTime();
                    String note = rs1.getString("Note");
                    boolean isActive = rs1.getBoolean("isActive");

                    // Step 3: Fetch Pond details
                    Pond pond = new Pond();
                    String sql2 = "SELECT PondID, PondName FROM dbo.Ponds WHERE PondID = ?";
                    stmt2 = cn.prepareStatement(sql2);
                    stmt2.setInt(1, pondID);
                    rs2 = stmt2.executeQuery();

                    if (rs2.next()) {
                        pond.setPondID(rs2.getInt("PondID"));
                        pond.setName(rs2.getString("PondName"));
                    }

                    // Step 4: Fetch Water Parameter Details
                    ArrayList<WaterParameterDetail> details = new ArrayList<>();
                    String sql3 = "SELECT ID, WaterParameterDescID, value FROM dbo.WaterParameterDetail WHERE WaterParameterID = ?";
                    stmt3 = cn.prepareStatement(sql3);
                    stmt3.setInt(1, waterParameterID);
                    rs3 = stmt3.executeQuery();

                    while (rs3.next()) {
                        int id = rs3.getInt("ID");
                        int waterParameterDescID = rs3.getInt("WaterParameterDescID");
                        double value = rs3.getDouble("value");

                        // Step 5: Fetch Water Parameter Description
                        WaterParameterDescription waterDesc = null;
                        String sql4 = "SELECT WaterParameterDescID, [name], [symbol], minValue, maxValue, [unit], optimalRange, [description] "
                                + "FROM dbo.WaterParameterDescription WHERE WaterParameterDescID = ?";
                        stmt4 = cn.prepareStatement(sql4);
                        stmt4.setInt(1, waterParameterDescID);
                        rs4 = stmt4.executeQuery();

                        if (rs4.next()) {
                            waterDesc = new WaterParameterDescription(
                                    rs4.getInt("WaterParameterDescID"),
                                    rs4.getString("name"),
                                    rs4.getString("symbol"),
                                    rs4.getDouble("minValue"),
                                    rs4.getDouble("maxValue"),
                                    rs4.getString("unit"),
                                    rs4.getString("optimalRange"),
                                    rs4.getString("description")
                            );
                        }

                        // Create a WaterParameterDetail object and add it to the details list
                        WaterParameterDetail detail = new WaterParameterDetail(
                                id, waterParameterID, waterParameterDescID, value, waterDesc
                        );
                        details.add(detail);
                    }

                    // Step 6: Create and add WaterParameter object to the list
                    WaterParameter waterParameter = new WaterParameter(
                            waterParameterID, accID, pondID, measurementDate, note, isActive, pond, details
                    );
                    listParameters.add(waterParameter);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs4 != null) {
                    rs4.close();
                }
                if (stmt4 != null) {
                    stmt4.close();
                }
                if (rs3 != null) {
                    rs3.close();
                }
                if (stmt3 != null) {
                    stmt3.close();
                }
                if (rs2 != null) {
                    rs2.close();
                }
                if (stmt2 != null) {
                    stmt2.close();
                }
                if (rs1 != null) {
                    rs1.close();
                }
                if (stmt1 != null) {
                    stmt1.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listParameters;
    }

    public WaterParameter getWaterParameterByID(int waterParameterID) {
        Connection cn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        PreparedStatement stmt4 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;
        WaterParameter waterParameter = null;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                // Step 1: Fetch Water Parameter for the given WaterParameterID
                String sql1 = "SELECT AccID, PondID, MeasurementDate, Note, isActive "
                        + "FROM dbo.WaterParameter "
                        + "WHERE WaterParameterID = ?";
                stmt1 = cn.prepareStatement(sql1);
                stmt1.setInt(1, waterParameterID);
                rs1 = stmt1.executeQuery();

                if (rs1.next()) {
                    int accID = rs1.getInt("AccID");
                    int pondID = rs1.getInt("PondID");
                    LocalDateTime measurementDate = rs1.getTimestamp("MeasurementDate").toLocalDateTime();
                    String note = rs1.getString("Note");
                    boolean isActive = rs1.getBoolean("isActive");

                    // Step 2: Fetch Pond details
                    Pond pond = new Pond();
                    String sql2 = "SELECT PondID, PondName FROM dbo.Ponds WHERE PondID = ?";
                    stmt2 = cn.prepareStatement(sql2);
                    stmt2.setInt(1, pondID);
                    rs2 = stmt2.executeQuery();

                    if (rs2.next()) {
                        pond.setPondID(rs2.getInt("PondID"));
                        pond.setName(rs2.getString("PondName"));
                    }

                    // Step 3: Fetch Water Parameter Details
                    ArrayList<WaterParameterDetail> details = new ArrayList<>();
                    String sql3 = "SELECT ID, WaterParameterDescID, value FROM dbo.WaterParameterDetail WHERE WaterParameterID = ?";
                    stmt3 = cn.prepareStatement(sql3);
                    stmt3.setInt(1, waterParameterID);
                    rs3 = stmt3.executeQuery();

                    while (rs3.next()) {
                        int id = rs3.getInt("ID");
                        int waterParameterDescID = rs3.getInt("WaterParameterDescID");
                        double value = rs3.getDouble("value");

                        // Step 4: Fetch Water Parameter Description
                        WaterParameterDescription waterDesc = null;
                        String sql4 = "SELECT WaterParameterDescID, [name], [symbol], minValue, maxValue, [unit], optimalRange, [description] "
                                + "FROM dbo.WaterParameterDescription WHERE WaterParameterDescID = ?";
                        stmt4 = cn.prepareStatement(sql4);
                        stmt4.setInt(1, waterParameterDescID);
                        rs4 = stmt4.executeQuery();

                        if (rs4.next()) {
                            waterDesc = new WaterParameterDescription(
                                    rs4.getInt("WaterParameterDescID"),
                                    rs4.getString("name"),
                                    rs4.getString("symbol"),
                                    rs4.getDouble("minValue"),
                                    rs4.getDouble("maxValue"),
                                    rs4.getString("unit"),
                                    rs4.getString("optimalRange"),
                                    rs4.getString("description")
                            );
                        }

                        // Create a WaterParameterDetail object and add it to the details list
                        WaterParameterDetail detail = new WaterParameterDetail(
                                id, waterParameterID, waterParameterDescID, value, waterDesc
                        );
                        details.add(detail);
                    }

                    // Step 5: Create WaterParameter object
                    waterParameter = new WaterParameter(
                            waterParameterID, accID, pondID, measurementDate, note, isActive, pond, details
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (rs4 != null) {
                    rs4.close();
                }
                if (stmt4 != null) {
                    stmt4.close();
                }
                if (rs3 != null) {
                    rs3.close();
                }
                if (stmt3 != null) {
                    stmt3.close();
                }
                if (rs2 != null) {
                    rs2.close();
                }
                if (stmt2 != null) {
                    stmt2.close();
                }
                if (rs1 != null) {
                    rs1.close();
                }
                if (stmt1 != null) {
                    stmt1.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return waterParameter;
    }

    public boolean addNewWaterParameter(WaterParameter waterParameter) {
        Connection cn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        ResultSet generatedKeys = null;
        boolean result = false;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                // Step 1: Insert data into WaterParameter table
                String sqlWaterParameter = "INSERT INTO dbo.WaterParameter "
                        + "(AccID, PondID, MeasurementDate, Note, isActive) "
                        + "VALUES (?, ?, ?, ?, ?)";
                stmt1 = cn.prepareStatement(sqlWaterParameter, Statement.RETURN_GENERATED_KEYS);
                stmt1.setInt(1, waterParameter.getAccID());
                stmt1.setInt(2, waterParameter.getPondID());  
                stmt1.setTimestamp(3, Timestamp.valueOf(waterParameter.getMeasurementDate()));
                stmt1.setString(4, waterParameter.getNote());
                stmt1.setInt(5, waterParameter.isIsActive() ? 1 : 0); // 1 for true, 0 for false

                // Execute the insert and retrieve the generated WaterParameterID
                int rowsAffected = stmt1.executeUpdate();
                if (rowsAffected == 0) {
                    return false; 
// No rows inserted
                }

                generatedKeys = stmt1.getGeneratedKeys();
                int waterParameterID = 0;
                if (generatedKeys.next()) {
                    waterParameterID = generatedKeys.getInt(1); // Get the generated WaterParameterID
                }

                // Step 2: Insert data into WaterParameterDetail table
                String sqlWaterParameterDetail = "INSERT INTO dbo.WaterParameterDetail "
                        + "(WaterParameterID, WaterParameterDescID, value) "
                        + "VALUES (?, ?, ?)";
                stmt2 = cn.prepareStatement(sqlWaterParameterDetail);

                // Loop through all WaterParameterDetail objects from waterParameter
                for (WaterParameterDetail detail : waterParameter.getWaterParameterDetails()) {
                    stmt2.setInt(1, waterParameterID); // Set WaterParameterID
                    stmt2.setInt(2, detail.getWaterParameterDescID()); // Set WaterParameterDescID
                    if (detail.getValue() != null) {
                        stmt2.setDouble(3, detail.getValue()); // Set value if it's not null
                    } else {
                        stmt2.setNull(3, Types.DOUBLE); // Set value to null if it's null
                    }
                    stmt2.addBatch(); // Add to batch
                }

                // Execute batch insert
                int[] rowsAffectedDetail = stmt2.executeBatch();
                if (rowsAffectedDetail.length == waterParameter.getWaterParameterDetails().size()) {
                    result = true; // Successfully inserted all details
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
                if (stmt2 != null) {
                    stmt2.close();
                }
                if (stmt1 != null) {
                    stmt1.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
