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
    private int pondId;
    private int userId;
    private String name;
    private String imagePond;
    private String descriptionPond;
    private float size;
    private float depth;
    private float volume;
    private int drainCount;
    private float pumpPower;

    public Pond() {
    }

    public int getPondId() {
        return pondId;
    }

    public void setPondId(int pondId) {
        this.pondId = pondId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePond() {
        return imagePond;
    }

    public void setImagePond(String imagePond) {
        this.imagePond = imagePond;
    }

    public String getDescriptionPond() {
        return descriptionPond;
    }

    public void setDescriptionPond(String descriptionPond) {
        this.descriptionPond = descriptionPond;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public int getDrainCount() {
        return drainCount;
    }

    public void setDrainCount(int drainCount) {
        this.drainCount = drainCount;
    }

    public float getPumpPower() {
        return pumpPower;
    }

    public void setPumpPower(float pumpPower) {
        this.pumpPower = pumpPower;
    }

    public Pond(int pondId, int userId, String name, String imagePond, String descriptionPond, float size, float depth, float volume, int drainCount, float pumpPower) {
        this.pondId = pondId;
        this.userId = userId;
        this.name = name;
        this.imagePond = imagePond;
        this.descriptionPond = descriptionPond;
        this.size = size;
        this.depth = depth;
        this.volume = volume;
        this.drainCount = drainCount;
        this.pumpPower = pumpPower;
    }

    @Override
    public String toString() {
        return "pondId=" + pondId + ", userId=" + userId + ", name=" + name + ", imagePond=" + imagePond + ", descriptionPond=" + descriptionPond + ", size=" + size + ", depth=" + depth + ", volume=" + volume + ", drainCount=" + drainCount + ", pumpPower=" + pumpPower ;
    }
    
    
}
