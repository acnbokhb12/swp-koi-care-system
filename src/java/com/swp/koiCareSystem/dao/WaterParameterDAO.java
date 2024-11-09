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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

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
                    desc.setMinValue(rs.getFloat("minValue"));
                    desc.setMaxValue(rs.getFloat("maxValue"));
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
                        float value = rs3.getFloat("value");

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
                                    rs4.getFloat("minValue"),
                                    rs4.getFloat("maxValue"),
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
                        float value = rs3.getFloat("value");

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
                                    rs4.getFloat("minValue"),
                                    rs4.getFloat("maxValue"),
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

    public boolean createNewWaterParameter(WaterParameter waterParameter) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int rowEffectV2 = 0;
        System.out.println(waterParameter);
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "insert into [dbo].[WaterParameter] ([AccID],[PondID],[MeasurementDate],[Note]) values (?,?, ?, ? )";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, waterParameter.getAccID());
                pst.setInt(2, waterParameter.getPondID());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formatDateMeasure = waterParameter.getMeasurementDate().format(formatter);
                pst.setString(3, formatDateMeasure);
                pst.setString(4, waterParameter.getNote());
                int rowEffect1 = pst.executeUpdate();
                if (rowEffect1 > 0) {
                    String sql2 = "select TOP 1 [WaterParameterID]\n"
                            + "from WaterParameter order by [WaterParameterID] desc";
                    PreparedStatement pst2 = cn.prepareStatement(sql2);
                    ResultSet rs2 = pst2.executeQuery();
                    if (rs2 != null && rs2.next()) {
                        int WaterParameterId = rs2.getInt(1);
                        cn.setAutoCommit(false);
                        for (WaterParameterDetail wtdt : waterParameter.getWaterParameterDetails()) {
                            String sql3 = "INSERT INTO dbo.WaterParameterDetail \n"
                                    + "(WaterParameterID, WaterParameterDescID, [value]) VALUES (?, ?, ?)";
                            PreparedStatement pst3 = cn.prepareStatement(sql3);
                            pst3.setInt(1, WaterParameterId);
                            pst3.setInt(2, wtdt.getWaterParameterDescID());
                            if (wtdt.getValue() != 0.0) {
                                pst3.setFloat(3, wtdt.getValue());
                            } else {
                                pst3.setNull(3, java.sql.Types.FLOAT);
                            }
                            rowEffectV2 = pst3.executeUpdate();
                            pst3.close();
                        }
                    }
                    cn.commit();
                    if (rowEffectV2 > 0) {
                        return true;
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

    public ArrayList<WaterParameterDescription> getListWaterDeailToStaticticsByUnit(int accId, int pondId, String unit) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<WaterParameterDescription> listDateStatisticByUnit = new ArrayList<>();
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select * from WaterParameterDescription where unit = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, unit);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        WaterParameterDescription wtdesc = new WaterParameterDescription();
                        int idWaterDesc = rs.getInt(1);
                        wtdesc.setWaterParameterDescID(idWaterDesc);
                        wtdesc.setName(rs.getString(2));
                        wtdesc.setSymbol(rs.getString(3));
                        wtdesc.setUnit(rs.getString(4));

                        String sql2 = "SELECT value\n"
                                + "from(\n"
                                + "select TOP 10 wtdt.[value] ,wt.MeasurementDate  from WaterParameter wt inner join WaterParameterDetail wtdt on wt.WaterParameterID = wtdt.WaterParameterID \n"
                                + "                                inner join WaterParameterDescription wtdesc on wtdt.WaterParameterDescID = wtdesc.WaterParameterDescID\n"
                                + "where [AccID] = ? and [PondID] = ? and [isActive] = 1 and unit = ? and wtdt.WaterParameterDescID = ? order by wt.MeasurementDate desc\n"
                                + ")AS RecentDates\n"
                                + "ORDER BY MeasurementDate ASC;";
                        PreparedStatement pst2 = cn.prepareStatement(sql2);
                        pst2.setInt(1, accId);
                        pst2.setInt(2, pondId);
                        pst2.setString(3, unit);
                        pst2.setInt(4, idWaterDesc);
                        ResultSet rs2 = pst2.executeQuery();
                        if (rs2 != null) {
                            while (rs2.next()) {
                                WaterParameterDetail wtdetail = new WaterParameterDetail();
                                float value = rs2.getFloat(1);
                                wtdetail.setValue(value);
                                wtdesc.addValueWaterParameterDetail(wtdetail);
                            }
                        }
                        listDateStatisticByUnit.add(wtdesc);
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
        return listDateStatisticByUnit;
    }

    public ArrayList<WaterParameter> getLatesDateToStatistics(int accId, int pondId) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<WaterParameter> listgetLatesDateToStatistics = new ArrayList<>();
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT MeasurementDate \n"
                        + "FROM (\n"
                        + "    SELECT TOP 10 MeasurementDate  \n"
                        + "    FROM WaterParameter \n"
                        + "    WHERE [AccID] = ? AND [PondID] = ? AND [isActive] = 1 \n"
                        + "    ORDER BY MeasurementDate DESC\n"
                        + ") AS RecentDates\n"
                        + "ORDER BY MeasurementDate ASC;";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, accId);
                pst.setInt(2, pondId);
                rs = pst.executeQuery();
                if (rs != null) {
                    while(rs.next()){
                        WaterParameter wt = new WaterParameter();
                        LocalDateTime measurementDate = rs.getTimestamp("MeasurementDate").toLocalDateTime();
                        wt.setMeasurementDate(measurementDate);
                        listgetLatesDateToStatistics.add(wt);
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
        return listgetLatesDateToStatistics;
    }

    public static void main(String[] args) {
        WaterParameterDAO wpt = new WaterParameterDAO();
        ArrayList<WaterParameterDescription> list = wpt.getListWaterDeailToStaticticsByUnit(5, 1, "mg/l");
//        ArrayList<WaterParameter> list = wpt.getLatesDateToStatistics(5, 1);
for (WaterParameterDescription item : list) {
            System.out.println(item);
        }
    }
}
