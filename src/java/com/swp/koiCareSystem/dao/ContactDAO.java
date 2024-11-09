/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Khanh
 */
public class ContactDAO {

    public ArrayList<Contact> getAllContact(int index) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Contact> list = new ArrayList<>();

        int distance = (index - 1) * 10;

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select * from [dbo].[Contact] \n"
                    + "order by [ID] desc\n"
                    + "offset ? rows \n"
                    + "fetch next 10 rows only";
            ps = c.prepareStatement(sql);
            ps.setInt(1, distance);
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Contact ct = new Contact();
                    ct.setId(rs.getInt(1));
                    ct.setName(rs.getString(2));
                    ct.setEmail(rs.getString(3));
                    ct.setMessage(rs.getString(4));
                    list.add(ct);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public int countContact() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select count(*) from [dbo].[Contact]";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public ArrayList<Contact> getContactDetail(int contactID) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Contact> list = new ArrayList<>();

        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "select * from [dbo].[Contact] WHERE ID = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1, contactID);
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Contact ct = new Contact();
                    ct.setId(rs.getInt(1));
                    ct.setName(rs.getString(2));
                    ct.setEmail(rs.getString(3));
                    ct.setMessage(rs.getString(4));
                    list.add(ct);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
    public boolean adminDeleteAccContact(int ctID){
        Connection c = null;
        PreparedStatement ps = null;
        
        try {
            c = DatabaseConnectionManager.getConnection();
            String sql = "DELETE FROM [dbo].[Contact] WHERE [ID] = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1, ctID);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ContactDAO dao = new ContactDAO();
        
//        int ctID = 1;
//        boolean deleteAccContact = dao.adminDeleteAccContact(ctID);
//        System.out.println("Delete successfully acc contact with id: " + deleteAccContact);

        

//        int count = dao.countContact();
//        System.out.println(count);
//        ArrayList<Contact> list = dao.getAllContact(1);
//        
//        for(Contact ct : list){
//            System.out.println(ct);
//        }
    }
}
