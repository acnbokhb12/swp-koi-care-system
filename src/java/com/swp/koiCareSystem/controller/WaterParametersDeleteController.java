/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.dao.WaterParameterDAO;
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
public class WaterParametersDeleteController extends HttpServlet {

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
            String waterParameterIdStr = request.getParameter("id");

            if (waterParameterIdStr != null && !waterParameterIdStr.trim().isEmpty()) {
                try {
                    int waterParameterId = Integer.parseInt(waterParameterIdStr);

                    // Gọi DAO để xóa bản ghi
                    WaterParameterDAO wpd = new WaterParameterDAO();
                    boolean isDeleted = wpd.deleteWaterParameter(waterParameterId);

                    if (isDeleted) {
                        request.setAttribute("message", "Water Parameter deleted successfully.");
                        request.setAttribute("toastMessage", "success");
                    } else {
                        request.setAttribute("message", "Failed to delete Water Parameter.");
                        request.setAttribute("toastMessage", "error");
                    }

                } catch (NumberFormatException e) {
                    request.setAttribute("message", "Invalid Water Parameter ID.");
                    request.setAttribute("toastMessage", "error");
                }
            } else {
                request.setAttribute("message", "No Water Parameter ID received.");
                request.setAttribute("toastMessage", "error");
            }

            // Chuyển hướng lại trang quản lý
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
