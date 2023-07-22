/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller.manager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Customer;
import model.Order;
import model.Product;
import model.Staff;

/**
 *
 * @author Acer Aspire
 */
@WebServlet(name = "ExportOrderManagerController", urlPatterns = "/exportordermanager")
public class ExportOrderManagerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order();
        String type = req.getParameter("type");
        List<Order> aolist = new ArrayList<>();
        Customer c = new Customer();
        Staff s = new Staff();
        Product p = new Product();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayDate = dateFormat.format(new Date());
        if (type.equals("1")) {
            aolist = order.AccountantGetAllOrder();
        }
        try {
            StringBuilder sb = new StringBuilder();

            if (!aolist.isEmpty()) {
                sb.append("OrderID"); sb.append(",");
                sb.append("OrderDate"); sb.append(",");
                sb.append("TotalMoney"); sb.append(",");
                sb.append("CustomerID"); sb.append(",");
                sb.append("CustomerName"); sb.append(",");
                sb.append("CustomerPhone"); sb.append(",");
                sb.append("StaffID"); sb.append(",");
                sb.append("StaffName"); sb.append(",");
                sb.append("StaffPhone"); sb.append(",");
                sb.append("Delivery Address"); sb.append(",");
                sb.append("Status"); sb.append(",");
                sb.append("CompleteDate"); sb.append("\r\n");
                for (Order o : aolist) {
                    sb.append(o.getID()); sb.append(",");
                    sb.append(o.getDate()); sb.append(",");
                    sb.append(o.getTotalMoney()); sb.append(",");
                    sb.append(o.getCustomerID()); sb.append(",");
                    sb.append(c.getCusById(o.getCustomerID()).getName()); sb.append(",");
                    sb.append(o.getCphone()); sb.append(",");
                    sb.append(o.getStaffid()); sb.append(",");
                    sb.append(s.getStaffByID(o.getStaffid()).getName()); sb.append(",");
                    sb.append(s.getStaffByID(o.getStaffid()).getPhone()); sb.append(",");
                    sb.append(o.getDaddress().replace(',', '.')); sb.append(",");
                    if(o.getOstatus() == 1){
                        sb.append("Complete"); sb.append(",");
                    }
                    if(o.getOstatus() == 0){
                        sb.append("Rejected"); sb.append(",");
                    }
                    if(o.getOstatus() == 3){
                        sb.append("In-progress"); sb.append(",");
                    }
                    sb.append(o.getCdate()); sb.append("\r\n");
                }
                sb.append("\r\n");
                sb.append(todayDate);
            }

            resp.setContentType("text/csv");
            resp.setHeader("Content-Disposition", "attachment; filename=\"OrderManager.csv\"");
            try (PrintWriter writer = resp.getWriter()) {
                writer.write(sb.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            req.getRequestDispatcher("404.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
