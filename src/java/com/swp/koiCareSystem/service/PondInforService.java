/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.PondDAO;
import com.swp.koiCareSystem.model.Pond;

/**
 *
 * @author PC
 */
public class PondInforService {
     private PondDAO pondDAO;

    public PondInforService() {
        pondDAO = new PondDAO();
    }

    public Pond GetPondInforByIDS(String id) { // Change the parameter type to String
        return pondDAO.getPondInforByID(id);
    }
}
