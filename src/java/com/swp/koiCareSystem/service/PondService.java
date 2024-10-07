/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.PondDAO;
import com.swp.koiCareSystem.model.Pond;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class PondService {

    private PondDAO ponddao = new PondDAO();

    public ArrayList<Pond> GetAllPondS() throws SQLException {
        ArrayList<Pond> listPond = ponddao.getAllPond();

        return listPond;
    }

}
