/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.model;

/**
 *
 * @author DELL
 */
public class Product {
    private int productID; 
    private String cateId;
    private String nameProduct;
    private String imgProduct;
    private String description;
    private float price;
    private ProductCategory categoryP;

    public Product() {
    }

    public Product(int productID,String cateId, String nameProduct, String imgProduct, String description, float price) {
        this.productID = productID;
        this.cateId = cateId;
        this.nameProduct = nameProduct;
        this.imgProduct = imgProduct;
        this.description = description;
        this.price = price; 
    }
    
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

     

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductCategory getCategoryP() {
        return categoryP;
    }

    public void setCategoryP(ProductCategory categoryP) {
        this.categoryP = categoryP;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", nameProduct=" + nameProduct + ", imgProduct=" + imgProduct + ", description=" + description + ", price=" + price + ", categoryP=" + categoryP + '}';
    }
    
    

    
    
    
}
