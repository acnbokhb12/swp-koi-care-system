/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class WaterParameter {

    private int waterParameterId;
    private int accID;
    private int pondID;
    private LocalDateTime measurementDate;
    private String note;
    private boolean isActive;
    private Pond pond;
    private ArrayList<WaterParameterDetail> waterParameterDetails;

    public WaterParameter() {
    }

    public WaterParameter(int waterParameterId, int accID, int pondID, LocalDateTime measurementDate, String note, boolean isActive, Pond pond, ArrayList<WaterParameterDetail> waterParameterDetails) {
        this.waterParameterId = waterParameterId;
        this.accID = accID;
        this.pondID = pondID;
        this.measurementDate = measurementDate;
        this.note = note;
        this.isActive = isActive;
        this.pond = pond;
        this.waterParameterDetails = waterParameterDetails;
    }

    public int getWaterParameterId() {
        return waterParameterId;
    }

    public void setWaterParameterId(int waterParameterId) {
        this.waterParameterId = waterParameterId;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    
    
    public int getPondID() {
        return pondID;
    }

    public void setPondID(int pondID) {
        this.pondID = pondID;
    }

    public LocalDateTime getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(LocalDateTime measurementDate) {
        this.measurementDate = measurementDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Pond getPond() {
        return pond;
    }

    public void setPond(Pond pond) {
        this.pond = pond;
    }

    public void setWaterParameterDetails(ArrayList<WaterParameterDetail> waterParameterDetails) {
        this.waterParameterDetails = waterParameterDetails;
    }

    public void addWaterParameterDetails(WaterParameterDetail waterParameterDetail) {
        this.waterParameterDetails.add(waterParameterDetail);
    }

    public ArrayList<WaterParameterDetail> getWaterParameterDetails() {
        return waterParameterDetails;
    }

}
