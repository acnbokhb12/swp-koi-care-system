/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author Khanh
 */
public class News {
    private int newsID; 
    private String title;
    private String newsDescription;
    private String newsImage;
    private Timestamp newsDate;
    private boolean isActive;
    private int newsCategoryID;
    private NewsCategory newsCategory;

    public News() {
    }

    public News(int newsID, String title, String newsDescription, String newsImage, Timestamp newsDate, boolean isActive, int newsCategoryID, NewsCategory newsCategory) {
        this.newsID = newsID;
        this.title = title;
        this.newsDescription = newsDescription;
        this.newsImage = newsImage;
        this.newsDate = newsDate;
        this.isActive = isActive;
        this.newsCategoryID = newsCategoryID;
        this.newsCategory = newsCategory;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public Timestamp getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Timestamp newsDate) {
        this.newsDate = newsDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getNewsCategoryID() {
        return newsCategoryID;
    }

    public void setNewsCategoryID(int newsCategoryID) {
        this.newsCategoryID = newsCategoryID;
    }

    public NewsCategory getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(NewsCategory newsCategory) {
        this.newsCategory = newsCategory;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(newsDate);
        return "News{" + "newsID=" + newsID + ", title=" + title + ", newsDescription=" + newsDescription + ", newsImage=" + newsImage + ", newsDate=" + formattedDate + ", isActive=" + (isActive ? "true" : "false") + ", newsCategoryID=" + newsCategoryID + ", newsCategory=" + newsCategory + '}';
    }


}
