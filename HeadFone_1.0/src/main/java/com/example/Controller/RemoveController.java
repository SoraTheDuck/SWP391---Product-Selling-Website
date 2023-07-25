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

/**
 *
 * @author admin
 */
import jakarta.servlet.annotation.*;
@WebServlet(name = "RemoveController", urlPatterns = "/remove")
public class RemoveController extends HttpServlet {

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

        float scrollPos;
        if (req.getParameter("scrollPos") != null) {
            scrollPos = Float.parseFloat(req.getParameter("scrollPos").toString());
        } else {
            scrollPos = 0;
        }
        System.out.println("process: " + scrollPos);
        session.setAttribute("scrollPos", scrollPos);

        String id = req.getParameter("id");
        cart.removeItem(id);
        session.setAttribute("cart", cart);
        resp.sendRedirect("process1");
    }

}
