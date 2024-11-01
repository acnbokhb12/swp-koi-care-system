/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.model;

/**
 *
 * @author DELL
 */
public class FeedPercentage {
    private int id;
    private String growthMode;
    private int temperatureMin;
    private int temperatureMax;
    private float percentage;
    private String description;

    public FeedPercentage() {
    }

    public FeedPercentage(int id, String growthMode, int temperatureMin, int temperatureMax, float percentage, String description) {
        this.id = id;
        this.growthMode = growthMode;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.percentage = percentage;
        this.description = description;
    }
    
     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrowthMode() {
        return growthMode;
    }

    public void setGrowthMode(String growthMode) {
        this.growthMode = growthMode;
    }

    public int getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(int temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public int getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(int temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FeedPercentage{" + "id=" + id + ", growthMode=" + growthMode + ", temperatureMin=" + temperatureMin + ", temperatureMax=" + temperatureMax + ", percentage=" + percentage + ", description=" + description + '}';
    }
    
    
    
}
