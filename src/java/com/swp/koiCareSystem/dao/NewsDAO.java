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
import com.swp.koiCareSystem.model.News;
import com.swp.koiCareSystem.model.NewsCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Khanh
 */
public class NewsDAO {

    public ArrayList<NewsCategory> getAllNewsCategory() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<NewsCategory> listNC = new ArrayList<>();
        try {
            c = DatabaseConnectionManager.getConnection();
            if (c != null) {
                String sql = "select * from newsCategory ";
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        listNC.add(new NewsCategory(rs.getInt(1), rs.getString(2)));
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
        return listNC;
    }

    public ArrayList<News> getAllNews(int index) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<News> listN = new ArrayList<>();
        int distance = (index - 1) * 10;
        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select n.NewsID, n.Title, nc.newsCategoryID, nc.name, n.NewsDate, n.isActive\n"
                    + "                    from [dbo].[News] n inner join [dbo].[newsCategory] nc \n"
                    + "					on n.newsCategoryID = nc.newsCategoryID\n"
                    + "					where n.isActive = 1\n"
                    + "					order by n.NewsID DESC\n"
                    + "					offset ? rows fetch next 10 rows only";
            ps = c.prepareStatement(sql);
            ps.setInt(1, distance);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    News n = new News();
                    NewsCategory nc = new NewsCategory(rs.getInt(3), rs.getString(4));
                    n.setNewsID(rs.getInt(1));
                    n.setTitle(rs.getString(2));
                    n.setNewsDate(rs.getTimestamp(5));
                    n.setIsActive(true);
                    n.setNewsCategory(nc);
                    listN.add(n);
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
        return listN;
    }

    public boolean createNews(News news, String time) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "INSERT INTO News (Title, NewsDescription, NewsImage, NewsDate, newsCategoryID) values (?,?,?,?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getNewsDescription());
            ps.setString(3, news.getNewsImage());
            ps.setString(4, time);
            ps.setInt(5, news.getNewsCategoryID());

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

    public int countAllNews() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select count(*) from News where [isActive] = 1";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
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

    public ArrayList<News> pagingCount(int index) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<News> list = new ArrayList<>();

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select n.NewsID, n.Title, nc.name, n.NewsDate, n.isActive\n"
                    + "from [dbo].[News] n inner join [dbo].[newsCategory] nc \n"
                    + "on n.newsCategoryID = nc.newsCategoryID\n"
                    + "order by n.NewsID\n"
                    + "offset ? rows fetch next 10 rows only";
            ps = c.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                News n = new News();
                NewsCategory nc = new NewsCategory();
                n.setNewsID(rs.getInt(1));
                n.setTitle(rs.getString(2));
                nc.setName(rs.getString(3));
                n.setNewsDate(rs.getTimestamp(4));
                n.setIsActive(true);
                list.add(n);
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

    public ArrayList<News> getNewsDetail(int newsId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<News> list = new ArrayList<>();

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select n.Title, n.NewsDate, nc.newsCategoryID, nc.name, n.NewsImage, n.NewsDescription\n"
                    + "from [dbo].[News] n \n"
                    + "inner join [dbo].[newsCategory] nc \n"
                    + "on n.newsCategoryID = nc.newsCategoryID "
                    + "where n.NewsID = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1, newsId);
            rs = ps.executeQuery();
            while (rs.next()) {
                News n = new News();
                NewsCategory nc = new NewsCategory(rs.getInt(3), rs.getString(4));
                n.setTitle(rs.getString(1));
                n.setNewsDate(rs.getTimestamp(2));
                n.setNewsImage(rs.getString(5));
                n.setNewsDescription(rs.getString(6));
                n.setNewsCategory(nc);
                list.add(n);
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

    public boolean deleteNewsById(String newsId) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "UPDATE [dbo].[News] SET [isActive] = 0  WHERE [NewsID] = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1, newsId);

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
        NewsDAO ndao = new NewsDAO();


//        int newsId = 2;
//        ArrayList<News> list = ndao.getNewsDetail(newsId);
//        System.out.println(list);
//        ArrayList<News> newsList = ndao.getAllNews(1);
//        System.out.println(newsList);
//        ArrayList<News> list = ndao.pagingCount(1);
//        System.out.println(list);
//        int count = ndao.countAllNews();
//        System.out.println(count);
//        ArrayList<NewsCategory> nc = ndao.getAllNewsCategory();
//        System.out.println(nc);
//        News news = new News(); // Tạo một đối tượng News
//        news.setTitle("Tiêu đề tin tức");
//        news.setNewsDescription("Mô tả tin tức");
//        news.setNewsImage("link_đến_hình_ảnh");
//        // Thiết lập thời gian hiện tại mà không có phần nano giây
//        LocalDateTime currentDateTime = LocalDateTime.now().withNano(0);
//        news.setNewsDate(Timestamp.valueOf(currentDateTime)); // Lưu trữ với định dạng đã làm tròn
//
//        news.setNewsCategoryID(2); // ID danh mục
//        System.out.println(news);
//        boolean result = ndao.createNews(news);
//        System.out.println("Tin tức đã được tạo: " + result);
    }
}
