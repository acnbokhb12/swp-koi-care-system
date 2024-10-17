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
    
    private PondDAO ponddao;
    
    public PondService() {
        ponddao = new PondDAO();
    }
    
    public ArrayList<Pond> getAllPondS(int accountID) {
        return ponddao.getAllPond(accountID);
    }
    
    public Pond getPondInforByID(int id) {
        return ponddao.getPondInforByID(id);
    }
    
    public boolean updatePondImageByPondID(int pid, String imgLink) {
        return ponddao.updatePondImageByPondID(pid, imgLink);
    }
    
    public ArrayList<Fish> GetAllFishInPondByPondID(int pid) {
        return ponddao.getAllFishInPondByID(pid);
    }

    public boolean createNewPond(Pond pond) {
        pond.setImage("https://www.thesprucepets.com/thmb/tucFN5e5O9-vbhr0jhbeL8zkFLY=/3572x0/filters:no_upscale():strip_icc()/GettyImages-1148621267-fbe7fcc9e0eb41078b0ee63bc3edc2b3.jpg");
        return ponddao.createNewPond(pond);
    }
}
