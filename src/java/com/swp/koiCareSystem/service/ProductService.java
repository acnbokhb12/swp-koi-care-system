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

    private ProductDAO productDAO;

    public ProductService() {
        productDAO = new ProductDAO();
    }

    public int countAllProduct() {
        return productDAO.countProducts();
    }

    public int countProductsByCate(int cateId) {
        return productDAO.countProductsByCate(cateId);
    }

    public int countProductsByName(String name) {
        return productDAO.countProductsByName(name);
    }

    public ArrayList<Product> getAllProducts(int index) {
        ArrayList<Product> list = productDAO.getAllProducts(index);
        return list;
    }

    public ArrayList<ProductCategory> getAllProductCate() {
        return productDAO.getAllCategory();
    }

    public ArrayList<Product> getProductsByCateId(int cateId, int index) {
        return productDAO.getProductsByCateId(cateId, index);
    }

    public ArrayList<Product> searchProductsByName(String name, int index) {
        return productDAO.searchProductsByName(name, index);
    }

    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    public ArrayList<Product> getProducts(int index) {
        ArrayList<Product> list = productDAO.getProducts(index);
        return list;
    }

    public boolean deleteProduct(int id) {
        return productDAO.deleteProduct(id);
    }

    public boolean updateProduct(Product p) {
        return productDAO.updateProduct(p);
    }

    public boolean updateImgAccountById(int id, String imgLink) {
        return productDAO.updateImgByProductID(id, imgLink);
    }
}
