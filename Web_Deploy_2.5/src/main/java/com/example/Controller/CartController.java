/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author admin
 */
@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("404");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String redirect=req.getParameter("redirect");
        String pid=req.getParameter("id");

        Cart c = new Cart();
        Object o = session.getAttribute("cart");
        if (o != null) {
            c = (Cart) o;
        }

        //scroll save
        float scrollPos;
        if (req.getParameter("scrollPos") != null) {
            scrollPos = Float.parseFloat(req.getParameter("scrollPos").toString());
        } else {
            scrollPos = 0;
        }
        System.out.println(scrollPos);
        session.setAttribute("scrollPos", scrollPos);

        if(redirect == "process")
        {
            System.out.println("here");
            int num = Integer.parseInt(req.getParameter("num").toString());

            if (num == -1 && c.getQuantityById(pid) <= 1) {
                System.out.println("if: "+c.getQuantityById(pid));
                c.removeItem(pid);
            } else {
                System.out.println("else: "+c.getQuantityById(pid));
                Product temp = new Product();
                Product p = temp.getProductByID(pid);
                float price = p.getPrice();
                Item i = new Item(p, price, num);
                c.addItem(i);
            }

            session.setAttribute("cart", c);
            resp.sendRedirect(redirect);
        }
        else
        {
            String id = req.getParameter("id");
            System.out.println(id);
            Product p = new Product();
            Product p1 = p.getProductByID2(id);
            float price;
            if (p1.getSaleprice() != 0) {
                price = p1.getSaleprice();
            } else {
                price = p1.getPrice();
            }
            Item t = new Item(p1, price, 1);
            c.addItem(t);
        }

        session.setAttribute("cart", c);
        if(redirect.equals("home"))resp.sendRedirect(redirect);
        if(redirect.equals("detail"))resp.sendRedirect("detail?pid="+pid);
        if(redirect.equals("shop"))resp.sendRedirect(redirect);
        if(redirect.equals("process"))resp.sendRedirect(redirect);

    }

}