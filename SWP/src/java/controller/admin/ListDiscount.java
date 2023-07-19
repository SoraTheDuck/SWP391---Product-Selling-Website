/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Admin;
import model.Product;

/**
 *
 * @author Acer Aspire
 */
public class ListDiscount extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Product p = new Product();
        boolean dis = p.checkDiscount(id);

        if (dis) {
            List<Product> list = p.getAllProductReleaseDate();
            req.setAttribute("list", list);
            req.setAttribute("mess", "Cannot add discount!");
            req.getRequestDispatcher("Admin_discount.jsp").forward(req, resp);
        } else {
            Product pr = p.getProductByID2(id);
            // Calculate today's date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String todayDate = dateFormat.format(new Date());

            // Set today's date as an attribute in the request scope
            req.setAttribute("todayDate", todayDate);
            req.setAttribute("p", pr);
            req.getRequestDispatcher("ProductDiscount.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        if (admin != null) {
            Product p = new Product();
            List<Product> list = p.getAllProductReleaseDate();
            req.setAttribute("list", list);
            req.getRequestDispatcher("Admin_discount.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("404").forward(req, resp);
        }
    }

}
