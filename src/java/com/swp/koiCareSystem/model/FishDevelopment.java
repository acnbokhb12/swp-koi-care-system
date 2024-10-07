/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.model;

/**
 *
 * @author PC
 */
import java.time.LocalDate;

public class FishDevelopment {
    private int fishDevelopmentID;  
    private int fishID;             
    private LocalDate dateGrowth;   
    private double length;          
    private double weight;          

    public FishDevelopment() {}

    public FishDevelopment(int fishDevelopmentID, int fishID, LocalDate dateGrowth, double length, double weight) {
        this.fishDevelopmentID = fishDevelopmentID;
        this.fishID = fishID;
        this.dateGrowth = dateGrowth;
        this.length = length;
        this.weight = weight;
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

    public LocalDate getDateGrowth() {
        return dateGrowth;
    }

    public void setDateGrowth(LocalDate dateGrowth) {
        this.dateGrowth = dateGrowth;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "FishDevelopment{" + "fishDevelopmentID=" + fishDevelopmentID + ", fishID=" + fishID + ", dateGrowth=" + dateGrowth + ", length=" + length + ", weight=" + weight + '}';
    }
    

}
