/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller.accountant;

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
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Order;

/**
 *
 * @author Acer Aspire
 */
@WebServlet(name = "ExportOrderController", urlPatterns = "/exportorder")
public class ExportOrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order();
        String type = req.getParameter("type");
        List<Order> aolist = new ArrayList<>();
        if (type.equals("1")) {
            aolist = order.AccountantGetAllOrder();
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (Order o : aolist) {
                sb.append(o.getID());
                sb.append(",");
                sb.append(o.getDate());
                sb.append(",");
                sb.append(o.getTotalMoney());
                sb.append(",");
                sb.append(o.getCustomerID());
                sb.append(",");
                sb.append(o.getStaffid());
                sb.append(",");
                if (o.getOtherid() > 0) {
                    sb.append("Completed");
                } else {
                    sb.append("In-Progress");
                }
                sb.append(",");
                sb.append(o.getCdate());
                sb.append("\r\n");
            }
            resp.setContentType("text/csv");
            resp.setHeader("Content-Disposition", "attachment; filename=\"file.csv\"");
            try (PrintWriter writer = resp.getWriter()) {
                writer.write(sb.toString());
            }
        } catch (Exception e) {
            req.getRequestDispatcher("404.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
