/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.model;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class WaterParameterDescription {

    private int waterParameterDescID;
    private String name;
    private String symbol;
    private float minValue;
    private float maxValue;
    private String unit;
    private String optimalRange;
    private String description;
    private ArrayList<WaterParameterDetail> listWaterParameterDetail;

    public WaterParameterDescription() {
          this.listWaterParameterDetail = new ArrayList<>();
    }

    public WaterParameterDescription(int waterParameterDescID, String name, String symbol, float minValue, float maxValue, String unit, String optimalRange, String description) {
        this.waterParameterDescID = waterParameterDescID;
        this.name = name;
        this.symbol = symbol;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = unit;
        this.optimalRange = optimalRange;
        this.description = description;
    }

    public int getWaterParameterDescID() {
        return waterParameterDescID;
    }

    public void setWaterParameterDescID(int waterParameterDescID) {
        this.waterParameterDescID = waterParameterDescID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getOptimalRange() {
        return optimalRange;
    }

    public void setOptimalRange(String optimalRange) {
        this.optimalRange = optimalRange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<WaterParameterDetail> getListWaterParameterDetail() {
        return listWaterParameterDetail;
    }

    public void setListWaterParameterDetail(ArrayList<WaterParameterDetail> value) {
        this.listWaterParameterDetail = value;
    }
    public void addValueWaterParameterDetail(WaterParameterDetail value){
        this.listWaterParameterDetail.add(value);
    }

    @Override
    public String toString() {
        return "WaterParameterDescription{" + "waterParameterDescID=" + waterParameterDescID + ", name=" + name + ", symbol=" + symbol + ", minValue=" + minValue + ", maxValue=" + maxValue + ", unit=" + unit + ", optimalRange=" + optimalRange + ", description=" + description + ", listWaterParameterDetail=" + listWaterParameterDetail + '}';
    } 

}
