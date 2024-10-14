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
                case IConstant.SHOP:
                    url = "ManageShopController";
                    break;
                case IConstant.PRODUCTDETAIL:
                    url = "ProductDetailController";
                    break;
                case IConstant.LOGIN:
                    url = "LoginController";
                    break;
                case IConstant.REGISTER:
                    url = "RegisterController";
                    break;
                case IConstant.LOGOUT:
                    url = "LogoutController";
                    break;
                case IConstant.POND:
                    url = "PondController";
                    break;
                case IConstant.FISH:
                    url = "FishController";
                    break;
                case IConstant.FISHINFOR:
                    url = "FishInforController";
                    break;
                case IConstant.PONDINFOR:
                    url = "PondInforController";
                    break;
                case IConstant.PONDDELETE:
                    url = "DeletePondController";
                    break;
                case IConstant.PROFILEJSP:
                    url = "profilePage.jsp";
                    break;
                case IConstant.EDIT_PROFILE_JSP:
                    url = "editProfile.jsp";
                    break;
                case IConstant.PASSWORDPROFILE:
                    url = "PasswordProfileController";
                    break;
                case IConstant.EDITPROFILE:
                    url = "EditProfileController";
                    break;
                case IConstant.UPIMGSINGLE:
                    url = "ImageUploadSingleController";
                    break;
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
