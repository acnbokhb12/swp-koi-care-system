/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.CaculatorDAO;
import com.swp.koiCareSystem.model.FeedPercentage;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CaculatorService {
    private CaculatorDAO caculatorService ;
    
    public CaculatorService(){
        this.caculatorService = new CaculatorDAO();
    }
    
    public ArrayList<String> getListGrowthMode(){
        return caculatorService.getListGrowthMode();
    }
    public ArrayList<FeedPercentage> getMinMaxTemperature(){
        return  caculatorService.getMinToMaxTemperature();
    }
}
