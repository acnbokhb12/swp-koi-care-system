/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.Product;
import com.swp.koiCareSystem.model.ProductCategory;
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
public class ProductCateController extends HttpServlet {
   
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
            String cateId = request.getParameter("cateID");
            String indexPage = request.getParameter("index");  
            if(cateId==null){
                cateId = "1";
            }else if(indexPage == null){
                indexPage = "1";
            }
            int cid = Integer.parseInt(cateId);
            int index = Integer.parseInt(indexPage);
            
            ProductService pds = new ProductService();
            int count = pds.CountProductsByCate(cid);
            int endPage = count/32;
            if(count % 32 != 0){
                endPage++;
            }
            ArrayList<Product> listProduct = pds.GetProductsByCateId(cid, index);
            String url = "";
            if(listProduct != null ){
                ArrayList<ProductCategory> listCate = pds.GetAllProductCate();
                request.setAttribute("ListC", listCate);
                request.setAttribute("ListP", listProduct);
                request.setAttribute("tag", index);
                request.setAttribute("endPage", endPage);
                request.setAttribute("cateID", cateId); 
                request.setAttribute("TagsCate", cid); 
                url = "shop.jsp";
            }else{
                url = "MainController?action=" + IConstant.SHOP;
            }
            request.getRequestDispatcher(url).forward(request, response);


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
