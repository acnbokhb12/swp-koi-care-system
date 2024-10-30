/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.dao.FishDAO;
import com.swp.koiCareSystem.model.Fish;
import com.swp.koiCareSystem.service.FishService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class FishInformationUpdateController extends HttpServlet {

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

            // Lấy các tham số từ request
            int fishID = Integer.parseInt(request.getParameter("fishID"));
            String fishName = request.getParameter("fishName");
            String bodyShape = request.getParameter("bodyShape");
            float age = Float.parseFloat(request.getParameter("age")); 
            String gender = request.getParameter("gender");
            String descriptionKoi = request.getParameter("descriptionKoi");
            String pondId = request.getParameter("pondkoi");
            int pid = Integer.parseInt(pondId);
            int oldPond = Integer.parseInt(request.getParameter("oldPond"));

            // Tạo đối tượng Fish
            Fish fish = new Fish();
            fish.setFishID(fishID);
            fish.setFishName(fishName);
            fish.setBodyShape(bodyShape);
            fish.setAge(age); 
            fish.setGender(gender);
            fish.setDescriptionKoi(descriptionKoi);
            fish.setPondID(pid);
              
            // Cập nhật thông tin cá
//            FishDAO fishDAO = new FishDAO();
//            boolean isUpdated = fishDAO.updateFishInformationByID(fish);
            FishService fsv = new FishService();
            boolean isUpdated = fsv.updateFishInformationByID(fish, oldPond);

            // Thông báo kết quả
            if (isUpdated) {
                request.setAttribute("message", "Fish information updated successfully");
                request.setAttribute("toastMessage", "success");

            } else {
                request.setAttribute("message", "Error occurred while updating fish information");
                request.setAttribute("toastMessage", "error");

            }

            request.getRequestDispatcher("FishInforController?fid=" + fishID).forward(request, response);

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
