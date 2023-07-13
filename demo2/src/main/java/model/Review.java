/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer Aspire
 */
public class Review {
    private int reviewID;
    private int rating;
    private String content;
    private String productID;
    private int customerID;
    private String customerName;
    private String postDate;

    public Review() {
        connect();
    }

    public Review(int reviewID, int rating, String content, String productID, int customerID,String customerName) {
        this.reviewID = reviewID;
        this.rating = rating;
        this.content = content;
        this.productID = productID;
        this.customerID = customerID;
        this.customerName = customerName;
        connect();
    }

    public Review(int reviewID, int rating, String content, String productID, int customerID, String customerName, String postDate) {
        this.reviewID = reviewID;
        this.rating = rating;
        this.content = content;
        this.productID = productID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.postDate = postDate;
        connect();
    }
    
    

    public Review(int rating, String content, String productID, int customerID) {
        this.rating = rating;
        this.content = content;
        this.productID = productID;
        this.customerID = customerID;
        connect();
    }
    
    
    
    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    
    public String getCustomerName(){
        return customerName;
    }
    
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
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
    
    public List<Review> getAllReviewsByProductID(String productid){
        List<Review> list = new ArrayList<>();
        try{
            String strSelect = "SELECT * FROM headphone.review join headphone.customer on review.CustomerID = customer.CustomerID where ProductID like ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, productid);
            rs = pstm.executeQuery();
            while(rs.next()){
                int reviewid = rs.getInt(1);
                int Rating = rs.getInt(2);
                String Content = rs.getString(3);
                String ProductID = rs.getString(4);
                int CustomerID = rs.getInt(5);
                String name = rs.getString(8);
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                String date = f.format(rs.getDate(6));
                list.add(new Review(reviewid, Rating, Content, ProductID, CustomerID, name, date));
            }
        }catch(Exception e){
            System.out.println("getAllReviewsByProductID");
        }
        return list;
    }
    
    public void addReview(){
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try{
            String sql = "insert into headphone.review (Rating,ReviewContent,ProductID,CustomerID) values (?, ?, ?, ?);";
            String sql2 = "INSERT INTO headphone.review (Rating, ReviewContent, ProductID, CustomerID, PostDate) VALUES (?, ?, ?, ?, ?);";
            pstm = cnn.prepareStatement(sql2);
            pstm.setInt(1, rating);
            pstm.setString(2, content);
            pstm.setString(3, productID);
            pstm.setInt(4,customerID);
            pstm.setString(5, date);
            
            pstm.execute();
        }catch(Exception e){
            System.out.println("addReview" + e.getMessage());
        }
    }
}
