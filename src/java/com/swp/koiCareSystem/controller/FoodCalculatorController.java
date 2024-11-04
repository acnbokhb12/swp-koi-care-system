/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swp.koiCareSystem.controller; 
 
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.FeedPercentage;
import com.swp.koiCareSystem.model.Fish;
import com.swp.koiCareSystem.service.CalculatorService;
import com.swp.koiCareSystem.service.FishService;
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
public class FoodCalculatorController extends HttpServlet {
   
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
                    
            FishService fsv = new FishService();
            ArrayList<Fish> listFish = fsv.getAllFishS(acc.getUserID());
            CalculatorService clts = new CalculatorService();
            ArrayList<String> listGrowthMode = clts.getListGrowthMode();
            ArrayList<FeedPercentage> getMinMaxOfTemp = clts.getMinMaxTemperature();
            int lengtArr = getMinMaxOfTemp.size();
            
            request.setAttribute("listFish", listFish);
            request.setAttribute("listGrowthMode", listGrowthMode);
            request.setAttribute("temperatureList", getMinMaxOfTemp);
            request.setAttribute("size", lengtArr);
            request.getRequestDispatcher("foodCalculator.jsp").forward(request, response);
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
