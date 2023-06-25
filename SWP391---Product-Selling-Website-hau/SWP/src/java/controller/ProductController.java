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
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author Acer Aspire
 */
public class ProductController extends HttpServlet {
    
    public int getTotalPage (int pageSize){
        Product product = new Product();
        int totalProducts = product.getAllProduct().size();
        int totalPage = (int) Math.ceil((double) totalProducts / pageSize);
        return totalPage;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        
        int pageSize = 9;
        int currentPage = 1;
        int startIndex = (currentPage - 1) * pageSize;
        int totalPage = getTotalPage(pageSize);
        if(req.getParameter("page") != null){
            currentPage = Integer.parseInt(req.getParameter("page"));
            startIndex = (currentPage - 1) * pageSize;
        }
        
        List<Product> list = product.getAllProductByPage2(pageSize, startIndex);


        req.setAttribute("list", list);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("link","/shop");
        req.getRequestDispatcher("shop-left-sidebar.jsp").forward(req, resp);
    }
    
}
