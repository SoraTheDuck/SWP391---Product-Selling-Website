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
 * @author Admin
 */
public class Order {

    private int ordId;
    private String date;
    private float total;
    private int cusId;
    private int staffId;

    public Order() {
        connect();
    }

    public Order(int ordId, String date, float total, int cusId, int staffId) {
        this.ordId = ordId;
        this.date = date;
        this.total = total;
        this.cusId = cusId;
        this.staffId = staffId;
    }

    public int getOrdId() {
        return ordId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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

    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        try {
            String strSelect = "SELECT * FROM headphone.orders";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int ordId = rs.getInt(1);
                String date = rs.getString(2);
                Float total = rs.getFloat(3);
                int cusId = rs.getInt(4);
                int staffId = rs.getInt(5);

                list.add(new Order(ordId, date, total, cusId, staffId));
            }
            pstm.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

//    public List<Order> getAllOrder2() {
//        List<Order> list = new ArrayList<>();
//        try {
//            String strSelect = "SELECT o.OrderId, c.customerName, s.staffName FROM Orders o \n"
//                    + "JOIN Customer c ON o.customerId = c.customerId \n"
//                    + "JOIN Staff s ON o.staffId = s.staffId";
//            pstm = cnn.prepareStatement(strSelect);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                Order order = new Order();
//                int ordId = rs.getInt("orderId");
//                order.setCustomerName(rs.getString("customerName"));
//                order.setStaffName(rs.getString("staffName"));
//                list.add(order);
//            }
//            pstm.close();
//        } catch (Exception ex) {
//            System.err.println(ex.getMessage());
//        }
//        return list;
//    }
    public void delete(String ordId) {
        String strSelect = "DELETE FROM orders where OrderID=?";
        try {
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, ordId);
            pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Tạo một đối tượng DAO để thao tác với đơn hàng
        Order order = new Order();

        // Gọi phương thức delete để xóa một đơn hàng với orderId cụ thể
        String orderIdToDelete = "2";
        order.delete(orderIdToDelete);
        System.out.println("Order deleted successfully.");
    }

}
