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
import java.sql.Date;
import java.util.Calendar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Khanh
 */
public class BlogDAO {

    

    //đếm số lượng blog trong db
    public int countBlog() {
        Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
        String sql = "select count(*) from Blogs";
        try {
            c = DatabaseConnectionManager.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countBlogByCate(int IDBlogCate) {
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

    public ArrayList<Blog> getBlogByCateId(int catBlogId, int index) {
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

    public ArrayList<Blog> getBlogsByCateId(String cid, int index) {
        Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
        ArrayList<Blog> listB = new ArrayList<>();
        int distance = (index - 1) * 8;
        try {
            c = DatabaseConnectionManager.getConnection();
            if (c != null) {
                String sql = "select b.BlogID, b.AccID, acc.FullName, acc.UserImage, b.BlogsDate, b.BlogsImage, b.Title, b.Content, b.IDBlogCate, ctb.NameBlogCate from Blogs b \n"
                        + "inner join CategoryBlog ctb on b.IDBlogCate = ctb.IDBlogCate inner join Accounts acc on b.AccID = acc.AccID \n"
                        + "where b.isActive = 1 and ctb.IDBlogCate = ? order by BlogID offset ? rows fetch next 8 rows only";
                ps = c.prepareStatement(sql);
                ps.setString(1, cid );
                ps.setInt(2, distance);
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

    public int countBlogByCateId(String cid) {
        Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
        try {
            c = DatabaseConnectionManager.getConnection();
            if (c != null) {
                String sql = "select count(*) from CategoryBlog where IDBlogCate = ?";
                ps = c.prepareStatement(sql);
                ps.setString(1, cid);
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

    public ArrayList<Blog> pagingCount(int index) {
        Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
        ArrayList<Blog> list = new ArrayList<>();

        String sql = "select b.BlogID, b.AccID, acc.FullName, acc.UserImage, b.BlogsDate, b.BlogsImage, b.Title, b.Content, b.IDBlogCate, ctb.NameBlogCate \n"
                + "from Blogs b \n"
                + "inner join CategoryBlog ctb on b.IDBlogCate = ctb.IDBlogCate \n"
                + "inner join Accounts acc on b.AccID = acc.AccID \n"
                + "where b.isActive = 1"
                + "order by BlogID \n"
                + "offset ? rows fetch next 8 rows only";
        try {
            c = DatabaseConnectionManager.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 8);
            rs = ps.executeQuery();
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
                list.add(bl);
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
        return list;
    }

    public boolean createNewBlog(Blog newBlog) {
        Connection c = null;
    PreparedStatement ps = null;
        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "INSERT INTO Blogs (AccID, IDBlogCate, Title, Content, BlogsImage, BlogsDate) VALUES (?, ?, ?, ?, ?, ?)";
            ps = c.prepareStatement(sql);
            ps.setInt(1, newBlog.getUserID() );
            ps.setInt(2, newBlog.getBlogCateId());
            ps.setString(3, newBlog.getTitle());
            ps.setString(4, newBlog.getContent());
            ps.setString(5, newBlog.getBlogImage());
            ps.setDate(6, newBlog.getBlogDate());
            

            // Execute the update
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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
        return false; 
    }
    
    public boolean deleteBlogByID(int blogID){
        Connection c = null;
        PreparedStatement ps = null;
        
        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "UPDATE [dbo].[Blogs] SET [isActive] = 0  WHERE [BlogID] = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1, blogID);

            int affectedRows = ps.executeUpdate();
            
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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
        return false;
    }

    public static void main(String[] args) {
        BlogDAO blogDAO = new BlogDAO();
        
        int blogID = 21;
        boolean isDeleted = blogDAO.deleteBlogByID(blogID);
//        System.out.println(blogID);
if (isDeleted) {
        System.out.println("Blog with ID " + blogID + " was successfully deleted.");
    } else {
        System.out.println("Failed to delete blog with ID " + blogID);
    }
        
//        Blog newBlog = new Blog();
//        newBlog.setUserID(1);  // Set a sample user ID
//        newBlog.setBlogCateId(2);  // Set a sample Blog Category ID
//        newBlog.setTitle("My New Blog Post");
//        newBlog.setContent("This is the content of my new blog post.");
//        newBlog.setBlogImage("image1.png");  // Sample blog image
//        newBlog.setBlogDate(new java.sql.Date(System.currentTimeMillis()));  // Set current date
//
//        // Test the createNewBlog() method
//        boolean isCreated = blogDAO.createNewBlog(newBlog);
//
//        System.out.println(newBlog);
//        ArrayList<BlogCategory> b = blogDAO.getAllBlogCategory();
        //ArrayList<Blog> list = blogDAO.SearchBlogByCateName("2", 1);
//        ArrayList<Blog> list = blogDAO.pagingCount(2);
//        int count = blogDAO.CountBlog();
//        System.out.println(list);

//        for (Blog o : list) {
//            System.out.println(o);
//        }
    }

}
