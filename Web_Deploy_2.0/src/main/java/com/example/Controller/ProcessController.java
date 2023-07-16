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
import model.Item;
import model.Product;

/**
 *
 * @author admin
 */
import jakarta.servlet.annotation.*;
@WebServlet(name = "ProcessController", urlPatterns = "/process")
public class ProcessController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }

        String pnum = req.getParameter("num");
        String pid = req.getParameter("id");
        try {
            int num = Integer.parseInt(pnum);
            if (num == -1 && cart.getQuantityById(pid) <= 1) {
                
                System.out.println("if: "+cart.getQuantityById(pid));
                cart.removeItem(pid);
            } else {
                
                System.out.println("else: "+cart.getQuantityById(pid));
                Product temp = new Product();
                Product p = temp.getProductByID(pid);
                float price = p.getPrice();
                Item i = new Item(p, price, num);
                cart.addItem(i);
            }
        } catch (Exception e) {
            System.out.println("ProcessController error");
        }
        session.setAttribute("cart", cart);
        req.getRequestDispatcher("Shopping-cart.jsp").forward(req, resp);
    }

}
