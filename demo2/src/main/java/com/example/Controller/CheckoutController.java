/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Cart;
import model.Customer;
import model.Order;

/**
 *
 * @author admin
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CheckoutController", urlPatterns = "/checkout")
public class CheckoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Customer checkLogin = (Customer) session.getAttribute("cus");
        if (checkLogin != null) {
            String mess;
            Cart cart = null;
            Object temp = session.getAttribute("cart");

            if (temp != null) {
                cart = (Cart) temp;
            } else {
                cart = new Cart();
            }

            if (cart.getItems().isEmpty()) {
                mess = "Please choose at least 1 product to checkout!!";
                req.setAttribute("mess", mess);
                req.getRequestDispatcher("Shopping-cart.jsp").forward(req, resp);
            } else {
                System.out.println("yay");
                req.getRequestDispatcher("Checkout.jsp").forward(req, resp);
            }
        } else {
            String mess = "Please Login to Order";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("catched");
    }

}
