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
public class Pond {
    private int pondID;          
    private int accID;           
    private String image;        
    private String name;         
    private int numberOfFish;   
    private double volume;       
    private double depth;        
    private double pumpPower;    
    private int drainCount;      
    private int skimmer;         

    public Pond() {}

    public Pond(int pondID, int accID, String image, String name, int numberOfFish, double volume, 
                double depth, double pumpPower, int drainCount, int skimmer) {
        this.pondID = pondID;
        this.accID = accID;
        this.image = image;
        this.name = name;
        this.numberOfFish = numberOfFish;
        this.volume = volume;
        this.depth = depth;
        this.pumpPower = pumpPower;
        this.drainCount = drainCount;
        this.skimmer = skimmer;
    }

    public int getPondID() {
        return pondID;
    }

    public void setPondID(int pondID) {
        this.pondID = pondID;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfFish() {
        return numberOfFish;
    }

    public void setNumberOfFish(int numberOfFish) {
        this.numberOfFish = numberOfFish;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getPumpPower() {
        return pumpPower;
    }

    public void setPumpPower(double pumpPower) {
        this.pumpPower = pumpPower;
    }

    public int getDrainCount() {
        return drainCount;
    }

    public void setDrainCount(int drainCount) {
        this.drainCount = drainCount;
    }

    public int getSkimmer() {
        return skimmer;
    }

    public void setSkimmer(int skimmer) {
        this.skimmer = skimmer;
    }

    @Override
    public String toString() {
        return "Pond{" + "pondID=" + pondID + ", accID=" + accID + ", image=" + image + ", name=" + name + ", numberOfFish=" + numberOfFish + ", volume=" + volume + ", depth=" + depth + ", pumpPower=" + pumpPower + ", drainCount=" + drainCount + ", skimmer=" + skimmer + '}';
    }
    
}
