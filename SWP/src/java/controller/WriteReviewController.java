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
import model.Customer;
import model.Review;

/**
 *
 * @author quany
 */
public class WriteReviewController  extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("cus");
        String content = req.getParameter("content");
        String rate = req.getParameter("rate");
        String productId = req.getParameter("productId");
        Review review = new Review();
        review.insertReview(new Review(content, customer , productId, Integer.parseInt(rate)));
        resp.sendRedirect("detail?pid="+ productId);
    }
    
}
