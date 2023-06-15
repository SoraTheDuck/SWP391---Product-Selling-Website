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
 * @author quany
 */
public class Product {

    private String id;
    private String name;
    private float price;
    private String image;
    private int quantity;
    private String description;

    public Product() {
        connect();
    }

    public Product(String id, String name, float price, String image, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    
        public List<Product> getAllProductByPage(int page, int pageIndex){
        List<Product> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM headphone.product LIMIT ? OFFSET ?";
            PreparedStatement statement = cnn.prepareStatement(sql);
            statement.setInt(1, page);
            statement.setInt(2, pageIndex);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product a = new Product();
                a.setId(rs.getString(1));
                a.setName(rs.getString(2));
                a.setPrice(rs.getFloat(3));
                a.setImage(rs.getString(4));
                a.setQuantity(rs.getInt(5));
                a.setDescription(rs.getString(6));
                list.add(a);
            }
        }catch(Exception ex){
            
        }
        return list;
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM headphone.product";
            PreparedStatement statement = cnn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product a = new Product();
                a.setId(rs.getString(1));
                a.setName(rs.getString(2));
                a.setPrice(rs.getFloat(3));
                a.setImage(rs.getString(4));
                a.setQuantity(rs.getInt(5));
                a.setDescription(rs.getString(6));
                list.add(a);
            }
        } catch (Exception ex) {

        }
        return list;
    }
    
    

}
