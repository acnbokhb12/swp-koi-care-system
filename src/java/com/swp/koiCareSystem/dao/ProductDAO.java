/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ProductDAO {
    public ArrayList<Product> GetAllProduct() throws SQLException{
        ArrayList<Product> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                String sql = "SELECT p.ProductImage, p.ProductName, p.Description, cp.CategoryName, p.Price  "
                            + "FROM Products p JOIN CategoryProduct cp ON p.CategoryID = cp.CategoryID ";
                ptm = conn.prepareStatement(sql);
                rs = ptm.executeQuery();
                while (rs.next()) {                    
                    String ProductImage = rs.getString("imageP");
                    String ProductName = rs.getString("nameP");
                    String Description = rs.getString("description");
                    String categoryName = rs.getString("catgoryName");
                    float Price = rs.getFloat("price");
                    list.add(new Product(0, 0, ProductName, ProductName, Description, Price));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
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
        return list;
    }   
}
