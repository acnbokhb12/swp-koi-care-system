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
    private float value;
    private WaterParameterDescription waterDesc;

    public WaterParameterDetail() {
    }

    public WaterParameterDetail(int id, int waterParameterID, int waterParameterDescID, float value, WaterParameterDescription waterDesc) {
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public WaterParameterDescription getWaterDesc() {
        return waterDesc;
    }

    public void setWaterDesc(WaterParameterDescription waterDesc) {
        this.waterDesc = waterDesc;
    }

    @Override
    public String toString() {
        return "WaterParameterDetail{" + "id=" + id + ", waterParameterID=" + waterParameterID + ", waterParameterDescID=" + waterParameterDescID + ", value=" + value + ", waterDesc=" + waterDesc + '}';
    }
    
}
