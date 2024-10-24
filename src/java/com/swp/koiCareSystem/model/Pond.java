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
    private String descriptionPond;
    private int numberOfFish;
    private float volume;
    private float depth;
    private float pumpPower;
    private int drainCount;
    private int skimmer;
    private boolean isActive;
    
    public Pond() {
    }

    public Pond(int pondID, int accID, String image, String name, String descriptionPond, int numberOfFish, float volume, float depth, float pumpPower, int drainCount, int skimmer) {
        this.pondID = pondID;
        this.accID = accID;
        this.image = image;
        this.name = name;
        this.descriptionPond = descriptionPond;
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

    public String getDescriptionPond() {
        return descriptionPond;
    }

    public void setDescriptionPond(String descriptionPond) {
        this.descriptionPond = descriptionPond;
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

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public double getPumpPower() {
        return pumpPower;
    }

    public void setPumpPower(float pumpPower) {
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

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Pond{" + "pondID=" + pondID + ", accID=" + accID + ", image=" + image + ", name=" + name + ", numberOfFish=" + numberOfFish + ", volume=" + volume + ", depth=" + depth + ", pumpPower=" + pumpPower + ", drainCount=" + drainCount + ", skimmer=" + skimmer + ", isActive=" + isActive + '}';
    }
}
