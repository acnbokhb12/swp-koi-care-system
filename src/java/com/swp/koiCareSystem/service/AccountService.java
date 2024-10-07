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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountService {

    private static final Logger logger = Logger.getLogger(AccountService.class.getName());

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] byteData = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : byteData) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, "Error hashing password", e);
            return null;
        }
    }

    public static void main(String[] args) {
        String password = "123456";
        String hashedPassword = AccountService.hashPassword(password);
        System.out.println("Mật khẩu gốc: " + password);
        System.out.println("Mật khẩu đã băm: " + hashedPassword);
    }

}
