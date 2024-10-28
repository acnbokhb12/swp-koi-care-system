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
    
    public int countAllNews(){
        return ndao.countAllNews();
    }

    public static void main(String[] args) {
        NewsService nsv = new NewsService();
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
        ArrayList<News> newsList = nsv.GetAllNews(1);

            System.out.println(newsList);
    }
}
