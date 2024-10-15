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
    
    public int countAllBlog(){
        return blogDAO.countBlog();
    }
    
    public ArrayList<Blog> GetAllBlog(int index){ 
        return blogDAO.getAllBlogs(index);
    }
    
    public ArrayList<BlogCategory> GetAllBlogCate(){
        return blogDAO.getAllBlogCategory();
    }
    
    public ArrayList<Blog> getBlogsCateById(String cid, int index){
        return  blogDAO.getBlogsByCateId(cid, index);
    }
    
    public int countBlogByCateId(String cid){
        return blogDAO.countBlogByCateId(cid);
    }
    
    public ArrayList<Blog> pagingCount(int index){
        return blogDAO.pagingCount(index);
    }
}
