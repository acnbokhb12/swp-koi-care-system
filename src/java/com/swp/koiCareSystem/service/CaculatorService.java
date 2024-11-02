/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.CaculatorDAO;
import com.swp.koiCareSystem.model.FeedPercentage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
    public int calculatorFoodForFish(String growthMode, float weight, float tempuratureAverage){
        float percentage = caculatorService.getPercenttageWithTempAndGrmode(growthMode, tempuratureAverage);
        int amountFood= (int) (percentage*weight*1000);
        return amountFood;
    }
    public static void main(String[] args) {
        CaculatorService clts = new CaculatorService();
       int amountFood = clts.calculatorFoodForFish("Low", (float) 0.8, (float) 18.3);
        System.out.println(amountFood);
    }
}
