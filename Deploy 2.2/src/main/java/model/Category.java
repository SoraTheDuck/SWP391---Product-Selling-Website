/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer Aspire
 */
public class Category {
    private int id;
    private String name;

    public Category() {
        connect();
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return name;
    }

    public void setCategoryName(String name) {
        this.name = name;
    }
    
    Connection cnn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    
    private void connect() {
        try {
            cnn = (new DBContext().connection);
            if (cnn != null) {
                //System.out.println("Connect successfully");
            } else {
                System.out.println("Connect Fail");
            }
        } catch (Exception e) {

        }
    }
    
    public List<Category> getAllCategory(){
        List <Category> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM headphone.category;";
            pstm = cnn.prepareStatement(sql);
            rs= pstm.executeQuery();
            while(rs.next()){
                int cid = rs.getInt(1);
                String cname = rs.getString(2);
                list.add(new Category(cid, cname));
            }
        }catch(Exception e){
            System.out.println("getAllCatefory"+e.getMessage());
        }
        return list;
    }

    
}
