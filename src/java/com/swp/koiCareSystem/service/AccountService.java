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
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.swp.koiCareSystem.config.IConstant;
import com.swp.koiCareSystem.dao.AccountDAO;
import com.swp.koiCareSystem.model.Account;
import com.swp.koiCareSystem.model.AccountStatus;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

;

public class AccountService {

    private final AccountDAO acd = new AccountDAO();

    // Get all fish for the specific account ID
    public int countAllAccountS() {
        return acd.countAllAccounts();

    }

    public ArrayList<Account> getAccountsS() {
        ArrayList<Account> listA = acd.getAccounts();
        return listA;
    }
    //Phân Trang 

    public ArrayList<Account> getAllAccountsS(int index) {
        ArrayList<Account> listacc = acd.getAccounts(index);
        return listacc;
    }

    public boolean createNewAccountFishS(Account accfish) {
        return acd.createNewAccount(accfish);

    }

    public String hashPassword(String password) {
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

    public String getToken(String code) throws ClientProtocolException, IOException {
        String response = Request.Post(IConstant.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", IConstant.GOOGLE_CLIENT_ID)
                        .add("client_secret", IConstant.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", IConstant.GOOGLE_REDIRECT_URI)
                        .add("code", code)
                        .add("grant_type", IConstant.GOOGLE_GRANT_TYPE)
                        .build()
                )
                .execute().returnContent().asString();
        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);

        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");

        return accessToken;

    }

    public Account getUserInfo(final String accessToken) throws ClientProtocolException, IOException {

        String link = IConstant.GOOGLE_LINK_GET_USER_INFO + accessToken;

        String response = Request.Get(link).execute().returnContent().asString(Charset.forName("UTF-8"));

        Account googlePojo = new Gson().fromJson(response, Account.class);

        return googlePojo;

    }

    public String getPasswordByAccID(int acid) {
        return acd.getPasswordByAccID(acid);
    }

    public boolean registerUser(Account account) {
        account.setPassword(hashPassword(account.getPassword()));
        return acd.registerUser(account);
    }

    public Account checkLogin(String email, String password) throws Exception {
        String hashedPassword = hashPassword(password);
        return acd.checkLogin(email, hashedPassword);
    }

    public boolean registerWithGoogle(Account account) {
        account.setPassword(hashPassword(account.getPassword()));
        account.setUserRole("customer");
        account.setAccountStatus(1);
        ImageUploadService imgUs = new ImageUploadService();
        String linkAvatar = imgUs.uploadImageFromUrl(account.getProfileImage());
        if(linkAvatar==null){
            return false;
        }else{
            account.setProfileImage(linkAvatar);
        }
        return acd.registerWithGoogleAcc(account);

    }

    public Account getAccountByEmail(String email) {
        return acd.getAccountByEmail(email);
    }

    public boolean checkPassword(String password_old, String currentPassword) {
        String hashedOldPassword = hashPassword(password_old);

        if (hashedOldPassword.equals(currentPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updatePassword(int accID, String newPassword) {
        String hashedPassword = hashPassword(newPassword);
        return acd.updatePassword(accID, hashedPassword);
    }

    public boolean upDateImgAccountById(int acid, String imgLink) {
        return acd.updateImgByAccountID(acid, imgLink);
    }

    public boolean updatePasswordWithEmail(String newPassword, String email) {
        String hashedPassword = hashPassword(newPassword);
        return acd.updatePasswordWithEmail(hashedPassword, email);
    }

    public boolean checkEmail(String email) {
        return acd.checkEmail(email);
    }

    // ADMIN ACCOUNT======================================
    //LIST ACCOUNT
    public ArrayList<Account> getAllAccountsToAdminS(int index) {
        ArrayList<Account> listacc = acd.getAccountsToAdmin(index);
        return listacc;
    }

    public int countAllAccountsToAdminS() {
        return acd.countAccountsToAdmin();
    }

    // LIST : STATUS
    public int countAllAccountsStatusToAdminS(int idStatus) {
        return acd.countAccountsByStatus(idStatus);
    }

    public ArrayList<AccountStatus> getAllAccountsStatusToAdminS() {
        return acd.getAllAccountStatuses();
    }

    public ArrayList<Account> searchAccountByStatus(int statusID, int index) {
        return acd.searchAccountsByStatus(statusID, index);
    }

// CREATE NEW ACCOUNT
    public boolean createNewAccountToAdmin(Account account) {
        return acd.createNewAccount(account);
    }

    // DELETE
    public boolean deleteAccountToAdmin(int accID) {
        return acd.deleteAccountByID(accID);
    }
    //INFORMATION

    public Account getAccountInformationByID(int id) {
        return acd.getAccountInformationByID(id);
    }

    //UPDATE 
    public boolean updateInformationAccounts(Account account) {
        return acd.updateInformationAccount(account);
    }

    static void main(String[] args) throws Exception {
        AccountService acs = new AccountService();
//        Account acc = acs.checkLogin("rikawa", "123456");
        String acc = acs.hashPassword("jinsu@123");
        System.out.println(acc);
    }

}
