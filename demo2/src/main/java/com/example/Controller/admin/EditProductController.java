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
import java.io.IOException;
import java.util.List;
import model.Product;

/**
 *
 * @author admin
 */
@WebServlet(name = "EditProductController", urlPatterns = "/editproduct")
public class EditProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Product p = new Product();

        String changelog = req.getParameter("change");
        if (changelog.isEmpty()) {
            req.setAttribute("mess", "Changelog cannot be empty!");
            req.setAttribute("p", p.getProductByID2(id));
            req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
            return;
        }

        String name = req.getParameter("name");
        if (name.isEmpty()) {
            req.setAttribute("mess", "Name cannot be empty!");
            req.setAttribute("p", p.getProductByID2(id));
            req.setAttribute("log", changelog);
            req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
            return;
        }
        
        String pr = req.getParameter("price");
        if (pr.isEmpty()) {
            req.setAttribute("mess", "Price cannot be empty!");
            req.setAttribute("p", p.getProductByID2(id));
            req.setAttribute("log", changelog);
            req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
            return;
        }
        float price = 0;
        try {
            price = Float.parseFloat(pr);
        } catch (NumberFormatException e) {
            System.err.println("Wrong price data type!");
            req.setAttribute("p", p.getProductByID2(id));
            req.setAttribute("mess", "Price must be float!");
            req.setAttribute("log", changelog);
            req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
            return;
        }

        String image = req.getParameter("image");
        if (image.isEmpty()) {
            req.setAttribute("mess", "Image cannot be empty!");
            req.setAttribute("p", p.getProductByID2(id));
            req.setAttribute("log", changelog);
            req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
            return;
        }

        if (req.getParameter("quantity").isEmpty()) {
            req.setAttribute("mess", "Quantity cannot be empty!");
            req.setAttribute("p", p.getProductByID2(id));
            req.setAttribute("log", changelog);
            req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
            return;
        }
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        String wire = "";
        if (req.getParameter("wire") != null) {
            wire = "Wired";
        } else {
            wire = "Wireless";
        }

        String description = req.getParameter("description");
        if (description.isEmpty()) {
            req.setAttribute("mess", "Description cannot be empty!");
            req.setAttribute("p", p.getProductByID2(id));
            req.setAttribute("log", changelog);
            req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
            return;
        }

        p.updateProduct(id, name, price, image, quantity, wire, description);
        p.updateHistory(changelog, id);

        List<Product> list = p.getAllProduct();
        req.setAttribute("listPro", list);
        req.setAttribute("mess", "Edit success!");
        req.getRequestDispatcher("Admin_products.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("test", id);
        Product p = new Product();
        req.setAttribute("p", p.getProductByID2(id));
        req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
    }

}
