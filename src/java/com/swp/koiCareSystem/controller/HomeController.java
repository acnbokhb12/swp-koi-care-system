/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.News;
import com.swp.koiCareSystem.model.OrderItem; 
import com.swp.koiCareSystem.model.Product;
import com.swp.koiCareSystem.service.CartService;
import com.swp.koiCareSystem.service.NewsService;
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
 * @author DELL
 */
public class HomeController extends HttpServlet {
   
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
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("userAccount");
            String wasLogined =   (String) session.getAttribute("logined");
            if(acc!=null && wasLogined ==null){
                ArrayList<OrderItem> cart =  (ArrayList<OrderItem>) session.getAttribute("cart");
                if (cart == null || cart.isEmpty()) {
                    CartService cv = new CartService();
                    // Gọi getCart từ Redis nếu giỏ hàng chưa có trong session 
                    ArrayList<OrderItem> getCart = cv.getCart(acc.getUserID());
                    session.setAttribute("cart", getCart);
                    session.setAttribute("logined", "waslogin");
                }
            }
            
            NewsService ns = new NewsService();
            ArrayList<News> lastest = ns.getLatestNewsInHome();
            ProductService ps = new ProductService();
            ArrayList<Product> random = ps.getTop10Product();
            
            request.setAttribute("lastest", lastest);
            request.setAttribute("random", random);
            request.getRequestDispatcher("home.jsp").forward(request, response);
 
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
