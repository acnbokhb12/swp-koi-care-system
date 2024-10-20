/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@MultipartConfig
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = "";
        try {
            /* TODO output your page here. You may use following sample code. */
            String ac = request.getParameter("action");
            if (ac == null || ac.isEmpty()) {
                ac = IConstant.HOME;
            }
            switch (ac) {
                case IConstant.HOME:
                    url = "home.jsp";
                    break;
                // START PLACE SHOP -------------------------------------------------------------                                     
                case IConstant.SHOP:
                    url = "ManageShopController";
                    break;
                case IConstant.PRODUCTDETAIL:
                    url = "ProductDetailController";
                    break;
                // START PLACE LOGIN-REGISTER-LOGOUT -------------------------------------------------------------                        
                case IConstant.LOGIN:
                    url = "LoginController";
                    break;
                case IConstant.REGISTER:
                    url = "RegisterController";
                    break;
                case IConstant.LOGOUT:
                    url = "LogoutController";
                    break;
                // START PLACE PROFILE -------------------------------------------------------------                                         
                case IConstant.PROFILE_JSP:
                    url = "profilePage.jsp";
                    break;
                case IConstant.EDIT_PROFILE_JSP:
                    url = "editProfile.jsp";
                    break;
                case IConstant.PASSWORD_PROFILE:
                    url = "PasswordProfileController";
                    break;
                case IConstant.EDIT_PROFILE:
                    url = "EditProfileController";
                    break;
                case IConstant.UP_IMG_SINGLE:
                    url = "ImageUploadSingleController";
                    break;
                // START PLACE BLOG -------------------------------------------------------------                                                     
                case IConstant.BLOG:
                    url = "ManageBlogController";
                    break;
                case IConstant.GET_BLOG_CID:
                    url = "GetBlogsByCateIdController";
                    break;
                case IConstant.CREATE_NEW_BLOG:
                    url = "CreateNewBlogController";
                    break;
                case IConstant.DELET_BLOG:
                    url = "DeleteBlogController";
                    break;
                // START PLACE FISH -------------------------------------------------------------  
                case IConstant.FISH:
                    url = "FishController";
                    break;
                case IConstant.FISH_INFOR:
                    url = "FishInforController";
                    break;
                case IConstant.FISH_CREATE_NEW:
                    url = "FishCreateNewController";
                    break;
                case IConstant.FISH_DELETE:
                    url = "FishDeleteController";
                    break;
                case IConstant.FISH_INFOR_UPDATE:
                    url = "FishInformationUpdateController";
                    break;
                case IConstant.FISH_IMAGE_UPDATE:
                    url = "FishImageUpdateController";
                    break;
                // START PLACE POND -------------------------------------------------------------     
                case IConstant.POND:
                    url = "PondController";
                    break;
                case IConstant.POND_INFOR:
                    url = "PondInforController";
                    break;
                case IConstant.ADD_NEW_POND:
                    url = "AddNewPondController";
                    break;
                case IConstant.POND_DELETE:
                    url = "DeletePondController";
                    break;
                case IConstant.POND_INFOR_UPDATE:
                    url = "UpdatePondInformationController";
                    break;
                case IConstant.POND_IMAGE_UPDATE:
                    url = "UpdatePondImageController";
                    break;
                //START ACCOUNT HAVE FISH---------------------------------------------------------------------------------
                case IConstant.FISH_USER:
                    url = "UserFishController";
                    break;
                case IConstant.FISH_USER_LIST:
                    url = "FishUserListController";
                    break;
                // START PLACE MANAGER -------------------------------------------------------------     
                case IConstant.PRODUCT_MANAGE:
                    url = "ManageProductController";
                    break;
                case IConstant.PRODUCT_INFORMATION:
                    url = "ManagerProductInformationController";
                    break;
                case IConstant.PRODUCT_INFORMATION_UPDATE:
                    url = "ManagerProductInformationUpdateController";
                    break;
                case IConstant.PRODUCT_CREATE_NEW:
                    url = "ManagerCreateNewProductController";
                    break;
                case IConstant.PRODUCT_DELETE:
                    url = "ManagerProductDeleteController";
                    break;
                case IConstant.PRODUCT_UPDATE:
                    url = "ManagerProductUpdateController";
                    break;
                case IConstant.PRODUCT_IMAGE_UPDATE:
                    url = "ManagerProductImageUpdateController";
                    break;
                // DEFAULT IF ERROR ACTION --------------------------------------------------------               
                default:
                    url = "home.jsp";
                    break;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
