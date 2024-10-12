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
public class ProfileInformationController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("userAccount");

        // Redirect to home if the user is not logged in
        if (acc == null) {
            response.sendRedirect("home.jsp");
            return;
        }
        int accID = Integer.parseInt(request.getParameter("accID"));
        String newKoiCareID = request.getParameter("KoiCareId");
        String fullName = request.getParameter("fullname");
        String newPhoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String gender = request.getParameter("choice-gender");

        String currentKoiCareId = acc.getKoiCareID();
        String currentPhoneNumber = acc.getPhoneNumber();

        AccountDAO acd = new AccountDAO();

        if (newPhoneNumber != null && !newPhoneNumber.isEmpty() && !newPhoneNumber.equals(currentPhoneNumber)) {
            if (acd.isPhoneNumberExist(newPhoneNumber)) {
                request.setAttribute("PhoneNumberExist", "Phone number already exists");
                request.getRequestDispatcher("MainController?action=editprofileJsp").forward(request, response);
                return;
            }
        }

        if (newKoiCareID != null && !newKoiCareID.isEmpty() && !newKoiCareID.equals(currentKoiCareId)) {
            if (acd.isKoiCareIDExist(newKoiCareID)) {
                request.setAttribute("KoiIdExist", "KoiCareId already exists");
                request.getRequestDispatcher("MainController?action=editprofileJsp").forward(request, response);
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
            request.getRequestDispatcher("MainController?action=profileJsp").forward(request, response);
        } else {
            request.getRequestDispatcher("MainController?action=editprofileJsp").forward(request, response);
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
