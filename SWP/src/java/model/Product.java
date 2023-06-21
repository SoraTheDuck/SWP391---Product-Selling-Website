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
    private String wire;
    private String description;

    public Product() {
        connect();
    }

    public Product(String id, String name, float price, String image, int quantity,String wire, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.wire = wire;
        this.description = description;
    }

    public String getWire(){
        return wire;
    }
    
    public void setWire(String wire){
        this.wire = wire;
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
    
    public List<Product> searchByName(String searchValue){
        List<Product> list = new ArrayList<>();
        try{
            String strSelect = "select * from headphone.product where ProductName like ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + searchValue + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                String Tid= rs.getString(1);
                String Tname = rs.getString(2);
                float Tprice = rs.getFloat(3);
                String Timage = rs.getString(4);
                int Tquantity = rs.getInt(5);
                String Twire = "Wired";
                if(rs.getInt(6)==0){
                    Twire = "Wireless";
                }
                String Tdescription = rs.getString(7);
                
                list.add(new Product(Tid, Tname, Tprice, Timage, Tquantity, Twire, Tdescription));
            }
        }catch(Exception e){
            System.out.println("searchByName" + e.getMessage());
        }
        return list;
    }
    
    public List<Product> searchProductByNameByPage(String searchValue,int page,int pageIndex){
        List<Product> list = new ArrayList<>();
        try{
            String sql = "select * from headphone.product where ProductName like ? LIMIT ? OFFSET ?";
            pstm = cnn.prepareStatement(sql);
            pstm.setString(1, "%" + searchValue + "%");
            pstm.setInt(2,page);
            pstm.setInt(3, pageIndex);
            rs = pstm.executeQuery();
            while(rs.next()){
                String Tid= rs.getString(1);
                String Tname = rs.getString(2);
                float Tprice = rs.getFloat(3);
                String Timage = rs.getString(4);
                int Tquantity = rs.getInt(5);
                String Twire = "Wired";
                if(rs.getInt(6)==0){
                    Twire = "Wireless";
                }
                String Tdescription = rs.getString(7);
                
                list.add(new Product(Tid, Tname, Tprice, Timage, Tquantity, Twire, Tdescription));
            }
        }catch(Exception e){
            System.out.println("searchProductByNameByPage"+e.getMessage());
        }
        return list;
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
                String Tid= rs.getString(1);
                String Tname = rs.getString(2);
                float Tprice = rs.getFloat(3);
                String Timage = rs.getString(4);
                int Tquantity = rs.getInt(5);
                String Twire = "Wired";
                if(rs.getInt(6)==0){
                    Twire = "Wireless";
                }
                String Tdescription = rs.getString(7);
                
                list.add(new Product(Tid, Tname, Tprice, Timage, Tquantity, Twire, Tdescription));
            }
        }catch(Exception ex){
            System.out.println("getAllProductByPage"+ex.getMessage());
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
                String Tid= rs.getString(1);
                String Tname = rs.getString(2);
                float Tprice = rs.getFloat(3);
                String Timage = rs.getString(4);
                int Tquantity = rs.getInt(5);
                String Twire = "Wired";
                if(rs.getInt(6)==0){
                    Twire = "Wireless";
                }
                String Tdescription = rs.getString(7);
                
                list.add(new Product(Tid, Tname, Tprice, Timage, Tquantity, Twire, Tdescription));
            }
        } catch (Exception ex) {
            System.out.println("getAllProduct"+ex.getMessage());
        }
        return list;
    }
     
    public Product getProductByID(String id){
        try{
            String strSelect = "SELECT * FROM headphone.product where ProductID= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while(rs.next()){
                String Tid= rs.getString(1);
                String Tname = rs.getString(2);
                float Tprice = rs.getFloat(3);
                String Timage = rs.getString(4);
                int Tquantity = rs.getInt(5);
                String Twire = "Wired";
                if(rs.getInt(6)==0){
                    Twire = "Wireless";
                }
                String Tdescription = rs.getString(7);
                
                return new Product(Tid, Tname, Tprice, Timage, Tquantity, Twire, Tdescription);
            }
        }catch(Exception e){
            System.out.println("searchByName" + e.getMessage());
        }
        return null;
    }
    
    public List<Product> getAllProductByCategoryByPage(int cid, int page,int pageIndex){
        List<Product> list = new ArrayList<>();
        try{
            String sql= "select * from headphone.product where CategoryID= ? LIMIT ? OFFSET ?";
            pstm = cnn.prepareStatement(sql);
            pstm.setInt(1, cid);
            pstm.setInt(2,page);
            pstm.setInt(3, pageIndex);
            rs = pstm.executeQuery();
            while(rs.next()){
                String Tid= rs.getString(1);
                String Tname = rs.getString(2);
                float Tprice = rs.getFloat(3);
                String Timage = rs.getString(4);
                int Tquantity = rs.getInt(5);
                String Twire = "Wired";
                if(rs.getInt(6)==0){
                    Twire = "Wireless";
                }
                String Tdescription = rs.getString(7);
                
                list.add(new Product(Tid, Tname, Tprice, Timage, Tquantity, Twire, Tdescription));
            }
        }catch(Exception e){
            System.out.println("getAllProductByCategory"+e.getMessage());
        }
        return list;
    }
    
    public List<Product> getAllProductsByCategory(int cid){
        List<Product> list = new ArrayList<>();
        try{
            String sql= "SELECT * FROM headphone.product where CategoryID = ? order by ReleaseDate desc LIMIT 6;";
            pstm = cnn.prepareStatement(sql);
            pstm.setInt(1, cid);
            rs = pstm.executeQuery();
            while(rs.next()){
                String Tid= rs.getString(1);
                String Tname = rs.getString(2);
                float Tprice = rs.getFloat(3);
                String Timage = rs.getString(4);
                int Tquantity = rs.getInt(5);
                String Twire = "Wired";
                if(rs.getInt(6)==0){
                    Twire = "Wireless";
                }
                String Tdescription = rs.getString(7);
                
                list.add(new Product(Tid, Tname, Tprice, Timage, Tquantity, Twire, Tdescription));
            }
        }catch(Exception e){
            System.out.println("getAllProductByCategory"+e.getMessage());
        }
        return list;
    }
}
