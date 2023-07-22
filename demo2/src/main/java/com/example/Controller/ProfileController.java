/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;

/**
 *
 * @author Admin
 */
import jakarta.servlet.annotation.*;

@WebServlet(name = "ProfileController", urlPatterns = "/profile")
public class ProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getSession().getAttribute("cus")!=null){
            Customer customer = (Customer) request.getSession().getAttribute("cus");
            int cusId = customer.getId();
            customer.getCusById(cusId);
            request.setAttribute("cus", customer);
            request.getRequestDispatcher("Customer_profile.jsp").forward(request, response);
        }else response.sendRedirect("404");
        
        
    }


}
