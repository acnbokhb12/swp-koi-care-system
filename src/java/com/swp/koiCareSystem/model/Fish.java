package com.swp.koiCareSystem.model;

public class Fish {
    private int fishID;          
    private int accID;           
    private int pondID;        
    private String fishImage;   
    private String fishName;     
    private String descriptionKoi; 
    private String bodyShape;    
    private float age;          
    private float length;      
    private float weight;       
    private String gender;     
    private boolean isActive;

    public Fish() {}
    
    public Fish(int fishID, String fishImage, String fishName) {
        this.fishID = fishID;
        this.fishImage = fishImage;
        this.fishName = fishName;
    }
    public Fish(int fishID, int accID, int pondID, String fishImage, String fishName, String descriptionKoi, String bodyShape, float age, float length, float weight, String gender) {
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

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }



    @Override
    public String toString() {
        return "Fish{" + "fishID=" + fishID + ", accID=" + accID + ", pondID=" + pondID + ", fishImage=" + fishImage + ", fishName=" + fishName + ", descriptionKoi=" + descriptionKoi + ", bodyShape=" + bodyShape + ", age=" + age + ", length=" + length + ", weight=" + weight + ", gender=" + gender + ", isActive=" + isActive + '}';
    }
}