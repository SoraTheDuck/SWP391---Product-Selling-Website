/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import model.Category;
import model.Product;

/**
 *
 * @author Acer Aspire
 */
import jakarta.servlet.annotation.*;

@WebServlet(name = "DisplayController", urlPatterns = "/display")
public class DisplayController extends HttpServlet {

    public int getTotalPage (int pageSize){
        Product product = new Product();
        int totalProducts = product.getAllProduct().size();
        int totalPage = (int) Math.ceil((double) totalProducts / pageSize);
        return totalPage;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        Category c = new Category();
        List<Category> clist = c.getAllCategory();
        String op = req.getParameter("op");
        int tag = 0;

        int pageSize = 9;
        int currentPage = 1;
        int startIndex = (currentPage - 1) * pageSize;
        int totalPage = getTotalPage(pageSize);
        if(req.getParameter("page") != null){
            currentPage = Integer.parseInt(req.getParameter("page"));
            startIndex = (currentPage - 1) * pageSize;
        }

        List<Product> list = new ArrayList<>();

        if(op.equals("0")){
            list = product.getAllProductByPage2(pageSize, startIndex);
        }

        if(op.equals("1")){
            list = product.getAllProductSortByReleaseDateDesc(pageSize, startIndex);
            tag = 1;
        }

        if(op.equals("2")){
            list = product.getAllProductSortByReleaseDate(pageSize, startIndex);
            tag = 2;
        }

        if(op.equals("3")){
            list = product.getAllProductSortBySalePrice(pageSize, startIndex);
            tag=3;
        }

        if(op.equals("4")){
            list = product.getAllProductSortBySalePriceDesc(pageSize, startIndex);
            tag =4;
        }

        if(op.equals("5")){
            list = product.getAllProductSortByRating(pageSize, startIndex);
            tag = 5;
        }

        if(op.equals("6")){
            list = product.getAllProductSortByRatingDesc(pageSize, startIndex);
            tag = 6;
        }
        req.setAttribute("categoryList", clist);
        req.setAttribute("list", list);
        req.setAttribute("tag", tag);
        HttpSession session = req.getSession();
        session.setAttribute("opSession", op);

        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("link","/display");
        req.getRequestDispatcher("shop-left-sidebar.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        Category c = new Category();
        List<Category> clist = c.getAllCategory();

        HttpSession session = req.getSession();
        String op = session.getAttribute("opSession").toString();
        int tag = 0;

        int pageSize = 9;
        int currentPage = 1;
        int startIndex = (currentPage - 1) * pageSize;
        int totalPage = getTotalPage(pageSize);
        if(req.getParameter("page") != null){
            currentPage = Integer.parseInt(req.getParameter("page"));
            startIndex = (currentPage - 1) * pageSize;
        }

        List<Product> list = new ArrayList<>();

        if(op.equals("0")){
            list = product.getAllProductByPage2(pageSize, startIndex);
        }

        if(op.equals("1")){
            list = product.getAllProductSortByReleaseDateDesc(pageSize, startIndex);
            tag = 1;
        }

        if(op.equals("2")){
            list = product.getAllProductSortByReleaseDate(pageSize, startIndex);
            tag = 2;
        }

        if(op.equals("3")){
            list = product.getAllProductSortBySalePrice(pageSize, startIndex);
            tag=3;
        }

        if(op.equals("4")){
            list = product.getAllProductSortBySalePriceDesc(pageSize, startIndex);
            tag =4;
        }

        if(op.equals("5")){
            list = product.getAllProductSortByRating(pageSize, startIndex);
            tag = 5;
        }

        if(op.equals("6")){
            list = product.getAllProductSortByRatingDesc(pageSize, startIndex);
            tag = 6;
        }
        req.setAttribute("categoryList", clist);
        req.setAttribute("list", list);
        req.setAttribute("tag", tag);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("link","/display");
        req.getRequestDispatcher("shop-left-sidebar.jsp").forward(req, resp);
    }

}
