/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.controller;

import com.swp.koiCareSystem.service.EmailService;
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
public class ContactController extends HttpServlet {

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
            String firstName = request.getParameter("firstName");
            String email = request.getParameter("email");
            String message = request.getParameter("message");

            // Gửi lại cho admin xem 
            String subject = "Contact Form Submission from " + firstName;
            String messageContent = "You have received a new message from the contact form:\n\n"
                    + "Name: " + firstName + "\n"
                    + "Email: " + email + "\n\n"
                    + "Message:\n" + message;

            // Gửi email lại cho khách hàng
            String thankYouSubject = "Thank you for contacting us!";
            String thankYouMessage = "Dear " + firstName + ",\n\n"
                    + "Thank you for reaching out! We've received your message and will respond shortly.\n\n"
                    + "Best regards,\n"
                    + "TEAM FIVE";

            EmailService emailService = new EmailService();
            boolean isSentToAdmin = emailService.send("kyhnse182995@fpt.edu.vn", subject, messageContent);

            if (isSentToAdmin) {
                boolean isSentToCustomer = emailService.send(email, thankYouSubject, thankYouMessage);
                if (isSentToCustomer) {
                    request.setAttribute("message", "Your message has been sent successfully! A confirmation email has been sent to you.");
                } else {
                    request.setAttribute("message", "Your message has been sent, but there was an error sending the confirmation email");
                }
            } else {
                request.setAttribute("message", "There was an error sending your message. Please try again later.");
            }
            request.getRequestDispatcher("contact.jsp").forward(request, response);
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
