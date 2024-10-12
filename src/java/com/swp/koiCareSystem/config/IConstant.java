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
    public final String PROFILEJSP = "profileJsp";
    public final String EDITPROFILEJSP = "editprofileJsp";

    public final String PRODUCTDETAIL = "productDetail";

    public final String NEWS = "news";

    public final String LOGIN = "login";
    public final String REGISTER = "register";
    public final String LOGOUT = "logout";

    public final String POND = "pond";
    public final String FISH = "fish";
    public final String FISHINFOR = "fishinfor";
    public final String PONDINFOR = "pondinfor";

    public final String PASSWORDPROFILE = "passwordprofile";

    public static final String GOOGLE_CLIENT_ID = "826453818267-omsh2s4t4ab4rs6eijvgop9bokm52v9q.apps.googleusercontent.com";

    public static final String GOOGLE_CLIENT_SECRET = "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";

    public static final String GOOGLE_REDIRECT_URI = "http://localhost:8084/com.swp.koiCareSystem/LoginGoogleController";

    public static final String GOOGLE_GRANT_TYPE = "authorization_code";

    public static final String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";

    public static final String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";

}
