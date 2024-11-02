/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.FeedPercentage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CaculatorDAO {

    public ArrayList<String> getListGrowthMode() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<String> growthMode = new ArrayList<>();
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "SELECT DISTINCT GrowthMode,\n"
                        + "    CASE \n"
                        + "        WHEN GrowthMode = 'Low' THEN 1\n"
                        + "        WHEN GrowthMode = 'Medium' THEN 2\n"
                        + "        WHEN GrowthMode = 'High' THEN 3\n"
                        + "    END AS SortOrder\n"
                        + "FROM FeedPercentage\n"
                        + "ORDER BY SortOrder;";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        growthMode.add(rs.getString(1));
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
        return growthMode;
    }

    public ArrayList<FeedPercentage> getMinToMaxTemperature() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String growthMode = "";
        ArrayList<FeedPercentage> minMaxTemp = new ArrayList<>();
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select top 1 GrowthMode from FeedPercentage";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    growthMode = rs.getString(1);
                    String sql2 = "select TempuratureMin, TempuratureMax from FeedPercentage where GrowthMode = ?";
                    PreparedStatement pst2 = cn.prepareStatement(sql2);
                    pst2.setString(1, growthMode);
                    ResultSet rs2 = pst2.executeQuery();
                    if (rs2 != null) {
                        while (rs2.next()) {
                            FeedPercentage fp = new FeedPercentage();
                            fp.setTemperatureMin(rs2.getInt(1));
                            fp.setTemperatureMax(rs2.getInt(2));
                            minMaxTemp.add(fp);
                        }
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
        return minMaxTemp;
    }

    public float getPercenttageWithTempAndGrmode(String growthMode, float temperature) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select [Percentage] \n"
                        + "from [dbo].[FeedPercentage] \n"
                        + "where [GrowthMode] = ? and [TempuratureMin] < ? and [TempuratureMax] > ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, growthMode);
                pst.setFloat(2, temperature);
                pst.setFloat(3, temperature);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    return rs.getFloat(1);
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
        return 0;
    }

    public static void main(String[] args) {
        CaculatorDAO cld = new CaculatorDAO();
        ArrayList<String> list = cld.getListGrowthMode();
//    float item = cld.getPercenttageWithTempAndGrmode("Low", (float) 18.5);
//        ArrayList<FeedPercentage> list = cld.getMinToMaxTemperature();
        for (String i : list) {
            System.out.println(i);
        }
//System.out.println(item);
    }
}
