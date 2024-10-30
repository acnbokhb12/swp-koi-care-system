/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.News;
import com.swp.koiCareSystem.service.ImageUploadService;
import com.swp.koiCareSystem.service.NewsService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Khanh
 */
@MultipartConfig
public class AdminCreateNewsController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            Part filePart = request.getPart("fileimg");
            String temDir = getServletContext().getRealPath("/") + "uploads";
            ImageUploadService img = new ImageUploadService();
            
            String imgUrl = "";
            if (filePart != null && filePart.getSize() > 0) {
                try {
                    imgUrl = img.uploadImage(filePart, temDir);
                    System.out.println(imgUrl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            String ntitle = request.getParameter("Title");
            String ndescrip = request.getParameter("NewsDescription");
            int ncid = Integer.parseInt(request.getParameter("newsCategoryID"));
            
            News news = new News();
            
            
            news.setTitle(ntitle);
            news.setNewsDescription(ndescrip);
            news.setNewsImage(imgUrl);
            news.setNewsCategoryID(ncid);
            news.setIsActive(true);
            
            NewsService ns = new NewsService();
            
            boolean isCreated = ns.createNews(news);
            
            if (isCreated) {
                request.setAttribute("message", "News has been created.");
                request.setAttribute("toastMessage", "success");
            } else {
                request.setAttribute("message", "An error occured while creating the news.");
                request.setAttribute("toastMessage", "error");
            }
            
            request.setAttribute("NewsImage", imgUrl);
            String url = "MainController?action=" + IConstant.ADMIN_NEWS;
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
