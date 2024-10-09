/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

/**
 *
 * @author ASUS
 */
import com.swp.koiCareSystem.dao.AccountDAO;
import com.swp.koiCareSystem.model.Account;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

;

public class AccountService {

    private final AccountDAO acd = new AccountDAO();

    public static String hashPassword(String password) {
        String salt = "salt";
        String result = null;

        password = password + salt;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            result = Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean isEmailExist(String email) throws Exception {
        return acd.isEmailExist(email);
    }

    public boolean isPhoneNumberExist(String phoneNumber) throws Exception {
        return acd.isPhoneNumberExist(phoneNumber);
    }

    public boolean registerUser(Account account) throws Exception {
        account.setPassword(hashPassword(account.getPassword()));
        return acd.registerUser(account);
    }
        public Account checkLogin(String email, String password) throws Exception {
        String hashedPassword = hashPassword(password);
        return acd.checkLogin(email, hashedPassword);
    }
}