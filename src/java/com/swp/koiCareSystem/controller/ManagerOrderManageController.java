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
import com.swp.koiCareSystem.model.Product;
import com.swp.koiCareSystem.model.ProductCategory;
import com.swp.koiCareSystem.service.OrderService;
import com.swp.koiCareSystem.service.ProductService;
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
public class ManagerOrderManageController extends HttpServlet {

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

            if (acc.getUserRole().equalsIgnoreCase("customer")) {
                request.getRequestDispatcher("HomeController").forward(request, response);
            } else if (acc.getUserRole().equalsIgnoreCase("admin")) {
                request.getRequestDispatcher("dashboardAdmin.jsp").forward(request, response);
            }

            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }

            int index = 1;

            try {
                index = Integer.parseInt(indexPage);
                if (index <= 0) {
                    response.sendRedirect("MainController?action=" + IConstant.MANAGER_ORDER_MANAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("MainController?action=" + IConstant.MANAGER_ORDER_MANAGE);
                return;
            }

            OrderService os = new OrderService();
            int count = os.countOrders();//20

            int endPage = count / 10;
            if (count % 10 != 0) {
                endPage++;
            }
            ArrayList<Order> listOrder = os.getAllOrders(index);
            ArrayList<OrderStatus> listStatus = os.getAllOrderStatuses();

            request.setAttribute("ListO", listOrder);
            request.setAttribute("ListS", listStatus);
            request.setAttribute("tag", index);
            request.setAttribute("endPage", endPage);
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
