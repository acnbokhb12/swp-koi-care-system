/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.dao.FishDAO;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.Fish;
import com.swp.koiCareSystem.service.FishService;
import com.swp.koiCareSystem.service.ImageUploadService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author PC
 */
public class FishCreateNewController extends HttpServlet {

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
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("userAccount");

            if (acc == null) {
                response.sendRedirect("home.jsp");
                return;
            }

            Part filePart = request.getPart("fileimg"); // Assuming this part handles the fish image upload
            String tempDir = getServletContext().getRealPath("/") + "uploads";
            ImageUploadService imgs = new ImageUploadService();
            String imageUrl = "";

            Fish newFish = new Fish();

            try {
                imageUrl = imgs.uploadImage(filePart, tempDir); // Upload the image and get the URL
                System.out.println(imageUrl);
            } catch (Exception e) {
                e.printStackTrace();
                // You may want to handle the error case, e.g., by returning or notifying the user
            }

            int accID = acc.getUserID();
            String fishName = request.getParameter("fishName");
            String descriptionKoi = request.getParameter("descriptionKoi");
            String bodyShape = request.getParameter("bodyShape");
            float age = Float.parseFloat(request.getParameter("age"));
            float length = Float.parseFloat(request.getParameter("length"));
            float weight = Float.parseFloat(request.getParameter("weight"));
            String gender = request.getParameter("gender");

            FishDAO fishDAO = new FishDAO();

            newFish.setAccID(accID);
            newFish.setFishImage(imageUrl);
            newFish.setFishName(fishName);
            newFish.setDescriptionKoi(descriptionKoi);
            newFish.setBodyShape(bodyShape);
            newFish.setAge(age);
            newFish.setLength(length);
            newFish.setWeight(weight);
            newFish.setGender(gender);
            newFish.setIsActive(true);

            boolean isCreated = fishDAO.createNewFish(newFish); // Call method to create new fish

            FishService fishService = new FishService();
            ArrayList<Fish> fishList = fishService.GetAllFishS(acc.getUserID()); // Assuming this gets all fish for the user

            if (isCreated) {
                request.setAttribute("message", "New Fish has been created");
            } else {
                request.setAttribute("message", "An error occurred while creating the fish.");
            }

            request.setAttribute("listFish", fishList); // Store the fish list in the request
            request.getRequestDispatcher("fish.jsp").forward(request, response); // Forward to the fish.jsp page

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
