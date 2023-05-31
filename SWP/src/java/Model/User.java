/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String address;
    private String email;

    public User() {
        connect();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        connect();
    }
    
    public User(int id, String name, String username, String password, String address, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    
    Connection cnn;//Kết nối DB
    Statement stm;//Thực thi các câu lệnh SQL
    PreparedStatement pstm;//Thực thi câu lệnh SQL
    ResultSet rs;//Lưu trữ dữ liệu và xử lí

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            }
        } catch (Exception e) {

        }
    }

    public boolean checkUserLogin() {
        try {
            String strSelect = "SELECT * FROM customer where username=? and password=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkUserLogin:" + e.getMessage());
        }
        return false;
    }
    
        public void getUserByAccount(String username) {
        try {
            String strSelect = "SELECT * FROM headphonestore.customer where username=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            while (rs.next()) {
                this.id=rs.getInt(1);
                this.name=rs.getString(2);
                this.username=rs.getString(3);
                this.password=rs.getString(4);
                this.address=rs.getString(5);
                this.email=rs.getString(6);
            }
        } catch (Exception e) {
            System.out.println("getUserByAccount:" + e.getMessage());
        }
    }
}
