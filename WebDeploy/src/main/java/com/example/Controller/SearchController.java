/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Product;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
/**
 *
 * @author Acer Aspire
 */
@WebServlet(name = "SearchController", urlPatterns = "/search")
public class SearchController extends HttpServlet {

    public int getTotalPage (int pageSize, String searchValue){
        Product product = new Product();
        int totalProducts = product.searchByName(searchValue).size();
        int totalPage = (int) Math.ceil((double) totalProducts / pageSize);
        return totalPage;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchValue = req.getParameter("searchbox");
        Product p = new Product();

        int pageSize = 9;
        int currentPage = 1;
        int startIndex = (currentPage - 1) * pageSize;
        int totalPage = getTotalPage(pageSize,searchValue);
        if(req.getParameter("page") != null){
            currentPage = Integer.parseInt(req.getParameter("page"));
            startIndex = (currentPage - 1) * pageSize;
        }

        List<Product> list = p.searchProductByNameByPage2(searchValue, pageSize, startIndex);


        req.setAttribute("list", list);
        req.setAttribute("searchValue",searchValue);

        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPage", totalPage);

        req.setAttribute("link","/search");
        req.getRequestDispatcher("shop-left-sidebar.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchValue = req.getParameter("searchbox");
        Product p = new Product();

        int pageSize = 9;
        int currentPage = 1;
        int startIndex = (currentPage - 1) * pageSize;
        int totalPage = getTotalPage(pageSize,searchValue);
        if(req.getParameter("page") != null){
            currentPage = Integer.parseInt(req.getParameter("page"));
            startIndex = (currentPage - 1) * pageSize;
        }

        List<Product> list = p.searchProductByNameByPage2(searchValue, pageSize, startIndex);


        req.setAttribute("list", list);
        req.setAttribute("searchValue",searchValue);

        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("link","/search");
        req.getRequestDispatcher("shop-left-sidebar.jsp").forward(req, resp);
    }

}