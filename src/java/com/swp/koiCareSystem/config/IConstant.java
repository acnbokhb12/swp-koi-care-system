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

// START NEWS-BLOGS ----------------------------------------------------------------------------------------------------------------------------------     
    public static String BLOG = "blog";
    public static String GET_BLOG_CID = "getBlogCid";
    public static String CREATE_NEW_BLOG = "createNewBlog";
    public static String DELET_BLOG = "deleteBlog";
    public final String NEWS = "news";

// START MANAGER ----------------------------------------------------------------------------------------------------------------------------------     
    public static String PRODUCT_MANAGE = "productmanage";
    public static String ACCOUNT_FISH_MANAGE = "accountfishmanage";
    public static String CREATE_USER_FISH_MANAGE = "createuserfishmanage";

    public static String FISH_MANAGE = "fishmanage";

}
