/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.Pond;
import com.swp.koiCareSystem.model.WaterParameter;
import com.swp.koiCareSystem.model.WaterParameterDescription;
import com.swp.koiCareSystem.service.PondService;
import com.swp.koiCareSystem.service.WaterParameterService;
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
public class StatisticsSearchPondByIdController extends HttpServlet {
   
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
            String getPondId = request.getParameter("pondId");
            int pondId =1;
            try {
                pondId= Integer.parseInt(getPondId);
            } catch (NumberFormatException e) {
                request.setAttribute("message", "An error occurred while search statistics.");
                request.setAttribute("toastMessage", "error");
                request.getRequestDispatcher("MainController?action="+IConstant.STATISTIC).forward(request, response);
                return;                
            }
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("userAccount");
            PondService ps = new PondService();
            ArrayList<Pond> listMyPond = ps.getAllPondS(acc.getUserID());
            WaterParameterService wtps = new WaterParameterService();
            ArrayList<WaterParameter> listDateStatistics = wtps.getLatesDateToStatistics(acc.getUserID(), pondId);
            ArrayList<WaterParameterDescription> listStatisticsWithUnitMgl = wtps.getListWaterDeailToStaticticsByUnit(acc.getUserID(), pondId, "mg/l");
            ArrayList<WaterParameterDescription> listStatisticsWithUnitTemp = wtps.getListWaterDeailToStaticticsByUnit(acc.getUserID(), pondId, "°C");
            ArrayList<WaterParameterDescription> listStatisticsWithUnitPercent = wtps.getListWaterDeailToStaticticsByUnit(acc.getUserID(), pondId, "%");
            ArrayList<WaterParameterDescription> listStatisticsWithUnitDH = wtps.getListWaterDeailToStaticticsByUnit(acc.getUserID(), pondId, "°dH");
            ArrayList<WaterParameterDescription> listStatisticsWithUnitGram = wtps.getListWaterDeailToStaticticsByUnit(acc.getUserID(), pondId, "g");
            ArrayList<WaterParameterDescription> listStatisticsWithUnitEmpty = wtps.getListWaterDeailToStaticticsByUnit(acc.getUserID(), pondId, "");

            request.setAttribute("listStatisticsWithUnitMgl", listStatisticsWithUnitMgl);
            request.setAttribute("listStatisticsWithUnitTemp", listStatisticsWithUnitTemp);
            request.setAttribute("listStatisticsWithUnitPercent", listStatisticsWithUnitPercent);
            request.setAttribute("listStatisticsWithUnitDH", listStatisticsWithUnitDH);
            request.setAttribute("listStatisticsWithUnitGram", listStatisticsWithUnitGram);
            request.setAttribute("listStatisticsWithUnitEmpty", listStatisticsWithUnitEmpty);
            request.setAttribute("listDateStatistics", listDateStatistics); 
                 
            request.setAttribute("listMyPond", listMyPond);
            request.setAttribute("tagPondId", getPondId);
            request.getRequestDispatcher("statistics.jsp").forward(request, response);
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
