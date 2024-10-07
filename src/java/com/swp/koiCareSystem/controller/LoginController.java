/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.dao.AccountDAO;
import com.swp.koiCareSystem.model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class LoginController extends HttpServlet {

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

        String action = request.getParameter("action");
        if ("login".equals(action)) {
            try {
                String email = request.getParameter("txtemail");
                String password = request.getParameter("txtpassword");

                // Tạo instance AccountDAO mà không cần khóa mã hóa
                AccountDAO dao = new AccountDAO();

                // Kiểm tra đăng nhập và băm mật khẩu trong DAO
                Account account = dao.checkLogin(email, password);

                if (account != null) {
                    // Tạo session cho người dùng
                    HttpSession session = request.getSession();
                    session.setAttribute("user", account);

                    // Chuyển hướng dựa trên vai trò của tài khoản
                    String role = account.getUserRole();
                    switch (role) {
                        case "admin":
                            response.sendRedirect("manageUser.jsp"); // Quản lý người dùng
                            break;
                        case "manager":
                            response.sendRedirect("manageProduct.jsp"); // Quản lý sản phẩm
                            break;
                        default:
                            response.sendRedirect("home.jsp"); // Trang chính cho người dùng thông thường
                            break;
                    }
                } else {
                    // Nếu thông tin đăng nhập không chính xác
                    request.setAttribute("error", "Wrong Email or Password!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } catch (Exception e) {
                // Xử lý ngoại lệ
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, "An unexpected error occurred", e);
                request.setAttribute("error", "An unexpected error occurred. Please try again later.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
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
