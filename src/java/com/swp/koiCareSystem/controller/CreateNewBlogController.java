/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.Blog;
import com.swp.koiCareSystem.model.BlogCategory;
import com.swp.koiCareSystem.service.BlogService;
import com.swp.koiCareSystem.service.ImageUploadService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class CreateNewBlogController extends HttpServlet {

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
            HttpSession session = request.getSession();

            Account acc = (Account) session.getAttribute("userAccount");

            if (acc == null) {
                response.sendRedirect("home.jsp");
                return;
            }

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

            int acid = acc.getUserID();
            int bcid = Integer.parseInt(request.getParameter("blogCateId"));
            String btitle = request.getParameter("title");
            String bcontent = request.getParameter("content");

            Blog newBlog = new Blog();

            newBlog.setUserID(acid);
            newBlog.setBlogCateId(bcid);
            newBlog.setTitle(btitle);
            newBlog.setContent(bcontent);
            newBlog.setBlogImage(imgUrl);
            newBlog.setIsActive(true);

            BlogService bs = new BlogService();

            boolean isCreated = bs.createNewBlog(newBlog);

            if (isCreated) {
                request.setAttribute("message", "New Blog has been created.");
                request.setAttribute("toastMessage", "seuccess");
            } else {
                request.setAttribute("message", "An error occured while creating the blog.");
                request.setAttribute("toastMessage", "error");
            }

            request.setAttribute("blogImage", imgUrl);
            
            String url = "";

            url = "MainController?action=" + IConstant.BLOG;

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
