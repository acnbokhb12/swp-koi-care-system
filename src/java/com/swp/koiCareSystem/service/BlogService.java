/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.BlogDAO;
import com.swp.koiCareSystem.model.Blog;
import com.swp.koiCareSystem.model.BlogCategory;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Khanh
 */
public class BlogService {

    private BlogDAO blogDAO;

    public BlogService() {
        blogDAO = new BlogDAO();
    }

    public int countAllBlog() {
        return blogDAO.countBlog();
    }

    public ArrayList<Blog> GetAllBlog(int index) {
        return blogDAO.getAllBlogs(index);
    }

    public ArrayList<BlogCategory> GetAllBlogCate() {
        return blogDAO.getAllBlogCategory();
    }

    public ArrayList<Blog> getBlogsCateById(String cid, int index) {
        return blogDAO.getBlogsByCateId(cid, index);
    }

    public int countBlogByCateId(String cid) {
        return blogDAO.countBlogByCateId(cid);
    }

    public ArrayList<Blog> pagingCount(int index) {
        return blogDAO.pagingCount(index);
    }

    public boolean createNewBlog(Blog newBlog) {
        LocalDate currentDate = LocalDate.now();

        Date utilDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(utilDate);

        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        newBlog.setBlogDate(sqlDate);

        if (newBlog.getBlogImage() == null || newBlog.getBlogImage().isEmpty()) {
            newBlog.setBlogImage(null); // Hoặc không gọi phương thức này nếu bạn không muốn thiết lập gì cả
        }
        return blogDAO.createNewBlog(newBlog);
    }

    public boolean deleteBlogById(int blogID) {
        return blogDAO.deleteBlogByID(blogID);
    }

    public static void main(String[] args) {
        Blog b = new Blog();
        BlogDAO dao = new BlogDAO();
        LocalDate currentDate = LocalDate.now();

        Date utilDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println(sqlDate);
    }
}
