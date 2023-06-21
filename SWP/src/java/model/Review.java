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
public class Review {

    private String reviewId, content, productId;
    private Customer customer;
    private int rate;

    public Review() {
    }

    public Review(String reviewId, String content, Customer customerId, String productId, int rate) {
        this.reviewId = reviewId;
        this.content = content;
        this.customer = customerId;
        this.productId = productId;
        this.rate = rate;
    }

    public Review(String content, Customer customerId, String productId, int rate) {
        this.content = content;
        this.customer = customerId;
        this.productId = productId;
        this.rate = rate;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Customer getCustomerId() {
        return customer;
    }

    public void setCustomerId(Customer customerId) {
        this.customer = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Review{" + "reviewId=" + reviewId + ", content=" + content + ", customerId=" + customer + ", productId=" + productId + ", rate=" + rate + '}';
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

    public void insertReview(Review review) {
        connect();
        try {
            String strAdd = "INSERT INTO `headphone`.`review`\n"
                    + "(\n"
                    + "`Rating`,\n"
                    + "`ReviewContent`,\n"
                    + "`ProductID`,\n"
                    + "`CustomerID`)\n"
                    + "VALUES\n"
                    + "(\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?);";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setInt(1, review.getRate());
            pstm.setString(2, review.getContent());
            pstm.setString(3, review.getProductId());
            pstm.setInt(4, review.getCustomerId().getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("CustomerRegister:" + e.getMessage());
        }
    }

    public List<Review> getAllReviewByProductId(String productId) {
        connect();
        List<Review> list = new ArrayList<>();
        Customer customer = new Customer();

        try {
            String strSelect = "SELECT * FROM headphone.review where ProductID = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, productId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Review r = new Review();
                r.setReviewId(rs.getString(1));
                r.setRate(rs.getInt(2));
                r.setContent(rs.getString(3));
                r.setProductId(rs.getString(4));
                r.setCustomerId(customer.getCusById(rs.getInt(5)));
                list.add(r);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
