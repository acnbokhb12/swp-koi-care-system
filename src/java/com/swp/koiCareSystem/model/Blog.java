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

    private int blogID;
    private int userID;
    private int blogCateId;
    private String title;
    private String content;
    private String blogImage;
    private Date blogDate;
    private boolean isActive;
    private BlogCategory blogCategory;
    private Account account;

    public Blog() {
    }

    public Blog(int blogID, int userID, int blogCateId, String title, String content, String blogImage, Date blogDate, boolean isActive, BlogCategory blogCategory, Account account) {
        this.blogID = blogID;
        this.userID = userID;
        this.blogCateId = blogCateId;
        this.title = title;
        this.content = content;
        this.blogImage = blogImage;
        this.blogDate = blogDate;
        this.isActive = isActive;
        this.blogCategory = blogCategory;
        this.account = account;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBlogCateId() {
        return blogCateId;
    }

    public void setBlogCateId(int blogCateId) {
        this.blogCateId = blogCateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
    }

    public Date getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(Date blogDate) {
        this.blogDate = blogDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public BlogCategory getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(BlogCategory blogCategory) {
        this.blogCategory = blogCategory;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Blog{" + "blogID=" + blogID + ", userID=" + userID + ", blogCateId=" + blogCateId + ", title=" + title + ", content=" + content + ", blogImage=" + blogImage + ", blogDate=" + blogDate + ", isActive=" + isActive + ", blogCategory=" + blogCategory + ", account=" + account + '}';
    }
    
    
}
