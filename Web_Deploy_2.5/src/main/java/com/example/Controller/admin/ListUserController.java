/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Customer;
import model.Order;

/**
 *
 * @author Admin
 */
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Order;
import model.Product;

/**
 *
 * @author Admin
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import model.Product;

/**
 *
 * @author admin
 */
import jakarta.servlet.annotation.*;
@WebServlet(name = "ListUserController", urlPatterns = "/list-user")
public class ListUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //for edit customer 
//        int cid = Integer.parseInt(req.getParameter("id"));
//        String cname = req.getParameter("name");
//        String cpass = req.getParameter("pass");
//        String caddr = req.getParameter("address");
//        String cemail = req.getParameter("email");
//
//        Customer cus = new Customer();
//        cus.updateCus(cname, cpass, caddr, cemail, cid);
//
//        req.setAttribute("upmess", "Update customer successfully!");
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("admin") != null) {
            Customer cus = new Customer();
            List<Customer> list = cus.getAllCus();
            req.setAttribute("listUser", list);

            String upmess = (String) req.getAttribute("upmess");
            req.setAttribute("upmess", upmess);

            req.getRequestDispatcher("Admin_users.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("404");
        }

    }

}
