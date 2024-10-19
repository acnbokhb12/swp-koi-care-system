/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.Fish; 
import com.swp.koiCareSystem.service.FishService; 
import java.io.IOException;
import java.io.PrintWriter; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class FishUserListController extends HttpServlet {

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

        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("userAccount");

        // Check if the user is logged in
        if (acc == null) {
            response.sendRedirect("home.jsp");
            return;
        }

        // Get user fish ID from request parameter
        String userFishIdStr = request.getParameter("userfishid");

        // Validate the fish ID
        if (userFishIdStr == null || userFishIdStr.isEmpty()) {
            request.setAttribute("error", "Fish ID is required");
            request.getRequestDispatcher("manageFish.jsp").forward(request, response);
            return;
        }

        try {
            int id = Integer.parseInt(userFishIdStr);

            // Get fish data for the logged-in user
            FishService fishService = new FishService();
            Fish fish = fishService.getFishInforByIDS(id);

            if (fish == null) {
                // Handle the case where no fish is found with the given ID
                request.setAttribute("error", "No fish found with the provided ID");
                request.getRequestDispatcher("manageFish.jsp").forward(request, response);
                return;
            }

            // Set the fish object as a request attribute
            request.setAttribute("fish", fish);

            // Forward the request to the JSP page
            request.getRequestDispatcher("manageFish.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Handle the case where the ID is not a valid integer
            request.setAttribute("error", "Invalid Fish ID format");
            request.getRequestDispatcher("manageFish.jsp").forward(request, response);
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
