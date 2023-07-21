/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Order {

    private int id;
    private String date;
    private float totalmoney;
    private int customerid;
    private int staffid;
    private int otherid;
    private String cdate;

    private String cphone;
    private String daddress;
    private int ostatus;

    public Order(int id, String date, float totalmoney, int customerid, int staffid, String cdate, String cphone, String daddress, int status) {
        this.id = id;
        this.date = date;
        this.totalmoney = totalmoney;
        this.customerid = customerid;
        this.staffid = staffid;
        this.cdate = cdate;
        this.cphone = cphone;
        this.daddress = daddress;
        this.ostatus = status;
    }

    public Order() {
        connect();
    }

    public Order(int id, String date, float totalmoney, int customerid) {
        this.id = id;
        this.date = date;
        this.totalmoney = totalmoney;
        this.customerid = customerid;
    }

    public Order(int id, String date, float totalmoney, int customerid, int staffid, int otherid, String cdate) {
        this.id = id;
        this.date = date;
        this.totalmoney = totalmoney;
        this.customerid = customerid;
        this.staffid = staffid;
        this.otherid = otherid;
        this.cdate = cdate;
    }

    public String getDaddress() {
        return daddress;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public void setDaddress(String daddress) {
        this.daddress = daddress;
    }
    public int getOstatus() {
        return ostatus;
    }
    public void setOstatus(int ostatus) {
        this.ostatus = ostatus;
    }
    
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotalMoney() {
        return totalmoney;
    }

    public void setTotalMoney(float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public int getCustomerID() {
        return customerid;
    }

    public void setCustomerID(int customerid) {
        this.customerid = customerid;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public int getOtherid() {
        return otherid;
    }

    public void setOtherid(int otherid) {
        this.otherid = otherid;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    
    
    Connection cnn; //ket noi DB
    Statement stm; //thuc thi cau lenh SQL
    PreparedStatement pstm;//thuc thi SQL
    PreparedStatement pstm2;
    PreparedStatement pstm3;
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

    public int getLatestOrderID(int customerid) {
        try {
            String sql = "SELECT * FROM headphone.orders where CustomerID=? order by OrderID desc limit 1";
            pstm = cnn.prepareStatement(sql);
            pstm.setInt(1, customerid);
            rs = pstm.executeQuery();
            if (rs.next()) {
                int oid = rs.getInt(1);
                return oid;
            }
        } catch (Exception ex) {
            System.out.println("getLatestOrderID" + ex.getMessage());
        }
        return 0;
    }

    public String getOrderAddress(int oid) {
        String address = "";
        try {
            String sql = "select * from headphone.orders where OrderID=?";
            pstm = cnn.prepareStatement(sql);
            pstm.setInt(1, oid);
            rs = pstm.executeQuery();
            if (rs.next()) {
                address = rs.getString(6);
            }
        } catch (Exception ex) {
            System.out.println("getOrderAddress" + ex.getMessage());
        }
        return address;
    }

    public String getOrderPhone(int oid) {
        String phone = "";
        try {
            String sql = "select * from headphone.orders where OrderID=?";
            pstm = cnn.prepareStatement(sql);
            pstm.setInt(1, oid);
            rs = pstm.executeQuery();
            if (rs.next()) {
                phone = rs.getString(7);
            }
        } catch (Exception ex) {
            System.out.println("getOrderPhone" + ex.getMessage());
        }
        return phone;
    }

    public String getOrderDate(int oid) {
        String date = "";
        try {
            String sql = "select * from headphone.orders where OrderID=?";
            pstm = cnn.prepareStatement(sql);
            pstm.setInt(1, oid);
            rs = pstm.executeQuery();

            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            if (rs.next()) {
                date = f.format(rs.getDate(2));
            }
        } catch (Exception ex) {
            System.out.println("getOrderPhone" + ex.getMessage());
        }
        return date;
    }


    public void addOrder1(Customer u, Cart cart, String address, String phone) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        java.sql.Date sqlDate = new Date(utilDate.getTime());
        int sID = getOrderManager();
        try {
            String addO = "insert into headphone.orders (OrderDate, TotalMoney, CustomerID, StaffID, DeliveryAddress, Phone) values (?, ?, ?, ?, ?, ?)";
            pstm = cnn.prepareStatement(addO);
            pstm.setDate(1, sqlDate);
            pstm.setFloat(2, cart.getTotalMoney());
            pstm.setInt(3, u.getId());
            pstm.setInt(4, sID);
            pstm.setString(5, address);
            pstm.setString(6, phone);
            pstm.execute();

            String sql2 = "select OrderID from headphone.orders order by OrderID desc limit 1 ";
            pstm2 = cnn.prepareStatement(sql2);
            rs = pstm2.executeQuery();

            if (rs.next()) {
                int oid = rs.getInt(1);
                for (Item i : cart.getItems()) {
                    String sql3 = "insert into headphone.orderproduct (OrderID,ProductID,Quantity,Price) values (?,?,?,?) ";
                    pstm3 = cnn.prepareStatement(sql3);
                    pstm3.setInt(1, oid);
                    pstm3.setString(2, i.getProduct().getId());
                    pstm3.setInt(3, i.getQuantity());
                    pstm3.setFloat(4, i.getPrice());
                    pstm3.execute();
                }
            }

        } catch (Exception e) {
            System.out.println("addOrder1: " + e.getMessage());
        }
    }

    public int getOrderManager() {
        int sID = 0;
        try {
            String strSelect = "SELECT OrderProcess.StaffID\n"
                    + "FROM (SELECT Staff.StaffID, Staff.StaffName, COUNT(CompletedOrder.OrderID) AS CompletedOrderCount, COUNT(Orders.OrderID) AS OrderCount, (COUNT(Orders.OrderID) - COUNT(CompletedOrder.OrderID)) AS ProcessingOrder\n"
                    + "FROM Headphone.Staff\n"
                    + "LEFT JOIN Headphone.Orders ON Staff.StaffID = Orders.StaffID\n"
                    + "LEFT JOIN Headphone.CompletedOrder ON Orders.OrderID = CompletedOrder.OrderID\n"
                    + "WHERE Staff.OrderManager = 1 AND Staff.Status = 0\n"
                    + "GROUP BY Staff.StaffID, Staff.StaffName) AS OrderProcess\n"
                    + "WHERE OrderProcess.ProcessingOrder < 10\n"
                    + "ORDER BY OrderCount ASC\n"
                    + "LIMIT 1";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            if (rs.next()) {
                sID = rs.getInt(1);
            } else {
                strSelect = "SELECT OrderProcess.StaffID\n"
                        + "FROM (SELECT Staff.StaffID, Staff.StaffName, COUNT(CompletedOrder.OrderID) AS CompletedOrderCount, COUNT(Orders.OrderID) AS OrderCount, (COUNT(Orders.OrderID) - COUNT(CompletedOrder.OrderID)) AS ProcessingOrder\n"
                        + "FROM Headphone.Staff\n"
                        + "LEFT JOIN Headphone.Orders ON Staff.StaffID = Orders.StaffID\n"
                        + "LEFT JOIN Headphone.CompletedOrder ON Orders.OrderID = CompletedOrder.OrderID\n"
                        + "WHERE Staff.OrderManager = 1 AND Staff.Status = 0\n"
                        + "GROUP BY Staff.StaffID, Staff.StaffName) AS OrderProcess\n"
                        + "ORDER BY OrderCount ASC\n"
                        + "LIMIT 1";
                pstm = cnn.prepareStatement(strSelect);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    sID = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            System.err.println("getOrderManager: " + e.getMessage());
        }
        return sID;
    }

    public List<Order> getListNotCompletedOrder(int staffID) {
        List<Order> list = new ArrayList<>();
        try {
            String sql = "SELECT o.* FROM headphone.orders o\n"
                    + "LEFT JOIN headphone.completedorder co ON o.OrderID = co.OrderID\n"
                    + "WHERE co.CompletedDate IS NULL AND o.StaffID=?;";
            pstm2 = cnn.prepareStatement(sql);
            pstm2.setInt(1, staffID);
            rs = pstm2.executeQuery();

            while (rs.next()) {
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                String date = "";
                if (rs.getDate(2) != null) {
                    date = f.format(rs.getDate(2));
                }
                list.add(new Order(rs.getInt(1), date, rs.getFloat(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println("getListNotCompletedOrder: " + e.getMessage());
        }
        return list;
    }
    
    public void completeOrder(int oid, boolean status) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        Date sqlDate = new Date(utilDate.getTime());
        try {
            String addO = "insert into headphone.completedorder (OrderID, CompletedDate, Status) values (?, ?, ?)";
            pstm = cnn.prepareStatement(addO);
            pstm.setInt(1, oid);
            pstm.setDate(2, sqlDate);
            pstm.setBoolean(3, status);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("completeOrder: " + e.getMessage());
        }
    }

    public void updateQuantity(List<OrderDetail> lo) {
        try {
            int newQuantity;
            Product p = new Product();
            for (OrderDetail od : lo) {
                String strUpdate = "update headphone.product set Quantity=? where ProductID=?";
                pstm = cnn.prepareStatement(strUpdate);

                Product p1 = p.getProductByID2(od.getProductName());

                newQuantity = p1.getQuantity() - od.getQuantity();
                pstm.setInt(1, newQuantity);
                pstm.setString(2, od.getProductName());
                pstm.execute();
            }
        } catch (Exception e) {
            System.out.println("updateQuantity: " + e.getMessage());
        }
    }

    public List<Order> getHistory(int customerid) {
        List<Order> data = new ArrayList<>();
        try {
            String sql = "SELECT O.OrderID, O.OrderDate, O.TotalMoney, O.CustomerID, O.StaffID,CO.OrderID, CO.CompletedDate, O.Phone, O.DeliveryAddress, CO.Status \n"
                    + "FROM Headphone.Orders AS O\n"
                    + "LEFT JOIN Headphone.CompletedOrder AS CO ON O.OrderID = CO.OrderID WHERE CustomerID=?;";
            pstm = cnn.prepareStatement(sql);
            pstm.setInt(1, customerid);
            rs = pstm.executeQuery();
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {
                int oid = rs.getInt(1);
                String date = "";
                date = f.format(rs.getDate(2));

                String st = String.format("%.1f", rs.getFloat(3));
                float money = Float.parseFloat(st);
                int cid = rs.getInt(4);
                int sid = rs.getInt(5);
                int otherid = 0;
                String cdate = "-";
                if (rs.getString(6) != null) {
                    otherid = rs.getInt(6);
                    cdate = f.format(rs.getDate(7));
                }

                String phone = rs.getString(8);
                String address = rs.getString(9);

                int status;
                if (rs.getString(10) == null) {
                    status = 3;
                } else {
                    status = rs.getInt(10);
                }
                System.out.println("status: " + status);
                data.add(new Order(oid, date, money, cid, sid, cdate, phone, address, status));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return data;
    }

    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        try {
            String strSelect = "Select OrderID, OrderDate, TotalMoney, CustomerId from headphone.orders;";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            String date = "";
            while (rs.next()) {
                int id = rs.getInt(1);
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                if (rs.getDate(2) != null) {
                    date = f.format(rs.getDate(2));
                }
                float totalmoney = rs.getFloat(3);
                int customerid = rs.getInt(4);

                list.add(new Order(id, date, totalmoney, customerid) );
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    

    
    public int getNumberOfOrder(){
        try {
            String sql = "SELECT COUNT(*) AS OrderCount FROM Headphone.Orders;";
            pstm = cnn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("getAllProductByPage" + ex.getMessage());
        }
            return -1;
    }
    
    public float getTotalEarning(){
        try {
            String sql = "SELECT SUM(TotalMoney) AS TotalMoneySum FROM Headphone.Orders;";
            pstm = cnn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            if(rs.next()){
                String st = String.format("%.3f", rs.getFloat(1));
                return Float.parseFloat(st);
            }
        } catch (Exception ex) {
            System.out.println("getAllProductByPage" + ex.getMessage());
        }
            return -1;
    }

    public void updateStaffOrder(List<Order> lo, int bannedStaffID) {
        try {
            int sid;
            Product p = new Product();
            for (Order o : lo) {
                sid = getOrderManager();
                String strUpdate = "UPDATE headphone.orders SET StaffID = "+sid+" WHERE StaffID = "+bannedStaffID+" AND OrderID = "+o.getID();
                pstm = cnn.prepareStatement(strUpdate);

                pstm.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("updateStaffOrder: " + e.getMessage());
        }
    }

    public List<Order> AccountantGetAllOrder(){
        List<Order> data = new ArrayList<>();
        try{
            String sql = "SELECT O.OrderID, O.OrderDate, O.TotalMoney, O.CustomerID, O.StaffID,CO.OrderID, CO.CompletedDate, O.Phone, O.DeliveryAddress, CO.Status\n" +
                    "FROM Headphone.Orders AS O\n" +
                    "LEFT JOIN Headphone.CompletedOrder AS CO ON O.OrderID = CO.OrderID;";
            pstm = cnn.prepareStatement(sql);
            rs = pstm.executeQuery();
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            while(rs.next()){
                int oid = rs.getInt(1);
                String date = "";
                date = f.format(rs.getDate(2));

                String st = String.format("%.1f", rs.getFloat(3));
                float money = Float.parseFloat(st);
                int cid = rs.getInt(4);
                int sid = rs.getInt(5);
                int otherid = 0;
                String cdate = "-";
                if(rs.getString(6) != null){
                    otherid = rs.getInt(6);
                    cdate = f.format(rs.getDate(7));
                }

                String phone = rs.getString(8);
                String address = rs.getString(9);

                int status;
                if(rs.getString(10)==null){
                    status = 3;
                }else{
                    status = rs.getInt(10);
                }

                data.add(new Order(oid, date, money, cid, sid, cdate,phone,address,status));
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return data;
    }

}
