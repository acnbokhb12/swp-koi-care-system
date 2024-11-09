/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.ContactDAO;
import com.swp.koiCareSystem.model.Contact;
import java.util.ArrayList;

/**
 *
 * @author Khanh
 */
public class ContactService {
    
    private ContactDAO cdao = new ContactDAO();
    
    public ArrayList<Contact> getAllContact(int index){
        return cdao.getAllContact(index);
    }
    
    public int countContact(){
        return cdao.countContact();
    }
    
    public ArrayList<Contact> getContactDetail(int contactID){
        return cdao.getContactDetail(contactID);
    }
    
    public boolean adminDeleteAccContact(int ctid){
        return cdao.adminDeleteAccContact(ctid);
    }
    
    public static void main(String[] args) {
        ContactService cs = new ContactService();
        
//        ArrayList<Contact> list = cs.getAllContact(1);
//        for(Contact ct : list){
//            System.out.println(ct);
//        }
                int testContactID = 1; // Adjust this ID based on a valid contact ID in your database
        ArrayList<Contact> list = cs.getContactDetail(testContactID);

        // Printing out the list for verification
        if (list.isEmpty()) {
            System.out.println("No contact found with ID: " + testContactID);
        } else {
            for (Contact contact : list) {
                System.out.println(contact);
            }
        }
    }
}
