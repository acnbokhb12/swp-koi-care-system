/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.ProductDAO;
import com.swp.koiCareSystem.model.Product;
import com.swp.koiCareSystem.model.ProductCategory;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ProductService {
    private ProductDAO productDAO ;
    
    public ProductService(){
        productDAO = new ProductDAO();
    }
    
    public int CountAllProduct(){
        int sumCount = productDAO.CountProducts();
        return sumCount;
    } 
    
    public int CountProductsByCate(int cateId){
        int sumCount = productDAO.CountProductsByCate(cateId);
        return sumCount;
    }
    
    public int CountProductsByName(String name){
        int sumCount = productDAO.CountProductsByName(name);
        return sumCount;
    }
    
    public ArrayList<Product> GetProductByPaging(int index){
        ArrayList<Product> list = productDAO.Pagingproduct(index);
        return  list;
    }
    
    public ArrayList<ProductCategory> GetAllProductCate(){
        ArrayList<ProductCategory> list = productDAO.GetAllCategory();
        return list;
    } 
    
    public ArrayList<Product> GetProductByCatePaging(int cateId, int index){
        ArrayList<Product> list = productDAO.PagingGetProductByCateId(cateId, index);
        return list;
    } 
    
    public ArrayList<Product> SearchProductsByName(String name, int index){
        ArrayList<Product> list = productDAO.SearchProductsByName(name, index);
        return list;
    }
}
