/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.PondDAO;
import com.swp.koiCareSystem.model.Fish;
import com.swp.koiCareSystem.model.Pond;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class PondService {
    
    private PondDAO pd;
    
    public PondService() {
        pd = new PondDAO();
    }
    
    public ArrayList<Pond> getAllPondS(int accountID) {
        return pd.getAllPond(accountID);
    }
    
    public Pond getPondInforByID(int id) {
        return pd.getPondInforByID(id);
    }
    
    public boolean updatePondImageByPondID(int pid, String imgLink) {
        return pd.updatePondImageByPondID(pid, imgLink);
    }
    
    public ArrayList<Fish> GetAllFishInPondByPondID(int pid) {
        return pd.getAllFishInPondByID(pid);
    }

    public boolean createNewPond(Pond pond) {
        pond.setImage("https://www.thesprucepets.com/thmb/tucFN5e5O9-vbhr0jhbeL8zkFLY=/3572x0/filters:no_upscale():strip_icc()/GettyImages-1148621267-fbe7fcc9e0eb41078b0ee63bc3edc2b3.jpg");
        return pd.createNewPond(pond);
    }
    public boolean deletePondByID(String pondId){
        return pd.deletePondByID(pondId);
    }
}
