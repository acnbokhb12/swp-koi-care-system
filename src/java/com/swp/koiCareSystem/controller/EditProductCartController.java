/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.OrderItem;
import com.swp.koiCareSystem.model.Product;
import com.swp.koiCareSystem.service.CartService;
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
public class EditProductCartController extends HttpServlet {
   
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
            
            String btnaction = request.getParameter("btnActionEditCart");
            String productId = request.getParameter("txteditId");
            boolean editSuccess = false; 

            if(btnaction != null && !btnaction.isEmpty() && productId != null && !productId.isEmpty()){
                HttpSession session = request.getSession();
                Account acc = (Account) session.getAttribute("userAccount");
                CartService cv = new CartService();
                if(btnaction.equalsIgnoreCase("remove")){
                    editSuccess = cv.deleteProductFromCart(acc.getUserID(), productId);
                    if(editSuccess){
                        ArrayList<OrderItem> getCart = cv.getCart(acc.getUserID());
                        session.setAttribute("cart", getCart);
                        request.setAttribute("message", "Deleted product from cart successfully");
                        request.setAttribute("toastMessage", "success"); 
                    } 
                    else { 
                        request.setAttribute("message", "An error occurred while deleting the product from the cart");
                        request.setAttribute("toastMessage", "error"); 
                    }
                }else{
                    int newQuantity =1;
                    try{
                        newQuantity = Integer.parseInt(request.getParameter("newQuantity"));                        
                    }catch (NumberFormatException e){
                        request.setAttribute("message", "An error occurred while updating quantity of product from cart");
                        request.setAttribute("toastMessage", "error");
                        request.getRequestDispatcher("cart.jsp").forward(request, response);
                        return ;
                    } 
                    editSuccess = cv.updateCart(acc.getUserID(), productId, newQuantity);
                    if(editSuccess){
                          ArrayList<OrderItem> getCart = cv.getCart(acc.getUserID()); 
                        session.setAttribute("cart", getCart);
                        request.setAttribute("message", "Update new quantity of product successfully");
                        request.setAttribute("toastMessage", "success");  
                    }else{
                        request.setAttribute("message", "An error occurred while Updating new quantity of product");
                        request.setAttribute("toastMessage", "error"); 
                    }  
                }
                request.getRequestDispatcher("cart.jsp").forward(request, response);
                
            }else{
                request.setAttribute("message", "An error occurred Edit Product in cart");
                request.setAttribute("toastMessage", "error");
                request.getRequestDispatcher("MainController?action="+ IConstant.SHOP).forward(request, response); 
            }
           

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
