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
 * @author ASUS
 */
public class ManagerSearchProductNameController extends HttpServlet {

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
            String name = request.getParameter("searchInput");

            // Check if searchInput is null or empty
            if (name == null || name.trim().isEmpty()) {
                String url = "MainController?action=" + IConstant.PRODUCT_MANAGE;
                response.sendRedirect(url);
                return;
            } else {
                // Trim and replace multiple spaces
                name = name.trim();
                name = name.replaceAll(" +", " ");
            }

            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            if (index < 1) {
                index = 1;
            }

            ProductService pds = new ProductService();
            int count = pds.countProductsByName(name);
            int endPage = count / 20;
            if (count % 20 != 0) {
                endPage++;
            }

            ArrayList<Product> listProduct = pds.managerSearchProductsByName(name, index);
            ArrayList<ProductCategory> listCate = pds.getAllProductCate();

            request.setAttribute("ListC", listCate);
            request.setAttribute("ListP", listProduct);
            request.setAttribute("tag", index);
            request.setAttribute("endPage", endPage);
            request.setAttribute("OldSearch", name);

            request.getRequestDispatcher("manageProduct.jsp").forward(request, response);

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
