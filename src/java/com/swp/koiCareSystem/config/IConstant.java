/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.config;
   
import io.github.cdimascio.dotenv.Dotenv; 




/**
 *
 * @author DELL
 */
public interface IConstant { 
    public final String HOME = "home"; 
    public final String SHOP = "shop";
    public final String SHOPJSP = "shopJsp";
    public final String PRODUCTDETAIL = "productDetail";
    
    public final String NEWS = "news";

    public final String LOGIN = "login";
    public final String REGISTER = "register";
    public final String LOGOUT = "logout";  
    
    public final String POND = "pond";
    public final String FISH = "fish"; 
    public final String FISHINFOR = "fishinfor";
    public final String PONDINFOR = "pondinfor"; 
    
    
    
//    Dotenv dotenv = Dotenv.configure()
//    .directory("D:\\f_code\\Project_Swp_Fall_2024\\com.swp.koiCareSystem\\web\\WEB-INF") // Đường dẫn tuyệt đối
//    .filename("devcontainer.env")
//    .load();\
    
     
}
