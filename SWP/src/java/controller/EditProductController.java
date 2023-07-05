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
import model.Product;

/**
 *
 * @author admin
 */
public class EditProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String pr=req.getParameter("price");
        
        float price=Float.parseFloat(pr);
        
        String image=req.getParameter("image");
        int quantity=Integer.parseInt(req.getParameter("quantity"));
        String wire="";
        String description=req.getParameter("description");
        
        if(req.getParameter("wire")!=null){
            wire="Wired";
        }
        else{
            wire="Wireless";
        }
        
        Product p=new Product();
        p.updateProduct(id, name, price, image, quantity, wire, description);
        
        
        List<Product> list=p.getAllProduct();
        req.setAttribute("listPro", list);
        req.getRequestDispatcher("Admin_products.jsp").forward(req, resp);
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product p = new Product();
        req.setAttribute("p", p.getProductByID2(id));
        req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
    }

}
