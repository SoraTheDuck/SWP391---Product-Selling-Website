/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Acer Aspire
 */
public class Customer {
    private int id;
    private String name,password,address,email;

    public Customer() {
    }

    public Customer(String name,String password, String address, String email) {
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
    
    public void register(){
        try{
            String strAdd = "INSERT INTO headphone.customer (CustomerName, Password, Address, Email) \n" +
"VALUES (?, ?, ?, ?);";

            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, name);
            pstm.setString(2, password);
            pstm.setString(3, address);
            pstm.setString(4, email);
            
            pstm.execute();
        }catch(Exception e){
            System.out.println("CustomerRegister:" + e.getMessage());
        }
    }
}
