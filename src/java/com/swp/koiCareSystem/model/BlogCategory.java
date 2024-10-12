/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.model;

/**
 *
 * @author Khanh
 */
public class BlogCategory {
    private int IDBlogCate;
    private String NameBlogCate;

    public BlogCategory() {
    }

    public BlogCategory(int IDBlogCate, String NameBlogCate) {
        this.IDBlogCate = IDBlogCate;
        this.NameBlogCate = NameBlogCate;
    }

    public int getIDBlogCate() {
        return IDBlogCate;
    }

    public void setIDBlogCate(int IDBlogCate) {
        this.IDBlogCate = IDBlogCate;
    }

    public String getNameBlogCate() {
        return NameBlogCate;
    }

    public void setNameBlogCate(String NameBlogCate) {
        this.NameBlogCate = NameBlogCate;
    }

    @Override
    public String toString() {
        return "BlogCategory{" + "IDBlogCate=" + IDBlogCate + "NameBlogCate=" + NameBlogCate + "}"; 
    }
    
    
}
