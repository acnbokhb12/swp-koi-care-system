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
    
//    Dotenv dotenv = Dotenv.configure().directory(".").filename(".env").load();
//     
//    public static final String GOOGLE_CLIENT_ID = dotenv.get("GOOGLE_CLIENT_ID");
//    public static final String GOOGLE_CLIENT_SECRET = dotenv.get("GOOGLE_CLIENT_SECRET");
//    public static final String GOOGLE_REDIRECT_URI = dotenv.get("GOOGLE_REDIRECT_URI");
//    public static final String GOOGLE_GRANT_TYPE = dotenv.get("GOOGLE_GRANT_TYPE");
//    public static final String GOOGLE_LINK_GET_TOKEN = dotenv.get("GOOGLE_LINK_GET_TOKEN");
//    public static final String GOOGLE_LINK_GET_USER_INFO = dotenv.get("GOOGLE_LINK_GET_USER_INFO");
}
