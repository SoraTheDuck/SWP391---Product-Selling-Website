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
import model.Cart;
import model.Item;
import model.Product;

import java.io.IOException;

@WebServlet(name = "ProcessController2", urlPatterns = "/process1")
public class ProcessController2 extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Float scrollPos = (Float) session.getAttribute("scrollPos"); // Retrieve scrollPos from session
        if (scrollPos != null) {
            float scrollPosValue = scrollPos.floatValue(); // Convert Float to float
            req.setAttribute("scrollPos", scrollPosValue); // Set scrollPos as a request attribute
        }
        req.getRequestDispatcher("Shopping-cart.jsp").forward(req, resp);
    }
}
