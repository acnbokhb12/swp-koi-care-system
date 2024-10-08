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
import java.util.Collection;
import java.util.Collections;

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
        return productDAO.CountProducts();
    } 
    
    public int CountProductsByCate(int cateId){ 
        return productDAO.CountProductsByCate(cateId);
    }
    
    public int CountProductsByName(String name){ 
        return productDAO.CountProductsByName(name);
    }
    
    public ArrayList<Product> GetAllProducts(int index){
        ArrayList<Product> list = productDAO.GetAllProducts(index);  
        return list;
    }
    
    public ArrayList<ProductCategory> GetAllProductCate(){ 
        return  productDAO.GetAllCategory();
    } 
    
    public ArrayList<Product> GetProductByCateId(int cateId, int index){ 
        return productDAO.GetProductByCateId(cateId, index);
    } 
    
    public ArrayList<Product> SearchProductsByName(String name, int index){ 
        return productDAO.SearchProductsByName(name, index);
    }
    
    public Product GetProductById(int id){
       return productDAO.GetProductById(id);
    }
}
