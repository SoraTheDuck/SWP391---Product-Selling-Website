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
@WebServlet(name = "ManagerBoardController", urlPatterns = "/managerboard")
public class ManagerBoardController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int mid = Integer.parseInt(session.getAttribute("mid").toString());
        Order o = new Order();
        List<Order> list = o.getListNotCompletedOrder(mid);
        req.setAttribute("ord_id", mid);
        req.setAttribute("list", list);
        req.getRequestDispatcher("OrderManager.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("mid")!=null){
        int mid = Integer.parseInt(session.getAttribute("mid").toString());
        Order o = new Order();
        List<Order> list = o.getListNotCompletedOrder(mid);
        req.setAttribute("ord_id", mid);
        req.setAttribute("list", list);
        req.getRequestDispatcher("OrderManager.jsp").forward(req, resp);
        }else resp.sendRedirect("404");
    }

}
