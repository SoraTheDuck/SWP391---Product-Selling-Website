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
import java.util.List;
import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author admin
 */
import jakarta.servlet.annotation.*;
@WebServlet(name = "CartController", urlPatterns = "/cart")
public class CartController extends HttpServlet {

    public int getTotalPage(int pageSize) {
        Product product = new Product();
        int totalProducts = product.getAllProduct().size();
        int totalPage = (int) Math.ceil((double) totalProducts / pageSize);
        return totalPage;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart c = new Cart();
        Object o = session.getAttribute("cart");
        if (o != null) {
            c = (Cart) o;
        }

        int num = Integer.parseInt(req.getParameter("num"));
        String id = req.getParameter("id");

        Product p = new Product();
        Product p1 = p.getProductByID2(id);

        float price;
        if (p1.getSaleprice() != 0) {
            price = p1.getSaleprice();
        } else {
            price = p1.getPrice();
        }
        System.out.println("product price: "+price);
        Item t = new Item(p1, price, num);
        c.addItem(t);

        session.setAttribute("cart", c);
        //req.getRequestDispatcher("shop").forward(req, resp);

        Product product = new Product();

        int pageSize = 9;
        int currentPage = 1;
        int startIndex = (currentPage - 1) * pageSize;
        int totalPage = getTotalPage(pageSize);
        if (req.getParameter("page") != null) {
            currentPage = Integer.parseInt(req.getParameter("page"));
            startIndex = (currentPage - 1) * pageSize;
        }

        List<Product> list = product.getAllProductByPage2(pageSize, startIndex);

        req.setAttribute("list", list);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("link", "/shop");
        req.getRequestDispatcher("shop-left-sidebar.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart c = new Cart();
        Object o = session.getAttribute("cart");
        if (o != null) {
            c = (Cart) o;
        }

        //int num = Integer.parseInt(req.getParameter("num"));
        String id = req.getParameter("id");

        Product p = new Product();
        Product p1 = p.getProductByID2(id);

        float price;
        if (p1.getSaleprice() != 0) {
            price = p1.getSaleprice();
        } else {
            price = p1.getPrice();
        }
        System.out.println("product price: "+price);
        Item t = new Item(p1, price, 1);
        c.addItem(t);

        session.setAttribute("cart", c);
        req.getRequestDispatcher("home").forward(req, resp);

    }

}
