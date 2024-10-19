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
// START SHOP ----------------------------------------------------------------------------------------------------------------------------------
    public final String SHOP = "shop";
    public final String SHOPJSP = "shopJsp";
    public final String PRODUCTDETAIL = "productDetail";

// START PROFILE ----------------------------------------------------------------------------------------------------------------------------------    
    public final String PROFILE_JSP = "profileJsp";
    public final String EDIT_PROFILE_JSP = "editProfileJsp";
    public final String PASSWORD_PROFILE = "passwordprofile";
    public final String INFORMATIONPROFILE = "informationprofile";
    public final String UP_IMG_SINGLE = "upImgSingle";
    public final String EDIT_PROFILE = "editProfile";

// START LOGIN-REGISTER-LOGOUT ----------------------------------------------------------------------------------------------------------------------------------
    public final String LOGIN = "login";
    public final String REGISTER = "register";
    public final String LOGOUT = "logout";

// START FISH ----------------------------------------------------------------------------------------------------------------------------------
    public final String FISH = "fish";
    public final String FISH_INFOR = "fishinfor";
    public final String FISH_CREATE_NEW = "fishcreatenew";
    public final String FISH_DELETE = "fishdelete";
    public final String FISH_INFOR_UPDATE = "fishinformationupdate";
    public final String FISH_IMAGE_UPDATE = "fishimageupdate";

// START POND ----------------------------------------------------------------------------------------------------------------------------------   
    public final String POND = "pond";
    public final String POND_INFOR = "pondinfor";
    public final String ADD_NEW_POND = "newpond";
    public final String POND_DELETE = "ponddelete";
    public final String POND_INFOR_UPDATE = "pondinformationupdate";
    public final String POND_IMAGE_UPDATE = "pondimageupdate";

  // START ACCOUNT ---------------------------------------------------------------------------------------------------------------------------------------
    public final String FISH_USER = "fishuser";
    public final String FISH_USER_LIST = "fishuserlist";

// START NEWS-BLOGS ----------------------------------------------------------------------------------------------------------------------------------     
    public static String BLOG = "blog";
    public static String GET_BLOG_CID = "getBlogCid";
    public static String CREATE_NEW_BLOG = "createNewBlog";
    public static String DELET_BLOG = "deleteBlog";
    public final String NEWS = "news";

// START MANAGER ----------------------------------------------------------------------------------------------------------------------------------     
    public static String PRODUCT_MANAGE = "productmanage";

// GOOGLE LOGIN ----------------------------------------------------------------------------------------------------------------------------------
    public static final String GOOGLE_CLIENT_ID = "826453818267-omsh2s4t4ab4rs6eijvgop9bokm52v9q.apps.googleusercontent.com";
    public static final String GOOGLE_CLIENT_SECRET = "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";
    public static final String GOOGLE_REDIRECT_URI = "http://localhost:8084/com.swp.koiCareSystem/LoginGoogleController";
    public static final String GOOGLE_GRANT_TYPE = "authorization_code";
    public static final String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static final String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";

// CLOUDINARY ----------------------------------------------------------------------------------------------------------------------------------
    public final String CLOUDINARY_NAME = "dkn16ntvy";
    public final String CLOUDINARY_API_KEY = "953513337114448";
    public final String CLOUDINARY_API_SECRET = "GDsBV9a9z9bhLx7_6SFVT40rZ8M";
// BOtay     ko hieu kieu gi
}
