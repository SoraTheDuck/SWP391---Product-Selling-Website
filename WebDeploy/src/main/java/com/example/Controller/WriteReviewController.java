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
import java.io.IOException;
import model.Review;

/**
 *
 * @author Acer Aspire
 */
@WebServlet(name = "WriteReviewController", urlPatterns = "/writereview")
public class WriteReviewController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productID = req.getParameter("productid");
        int customerID =Integer.parseInt(req.getParameter("logined")); 
        int rating = Integer.parseInt(req.getParameter("rating")); 
        String content = req.getParameter("content");
        
        Review r = new Review(rating, content, productID, customerID);
        r.addReview();
        resp.sendRedirect("detail?pid="+ productID);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productID = req.getParameter("productid");
        int customerID =Integer.parseInt(req.getParameter("logined")); 
        
        int rating = Integer.parseInt(req.getParameter("rating")); 
        String content = req.getParameter("content");
        
        System.out.println(req.getParameter("logined"));
        System.out.println(req.getParameter("rating"));
        Review r = new Review(rating, content, productID, customerID);
        r.addReview();
        resp.sendRedirect("detail?pid="+ productID);
    }
    
}
