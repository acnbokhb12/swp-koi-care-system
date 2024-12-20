/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.AccountStatus;
import com.swp.koiCareSystem.service.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class AdminAccountStatusController extends HttpServlet {

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
            Account acc = (Account) session.getAttribute("userAccount");

            // Kiểm tra quyền truy cập
            if (acc == null || acc.getUserRole().equalsIgnoreCase("user")) {
                request.getRequestDispatcher("HomeController").forward(request, response);
                return;
            } else if (acc == null && acc.getUserRole().equalsIgnoreCase("manager")) {
                request.getRequestDispatcher("dashboardManager.jsp").forward(request, response);
                return;
            }

            String statusId = request.getParameter("status");
            int status = 1; 
            if (statusId != null && !statusId.isEmpty()) {
                try {
                    status = Integer.parseInt(statusId); 
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    status = 0; 
                }
            }

            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }

            int index = 1;
            try {
                index = Integer.parseInt(indexPage);
                if (index <= 0) {
                    index = 1;
                }
            } catch (NumberFormatException e) {
                index = 1; 
            }

            AccountService accountService = new AccountService();

            int count = accountService.countAllAccountsStatusToAdminS(status);
            int endPage = count / 10;
            if (count % 10 != 0) {
                endPage++;
            }

            ArrayList<AccountStatus> listStatus = accountService.getAllAccountsStatusToAdminS();
            ArrayList<Account> listAccountSearchStatus = accountService.searchAccountByStatus(status, index);

            request.setAttribute("listAcc", listAccountSearchStatus);
            request.setAttribute("listAccS", listStatus);
            request.setAttribute("tag", index);
            request.setAttribute("endPage", endPage);
            request.setAttribute("statusIdTag", statusId);

            request.getRequestDispatcher("manageAccount.jsp").forward(request, response);
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
