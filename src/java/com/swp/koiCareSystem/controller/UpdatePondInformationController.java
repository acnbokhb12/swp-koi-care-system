/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.dao.PondDAO;
import com.swp.koiCareSystem.model.Pond;
import com.swp.koiCareSystem.service.PondService;
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
public class UpdatePondInformationController extends HttpServlet {

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
            int pondID = Integer.parseInt(request.getParameter("pondID"));
            String name = request.getParameter("pondName");
            String description = request.getParameter("descriptionPond");
            float depth = Float.parseFloat(request.getParameter("depth"));
            float volume = Float.parseFloat(request.getParameter("volume"));
            int drainCount = Integer.parseInt(request.getParameter("drainCount"));
            float pumpPower = Float.parseFloat(request.getParameter("pumpPower"));
            int numberOfFish = Integer.parseInt(request.getParameter("numberOfFish"));
            int skimmer = Integer.parseInt(request.getParameter("skimmer"));

            Pond pond = new Pond();
            pond.setPondID(pondID);
            pond.setName(name);
            pond.setDescriptionPond(description);
            pond.setDepth(depth);
            pond.setVolume(volume);
            pond.setDrainCount(drainCount);
            pond.setPumpPower(pumpPower);
            pond.setNumberOfFish(numberOfFish);
            pond.setSkimmer(skimmer);

            PondDAO pondDAO = new PondDAO();
            boolean upinfo = pondDAO.updatePondInformationByID(pond);
            
            if (upinfo) {
                request.setAttribute("message", "New Pond has been created");
            } else {
                request.setAttribute("message", "An error occurred while creating the pond.");
            }
            
            PondService ponds = new PondService();

            Pond pin = ponds.GetPondInforByIDS(pondID);
            request.setAttribute("pond", pin);
            request.getRequestDispatcher("pondInfor.jsp").forward(request, response);
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
