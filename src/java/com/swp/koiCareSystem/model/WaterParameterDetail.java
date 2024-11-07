/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.model;

/**
 *
 * @author ASUS
 */
public class WaterParameterDetail {

    private int id;
    private int waterParameterID;
    private int waterParameterDescID;
    private Double value;
    private WaterParameterDescription waterDesc;

    public WaterParameterDetail() {
    }

    public WaterParameterDetail(int id, int waterParameterID, int waterParameterDescID, double value, WaterParameterDescription waterDesc) {
        this.id = id;
        this.waterParameterID = waterParameterID;
        this.waterParameterDescID = waterParameterDescID;
        this.value = value;
        this.waterDesc = waterDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWaterParameterID() {
        return waterParameterID;
    }

    public void setWaterParameterID(int waterParameterID) {
        this.waterParameterID = waterParameterID;
    }

    public int getWaterParameterDescID() {
        return waterParameterDescID;
    }

    public void setWaterParameterDescID(int waterParameterDescID) {
        this.waterParameterDescID = waterParameterDescID;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public WaterParameterDescription getWaterDesc() {
        return waterDesc;
    }

    public void setWaterDesc(WaterParameterDescription waterDesc) {
        this.waterDesc = waterDesc;
    }

}
