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

    public boolean updateAccount(int userId, String email, String fullName, String phoneNumber, String address, String gender, String oldPassword, String newPassword) throws Exception {
        Account accountFromDb = acd.getUserById(userId);
        if (accountFromDb == null) {
            throw new Exception("Account not found");
        }
        Account updatedAccount = new Account();
        updatedAccount.setUserID(userId);
        updatedAccount.setEmail(email);
        updatedAccount.setFullName(fullName);
        updatedAccount.setPhoneNumber(phoneNumber);
        updatedAccount.setAddress(address);
        updatedAccount.setGender(gender);

        if (newPassword != null && !newPassword.isEmpty()) {
            updatedAccount.setPassword(hashPassword(newPassword));
        } else {
            updatedAccount.setPassword(accountFromDb.getPassword());
        }
        return acd.updateAccount(updatedAccount);
    }
}
