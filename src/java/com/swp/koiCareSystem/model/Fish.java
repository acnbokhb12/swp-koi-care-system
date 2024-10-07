/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.model;

/**
 *
 * @author PC
 */
public class Fish {
    private int fishID;          
    private int accID;           
    private int pondID;        
    private String fishImage;   
    private String fishName;     
    private String descriptionKoi; 
    private String bodyShape;    
    private double age;          
    private double length;      
    private double weight;       
    private String gender;       

    public Fish() {}

    public Fish(int fishID, int accID, int pondID, String fishImage, String fishName, String descriptionKoi,
                String bodyShape, double age, double length, double weight, String gender) {
        this.fishID = fishID;
        this.accID = accID;
        this.pondID = pondID;
        this.fishImage = fishImage;
        this.fishName = fishName;
        this.descriptionKoi = descriptionKoi;
        this.bodyShape = bodyShape;
        this.age = age;
        this.length = length;
        this.weight = weight;
        this.gender = gender;
    }

    // Getters and Setters
    public int getFishID() {
        return fishID;
    }

    public void setFishID(int fishID) {
        this.fishID = fishID;
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

    public String getFishImage() {
        return fishImage;
    }

    public void setFishImage(String fishImage) {
        this.fishImage = fishImage;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public String getDescriptionKoi() {
        return descriptionKoi;
    }

    public void setDescriptionKoi(String descriptionKoi) {
        this.descriptionKoi = descriptionKoi;
    }

    public String getBodyShape() {
        return bodyShape;
    }

    public void setBodyShape(String bodyShape) {
        this.bodyShape = bodyShape;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Fish{" + "fishID=" + fishID + ", accID=" + accID + ", pondID=" + pondID + ", fishImage=" + fishImage + ", fishName=" + fishName + ", descriptionKoi=" + descriptionKoi + ", bodyShape=" + bodyShape + ", age=" + age + ", length=" + length + ", weight=" + weight + ", gender=" + gender + '}';
    }
    
}

