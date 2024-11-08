/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.dao.AccountDAO;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.service.AccountService;
import com.swp.koiCareSystem.service.ImageUploadService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author PC
 */
@MultipartConfig
public class AdminUpdateImageAccountController extends HttpServlet {

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
        // Lấy productId và filePart từ request
        int accountId = Integer.parseInt(request.getParameter("accid"));
        Part filePart = request.getPart("fileimg"); // Tệp ảnh từ form
        String tempDir = getServletContext().getRealPath("/") + "uploads"; // Thư mục tạm để lưu ảnh

        // Khởi tạo dịch vụ tải ảnh
        ImageUploadService imgs = new ImageUploadService();
        String imageUrl = "";
        try {
            // Tải ảnh lên và nhận URL
            imageUrl = imgs.uploadImage(filePart, tempDir);
            System.out.println(imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cập nhật thông tin tài khoản
       AccountService accountDAO = new AccountService();
        boolean isUpdated = accountDAO.upDateImgAccountById(accountId, imageUrl);

        String url = "";
        if (isUpdated) {
            url = "MainController?action=" + IConstant.ADMIN_ACCOUNT_UPDATE_IMAGE + "&accountId=" + accountId;
        } else {
            url = "MainController?action=" + IConstant.ADMIN_ACCOUNT_UPDATE_INFORMATION + "&accountId=" + accountId;
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
