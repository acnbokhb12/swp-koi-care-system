/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

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
public class AdminSearchAccountController extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("userAccount");

            if (acc != null && acc.getUserRole() != null) {
                if (acc.getUserRole().equalsIgnoreCase("customer")) {
                    request.getRequestDispatcher("HomeController").forward(request, response);
                    return;
                } else if (acc.getUserRole().equalsIgnoreCase("manager")) {
                    request.getRequestDispatcher("dashboardManager.jsp").forward(request, response);
                    return;
                }
            }

            String searchInput = request.getParameter("searchInput");
            String searchChoice = request.getParameter("searchChoice");
            String indexPage = request.getParameter("index");

            AccountService acd = new AccountService();

            int index = 1;
            if (indexPage != null) {
                try {
                    index = Integer.parseInt(indexPage);
                    if (index <= 0) {
                        response.sendRedirect("AdminSearchAccountController?searchInput=" + searchInput + "&searchChoice=" + searchChoice + "&index=1");
                        return;
                    }
                } catch (NumberFormatException e) {
                    response.sendRedirect("AdminSearchAccountController?searchInput=" + searchInput + "&searchChoice=" + searchChoice + "&index=1");
                    return;
                }
            }

            if (searchInput != null) {
                searchInput = searchInput.trim();
                searchInput = searchInput.replaceAll(" +", " ");  
            }

            ArrayList<Account> ListResults = new ArrayList<>();
            int count = 0;

            // Search logic
            if (searchInput.isEmpty()) {
                count = acd.countAllAccountS();
                ListResults = acd.getAllAccountsToAdminS(index);
            } else if (searchChoice != null) {
                switch (searchChoice) {
                    case "phone":
                        count = acd.countAcccountByPhoneNumber(searchInput);
                        ListResults = acd.searchAccountByPhoneNumber(searchInput, index);
                        break;
                    case "name":
                        count = acd.countAcccountByFullName(searchInput);
                        ListResults = acd.searchAccountByFullName(searchInput, index);
                        break;
                    case "email":
                        count = acd.countAcccountByEmail(searchInput);
                        ListResults = acd.searchAccountByEmail(searchInput, index);
                        break;
                    default:
                        break;
                }
            }

            int endPage = count / 10;
            if (count % 10 != 0) {
                endPage++;
            }
            ArrayList<AccountStatus> listStatus = acd.getAllAccountsStatusToAdminS();

            request.setAttribute("listAcc", ListResults); 
            request.setAttribute("listAccS", listStatus);

            request.setAttribute("tag", index);  
            request.setAttribute("endPage", endPage);  
            request.setAttribute("searchInput", searchInput);  
            request.setAttribute("searchChoice", searchChoice);  

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
