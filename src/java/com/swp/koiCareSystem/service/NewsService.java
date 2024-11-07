/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.NewsDAO;
import com.swp.koiCareSystem.model.News;
import com.swp.koiCareSystem.model.NewsCategory;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Khanh
 */
public class NewsService {

    private final NewsDAO ndao = new NewsDAO();

    public ArrayList<NewsCategory> getAllNewsCategory() {
        ArrayList<NewsCategory> listNC = ndao.getAllNewsCategory();
        return listNC;
    }

    public ArrayList<News> GetAllNews(int index) {
        return ndao.getAllNews(index);
    }

    public boolean createNews(News news) {
        LocalDateTime currentDateTime = LocalDateTime.now().withNano(0);  // Xóa phần nano giây
        java.sql.Timestamp sqlTimestamp = Timestamp.valueOf(currentDateTime);
        String time = sqlTimestamp.toString().split("\\.")[0];
        return ndao.createNews(news, time);
    }

    public int countAllNews() {
        return ndao.countAllNews();
    }

    public ArrayList<News> getNewsDetail(int newsId) {
        return ndao.getNewsDetail(newsId);
    }

    public boolean adminDeleteNewsById(String newsId) {
        return ndao.deleteNewsById(newsId);
    }

    public ArrayList<News> searchNewsByCate(String newsCate, int index) {
        return ndao.searchNewsCategory(newsCate, index);
    }

    public int countNewsByCategoryID(int category) {
        return ndao.countNewsByCategoryID(category);
    }

    public ArrayList<News> adminSearchNewsByTitle(String title, int index) {
        return ndao.adminSearchNewsByTitle(title, index);
    }

    public int countNewsByTitle(String title) {
        return ndao.countNewsByTitle(title);
    }

    public ArrayList<News> getNewsLatest() {
        return ndao.getNewsLatest();
    }
    
    public ArrayList<News> getListNewsSpecialByCateId(int idCate){
        return ndao.getListNewsSpecialByCateId(idCate);
    }
    
    public ArrayList<News> getNormalNewsList(int index){
        return ndao.getNormalNewsList(index);
    }
    
    public int countNormalNewsList(){
        return ndao.countNormalNewsList();
    }
    
    public ArrayList<News> getNewsInNewsDetail(){
        return ndao.getNewsListInNewsDetail();
    }
    
    public ArrayList<News> getRandomNews(){
        return ndao.randomNews();
    }
    
    public ArrayList<News> getLatestNewsInHome(){
        return ndao.getLatestNewsInHome();
    }
    
    public static void main(String[] args) {
        NewsService nsv = new NewsService();

//        ArrayList<News> list = nsv.showNewsByCate("Events");
//        if (list.isEmpty()) {
//            System.out.println("Danh sách không có tin tức.");
//        } else {
//            for (News news : list) {
//                // In ra thông tin của mỗi tin tức
//                System.out.println("News ID: " + news.getNewsID());
//                System.out.println("Title: " + news.getTitle());
//                System.out.println("Category ID: " + news.getNewsCategory().getId());
//                System.out.println("Category Name: " + news.getNewsCategory().getName());
//                System.out.println("News Image: " + news.getNewsImage());
//                System.out.println("-------------------------------");
//            }
//        }
//        int day = 20;
//        int month = 11;
//        Integer year = null;
//
//        int index = 1;
//
//        ArrayList<News> list = nsv.adminSearchNewsByDate(day, month, year, index);
//        System.out.println(list);
//        ArrayList<News> list = nsv.adminSearchNewsByTitle("koi", 2);
//
//        for (News news : list) {
//            System.out.println(news);
//        }

//        String category = "Pond"; // Thay bằng tên chuyên mục bạn muốn kiểm tra
//        int count = nsv.countNewsByCategory(category);
//        System.out.println("Số lượng bài viết trong chuyên mục '" + category + "': " + count);
//        ArrayList<News> list = nsv.searchNewsByCate("Water Parameter Control", 1);
//
//        for (News news : list) {
//            System.out.println(news);
//        }
//        String newsId = "42";
//        boolean isDeleted = nsv.adminDeleteNewsById(newsId);
////        System.out.println(blogID);
//        if (isDeleted) {
//            System.out.println("Blog with ID " + newsId + " was successfully deleted.");
//        } else {
//            System.out.println("Failed to delete blog with ID " + newsId);
//        }
//        News news = new News(); // Tạo một đối tượng News
//        news.setTitle("Tiêu đề tin tức ádsadasddsa");
//        news.setNewsDescription("Mô tả tin tức");
//        news.setNewsImage("link_đến_hình_ảnh");
//        news.setNewsCategoryID(1);
//        boolean is = nsv.createNews(news);
//        System.out.println(is);
//            ArrayList<News> list = nsv.GetAllNews(1);
//            for (News news : list) {
//            System.out.println(news);
//        }
//        ArrayList<News> newsList = nsv.GetAllNews(1);
//
//            System.out.println(newsList);
//        int newsId = 1;
//       ArrayList<News> list = nsv.getNewsDetail(newsId);
//        System.out.println(list);
    }
}
