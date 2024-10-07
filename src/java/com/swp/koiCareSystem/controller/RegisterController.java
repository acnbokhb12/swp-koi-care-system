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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountDAO acd = new AccountDAO();
        AccountService acs = new AccountService();

        // Get form parameters
        String email = request.getParameter("txtemail");
        String fullName = request.getParameter("txtusername");
        String password = request.getParameter("txtpassword");
        String confirmPassword = request.getParameter("txtconfirmpassword");
        String phoneNumber = request.getParameter("txtphone");
        String gender = request.getParameter("choice-gender");

        // Validation checks
        try {
            // Check if email exists
            if (acd.isEmailExist(email)) {
                request.setAttribute("emailExists", true);
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            // Check if phone number exists
            if (acd.isPhoneNumberExist(phoneNumber)) {
                request.setAttribute("phoneExists", true);
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            // Check if passwords match
            if (!password.equals(confirmPassword)) {
                request.setAttribute("passwordMismatch", true);
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            // Create a new account
            Account account = new Account();
            account.setEmail(email);
            account.setFullName(fullName);

            // Hash the password before setting it
            account.setPassword(AccountService.hashPassword(password));

            account.setPhoneNumber(phoneNumber);
            account.setUserRole("user");
            account.setGender(gender);
            account.setAccountStatus(1);

            // Register the user
            if (acd.registerUser(account)) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("registrationError", true);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("registrationError", true);
            request.getRequestDispatcher("register.jsp").forward(request, response);
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
