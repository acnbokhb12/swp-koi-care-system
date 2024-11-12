/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.Fish;
import com.swp.koiCareSystem.model.Pond;
import com.swp.koiCareSystem.service.AccountService;
import com.swp.koiCareSystem.service.FishService;
import com.swp.koiCareSystem.service.PondService;
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
 * @author PC
 */
public class ManagerAquariumDetailsController extends HttpServlet {

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
            
            int accID = 1;
            try {
                 accID = Integer.parseInt(request.getParameter("acid"));                
            } catch (NumberFormatException e) {
                response.sendRedirect("MainController?action="+IConstant.ACCOUNT_FISH_MANAGE);
                return;
            }
            
            
            FishService fs = new FishService();
            PondService ps = new PondService();
            
            int fishCount = fs.countAllFishByIdS(accID);
            request.setAttribute("fishCount", fishCount);

            int pondCount = ps.countAllPondsByIdS(accID);
            request.setAttribute("pondCount", pondCount);

            ArrayList<Fish> listFish = fs.getAllFishS(accID);
            ArrayList<Pond> listPonds = ps.getAllPondS(accID);

            request.setAttribute("acid", accID);
            request.setAttribute("listFish", listFish);
            request.setAttribute("listPond", listPonds);

            request.getRequestDispatcher("manageAquariumDetails.jsp").forward(request, response);
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
