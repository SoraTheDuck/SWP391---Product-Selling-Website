/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller.marketing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Product;

/**
 *
 * @author admin
 */
@WebServlet(name = "MarketingDiscountController", urlPatterns = "/marketingdiscount")
public class MarketingDiscountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String end = req.getParameter("end");
        String dis = req.getParameter("discount");
        int discount = 0;
        Product p = new Product();

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String todayDate = f.format(new Date());

        Product pr = p.getProductByID2(id);

        if (end.isEmpty()) {
            req.setAttribute("todayDate", todayDate);
            req.setAttribute("mess", "Please choose an end date");
            req.setAttribute("p", pr);
            req.getRequestDispatcher("MarketingDiscount.jsp").forward(req, resp);
            return;
        }

        if (dis.isEmpty() || dis.equals("0")) {
            req.setAttribute("todayDate", todayDate);
            req.setAttribute("mess", "Please enter discount");
            req.setAttribute("p", pr);
            req.getRequestDispatcher("MarketingDiscount.jsp").forward(req, resp);
            return;
        } else  discount = Integer.parseInt(dis);

        if (discount >= 90  || discount <= 0) {
            req.setAttribute("mess", "Discount must be greater than 0% and less than 90%");
            req.setAttribute("p", pr);
            req.setAttribute("todayDate", todayDate);
            req.getRequestDispatcher("MarketingDiscount.jsp").forward(req, resp);
            return;
        }

        try {
            Date ed = f.parse(end);
            java.util.Calendar cal = java.util.Calendar.getInstance();
            Date utilDate = cal.getTime();

            if (ed.before(utilDate)) {
                req.setAttribute("p", pr);
                req.setAttribute("mess", "Invalid end date!<br>(end date must be later than today)");
                req.setAttribute("todayDate", todayDate);
                req.getRequestDispatcher("MarketingDiscount.jsp").forward(req, resp);
            } else
            {
                p.setDiscount(todayDate, end, discount, id);
                List<Product> list = p.getAllProductReleaseDate();
                req.setAttribute("list", list);
                req.setAttribute("mess", "Set discount success!");
                req.getRequestDispatcher("Marketing.jsp").forward(req, resp);
            }
        } catch (ParseException e) {
            req.setAttribute("todayDate", todayDate);
            System.out.println("ProductDiscountController: cannot parse date");
            req.setAttribute("mess", "Cannot set discount!");
            req.setAttribute("p", pr);
            req.getRequestDispatcher("MarketingDiscount.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }
    
}
