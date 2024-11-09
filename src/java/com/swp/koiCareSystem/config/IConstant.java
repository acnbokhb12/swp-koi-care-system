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

// START FISH GROWTH ----------------------------------------------------------------------------------------------------------------------------------
    public final String FISH_GROWTH_CHART_INFO = "fishgrowthchartinformation";
    public final String FISH_GROWTH_CHART_CREATE = "fishgrowthchartcreate";
    public final String FISH_GROWTH_CHART_UPDATE = "fishgrowthchartupdate";
    public final String FISH_GROWTH_CHART_DELETE = "fishgrowthchartdelete";
    public final String FISH_GROWTH_CHART_SEARCH_LENGTH = "fishgrowthchartsearchlength";
    public final String FISH_GROWTH_CHART_SEARCH_WEIGHT = "fishgrowthchartsearchweight";

// START POND ----------------------------------------------------------------------------------------------------------------------------------   
    public final String POND = "pond";
    public final String POND_INFOR = "pondinfor";
    public final String ADD_NEW_POND = "newpond";
    public final String POND_DELETE = "ponddelete";
    public final String POND_INFOR_UPDATE = "pondinformationupdate";
    public final String POND_IMAGE_UPDATE = "pondimageupdate";

// START POND ----------------------------------------------------------------------------------------------------------------------------------   
    public final String WATER_PARAMETERS_MANAGE = "waterparametersmanage";
    public final String WATER_PARAMETERS_CREATE_NEW = "waterparametercreatenew";
    public final String WATER_PARAMETERS_UPDATE = "waterparameterupdate";
    public final String WATER_PARAMETERS_DELETE = "waterparameterdelete";

    // START AQUARIUM MANAGER ---------------------------------------------------------------------------------------------------------------------------------------
    public static String ACCOUNT_FISH_MANAGE = "accountfishmanage";
    public static String FISH_MANAGE = "fishmanage";
    public static String MANAGE_FISH_DETAIL = "managefishdetail";
    public static String MANAGE_AQUARIUM_DETAILS = "manageaquariumdetails";
    public static String MANAGE_POND = "managepond";
    public static String MANAGE_POND_DETAILS = "manageponddetails";

// START FOOD CACULATOR
    public final String FOOD_CALCULATOR = "foodCalculator";
    public final String SALT_CALCULATOR = "saltCalculator";
// START PURCHASE HISTORY
    public final String PURCHASE_HISTORY = "purchaseHistory";

// START NEWS-BLOGS ----------------------------------------------------------------------------------------------------------------------------------     
    public static String BLOG = "blog";
    public static String GET_BLOG_CID = "getBlogCid";
    public static String CREATE_NEW_BLOG = "createNewBlog";
    public static String DELET_BLOG = "deleteBlog";
    public final String NEWS = "news";
    public final String VIEW_NEWS = "viewNews";

// START ADMIN NEWS ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public final String CREATE_NEWS = "createNews";
    public final String NEWS_INFOR_CREATE = "newsInforCreate";
    public final String ADMIN_NEWS = "adminNews";
    public final String ADMIN_NEWS_DETAIL = "adminNewsDetail";
    public final String ADMIN_DELETE_NEWS = "adminDeleteNews";
    public final String ADMIN_SEARCH_NEWS_CATE = "adminSearchNewsCate";
    public final String ADMIN_SEARCH_NEWS_TITLE = "adminSearchNewsTitle";

// START MANAGER PRODUCT ----------------------------------------------------------------------------------------------------------------------------------     
    public static String PRODUCT_MANAGE = "productmanage";
    public static String PRODUCT_INFORMATION = "productinformation";
    public static String PRODUCT_INFORMATION_UPDATE = "productinformationupdate";
    public static String PRODUCT_CREATE_NEW = "productcreatenew";
    public static String PRODUCT_UPDATE = "productupdate";
    public static String PRODUCT_DELETE = "productdelete";
    public static String PRODUCT_IMAGE_UPDATE = "productimgageupdate";

// START FORGET PASSWORD ----------------------------------------------------------------------------------------------------------------------------------
    public final String CUSTOMER_FORGET_PASSWORD = "forgetpassword";
    public final String CUSTOMER_VALIDATE_OTP = "validateotp";
    public final String CUSTOMER_NEW_PASSWORD = "newpassword";

// START MANAGER ORDER ----------------------------------------------------------------------------------------------------------------------------------     
    public final String MANAGER_ORDER_MANAGE = "managerordermanage";
    public final String MANAGER_ORDER_DETAILS = "managerorderdetails";
    public final String MANAGER_ORDER_DELETE = "managerorderdelete";
    public final String MANAGER_ORDER_STATUS_CHANGE = "managerorderstatuschange";

// START MANAGE DASHBOARD ADMIN - MANAGER
    public final String DASHBOARD_ADMIN = "dashboardAdmin";
    public final String DASHBOARD_MANAGER = "dashboardManager";

//START ADMIN ACCOUNT ----------------------------------------------------------------------------------------------------------------------------------------------------------------
    public final String ADMIN_ACCOUNT = "adminAccount";
    public final String ADMIN_ACCOUNT_STATUS = "adminAccountStatus";
    public final String ADMIN_ACCOUNT_CREATE = "adminAccountCreate";
    public final String ADMIN_ACCOUNT_DELETE = "adminAccountDelete";
    public final String ADMIN_ACCOUNT_UPDATE = "adminAccountUpdate";
    public final String ADMIN_ACCOUNT_INFORMATION = "adminAccountInformation";
    public final String ADMIN_ACCOUNT_UPDATE_INFORMATION = "adminAccountUpdateInformation";
    public final String ADMIN_ACCOUNT_UPDATE_IMAGE = "adminAccountUpdateImage";

    // GOOGLE & CLOUDINARY -----------------------------------------------------------------------------------------------------------------------------------------------
    Dotenv dotenv = Dotenv.configure().directory(".").filename(".env").load();

    public static final String GOOGLE_CLIENT_ID = dotenv.get("GOOGLE_CLIENT_ID");
    public static final String GOOGLE_CLIENT_SECRET = dotenv.get("GOOGLE_CLIENT_SECRET");
    public static final String GOOGLE_REDIRECT_URI = dotenv.get("GOOGLE_REDIRECT_URI");
    public static final String GOOGLE_GRANT_TYPE = dotenv.get("GOOGLE_GRANT_TYPE");
    public static final String GOOGLE_LINK_GET_TOKEN = dotenv.get("GOOGLE_LINK_GET_TOKEN");
    public static final String GOOGLE_LINK_GET_USER_INFO = dotenv.get("GOOGLE_LINK_GET_USER_INFO");

    public final String CLOUDINARY_NAME = dotenv.get("CLOUDINARY_NAME");
    public final String CLOUDINARY_API_KEY = dotenv.get("CLOUDINARY_API_KEY");
    public final String CLOUDINARY_API_SECRET = dotenv.get("CLOUDINARY_API_SECRET");

    public final String URI_JEDIS = dotenv.get("URI_JEDIS");

}
