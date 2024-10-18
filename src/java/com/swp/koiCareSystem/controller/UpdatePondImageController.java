/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.model.Pond;
import com.swp.koiCareSystem.service.ImageUploadService;
import com.swp.koiCareSystem.service.PondService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ASUS
 */
public class UpdatePondImageController extends HttpServlet {

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
            Part filePart = request.getPart("fileimg");
            String tempDir = getServletContext().getRealPath("/") + "uploads";
            ImageUploadService imgs = new ImageUploadService();
            String imageUrl = "";
            try {
                imageUrl = imgs.uploadImage(filePart, tempDir);
                System.out.println(imageUrl);

            } catch (Exception e) {
                e.printStackTrace();

            }
            int pondID = Integer.parseInt(request.getParameter("pondID"));

            PondService ponds = new PondService();
            boolean upImage = ponds.updatePondImageByPondID(pondID, imageUrl);

            if (upImage) {
                request.setAttribute("message", "Image of pond updated successfully");
                request.setAttribute("toastMessage", "success");

            } else {
                request.setAttribute("message", "Error occurred while updating image of pond");
                request.setAttribute("toastMessage", "error");

            }
            Pond updatedPond = ponds.getPondInforByID(pondID);
            request.setAttribute("pond", updatedPond);

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
