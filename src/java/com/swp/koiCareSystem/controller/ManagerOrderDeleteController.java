/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.Order;
import com.swp.koiCareSystem.service.OrderService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class ManagerOrderDeleteController extends HttpServlet {

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
            String orderIdStr = request.getParameter("orderId");
            String statusId = request.getParameter("statusId");
            String index = request.getParameter("index");

            OrderService os = new OrderService();
            String message;
            String toastMessage;

            try {
                int orderId = Integer.parseInt(orderIdStr);
                Order order = os.getOrderById(orderId);

                if (order != null) {
                    boolean isDeleted = os.deleteOrder(orderId);

                    if (isDeleted) {
                        toastMessage = "success";
                        message = "Order deleted successfully.";
                    } else {
                        toastMessage = "error";
                        message = "Failed to delete the order.";
                    }
                } else {
                    toastMessage = "error";
                    message = "Order not found.";
                }
            } catch (NumberFormatException e) {
                toastMessage = "error";
                message = "Invalid order ID.";
            }

            request.getSession().setAttribute("toastMessage", toastMessage);
            request.getSession().setAttribute("message", message);

            if (statusId != null && !statusId.isEmpty()) {
                response.sendRedirect("ManagerOrderSearchByOrderStatusController?status=" + statusId + "&index=" + (index != null ? index : "1"));
            } else {
                response.sendRedirect("MainController?action=" + IConstant.MANAGER_ORDER_MANAGE + "&index=" + (index != null ? index : "1"));
            }
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
