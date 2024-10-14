/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.dao.PondDAO;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.Pond;
import com.swp.koiCareSystem.service.ImageUploadService;
import com.swp.koiCareSystem.service.PondService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ASUS
 */
@MultipartConfig
public class AddNewPondController extends HttpServlet {

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

            Part filePart = request.getPart("fileimg");
            String tempDir = getServletContext().getRealPath("/") + "uploads";
            ImageUploadService imgs = new ImageUploadService();
            String imageUrl = "";

            Pond newPond = new Pond();

            try {
                imageUrl = imgs.uploadImage(filePart, tempDir);
                System.out.println(imageUrl);

            } catch (Exception e) {
                e.printStackTrace();

            }

            String name = request.getParameter("pondName");
            float depth = Float.parseFloat(request.getParameter("depth"));
            float volume = Float.parseFloat(request.getParameter("volume"));
            int drainCount = Integer.parseInt(request.getParameter("drainCount"));
            float pumpPower = Float.parseFloat(request.getParameter("pumpPower"));
            String descriptionPond = request.getParameter("descriptionPond");
            int numberOfFish = Integer.parseInt(request.getParameter("numberOfFish"));
            int skimmerQuantity = Integer.parseInt(request.getParameter("skimmer"));

            newPond.setImage(imageUrl);
            newPond.setName(name);
            newPond.setDepth(depth);
            newPond.setVolume(volume);
            newPond.setDrainCount(drainCount);
            newPond.setPumpPower(pumpPower);
            newPond.setDescriptionPond(descriptionPond);
            newPond.setNumberOfFish(numberOfFish);
            newPond.setSkimmer(skimmerQuantity);
            newPond.setIsActive(true);

            PondDAO pd = new PondDAO();
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("userAccount");
            int acid = acc.getUserID();;
            newPond.setAccID(acid);

            boolean isPondCreated = pd.createNewPond(newPond);

            PondService ponds = new PondService();
            ArrayList<Pond> listP = ponds.GetAllPondS(acc.getUserID());

            request.setAttribute("listPonds", listP);
            request.getRequestDispatcher("pond.jsp").forward(request, response);
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
