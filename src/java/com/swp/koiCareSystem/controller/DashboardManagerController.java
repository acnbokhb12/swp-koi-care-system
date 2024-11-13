/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.Order;
import com.swp.koiCareSystem.model.OrderItem;
import com.swp.koiCareSystem.model.Product;
import com.swp.koiCareSystem.service.OrderService;
import com.swp.koiCareSystem.service.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class DashboardManagerController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            OrderService os = new OrderService();
            ProductService ps = new ProductService();

            int totalCustomers = os.countTotalCustomersOrder();
            int totalOrders = os.countOrders();
            int totalProduct = ps.countAllProduct();
            double totalAmount = os.countTotalAmountOrder();

            OrderItem mostOrderedItem = os.getMostOrderedProductWithDetails();
            ArrayList<Order> listOrder5Month = os.getAmountPast5Month();
            ArrayList<Order> listOrder7Days = os.getAmountPast7Days();

            request.setAttribute("totalAmount", totalAmount);
            request.setAttribute("totalCustomers", totalCustomers);
            request.setAttribute("totalOrders", totalOrders);
            request.setAttribute("totalProduct", totalProduct);
            request.setAttribute("orders5M", listOrder5Month);
            request.setAttribute("orders7D", listOrder7Days);
            
            
            if (mostOrderedItem != null && mostOrderedItem.getProduct() != null) {
                Product mostOrderedProduct = mostOrderedItem.getProduct();

                int orderCount = os.countOrdersForProduct(mostOrderedProduct.getProductID());
                request.setAttribute("bestProduct", mostOrderedProduct);
                request.setAttribute("orderCount", orderCount);
            } else {
                request.setAttribute("bestProduct", null);
                request.setAttribute("orderCount", 0);
            }
            Account topSpender = os.getTopSpender();
            if (topSpender != null) {
                request.setAttribute("topSpender", topSpender);
            } else {
                request.setAttribute("topSpender", null);
            }

            request.getRequestDispatcher("dashboardManager.jsp").forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
