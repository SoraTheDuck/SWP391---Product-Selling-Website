/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Acer Aspire
 */
public class CategoryController extends HttpServlet {
    
    public int getTotalPage (int pageSize,int cid){
        Product product = new Product();
        int totalProducts = product.getAllProductsByCategory(cid).size();
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
        Category c = new Category();
        
        List<Category> clist = c.getAllCategory();
        
        HttpSession session = req.getSession();
        int cid;
        if(req.getParameter("cid") == null){
            cid = Integer.parseInt(session.getAttribute("cidSession").toString());
        }else{
            cid = Integer.parseInt(req.getParameter("cid"));
        }
        
        
        int pageSize = 9;
        int currentPage = 1;
        int startIndex = (currentPage - 1) * pageSize;
        int totalPage = getTotalPage(pageSize,cid);
        if(req.getParameter("page") != null){
            currentPage = Integer.parseInt(req.getParameter("page"));
            startIndex = (currentPage - 1) * pageSize;
        }
        
        List<Product> list = product.getAllProductByCategoryByPage2(cid, pageSize, startIndex);
        
        req.setAttribute("categoryList", clist);
        req.setAttribute("list", list);
        session.setAttribute("cidSession", cid);
        
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("link","/category");
        req.getRequestDispatcher("shop-left-sidebar.jsp").forward(req, resp);
    }
    
}
