/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.FishDAO;
import com.swp.koiCareSystem.model.FishDevelopment;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class FishDevelopmentService {
        private FishDAO fdao = new FishDAO();

        public ArrayList<FishDevelopment> GetAllFishDevelopmentS() throws SQLException {
        ArrayList<FishDevelopment> listfD = fdao.getAllFishDevelopment();

        return listfD;
    }

}
