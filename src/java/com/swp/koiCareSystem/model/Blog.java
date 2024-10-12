/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.model;

import java.sql.Date;

/**
 *
 * @author Khanh
 */
public class Blog {
    private int BlogID;
    private int AccID;
    private int IDBlogCate;
    private String Title; 
    private String Content;
    private String BlogsImage;
    private Date BlogsDate;

    public Blog() {
    }

    public Blog(int BlogID, int AccID, int IDBlogCate, String Title, String Content, String BlogsImage, Date BlogsDate) {
        this.BlogID = BlogID;
        this.AccID = AccID;
        this.IDBlogCate = IDBlogCate;
        this.Title = Title;
        this.Content = Content;
        this.BlogsImage = BlogsImage;
        this.BlogsDate = BlogsDate;
    }

    public int getBlogID() {
        return BlogID;
    }

    public void setBlogID(int BlogID) {
        this.BlogID = BlogID;
    }

    public int getAccID() {
        return AccID;
    }

    public void setAccID(int AccID) {
        this.AccID = AccID;
    }

    public int getIDBlogCate() {
        return IDBlogCate;
    }

    public void setIDBlogCate(int IDBlogCate) {
        this.IDBlogCate = IDBlogCate;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getBlogsImage() {
        return BlogsImage;
    }

    public void setBlogsImage(String BlogsImage) {
        this.BlogsImage = BlogsImage;
    }

    public Date getBlogsDate() {
        return BlogsDate;
    }

    public void setBlogsDate(Date BlogsDate) {
        this.BlogsDate = BlogsDate;
    }

    @Override
    public String toString() {
        return "Blog{" + "BlogID=" + BlogID + ", AccID=" + AccID + ", IDBlogCate=" + IDBlogCate + ", Title=" + Title + ", Content=" + Content + ", BlogsImage=" + BlogsImage + ", BlogsDate=" + BlogsDate + '}';
    }

}
