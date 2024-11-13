/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.service.AccountService;
import com.swp.koiCareSystem.service.ContactService;
import com.swp.koiCareSystem.service.NewsService;
import com.swp.koiCareSystem.service.OrderService;
import com.swp.koiCareSystem.service.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class DashboarAdminController extends HttpServlet {
   
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
            AccountService as = new AccountService();
            int countAcc = as.countAllAccountS();
            String totalUsers = "Total Customers";

            NewsService ns = new NewsService();
            int countNews = ns.countAllNews();
            String totalNews = "Total News";

            ContactService cs = new ContactService();
            int countContact = cs.countContact();
            String totalContact = "Total Contacts";

            OrderService os = new OrderService();
            int countOrder = os.countOrders();
            String totalOrder = "Total Orders";
            
            ProductService ps = new ProductService();
            

            request.setAttribute("totalUsers", totalUsers);
            request.setAttribute("accountCount", countAcc);
            request.setAttribute("countNews", countNews);
            request.setAttribute("totalNews", totalNews);
            request.setAttribute("countContact", countContact);
            request.setAttribute("totalContact", totalContact);
            request.setAttribute("countOrder", countOrder);
            request.setAttribute("totalOrder", totalOrder);
            

            request.getRequestDispatcher("dashboardAdmin.jsp").forward(request, response);
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
