/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Product;

/**
 *
 * @author admin
 */
@WebServlet(name = "AdminPageController", urlPatterns = "/adminpage")
public class DeleteDiscountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String mess;
        Product p = new Product();
        boolean dis = p.checkDiscount(id);

        if (dis) {
            p.deleteDiscount(id);
            mess = "Delete success!";
        } else {
            mess = "Cannot delete";
        }

        HttpSession session = req.getSession();
        if (session.getAttribute("admin") != null) {
            List<Product> list = p.getAllProductReleaseDate();
            req.setAttribute("list", list);
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("Admin_discount.jsp").forward(req, resp);
        }
        if (session.getAttribute("marketing") != null) {
            List<Product> list = p.getAllProductReleaseDate();
            req.setAttribute("list", list);
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("Marketing.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("admin") != null || session.getAttribute("marketing") != null) {
            req.getRequestDispatcher("Admin_discount.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("404").forward(req, resp);
        }
    }

}
