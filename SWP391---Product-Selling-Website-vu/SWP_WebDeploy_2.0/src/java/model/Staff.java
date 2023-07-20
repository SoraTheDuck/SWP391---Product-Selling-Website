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
public class Staff {

    private int id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private boolean accountant;
    private boolean marketing;
    private boolean orderManager;
    private int adminID;

    public Staff() {
        connect();
    }

    public Staff(String email, String password) {
        this.password = password;
        this.email = email;
        connect();
    }

    public Staff(int id, String name, String password, String email, String phone, boolean accountant, boolean marketing, boolean orderManager, int adminID) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.accountant = accountant;
        this.marketing = marketing;
        this.orderManager = orderManager;
        this.adminID = adminID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAccountant() {
        return accountant;
    }

    public void setAccountant(boolean accountant) {
        this.accountant = accountant;
    }

    public boolean isMarketing() {
        return marketing;
    }

    public void setMarketing(boolean marketing) {
        this.marketing = marketing;
    }

    public boolean isOrderManager() {
        return orderManager;
    }

    public void setOrderManager(boolean orderManager) {
        this.orderManager = orderManager;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    Connection cnn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;

    private void connect() {
        try {
            cnn = (new DBContext().connection);
            if (cnn != null) {
                System.out.println("Connect successfully3");
            } else {
                System.out.println("Connect Fail");
            }
        } catch (Exception e) {

        }
    }

    public boolean checkLogin() {
        try {
            String strSelect = "SELECT * FROM headphone.staff where email=? and password=? ";
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

    public String getRole() {
        String role = "";
        try {
            String strSelect = "SELECT * FROM headphone.staff where email=? and password=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, email);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                if (rs.getBoolean(6)) {
                    role = "Accountant";
                }
                if (rs.getBoolean(7)) {
                    role = "Marketing";
                }
                if (rs.getBoolean(8)) {
                    role = "OrderManager";
                }
            }
        } catch (Exception e) {
            System.out.println("getRole:" + e.getMessage());
        }
        return role;
    }

    public List<Staff> getListStaff() {
        List<Staff> data = new ArrayList<>();
        try {
            String sql = "select * from headphone.staff";
            pstm = cnn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int sid = rs.getInt(1);
                String sname = rs.getString(2);
                String spassword = rs.getString(3);
                String semail = rs.getString(4);
                String sphone = rs.getString(5);
                boolean acc = rs.getBoolean(6);
                boolean mar = rs.getBoolean(7);
                boolean ord = rs.getBoolean(8);
                int ad = rs.getInt(10);

                data.add(new Staff(sid, sname, spassword, semail, sphone, acc, mar, ord, ad));

            }
        } catch (Exception e) {
            System.out.println("getListStaff" + e.getMessage());
        }
        return data;
    }

    public void addStaff(String sname, String spassword, String semail, String sphone, boolean acc, boolean mar, boolean ord, int adID) {
        try {
            String strAdd = "insert into headphone.staff (StaffName, Password, Email, Phone, Accountant, "
                    + "Marketing, OrderManager, AdminID) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";

            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, sname);
            pstm.setString(2, spassword);
            pstm.setString(3, semail);
            pstm.setString(4, sphone);
            pstm.setBoolean(5, acc);
            pstm.setBoolean(6, mar);
            pstm.setBoolean(7, ord);
            pstm.setInt(8, adID);

            pstm.execute();
        } catch (Exception e) {
            System.out.println("addStaff:" + e.getMessage());
        }
    }

    public Staff getStaff() {
        Staff s = new Staff();
        try {
            String strSelect = "SELECT * FROM headphone.staff where email=? and password=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, email);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt(1);
                String sname = rs.getString(2);
                String sphone = rs.getString(5);
                boolean saccountant = rs.getBoolean(6);
                boolean smarketing = rs.getBoolean(7);
                boolean sorderManager = rs.getBoolean(8);
                int sadminID = rs.getInt(10);

                s = new Staff(sid, sname, password, email, sphone, saccountant, smarketing, sorderManager, sadminID);

            }
        } catch (Exception e) {
            System.out.println("getStaff:" + e.getMessage());
        }
        return s;
    }
    
        public boolean checkExist(String email) {
        try {
            String strSelect = "SELECT * FROM headphone.staff where email=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkExist:" + e.getMessage());
        }
        return false;
    }

}
