/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.FishDAO;
import com.swp.koiCareSystem.model.Fish;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class FishInforService {

    private FishDAO fishDAO;

    public FishInforService() {
        fishDAO = new FishDAO();
    }

    public Fish GetFishInforByIDS(String id) { // Change the parameter type to String
        return fishDAO.getFishInforByID(id);
    }
}
