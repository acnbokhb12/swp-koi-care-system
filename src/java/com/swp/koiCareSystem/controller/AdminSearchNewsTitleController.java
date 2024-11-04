/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.News;
import com.swp.koiCareSystem.model.NewsCategory;
import com.swp.koiCareSystem.service.NewsService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Khanh
 */
public class AdminSearchNewsTitleController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String title = request.getParameter("newsTitle");
            
            if (title == null || title.trim().isEmpty()) {
                String url = "MainControler?action=" + IConstant.ADMIN_NEWS;
                response.sendRedirect(url);
            } else {
                title = title.trim();
                title = title.replaceAll(" +", " ");
            }
            
            String indexPage = request.getParameter("index");
            if(indexPage == null){
                indexPage= "1";
            }
            
            int index = 1;
            try {
                index = Integer.parseInt(indexPage);
            } catch (Exception e) {
                response.sendRedirect("MainController?action=" + IConstant.ADMIN_NEWS);
                return;
            }
            
            
            NewsService ns = new NewsService();
            int count = ns.countNewsByTitle(title);
            
            int endPage = count/10; 
            if(count % 10 != 0){
                endPage++;
            } 
            
            ArrayList<News> listN = ns.adminSearchNewsByTitle(title, index);
            ArrayList<NewsCategory> listNC = ns.getAllNewsCategory();
            
            request.setAttribute("ListN", listN);
            request.setAttribute("listNC", listNC);
            request.setAttribute("tag", index);
            request.setAttribute("endPage", endPage);
            request.setAttribute("OldSearch", title); 
            request.getRequestDispatcher("manageNews.jsp").forward(request, response);
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
