/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.Fish;
import com.swp.koiCareSystem.service.FishService;
import com.swp.koiCareSystem.service.ImageUploadService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author PC
 */
@MultipartConfig
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
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("userAccount");

            if (acc == null) {
                response.sendRedirect("home.jsp");
            } else {

                Part filePart = request.getPart("fileimg");
                String imageUrl = "";
                if (filePart != null) {
                    String tempDir = getServletContext().getRealPath("/") + "uploads";
                    ImageUploadService imgs = new ImageUploadService();
                    try {
                        imageUrl = imgs.uploadImage(filePart, tempDir);
                        System.out.println(imageUrl);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                int accID = acc.getUserID();
                String fishName = request.getParameter("fishName");
                String descriptionKoi = request.getParameter("descriptionKoi");
                String bodyShape = request.getParameter("bodyShape");
                float age = Float.parseFloat(request.getParameter("age"));
                float length = Float.parseFloat(request.getParameter("length"));
                float weight = Float.parseFloat(request.getParameter("weight"));
                String gender = request.getParameter("gender");
                String pondId = request.getParameter("pondkoi");
                int pid = Integer.parseInt(pondId);
 
                Fish newFish = new Fish();

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
                newFish.setPondID(pid);
               

                FishService fsv = new FishService();
                boolean isCreated = fsv.addNewFish(newFish);

                if (isCreated) {
                    request.setAttribute("message", "New Fish has been created");
                    request.setAttribute("toastMessage", "success");

                } else {
                    request.setAttribute("message", "An error occurred while creating the fish.");
                    request.setAttribute("toastMessage", "error");

                }
 
                request.getRequestDispatcher("FishController").forward(request, response);
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
