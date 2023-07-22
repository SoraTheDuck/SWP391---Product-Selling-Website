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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Order;
import model.Product;

@WebServlet(name = "AccountantProductController", urlPatterns = "/accountantproduct")
public class AccountantProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product p = new Product();
        List<Product> rlist = p.getListTotalRevenueProduct();
        req.setAttribute("rlist", rlist);
        req.getRequestDispatcher("Accountant_product.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product p = new Product();
        List<Product> rlist = p.getListTotalRevenueProduct();
        req.setAttribute("rlist", rlist);
        req.getRequestDispatcher("Accountant_product.jsp").forward(req, resp);
    }

}