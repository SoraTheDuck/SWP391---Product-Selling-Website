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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Product;

/**
 *
 * @author admin
 */
public class ProductDiscountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //String start = ;
        String end = req.getParameter("end");
        String dis = req.getParameter("discount");
        int discount=0;
        Product p = new Product();
        Product pr = p.getProductByID2(id);
        
//        if (start == null) {
//            req.setAttribute("mess", "Please choose a start date");
//            req.setAttribute("p", pr);
//            req.getRequestDispatcher("ProductDiscount.jsp").forward(req, resp);
//        }
        if (end == null) {
            req.setAttribute("mess", "Please choose an end date");
            req.setAttribute("p", pr);
            req.getRequestDispatcher("ProductDiscount.jsp").forward(req, resp);
        }
        if (dis == null) {
            req.setAttribute("mess", "Please enter discount");
            req.setAttribute("p", pr);
            req.getRequestDispatcher("ProductDiscount.jsp").forward(req, resp);
        }
        else{
            discount=Integer.parseInt(dis);
        }
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println(start);
        try {
            Date sd = f.parse(req.getParameter("start"));
            Date ed = f.parse(end);
            java.util.Calendar cal = java.util.Calendar.getInstance();
            java.util.Date utilDate = cal.getTime();

            if (sd.before(utilDate) || ed.before(utilDate)) {
                req.setAttribute("mess", "End date or start date not valid!<br>(end date must be later than today, start date must be today or later)");
                req.getRequestDispatcher("ProductDiscount.jsp").forward(req, resp);
            } else {
                if (ed.before(sd)) {
                    req.setAttribute("mess", "End date must be after start date!");
                    req.getRequestDispatcher("ProductDiscount.jsp").forward(req, resp);
                } else {
                    //p.setDiscount(start, end, discount, id);
                    req.setAttribute("mess", "Set discount success!");
                    List<Product> list = p.getAllProductReleaseDate();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("Discount.jsp").forward(req, resp);
                }
            }
        } catch (ParseException e) {
            System.out.println("ProductDiscountController: cannot parse date");
            req.setAttribute("mess", "Cannot set discount!");
            req.setAttribute("p", pr);
            req.getRequestDispatcher("ProductDiscount.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
