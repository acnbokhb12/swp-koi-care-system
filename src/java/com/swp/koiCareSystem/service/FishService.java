/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.FishDAO;
import com.swp.koiCareSystem.model.Fish;
import com.swp.koiCareSystem.model.FishDevelopment;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class FishService {

    private FishDAO fdao = new FishDAO();

    public ArrayList<Fish> GetAllFishS() throws SQLException {
        ArrayList<Fish> listf = fdao.getAllFish();

        return listf;
    }

  
}
