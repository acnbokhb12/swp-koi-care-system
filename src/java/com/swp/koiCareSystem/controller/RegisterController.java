/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.dao.AccountDAO;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.service.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class RegisterController extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        AccountDAO acd = new AccountDAO();
        AccountService acs = new AccountService();

        String koiCareId = request.getParameter("txtid");
        String fullName = request.getParameter("txtusername");
        String password = request.getParameter("txtpassword");
        String confirmPassword = request.getParameter("txtconfirmpassword");

        if (acd.isKoiCareIDExist(koiCareId)) {
            request.setAttribute("idExists", "KoiCareID already exists");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        Account account = new Account();
        account.setKoiCareID(koiCareId);
        account.setProfileImage("https://i.pinimg.com/564x/bc/43/98/bc439871417621836a0eeea768d60944.jpg");
        account.setFullName(fullName);
        account.setPassword(password);
        account.setUserRole("customer");
        account.setAccountStatus(1);

        if (acs.registerUser(account)) {
            HttpSession session = request.getSession();
            session.setAttribute("userAccount", account);
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("register.jsp");
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
