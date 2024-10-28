/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.model.Account;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Khanh
 */
public class NewsCateController extends HttpServlet {

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
            
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("userAccount");

            if (acc != null && !acc.getUserRole().equalsIgnoreCase("admin")) {
                response.sendRedirect("home.jsp");
                return;
            }
            
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1"; // Giá trị mặc định là 1 nếu không có chỉ số trang
            }
            int index = Integer.parseInt(indexPage);
            
            NewsService ns = new NewsService();
                        int count = ns.countAllNews();//200

            int endPage = count / 10;
            if (count % 10 != 0) {
                endPage++;
            }
            
            ArrayList<News> listN = ns.GetAllNews(index);
            ArrayList<NewsCategory> listNC = ns.getAllNewsCategory();
            
            request.setAttribute("ListN", listN);
            request.setAttribute("ListNC", listNC);
            request.setAttribute("tag", index);
            request.setAttribute("endPage", endPage);
            request.getRequestDispatcher("manageAddNews.jsp").forward(request, response);
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
