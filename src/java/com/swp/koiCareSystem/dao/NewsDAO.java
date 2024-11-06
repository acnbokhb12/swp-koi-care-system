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

    public ArrayList<News> searchNewsCategory(String idCate, int index) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<News> listN = new ArrayList<>();

        int distance = (index - 1) * 10;

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select n.NewsID, n.Title,  ctn.name, n.NewsDate, n.isActive\n"
                    + "from [dbo].[News] n inner join [dbo].[newsCategory] ctn \n"
                    + "on n.newsCategoryID = ctn.newsCategoryID\n"
                    + "where n.newsCategoryID = ? and n.[isActive] = 1\n"
                    + "order by n.NewsID\n"
                    + "offset ? rows fetch next 10 rows only";
            ps = c.prepareStatement(sql);

            ps.setString(1, idCate);
            ps.setInt(2, distance);
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    News n = new News();
                    NewsCategory nc = new NewsCategory();
                    n.setNewsID(rs.getInt(1));
                    n.setTitle(rs.getString(2));
                    nc.setName(rs.getString(3));
                    n.setNewsDate(rs.getTimestamp(4));
                    n.setIsActive(rs.getBoolean(5));
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

    public int countNewsByCategoryID(int category) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DatabaseConnectionManager.getConnection();
            if (c != null) {
                String sql = "select count(*) from News where [newsCategoryID] = ? and [isActive] = 1";
                ps = c.prepareStatement(sql);
                ps.setInt(1, category);
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

    public ArrayList<News> adminSearchNewsByTitle(String title, int index) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<News> listN = new ArrayList<>();

        int distance = (index - 1) * 10;

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select n.NewsID, n.Title, ctn.name, n.NewsDate, n.isActive \n"
                    + "from [dbo].[News] n inner join [dbo].[newsCategory] ctn \n"
                    + "on n.newsCategoryID = ctn.newsCategoryID\n"
                    + "where  n.Title like ? and n.isActive = 1\n"
                    + "order by n.NewsID DESC \n"
                    + "offset ? rows fetch next 10 rows only";
            ps = c.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");
            ps.setInt(2, distance);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    News n = new News();
                    NewsCategory nc = new NewsCategory();
                    n.setNewsID(rs.getInt(1));
                    n.setTitle(rs.getString(2));
                    nc.setName(rs.getString(3));
                    n.setNewsDate(rs.getTimestamp(4));
                    n.setIsActive(rs.getBoolean(5));
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

    public int countNewsByTitle(String title) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DatabaseConnectionManager.getConnection();
            if (c != null) {
                String sql = "SELECT COUNT(*) \n"
                        + "FROM [dbo].[News] \n"
                        + "WHERE [Title] LIKE ? AND isActive = 1";
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + title + "%");
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

    public ArrayList<News> getNewsLatest() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<News> listN = new ArrayList<>();

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select TOP 9 n.NewsID, n.Title, nc.newsCategoryID, nc.name, n.NewsImage\n"
                    + "from [dbo].[News] n inner join [dbo].[newsCategory] nc \n"
                    + "on n.newsCategoryID = nc.newsCategoryID\n"
                    + "where n.isActive = 1 order by n.NewsID desc";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    News n = new News();
                    NewsCategory nc = new NewsCategory(rs.getInt(3), rs.getString(4));
                    n.setNewsID(rs.getInt(1));
                    n.setTitle(rs.getString(2));
                    n.setNewsImage(rs.getString(5));
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

    public ArrayList<News> getListNewsSpecialByCateId(int idCate) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<News> listN = new ArrayList<>();

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select TOP 10 n.NewsID, n.Title, nc.newsCategoryID, nc.name, n.NewsImage, n.NewsDate\n"
                    + "from [dbo].[News] n inner join [dbo].[newsCategory] nc \n"
                    + "on n.newsCategoryID = nc.newsCategoryID\n"
                    + "where n.isActive = 1 and nc.newsCategoryID = ?\n"
                    + "order by n.NewsID desc";
            ps = c.prepareStatement(sql);
            ps.setInt(1, idCate);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    News n = new News();
                    NewsCategory nc = new NewsCategory(rs.getInt(3), rs.getString(4));
                    n.setNewsID(rs.getInt(1));
                    n.setTitle(rs.getString(2));
                    n.setNewsImage(rs.getString(5));
                    n.setNewsDate(rs.getTimestamp(6));
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

    public ArrayList<News> getNormalNewsList(int index) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<News> listN = new ArrayList<>();

        int distance = (index - 1) * 6;

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select n.NewsID, n.Title, ctn.newsCategoryID, ctn.name, n.NewsImage, n.NewsDate \n"
                    + "from [dbo].[News] n inner join [dbo].[newsCategory] ctn \n"
                    + "on n.newsCategoryID = ctn.newsCategoryID\n"
                    + "where n.isActive = 1\n"
                    + "order by n.NewsID asc \n"
                    + "offset ? rows fetch next 6 rows only";
            ps = c.prepareStatement(sql);
            ps.setInt(1, distance);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    News n = new News();
                    NewsCategory nc = new NewsCategory(rs.getInt(3), rs.getString(4));
                    n.setNewsID(rs.getInt(1));
                    n.setTitle(rs.getString(2));
                    n.setNewsImage(rs.getString(5));
                    n.setNewsDate(rs.getTimestamp(6));
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

    public int countNormalNewsList() {
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

    public ArrayList<News> getNewsListInNewsDetail() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<News> listN = new ArrayList<>();

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select TOP 5 n.NewsID, n.Title, nc.newsCategoryID, nc.name, n.NewsImage\n"
                    + "from [dbo].[News] n inner join [dbo].[newsCategory] nc \n"
                    + "on n.newsCategoryID = nc.newsCategoryID\n"
                    + "where n.isActive = 1 ORDER BY NEWID()";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    News n = new News();
                    NewsCategory nc = new NewsCategory(rs.getInt(3), rs.getString(4));
                    n.setNewsID(rs.getInt(1));
                    n.setTitle(rs.getString(2));
                    n.setNewsImage(rs.getString(5));
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

    public ArrayList<News> randomNews() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<News> listN = new ArrayList<>();

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "SELECT TOP 1 n.NewsID, n.Title, nc.newsCategoryID, nc.name, n.NewsImage\n"
                    + "FROM [dbo].[News] n\n"
                    + "INNER JOIN [dbo].[newsCategory] nc \n"
                    + "ON n.newsCategoryID = nc.newsCategoryID\n"
                    + "ORDER BY NEWID()";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    News n = new News();
                    NewsCategory nc = new NewsCategory(rs.getInt(3), rs.getString(4));
                    n.setNewsID(rs.getInt(1));
                    n.setTitle(rs.getString(2));
                    n.setNewsImage(rs.getString(5));
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

    public static void main(String[] args) {
        NewsDAO ndao = new NewsDAO();

        ArrayList<News> list = ndao.getNewsListInNewsDetail();
        for (News news : list) {
            System.out.println("News ID: " + news.getNewsID());
            System.out.println("Title: " + news.getTitle());
            System.out.println("Category ID: " + news.getNewsCategory().getId());
            System.out.println("Category Name: " + news.getNewsCategory().getName());
            System.out.println("News Image: " + news.getNewsImage());
            System.out.println("-------------------------------");
        }

//        int count = ndao.countNormalNewsList();
//        System.out.println(count);
//        ArrayList<News> list = ndao.getNormalNewsList(1);
//        if (list.isEmpty()) {
//            System.out.println("Danh sách không có tin tức.");
//        } else {
//            for (News news : list) {
//                System.out.println(news);
//                // In ra thông tin của mỗi tin tức
////                System.out.println("News ID: " + news.getNewsID());
////                System.out.println("Title: " + news.getTitle());
////                System.out.println("Category ID: " + news.getNewsCategory().getId());
////                System.out.println("Category Name: " + news.getNewsCategory().getName());
////                System.out.println("News Image: " + news.getNewsImage());
////                sout
////                System.out.println("-------------------------------");
//            }
//        }
//
//        ArrayList<News> list = ndao.searchNewsCategory("1", 1);
//        int count = ndao.countNewsByCategoryID(2);
//        System.out.println(count);
//        ArrayList<NewsCategory> list = ndao.getAllNewsCategory();
//        System.out.println(list);
//        ArrayList<News> list = ndao.adminSearchNewsByTitle("koi", 1);
//
//        for (News news : list) {
//            System.out.println(news);
//        }
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
