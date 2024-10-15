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

    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //đếm số lượng blog trong db
    public int countBlog() {
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

    public boolean createNewBlog(Blog b) {
        boolean checkInsert = false;
        try {
            c = DatabaseConnectionManager.getConnection();
            if (c != null) {
                String sql = "insert into Blogs(AccID, IDBlogCate, Title, Content, BlogsImage, BlogsDate) "
                        + "values (?, ?, ?, ?, ?, ?, ?)";
                ps = c.prepareStatement(sql);
                ps.setInt(1, b.getBlogID());
                ps.setInt(2, b.getBlogCateId());
                ps.setString(3, b.getTitle());
                ps.setString(4, b.getContent());
                ps.setString(5, b.getBlogImage());
                ps.setDate(6, b.getBlogDate());
                checkInsert = ps.executeUpdate() > 0 ? true : false;
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
        return checkInsert;
    }

    public static void main(String[] args) {
        BlogDAO blogDAO = new BlogDAO();
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
