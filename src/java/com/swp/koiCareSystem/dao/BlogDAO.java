/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.Blog;
import com.swp.koiCareSystem.model.BlogCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Khanh
 */
public class BlogDAO {

    public int CountBlog() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DatabaseConnectionManager.getConnection();
            if (c != null) {
                String sql = "select count(*) from Blogs";
                ps = c.prepareStatement(sql);
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

//    public ArrayList<Blog> GetAllBlogs(int index){
//        Connection c = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        
////        ArrayList
//    }
    public ArrayList<Blog> getAllBlogs(int index) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Blog> listB = new ArrayList<>();
        int distance = (index - 1) * 8;
        try {
            c = DatabaseConnectionManager.getConnection();
            if (c != null) {
                String sql = "select b.BlogID, b.AccID, acc.FullName, acc.UserImage, b.BlogsDate, b.BlogsImage, b.Title, b.Content, b.IDBlogCate, ctb.NameBlogCate \n"
                        + "from [dbo].[Blogs] b \n"
                        + "inner join [dbo].[CategoryBlog] ctb \n"
                        + "on b.IDBlogCate = ctb.IDBlogCate \n"
                        + "inner join [dbo].[Accounts] acc\n"
                        + "on b.AccID = acc.AccID\n"
                        + "where b.isActive = 1\n"
                        + "order by BlogID \n"
                        + "offset ? rows \n"
                        + "fetch next 8 rows only";
                ps = c.prepareStatement(sql);
                ps.setInt(1, distance);
                rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Blog bl = new Blog();
                        BlogCategory bc = new BlogCategory(rs.getInt(9), rs.getString(10));
                        Account acc = new Account();
                        acc.setFullName(rs.getString(3));
                        acc.setProfileImage(rs.getString(4)); 
                        bl.setBlogID(rs.getInt(1));
                        bl.setUserID(rs.getInt(2));
                        bl.setBlogDate(rs.getDate(5));
                        bl.setBlogImage(rs.getString(6));
                        bl.setTitle(rs.getString(7));
                        bl.setContent(rs.getString(8));
                        bl.setBlogCategory(bc);
                        bl.setAccount(acc);
                        listB.add(bl);
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
        return listB;
    }

    public ArrayList<BlogCategory> getAllBlogCategory() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BlogCategory> listBC = new ArrayList<>();
        try {
            c = DatabaseConnectionManager.getConnection();
            if (c != null) {
                String sql = "select * from CategoryBlog";
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        listBC.add(new BlogCategory(rs.getInt(1), rs.getString(2)));
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
        return listBC;
    }

    public ArrayList<Blog> GetBlogByCateId(int catBlogId, int index) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Blog> listB = new ArrayList<>();
        int distance = (index - 1) * 5;
        try {
            c = DatabaseConnectionManager.getConnection();
            if (c != null) {
                String sql = "select * \n"
                        + "from Blogs b \n"
                        + "inner join CategoryBlog ctb \n"
                        + "on b.IDBlogCate = ctb.IDBlogCate \n"
                        + "where b.isActive = 1\n"
                        + "order by BlogID offset ? rows \n"
                        + "fetch next 5 rows only";
                ps = c.prepareStatement(sql);
                ps.setInt(1, catBlogId);
                ps.setInt(2, distance);
                rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Blog bl = new Blog();
                        BlogCategory bc = new BlogCategory(rs.getInt(8), rs.getString(9));
                        bl.setBlogID(rs.getInt(1));
                        bl.setTitle(rs.getString(4));
                        bl.setContent(rs.getString(5));
                        bl.setBlogImage(rs.getString(6));
                        bl.setBlogDate(rs.getDate(7));
                        bl.setBlogCategory(bc);
                        listB.add(bl);
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
        return listB;
    }

    public static void main(String[] args) {
        BlogDAO blogDAO = new BlogDAO();
        ArrayList<Blog> b = blogDAO.getAllBlogs(1);

        for (Blog blog : b) {
            System.out.println(blog);
        }
    }

}
