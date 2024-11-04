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
public class AdminSearchNewsCateController extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            String newsCate = request.getParameter("newsCategory");
            String indexPage = request.getParameter("index");

            if (indexPage == null) {
                indexPage = "1";
            }

            int ncid = Integer.parseInt(newsCate);
            int index = 1;
            try {
                index = Integer.parseInt(indexPage);
            } catch (Exception e) {
                response.sendRedirect("MainController?action=" + IConstant.ADMIN_NEWS);
                return;
            }

            NewsService ns = new NewsService();
            int count = ns.countNewsByCategoryID(ncid);
            
            int endPage = count / 10;
            if (count % 10 != 0) {
                endPage++;
            }
            ArrayList<News> listNews = ns.searchNewsByCate(newsCate, index);
            ArrayList<NewsCategory> listCate = ns.getAllNewsCategory();

            String url = "";
            if (listNews != null && !listNews.isEmpty()) {
                request.setAttribute("ListN", listNews);
                request.setAttribute("listNC", listCate);
                request.setAttribute("tag", index);
                request.setAttribute("endPage", endPage);
                request.setAttribute("OldSearchNewsCate", newsCate);
                request.setAttribute("TagsNewsCate", ncid);
                request.setAttribute("tagSearch", "category");
                url = "manageNews.jsp";
            } else {
                url = "MainController?action=" + IConstant.ADMIN_NEWS;
            }

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
