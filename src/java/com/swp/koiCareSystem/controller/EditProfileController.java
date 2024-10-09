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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class EditProfileController extends HttpServlet {

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
        HttpSession session = request.getSession();
        Account currentUser = (Account) session.getAttribute("UserAccount");

        if (currentUser != null) {
            int userID = currentUser.getUserID();
            AccountDAO acd = new AccountDAO();
            Account account = null;
            try {
                account = acd.getUserById(userID);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("UserAccount", account);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("editProfile.jsp");
        dispatcher.forward(request, response);
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
        HttpSession session = request.getSession();
        Account currentUser = (Account) session.getAttribute("UserAccount");

        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String gender = request.getParameter("choice-gender");
        String oldPassword = request.getParameter("password_old");
        String newPassword = request.getParameter("password_new");

        AccountService acs = new AccountService();
        AccountDAO acd = new AccountDAO();
        Account accountFromDb = null;
        try {
            accountFromDb = acd.getUserById(currentUser.getUserID());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (!accountFromDb.getEmail().equals(email) && acd.isEmailExist(email)) {
                request.setAttribute("emailExists", "Email address is already in use.");
                doGet(request, response);
                return;
            }

            if (!accountFromDb.getPassword().equals(acs.hashPassword(oldPassword))) {
                request.setAttribute("wrongPassword", "Old password is incorrect.");
                doGet(request, response);
                return;
            }
            // Cập nhật thông tin tài khoản
            boolean isUpdated = acs.updateAccount(currentUser.getUserID(), email, fullName, phoneNumber, address, gender, oldPassword, newPassword);

            if (isUpdated) {
                currentUser.setEmail(email);
                currentUser.setFullName(fullName);
                currentUser.setPhoneNumber(phoneNumber);
                currentUser.setAddress(address);
                currentUser.setGender(gender);
                session.setAttribute("UserAccount", currentUser);
                request.setAttribute("updateSuccess", "Profile updated successfully.");
                doGet(request, response);
            } else {
                request.setAttribute("updateError", "Failed to update profile.");
                doGet(request, response);
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ
            request.setAttribute("updateError", "An error occurred: " + e.getMessage());
            doGet(request, response);
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
