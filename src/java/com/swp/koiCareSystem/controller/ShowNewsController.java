/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

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
public class ShowNewsController extends HttpServlet {

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
            
            NewsService ns = new NewsService();

            ArrayList<News> randomNews = ns.getRandomNews();
            ArrayList<News> newsListLatest = ns.getNewsLatest();
            ArrayList<News> listNewsSpecialV1 = ns.getListNewsSpecialByCateId(4);
            String titleNewsSpecialV1 = "Water Parameter Control News";
            ArrayList<News> listNewsSpecialV2 = ns.getListNewsSpecialByCateId(1);
            String titleNewsSpecialV2 = "Events News";

            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1"; // Giá trị mặc định là 1 nếu không có chỉ số trang
            }
            int index = Integer.parseInt(indexPage);

            int count = ns.countNormalNewsList();

            int endPage = count / 6;
            if (count % 6 != 0) {
                endPage++;
            }

            ArrayList<News> listNormalNews = ns.getNormalNewsList(index);
            String titleNewsNormal = "Normal News";

            request.setAttribute("newsListLatest", newsListLatest);
            request.setAttribute("listNewsSpecialV1", listNewsSpecialV1);
            request.setAttribute("listNewsSpecialV2", listNewsSpecialV2);
            request.setAttribute("titleNewsSpecialV1", titleNewsSpecialV1);
            request.setAttribute("titleNewsSpecialV2", titleNewsSpecialV2);
            request.setAttribute("listNormalNews", listNormalNews);
            request.setAttribute("titleNewsNormal", titleNewsNormal);
            request.setAttribute("randomNews", randomNews);
            request.setAttribute("tag", index);
            request.setAttribute("endPage", endPage);

            request.getRequestDispatcher("news.jsp").forward(request, response);
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
