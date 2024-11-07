/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.WaterParameter;
import com.swp.koiCareSystem.model.WaterParameterDetail;
import com.swp.koiCareSystem.service.WaterParameterService;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class WaterParametersCreateNewController extends HttpServlet {

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
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("userAccount");

            if (acc == null) {
                response.sendRedirect("login.jsp");
            }

            int accID = (acc.getUserID());
            int pondID = Integer.parseInt(request.getParameter("pond"));
            String datetime = request.getParameter("datetime");
            String note = request.getParameter("note");

            WaterParameter waterpara = new WaterParameter();
            waterpara.setAccID(accID);
            waterpara.setPondID(pondID);
            waterpara.setMeasurementDate(LocalDateTime.parse(datetime));
            waterpara.setNote(note);
            waterpara.setIsActive(true);

            ArrayList<WaterParameterDetail> details = new ArrayList<>();

            String[] parameterNames = {"NO2", "O2", "NO3", "temperature", "PO4", "pH", "NH4", "KH", "GH", "CO2", "salt", "fedAmount", "outdoorTemp"};
            for (int i = 0; i < parameterNames.length; i++) {
                String paramValue = request.getParameter(parameterNames[i]);
                if (paramValue != null && !paramValue.isEmpty()) {
                    int waterParameterDescID = i + 1;
                    double value = Double.parseDouble(paramValue);
                    WaterParameterDetail detail = new WaterParameterDetail();
                    detail.setWaterParameterDescID(waterParameterDescID);
                    detail.setValue(value);
                    details.add(detail);
                }
            }

            waterpara.setWaterParameterDetails(details);
            WaterParameterService wps = new WaterParameterService();
            boolean result = wps.addNewWaterParameter(waterpara);

            if (result) {
                //thanh cong
                response.sendRedirect("MainController?action=" + IConstant.WATER_PARAMETERS_MANAGE);
            } else {
                //that bai
                response.sendRedirect("MainController?action=" + IConstant.WATER_PARAMETERS_MANAGE);
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
