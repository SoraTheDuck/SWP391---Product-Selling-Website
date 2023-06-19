/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer Aspire
 */
public class Customer {

    private int id;
    private String name, password, address, email;

    public Customer() {
        connect();
    }

    public Customer(String email, String password) {
        this.password = password;
        this.email = email;
        connect();
    }
    
    public Customer(String name, String password, String address, String email) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
        connect();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    Connection cnn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;

    private void connect() {
        try {
            cnn = (new DBContext().connection);
            if (cnn != null) {
                System.out.println("Connect successfully");
            } else {
                System.out.println("Connect Fail");
            }
        } catch (Exception e) {

        }
    }

    public void register() {
        try {
            String strAdd = "INSERT INTO headphone.customer (CustomerName, Password, Address, Email) \n"
                    + "VALUES (?, ?, ?, ?);";

            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, name);
            pstm.setString(2, password);
            pstm.setString(3, address);
            pstm.setString(4, email);

            pstm.execute();
        } catch (Exception e) {
            System.out.println("CustomerRegister:" + e.getMessage());
        }
    }
    
    public boolean checkLogin() {
        try {
            String strSelect = "SELECT * FROM headphone.customer where email=? and password=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, email);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkLogin:" + e.getMessage());
        }
        return false;
    }

    public boolean checkCustomerExist(String email) {
        try {
            String strQuery = "SELECT * FROM headphone.customer WHERE Email = ?";
            pstm = cnn.prepareStatement(strQuery);
            pstm.setString(1, email);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkCustomerExist:" + e.getMessage());
        }
        return false;
    }
    
    public void getCustomerByAccount(String email) {
        try {
            String strSelect = "SELECT * FROM headphone.customer where email=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
                this.id = rs.getInt(1);
                this.name = rs.getString(2);
                this.email = rs.getString(5);
                this.password = rs.getString(3);
                this.address = rs.getString(4);
            }
        } catch (Exception e) {
            System.out.println("getCustomerByAccount:" + e.getMessage());
        }
    }
    public void getCustomer(int cusId) {
        String strSelect = "SELECT * FROM headphone.Customer where CustomerId =?";
        try {
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, cusId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                this.id = rs.getInt(1);
                this.name = rs.getString(2);
                this.email = rs.getString(3);
                this.password = rs.getString(4);
                this.address = rs.getString(5);
                this.email = rs.getString(6);
            }
        } catch (Exception ex) {
            Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Customer getCusByEmail(String email) {
        String sql = "select * from customer where Email = ? ";
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Cid = rs.getInt(1);
                String Cname = rs.getString(2);
                String Cpass = rs.getString(3);
                String Caddress = rs.getString(4);
                String Cemail = rs.getString(5);
                return new Customer(Cname, Cpass, Caddress, Cemail);
            }
        } catch (Exception ex) {
            System.out.println("getCusByEmail");
        }
        return null;
    }
    
    public Customer UpdatePassAcc(String resetPass, int id) {
        String sql = "update customer set Password =? where CustomerID = ?;";
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(2, id);
            ps.setString(1, resetPass);
            ps.executeUpdate();
            return getCusById(id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public Customer getCusById(int id) {
        String sql = "select * from customer where CustomerID = ? ";
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString(5);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String address = rs.getString(4);
                return new Customer(name, pass, address, email);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
