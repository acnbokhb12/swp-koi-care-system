/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Blog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Khanh
 */
public class BlogDAO {
    
    public int CountBlog(){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DatabaseConnectionManager.getConnection();
            if(c != null){
                String sql = "select count(*) from Blogs";
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                if(rs != null && rs.next()){
                    return rs.getInt(1);
                }
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
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    
    public int CountBlogByCate(int IDBlogCate) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DatabaseConnectionManager.getConnection();
            if (c != null) {
                String sql = "select count(*) from Blogs where [IDBlogCate] = ?";
                ps = c.prepareStatement(sql);
                ps.setInt(1, IDBlogCate);
                rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return rs.getInt(1);
                }
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
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    
    public ArrayList<Blog> GetAllBlogs(int index){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList
    }
}
