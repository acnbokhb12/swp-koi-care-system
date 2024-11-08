/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.WaterParameter;
import com.swp.koiCareSystem.model.WaterParameterDescription;
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
            String datetime = request.getParameter("datetimeMeasure"); 
            String note = request.getParameter("noteNew");
            WaterParameterService wps = new WaterParameterService();

            WaterParameter waterpara = new WaterParameter();
            waterpara.setAccID(accID);
            waterpara.setPondID(pondID);
            try {
                waterpara.setMeasurementDate(LocalDateTime.parse(datetime));
            } catch (Exception e) {
                request.setAttribute("message", "Please choose date and time ");
                request.setAttribute("toastMessage", "error");
                request.getRequestDispatcher("MainController?action=" + IConstant.WATER_PARAMETERS_MANAGE).forward(request, response);
                return;
            }
            System.out.println(LocalDateTime.parse(datetime));
            waterpara.setNote(note);
            waterpara.setIsActive(true);
            
            ArrayList<WaterParameterDetail> details = new ArrayList<>();
            ArrayList<WaterParameterDescription> listParametersDescription = wps.getAllWaterParameterDescriptions();
             
            for(WaterParameterDescription item : listParametersDescription ){ 
                float value = (float) 0.0;
                String paramValueChar = "waPara" + item.getWaterParameterDescID();
                String paramValue = request.getParameter(paramValueChar);
                if (paramValue != null && !paramValue.trim().isEmpty()) {
                    value = Float.parseFloat(paramValue);
                }
                WaterParameterDetail detail = new WaterParameterDetail();
                detail.setWaterParameterDescID(item.getWaterParameterDescID());
                detail.setValue(value);
                details.add(detail);
            }
                

            waterpara.setWaterParameterDetails(details);
            boolean result = wps.createNewWaterParameter(waterpara);

            if (result) {
                request.setAttribute("message", "New WaterParemeter has been created");
                request.setAttribute("toastMessage", "success");
            } else {
                request.setAttribute("message", "An error occurred while creating WaterParemeter");
                request.setAttribute("toastMessage", "error");
            
            }
                request.getRequestDispatcher("MainController?action=" + IConstant.WATER_PARAMETERS_MANAGE).forward(request, response);
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
