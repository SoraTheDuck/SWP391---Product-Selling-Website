/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Order;
import model.Product;

/**
 *
 * @author Acer Aspire
 */
@WebServlet(name = "AdminPageController", urlPatterns = "/adminpage")
public class AdminPageController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product p = new Product();
        Customer c = new Customer();
        Order o = new Order();

        int totalCustomer = c.getNumberOfCustomer();
        int totalProduct = p.getNumberOfProduct();
        int totalOrder = o.getNumberOfOrder();
        float totalEarning = o.getTotalEarning();
        List<Product> toplist = p.getTrendingProduct();

        req.setAttribute("toplist", toplist);
        req.setAttribute("totalcustomer", totalCustomer);
        req.setAttribute("totalproduct", totalProduct);
        req.setAttribute("totalorder", totalOrder);
        req.setAttribute("totalearning", totalEarning);

        req.getRequestDispatcher("Admin_page.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session.getAttribute("admin") != null) {
            Product p = new Product();
            Customer c = new Customer();
            Order o = new Order();

            int totalCustomer = c.getNumberOfCustomer();
            int totalProduct = p.getNumberOfProduct();
            int totalOrder = o.getNumberOfOrder();
            float totalEarning = o.getTotalEarning();
            List<Product> toplist = p.getTrendingProduct();

            req.setAttribute("toplist", toplist);
            req.setAttribute("totalcustomer", totalCustomer);
            req.setAttribute("totalproduct", totalProduct);
            req.setAttribute("totalorder", totalOrder);
            req.setAttribute("totalearning", totalEarning);

            req.getRequestDispatcher("Admin_page.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("404");
        }

    }

}
