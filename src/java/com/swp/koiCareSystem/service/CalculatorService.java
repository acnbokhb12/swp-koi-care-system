/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.CalculatorDAO;
import com.swp.koiCareSystem.model.FeedPercentage;
import java.util.ArrayList; 
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author DELL
 */
public class CalculatorService {
    private CalculatorDAO calculatorDAO ;
    
    public CalculatorService(){
        this.calculatorDAO = new CalculatorDAO();
    }
    
    public ArrayList<String> getListGrowthMode(){
       ArrayList<String> list = calculatorDAO.getListGrowthMode();
       List<String> uniqueList = list.stream()
                                       .distinct()
                                       .collect(Collectors.toList());
       return (ArrayList<String>) uniqueList;
       
    }
    public ArrayList<FeedPercentage> getMinMaxTemperature(){
        return  calculatorDAO.getMinToMaxTemperature();
    }
    public int calculatorFoodForFish(String growthMode, float weight, float tempuratureAverage){
        float percentage = calculatorDAO.getPercenttageWithTempAndGrmode(growthMode, tempuratureAverage);
        int amountFood= (int) (percentage*weight*1000);
        return amountFood;
    }
    public String getDescriptionrecommendation(String growthMode, float tempuratureAverage ){
        return  calculatorDAO.getDescriptionrecommendation(growthMode, tempuratureAverage);   
    }
    public static void main(String[] args) {
        CalculatorService clts = new CalculatorService();
       int amountFood = clts.calculatorFoodForFish("Low", (float) 0.8, (float) 18.3);
        System.out.println(amountFood);
    }
}
