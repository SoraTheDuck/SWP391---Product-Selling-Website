/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Customer;

/**
 *
 * @author toden
 */
public class CustomerDAO extends DBContext {

    public CustomerDAO() {
        super();
    }

    public static Customer getCusByEmailAndPass(String email, String pass) {
        String sql = "select * from customer where Email = ? and Password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String address = rs.getString(4);
                return new Customer(id, name, pass, address, email);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    public static Customer getCusByEmail(String email) {
        String sql = "select * from customer where Email = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String address = rs.getString(4);
                return new Customer(id, name, pass, address, email);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public static Customer getCusById(int id) {
        String sql = "select * from customer where CustomerID = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString(5);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String address = rs.getString(4);
                return new Customer(id, name, pass, address, email);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    public static int getCusId() {
        String sql = "select CustomerID from customer order by CustomerID desc LIMIT 1;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {

        }
        return 0;
    }

    public static void AddCus(String name, String password, String address, String email) {
        String sql = "insert into customer values(?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, getCusId() + 1);
            ps.setString(2, name);
            ps.setString(3, password);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static Customer UpdatePassAcc(String resetPass, int id) {
        String sql = "update customer set Password =? where CustomerID = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(2, id);
            ps.setString(1, resetPass);
            ps.executeUpdate();
            return getCusById(id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
