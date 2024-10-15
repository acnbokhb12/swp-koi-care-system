/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.model.Blog;
import com.swp.koiCareSystem.model.BlogCategory;
import com.swp.koiCareSystem.service.BlogService;
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
public class BlogCateController extends HttpServlet {

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
            String blogCateId = request.getParameter("blogCateId");
            String indexP = request.getParameter("index");
            if (blogCateId == null) {
                blogCateId = "1";
            }else if (indexP == null) {
                indexP = "1";
            }
            int bcId = Integer.parseInt(blogCateId);
            int index = Integer.parseInt(indexP);
            
            BlogService bs = new BlogService();
            int count = bs.countAllBlog();
            
            int endPage = count/8;
            if (count % 8 != 0) {
                endPage++;
            }
            
            ArrayList<Blog> listBlog = bs.GetAllBlog(index);
            ArrayList<BlogCategory> listBlogCate = bs.GetAllBlogCate();
            
            request.setAttribute("ListBC", listBlogCate);
            request.setAttribute("listP", listBlog);
            request.setAttribute("tag", index);
            request.setAttribute("endPage", endPage);
            request.setAttribute("blogCateId", blogCateId);
            request.setAttribute("TagBlogCate", bcId);
            request.getRequestDispatcher("blog.jsp").forward(request, response);
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
