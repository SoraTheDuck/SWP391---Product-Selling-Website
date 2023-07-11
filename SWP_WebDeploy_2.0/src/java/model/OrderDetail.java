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
 * @author admin
 */
public class OrderDetail {

    private int orderId;
    private String productName;
    private int quantity;
    private float price;

    public OrderDetail() {
        connect();
    }

    public OrderDetail(int orderId, String productName, int quantity, float price) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    Connection cnn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;

    private void connect() {
        try {
            cnn = (new DBContext().connection);
            if (cnn != null) {
                System.out.println("Connect successfully4");
            } else {
                System.out.println("Connect Fail");
            }
        } catch (Exception e) {

        }
    }

    public float getTotalMoney(List<OrderDetail> orderDetails) {
        float t = 0;
        for (OrderDetail o : orderDetails) {
            t += (o.getQuantity()) * (o.getPrice());
        }
        return t;
    }

    public List<OrderDetail> getHistory(int oid) {
        List<OrderDetail> data = new ArrayList<>();
        try {
            String sql = "select od.OrderID, p.ProductName, od.Quantity, od.Price from headphone.orderproduct od, headphone.product p where od.ProductID = p.ProductID and OrderID = ?";
            pstm = cnn.prepareStatement(sql);
            pstm.setInt(1, oid);
            rs = pstm.executeQuery();

            while (rs.next()) {
                data.add(new OrderDetail(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4)));
            }
        } catch (Exception e) {
            System.out.println("getHistory: " + e.getMessage());
        }
        return data;
    }
}
