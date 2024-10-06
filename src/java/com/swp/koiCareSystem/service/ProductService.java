/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.ProductDAO;
import com.swp.koiCareSystem.model.Product;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ProductService {
    private ProductDAO pd = new ProductDAO();
    
    public ArrayList<Product> GetAllProductS(){
        ArrayList<Product> listPd = pd.GetAllProduct();
        
         
        return listPd;
    }
    
}
