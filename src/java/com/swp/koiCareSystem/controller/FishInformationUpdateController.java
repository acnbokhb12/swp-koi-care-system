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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                // Lấy các tham số từ request
                int fishID = Integer.parseInt(request.getParameter("fishID"));
                String fishName = request.getParameter("fishName");
                String bodyShape = request.getParameter("bodyShape");
                float age = Float.parseFloat(request.getParameter("age"));
                float length = Float.parseFloat(request.getParameter("length"));
                float weight = Float.parseFloat(request.getParameter("weight"));
                String gender = request.getParameter("gender");
                String descriptionKoi = request.getParameter("descriptionKoi");

                // Tạo đối tượng Fish
                Fish fish = new Fish();
                fish.setFishID(fishID);
                fish.setFishName(fishName);
                fish.setBodyShape(bodyShape);
                fish.setAge(age);
                fish.setLength(length);
                fish.setWeight(weight);
                fish.setGender(gender);
                fish.setDescriptionKoi(descriptionKoi);

                // Cập nhật thông tin cá
                FishDAO fishDAO = new FishDAO();
                boolean isUpdated = fishDAO.updateFishInformationByID(fish);

                // Thông báo cập nhật thành công hay thất bại
                if (isUpdated) {
                    request.setAttribute("message", "Fish information updated successfully.");
                } else {
                    request.setAttribute("message", "An error occurred while updating fish information.");
                }

                // Lấy thông tin cá đã cập nhật
                FishService fishService = new FishService();
                Fish updatedFish = fishService.GetFishInforByIDS(fishID);
                request.setAttribute("fish", updatedFish);
                request.getRequestDispatcher("fishInfor.jsp").forward(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet to update fish information";
    }
}
