package com.swp.koiCareSystem.model;


public class Account {

    private int accID;             
    private String email;          
    private String userImage;      
    private String password;       
    private String fullName;       
    private String phoneNumber;    
    private String userRole;       
    private String address;        
    private String gender;       
    private int idStatus;          

    public Account() {
    }

    public Account(int accID, String email, String userImage, String password, String fullName,
            String phoneNumber, String userRole, String address, String gender, int idStatus) {
        this.accID = accID;
        this.email = email;
        this.userImage = userImage;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
        this.address = address;
        this.gender = gender;
        this.idStatus = idStatus;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
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

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;

    }

    @Override
    public String toString() {
        return "AccountDTO{" + "accID=" + accID + ", email=" + email + ", userImage=" + userImage + ", password=" + password + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", userRole=" + userRole + ", address=" + address + ", gender=" + gender + ", idStatus=" + idStatus + '}';
    }

}
