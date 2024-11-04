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
public class FoodCalculatorDetailController extends HttpServlet {
   
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
            String fishInfo  = request.getParameter("fishInfo"); 
            String growthMode = request.getParameter("growth");
            String temp = request.getParameter("temperature");
            String fishId = "";
            String weightF = "";
            if (fishInfo != null){
                String[] parts = fishInfo.split("-");
                fishId = parts[0];
                weightF = parts[1];
            } 
            float weightFish = (float) 0.1;
            float temperatureAvg = (float) 0.1;
            try {
                weightFish = Float.parseFloat(weightF);
            } catch (NumberFormatException e) {
                response.sendRedirect("MainController?action="+IConstant.FOOD_CALCULATOR);
                return;
            }
            try {
                temperatureAvg = Float.parseFloat(temp);
            } catch (NumberFormatException e) {
                response.sendRedirect("MainController?action="+IConstant.FOOD_CALCULATOR);
                return;
            }
            CalculatorService clts = new CalculatorService();
            int amountFood = clts.calculatorFoodForFish(growthMode, weightFish, temperatureAvg);
            String recommend = clts.getDescriptionrecommendation(growthMode, temperatureAvg);
            request.setAttribute("amountFood", amountFood);
            request.setAttribute("growthM", growthMode);
            request.setAttribute("averageTemperature", temperatureAvg);
            request.setAttribute("fishId", fishId);
            request.setAttribute("recommend", recommend);
            request.getRequestDispatcher("MainController?action="+IConstant.FOOD_CALCULATOR).forward(request, response);
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
