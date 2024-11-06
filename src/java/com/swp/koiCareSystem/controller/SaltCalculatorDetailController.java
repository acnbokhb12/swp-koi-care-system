/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.service.CalculatorService;
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
public class SaltCalculatorDetailController extends HttpServlet {
   
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
            String pondInfor = request.getParameter("pondInFor");
            String pondId = "";
            String volumePond = "";
            if(pondInfor!=null){
                String[] parts = pondInfor.split("-");
                pondId = parts[0];
                volumePond = parts[1];
            }
            String currentConcentration = request.getParameter("currentConcentration");
            String desiredConcentration = request.getParameter("desiredConcentration");
            String waterChange = request.getParameter("waterChange");
            float volume = 0;
            float currentConcentrate = 0;
            float desiredConcentrate = 0;
            int waterChageNum = 0;
            try {
                volume = Float.parseFloat(volumePond);
                currentConcentrate = Float.parseFloat(currentConcentration);
                desiredConcentrate = Float.parseFloat(desiredConcentration);
                waterChageNum = Integer.parseInt(waterChange);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                request.setAttribute("message", "An error occurred while deleting the pond.");
                request.setAttribute("toastMessage", "error");
                request.getRequestDispatcher("MainController?action="+IConstant.SALT_CALCULATOR).forward(request, response);
                return;
            }
            CalculatorService clts = new CalculatorService();
            float amountOfSalt = clts.calculateAmountOfSalt(volume, desiredConcentrate, currentConcentrate);
            float perWaterChange = clts.calculatePerWaterChange(waterChageNum, volume, desiredConcentrate);
            request.setAttribute("amountOfSalt", amountOfSalt);
            request.setAttribute("perWaterChange", perWaterChange);
            request.setAttribute("pondId", pondId);
            request.setAttribute("desiredConcentration", desiredConcentration);
            request.setAttribute("currentConcentration", currentConcentration);
            request.setAttribute("waterChange", waterChange);
            request.getRequestDispatcher("MainController?action="+IConstant.SALT_CALCULATOR).forward(request, response);

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
