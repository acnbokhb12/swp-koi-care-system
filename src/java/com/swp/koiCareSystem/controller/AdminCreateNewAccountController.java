/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.dao.AccountDAO;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.service.ImageUploadService;
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
 * @author PC
 */
@MultipartConfig
public class AdminCreateNewAccountController extends HttpServlet {

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
            HttpSession session = request.getSession();

            Part filePart = request.getPart("fileimg");
            String tempDir = getServletContext().getRealPath("/") + "uploads";
            String imageUrl = "";

            // Xử lý tải lên hình ảnh
            if (filePart != null) {
                ImageUploadService imgs = new ImageUploadService();
                try {
                    imageUrl = imgs.uploadImage(filePart, tempDir);
                    System.out.println(imageUrl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Lấy thông tin tài khoản từ yêu cầu
            String email = request.getParameter("email");
            String fullName = request.getParameter("fullName");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            String gender = request.getParameter("gender");
            int accountStatus = 1; // Bạn có thể thay đổi giá trị này nếu cần

            // Tạo đối tượng Account
            Account account = new Account();
            account.setEmail(email);
            account.setFullName(fullName);
            account.setPassword(password);
            account.setProfileImage(imageUrl); // Gán đường dẫn hình ảnh
            account.setUserRole(role);
            account.setAddress(address);
            account.setPhoneNumber(phoneNumber);
            account.setGender(gender);
            account.setAccountStatus(accountStatus);

            // Sử dụng DAO để tạo tài khoản
            AccountDAO accountDAO = new AccountDAO();
            boolean result = accountDAO.createNewAccount(account);

            if (result) {
                request.setAttribute("message", "New Account has been created");
                request.setAttribute("toastMessage", "success");
            } else {
                request.setAttribute("message", "An error occurred while creating the Account.");
                request.setAttribute("toastMessage", "error");
            }

            // Chuyển hướng đến Controller quản lý tài khoản
            String url = "AdminAccountController"; // Chuyển hướng đến Controller quản lý tài khoản
            request.getRequestDispatcher(url).forward(request, response);
        }
    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

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
