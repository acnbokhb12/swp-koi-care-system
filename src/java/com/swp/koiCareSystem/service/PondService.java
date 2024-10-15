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

    public ArrayList<Pond> GetAllPondS(int accountID) {
        return ponddao.getAllPond(accountID);
    }

    public Pond GetPondInforByIDS(int id) {
        return ponddao.getPondInforByID(id);
    }

    public boolean updatePondImageByPondID(int pid, String imgLink) {
        return ponddao.updatePondImageByPondID(pid, imgLink);
    }

    public ArrayList<Fish> GetAllFishInPondByPondID(int pid) {
        return ponddao.getAllFishInPondByID(pid);
    }
}
