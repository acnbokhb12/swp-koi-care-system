/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.model.WaterParameter;
import com.swp.koiCareSystem.model.WaterParameterDetail;
import com.swp.koiCareSystem.service.WaterParameterService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.cloudinary.json.JSONArray;
import org.cloudinary.json.JSONObject;

/**
 *
 * @author ASUS
 */
public class WaterParametersInformationController extends HttpServlet {

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
            response.setContentType("application/json");

            // Sửa lỗi cú pháp ở đây
            int waterParameterId = Integer.parseInt(request.getParameter("waterParameterID"));

            // Giả sử bạn có một phương thức để lấy dữ liệu từ database dựa trên ID này
            WaterParameterService wps = new WaterParameterService();
            WaterParameter waterParameter = wps.getWaterParameterByID(waterParameterId);

            // Chuyển đổi dữ liệu thành JSON
            JSONObject jsonResponse = new JSONObject();

            // Thông tin chung về WaterParameter
            jsonResponse.put("pond", waterParameter.getPond().getName());
            jsonResponse.put("dateTime", waterParameter.getMeasurementDate().toString());
            jsonResponse.put("note", waterParameter.getNote());

            // Tạo mảng chi tiết WaterParameterDetail
            JSONArray detailsArray = new JSONArray();
            for (WaterParameterDetail detail : waterParameter.getWaterParameterDetails()) {
                JSONObject detailObject = new JSONObject();
                detailObject.put("name", detail.getWaterDesc().getName());
                detailObject.put("symbol", detail.getWaterDesc().getSymbol());
                detailObject.put("value", detail.getValue());
                detailObject.put("minValue", detail.getWaterDesc().getMinValue());
                detailObject.put("maxValue", detail.getWaterDesc().getMaxValue());
                detailObject.put("unit", detail.getWaterDesc().getUnit());
                detailObject.put("optimalRange", detail.getWaterDesc().getOptimalRange());
                detailObject.put("description", detail.getWaterDesc().getDescription());

                detailsArray.put(detailObject);
            }

            // Thêm chi tiết vào JSON Response
            jsonResponse.put("details", detailsArray);

            // Trả về JSON dưới dạng response
            out.write(jsonResponse.toString());
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
