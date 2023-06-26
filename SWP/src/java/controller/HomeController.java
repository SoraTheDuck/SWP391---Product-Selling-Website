/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Acer Aspire
 */
public class HomeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product p = new Product();
        Category c = new Category();
        List<Category> list = c.getAllCategory();
        List<Product> hlist = p.getAllProductsByCategory(1);
        List<Product> elist = p.getAllProductsByCategory(2);
        List<Product> hslist = p.getAllProductsByCategory(3);
        List<Product> alist = p.getAllProductsByCategory(4);
        req.setAttribute("categoryList", list);
        req.setAttribute("earphoneList", elist);
        req.setAttribute("headphoneList", hlist);
        req.setAttribute("headsetList", hslist);
        req.setAttribute("airpodList", alist);
        req.getRequestDispatcher("Home.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product p = new Product();
        Category c = new Category();
        List<Category> list = c.getAllCategory();
        List<Product> hlist = p.getAllProductsByCategory(1);
        List<Product> elist = p.getAllProductsByCategory(2);
        List<Product> hslist = p.getAllProductsByCategory(3);
        List<Product> alist = p.getAllProductsByCategory(4);
        req.setAttribute("categoryList", list);
        req.setAttribute("earphoneList", elist);
        req.setAttribute("headphoneList", hlist);
        req.setAttribute("headsetList", hslist);
        req.setAttribute("airpodList", alist);
        req.getRequestDispatcher("Home.jsp").forward(req, resp);
    }
    
}
