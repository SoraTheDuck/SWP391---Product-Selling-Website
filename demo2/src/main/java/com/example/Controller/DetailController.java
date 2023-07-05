/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import model.Cart;
import model.Category;
import model.Product;
import model.Review;

/**
 *
 * @author Acer Aspire
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DetailController", urlPatterns = "/detail")
public class DetailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart c = new Cart();
        Object o = session.getAttribute("cart");
        if (o != null) {
            c = (Cart) o;
        }

        String pid = req.getParameter("pid");

        Product product = new Product();
        Review review = new Review();
        List<Review> reviewListSize = review.getAllReviewsByProductID(pid);

        req.setAttribute("detail", product.getProductByID2(pid));
        req.setAttribute("review", review.getAllReviewsByProductID(pid));
        req.setAttribute("reviewListSize", reviewListSize.size());
        req.getRequestDispatcher("single-product.jsp").forward(req, resp);
    }

}
