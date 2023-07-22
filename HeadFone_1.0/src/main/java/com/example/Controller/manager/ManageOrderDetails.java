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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Order;

/**
 *
 * @author Acer Aspire
 */
@WebServlet(name = "ManageOrderDetails", urlPatterns = "/manageorderdetails")
public class ManageOrderDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order();
        List<Order> orderAList = order.AccountantGetAllOrder();
        req.setAttribute("orderAList", orderAList);
        req.getRequestDispatcher("ManageOrderDetail.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Order order = new Order();
        if(session.getAttribute("mid")!=null){
        List<Order> orderAList = order.AccountantGetAllOrder();
        req.setAttribute("orderAList", orderAList);
        req.getRequestDispatcher("ManageOrderDetail.jsp").forward(req, resp);
        }else resp.sendRedirect("404");
        
    }
    
}
