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
public class Account {

    private int userID;
    private String email;
    private String profileImage;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String userRole;
    private String address;
    private String gender;
    private int accountStatus;

    public Account() {
    }

    public Account(int userID, String email, String profileImage, String password, String fullName, String phoneNumber, String userRole, String address, String gender, int accountStatus) {
        this.userID = userID;
        this.email = email;
        this.profileImage = profileImage;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
        this.address = address;
        this.gender = gender;
        this.accountStatus = accountStatus;
    }

    public Account(String email, String username, String password, String phone, String userRole, String gender, int accountStatus) {
        this.email = email;
        this.fullName = username;
        this.password = password;
        this.phoneNumber = phone;
        this.userRole = userRole;
        this.gender = gender;
        this.accountStatus = accountStatus;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "userID=" + userID + ", email=" + email + ", profileImage=" + profileImage + ", password=" + password + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", userRole=" + userRole + ", address=" + address + ", gender=" + gender + ", accountStatus=" + accountStatus;
    }

}