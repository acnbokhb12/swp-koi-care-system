/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.BlogDAO;
import com.swp.koiCareSystem.model.Blog;
import com.swp.koiCareSystem.model.BlogCategory;
import java.util.ArrayList;

/**
 *
 * @author Khanh
 */
public class BlogService {
    private BlogDAO blogDAO;
    
    public BlogService(){
        blogDAO = new BlogDAO();
    }
    
    public int CountAllBlog(){
        return blogDAO.CountBlog();
    }
    
    public ArrayList<Blog> GetAllBlog(int index){ 
        return blogDAO.getAllBlogs(index);
    }
    
    public ArrayList<BlogCategory> GetAllBlogCate(){
        return blogDAO.getAllBlogCategory();
    }
}
