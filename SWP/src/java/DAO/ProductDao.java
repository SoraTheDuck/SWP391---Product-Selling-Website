/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DBContext;
import model.Product;

/**
 *
 * @author quany
 */
public class ProductDao extends DBContext{
    public List<Product> getAllProductByPage(int page, int pageIndex){
        List<Product> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM headphone.product LIMIT ? OFFSET ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, page);
            statement.setInt(2, pageIndex);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product a = new Product();
                a.setId(rs.getInt(1));
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
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM headphone.product";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product a = new Product();
                a.setId(rs.getInt(1));
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
}
