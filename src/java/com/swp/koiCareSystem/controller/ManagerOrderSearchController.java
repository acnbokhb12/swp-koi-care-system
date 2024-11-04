/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.Order;
import com.swp.koiCareSystem.model.OrderStatus;
import com.swp.koiCareSystem.service.OrderService;
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
 * @author ASUS
 */
public class ManagerOrderSearchController extends HttpServlet {

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

            if (acc != null && acc.getUserRole() != null) {
                if (acc.getUserRole().equalsIgnoreCase("customer")) {
                    request.getRequestDispatcher("HomeController").forward(request, response);
                    return;
                } else if (acc.getUserRole().equalsIgnoreCase("admin")) {
                    request.getRequestDispatcher("dashboardAdmin.jsp").forward(request, response);
                    return;
                }
            }

            String searchInput = request.getParameter("searchInput");
            String searchChoice = request.getParameter("searchChoice");
            String indexPage = request.getParameter("index");

            OrderService os = new OrderService();

            int index = 1;
            if (indexPage != null) {
                try {
                    index = Integer.parseInt(indexPage);
                    if (index <= 0) {
                        response.sendRedirect("ManagerOrderSearchController?searchInput=" + searchInput + "&searchChoice=" + searchChoice + "&index=1");
                    }
                } catch (NumberFormatException e) {
                    response.sendRedirect("ManagerOrderSearchController?searchInput=" + searchInput + "&searchChoice=" + searchChoice + "&index=1");
                }
            }

            if (searchInput != null) {
                searchInput = searchInput.trim();
                searchInput = searchInput.replaceAll(" +", " ");
            }

            ArrayList<Order> ListResults = new ArrayList<>();
            int count = 0;

            if (searchInput.isEmpty()) {
                count = os.countOrders();
                ListResults = os.getAllOrders(index);
            } else if (searchChoice != null) {
                switch (searchChoice) {
                    case "name":
                        count = os.countOrdersByCustomerNames(searchInput);
                        ListResults = os.searchOrdersByCustomerNames(searchInput, index);
                        break;
                    case "phone":
                        count = os.countOrdersByPhone(searchInput);
                        ListResults = os.searchOrdersByPhone(searchInput, index);
                        break;
                    case "address":
                        count = os.countOrdersByAddress(searchInput);
                        ListResults = os.searchOrdersByAddress(searchInput, index);
                        break;
                }
            }

            int endPage = count / 10;
            if (count % 10 != 0) {
                endPage++;
            }

            request.setAttribute("ListO", ListResults);
            request.setAttribute("tag", index);
            request.setAttribute("endPage", endPage);
            request.setAttribute("searchInput", searchInput);
            request.setAttribute("searchChoice", searchChoice);

            request.getRequestDispatcher("manageOrder.jsp").forward(request, response);
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
