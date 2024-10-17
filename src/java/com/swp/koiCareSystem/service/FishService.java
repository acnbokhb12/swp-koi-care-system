/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.FishDAO;
import com.swp.koiCareSystem.model.Fish; 
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class FishService {
     private FishDAO fishDAO;

    public FishService() {
        fishDAO = new FishDAO();
    }

    // Get all fish for the specific account ID
    public ArrayList<Fish> GetAllFishS(int accountID) {
        return fishDAO.getAllFish(accountID); 

}
    public Fish GetFishInforByIDS (int id) { // Change the parameter type to String
        return fishDAO.getFishInforByID(id);
    }
    public boolean updateFishImageByPondId(int pid, String imgLink) {
        return fishDAO.updateFishImageByFishID(pid, imgLink);
    }
    public boolean addNewFish(Fish f){
        if(f.getFishImage() == null || f.getFishImage().isEmpty() ){
            f.setFishImage("https://plus.unsplash.com/premium_photo-1723672584731-52b5f1a67543?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8a29pJTIwZmlzaHxlbnwwfHwwfHx8MA%3D%3D");
        }
        return  fishDAO.addNewFish(f);
    }
    public boolean deletFishByID(String fishId){
        return  fishDAO.deleteFishByID(fishId);
    }
    public boolean updateFishInformationByID(Fish f){
        return fishDAO.updateFishInformationByID(f);
    }
 
}

