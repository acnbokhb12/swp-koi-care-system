/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.dao.AccountDAO;
import com.swp.koiCareSystem.model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("userAccount");

            // Redirect to home if the user is not logged in
            if (acc == null) {
                response.sendRedirect("home.jsp");
                return;
            }
            int accID = Integer.parseInt(request.getParameter("accID"));
            String newKoiCareID = (String) request.getParameter("KoiCareId");
            String fullName = (String) request.getParameter("fullname");
            String newPhoneNumber = (String) request.getParameter("phoneNumber");
            String address = (String) request.getParameter("address");
            String gender = (String) request.getParameter("choice-gender");

            AccountDAO acd = new AccountDAO();
            String currentKoiCareId = acc.getKoiCareID();
            String currentPhoneNumber = acc.getPhoneNumber();

            if (newPhoneNumber != null && !newPhoneNumber.isEmpty() && !newPhoneNumber.equals(currentPhoneNumber)) {
                if (acd.isPhoneNumberExist(newPhoneNumber)) {
                    request.setAttribute("PhoneNumberExist", "Phone number already exists");
                    request.getRequestDispatcher("editProfile.jsp").forward(request, response);
                    return;
                }
            }

            if (newKoiCareID != null && !newKoiCareID.isEmpty() && !newKoiCareID.equals(currentKoiCareId)) {
                if (acd.isKoiCareIDExist(newKoiCareID)) {
                    request.setAttribute("KoiIdExist", "KoiCareId already exists");
                    request.getRequestDispatcher("editProfile.jsp").forward(request, response);
                    return;
                }
                acc.setKoiCareID(newKoiCareID);
            }

            acc.setFullName(fullName);
            acc.setPhoneNumber(newPhoneNumber);
            acc.setAddress(address);
            acc.setGender(gender);
            acc.setUserID(accID);

            boolean updateSuccess = acd.updateAccount(acc);

            if (updateSuccess) {
                request.setAttribute("message", "Your Information updated successfully");
                request.setAttribute("toastMessage", "success");
            } else {
                request.setAttribute("message", "An error occurred while update your information");
                request.setAttribute("toastMessage", "error");
            }

            request.getRequestDispatcher("profilePage.jsp").forward(request, response);
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
