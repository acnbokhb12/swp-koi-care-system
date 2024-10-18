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
        if(f.getPondID() > 0){            
            PondService psv = new PondService();
            int quantityFishInPond = psv.getNumberFishInPond(f.getPondID());
            quantityFishInPond += 1;
            boolean isUpdateQuantity = psv.updateNumberFishInPond(quantityFishInPond, f.getPondID());
            if (!isUpdateQuantity)
                return false; 
        }
        return  fishDAO.addNewFish(f);
    }
    public boolean deletFishByID(String fishId, int pondId){
        if(pondId > 0){            
            PondService psv = new PondService();
            int quantityFishInPond = psv.getNumberFishInPond(pondId);
             quantityFishInPond -= 1;
            boolean isUpdateQuantity = psv.updateNumberFishInPond(quantityFishInPond, pondId);
            if (!isUpdateQuantity)
                return false; 
        }
        return  fishDAO.deleteFishByID(fishId);
    }
    public boolean updateFishInformationByID(Fish f, int oldPondId){
        PondService psv = new PondService();
        if(oldPondId == 0){
            if(f.getPondID() > 0){
                int quantityFishInPond = psv.getNumberFishInPond(f.getPondID());
                quantityFishInPond += 1; 
                boolean isUpdateQuantity = psv.updateNumberFishInPond(quantityFishInPond, f.getPondID());
                if (!isUpdateQuantity)
                    return false;
            }
        }else{
            if(f.getPondID()== 0){
                int quantityFishInOldPond = psv.getNumberFishInPond(oldPondId); // lay cai quantity old pond khi chuyen
                quantityFishInOldPond -= 1;
                boolean isUpdateQuantity = psv.updateNumberFishInPond(quantityFishInOldPond, oldPondId);
                if (!isUpdateQuantity)
                    return false;
            }else if(f.getPondID() != oldPondId){
// Decrease quantity of fish in old pond                
                int quantityFishInOldPond = psv.getNumberFishInPond(oldPondId);
                quantityFishInOldPond  -= 1;
                 if (quantityFishInOldPond < 0) return false;
                boolean isUpdateQuantityOld = psv.updateNumberFishInPond(quantityFishInOldPond , oldPondId);
                if (!isUpdateQuantityOld)
                    return false; 
// Increase quantity of fish in old pond              
                int quantityNewPond = psv.getNumberFishInPond(f.getPondID());
                quantityNewPond += 1;
                boolean isUpdateQuantityNew = psv.updateNumberFishInPond(quantityNewPond, f.getPondID());
                if (!isUpdateQuantityNew)
                    return false;
            }
        }
        return fishDAO.updateFishInformationByID(f);
    }
    public int countFishInPondByPondId(int pondID){
        return fishDAO.countFishInPondByPondId(pondID);
    }
 
}

