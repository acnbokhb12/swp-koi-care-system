/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.model;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class FishDevelopment {

    private int fishDevelopmentID;
    private int fishID;
    private Date updateDate;
    private float updateLength;
    private float updateWeight;

    public FishDevelopment() {
    }

    public FishDevelopment(int fishDevelopmentID, int fishID, Date updateDate, float updateLength, float updateWeight) {
        this.fishDevelopmentID = fishDevelopmentID;
        this.fishID = fishID;
        this.updateDate = updateDate;
        this.updateLength = updateLength;
        this.updateWeight = updateWeight;
    }

    public FishDevelopment(int fishID, Date updateDate, float updateLength, float updateWeight) {
        this.fishID = fishID;
        this.updateDate = updateDate;
        this.updateLength = updateLength;
        this.updateWeight = updateWeight;
    }
    

    public int getFishDevelopmentID() {
        return fishDevelopmentID;
    }

    public void setFishDevelopmentID(int fishDevelopmentID) {
        this.fishDevelopmentID = fishDevelopmentID;
    }

    public int getFishID() {
        return fishID;
    }

    public void setFishID(int fishID) {
        this.fishID = fishID;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public float getUpdateLength() {
        return updateLength;
    }

    public void setUpdateLength(float updateLength) {
        this.updateLength = updateLength;
    }

    public float getUpdateWeight() {
        return updateWeight;
    }

    public void setUpdateWeight(float updateWeight) {
        this.updateWeight = updateWeight;
    }

    @Override
    public String toString() {
        return "FishDevelopment{" + "fishDevelopmentID=" + fishDevelopmentID + ", fishID=" + fishID + ", updateDate=" + updateDate + ", updateLength=" + updateLength + ", updateWeight=" + updateWeight + '}';
    }

}
