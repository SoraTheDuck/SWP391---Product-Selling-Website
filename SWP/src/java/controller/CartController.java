/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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
public class CartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("404");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int scrollPos;
        if(req.getParameter("scrollPos") != null) scrollPos = Integer.parseInt(req.getParameter("scrollPos"));
        else scrollPos = 0;

        String redirect=req.getParameter("redirect");
        String pid=req.getParameter("id");

        HttpSession session = req.getSession();
        Cart c = new Cart();
        Object o = session.getAttribute("cart");
        if (o != null) {
            c = (Cart) o;
        }

        String id = req.getParameter("id");

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

        session.setAttribute("cart", c);
        req.setAttribute("scrollPos", scrollPos);
        if(redirect.equals("home"))resp.sendRedirect(redirect);
        if(redirect.equals("detail"))resp.sendRedirect("detail?pid="+pid);
        if(redirect.equals("shop"))resp.sendRedirect("shop");

    }

}