/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.WaterParameterDAO;
import com.swp.koiCareSystem.model.WaterParameter;
import com.swp.koiCareSystem.model.WaterParameterDescription;
import com.swp.koiCareSystem.model.WaterParameterDetail;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class WaterParameterService {

    private WaterParameterDAO wpd;

    public WaterParameterService() {
        this.wpd = new WaterParameterDAO();
    }

    public ArrayList<WaterParameter> getWaterParametersByAccID(int accID) {
        return wpd.getWaterParametersByAccID(accID);
    }

    public ArrayList<WaterParameterDescription> getAllWaterParameterDescriptions() {
        return wpd.getAllWaterParameterDescriptions();
    }

    public WaterParameter getWaterParameterByID(int waterParameterID) {
        return wpd.getWaterParameterByID(waterParameterID);
    }

    public boolean createNewWaterParameter(WaterParameter newWaterParameter) {
        return wpd.createNewWaterParameter(newWaterParameter);
    }

    public boolean updateWaterParameter(WaterParameter updatewaterParameter) {
        return wpd.updateWaterParameter(updatewaterParameter);
    }

    public boolean isDateTimeExist(int pondID, LocalDateTime measurementDate) {
        return wpd.isDateTimeExist(pondID, measurementDate);
    }
}
