/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.accountant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Order;

/**
 *
 * @author Acer Aspire
 */
public class AccountantOrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order();
        List<Order> orderAList = order.AccountantGetAllOrder();
        req.setAttribute("orderAList", orderAList);
        req.getRequestDispatcher("Accountant.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order();
        List<Order> orderAList = order.AccountantGetAllOrder();
        req.setAttribute("orderAList", orderAList);
        req.getRequestDispatcher("Accountant.jsp").forward(req, resp);
    }
    
    
}
