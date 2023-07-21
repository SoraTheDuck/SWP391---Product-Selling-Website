/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller.marketing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import model.Product;

/**
 *
 * @author admin
 */
@WebServlet(name = "MEditProductController", urlPatterns = "/marketingeditproduct")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class MEditProductController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id = req.getParameter("id");
        System.out.println(id + "fe");
        Product p = new Product();

        String changelog = req.getParameter("changelog");
        System.out.println(changelog);
        
        if (changelog.isEmpty()) {
            req.setAttribute("mess", "Changelog cannot be empty!");
            req.setAttribute("p", p.getProductByID2(id));
            req.getRequestDispatcher("MarketingEditProduct.jsp").forward(req, resp);
            return;
        }

        String name = req.getParameter("name");
        if (name.isEmpty()) {
            req.setAttribute("mess", "Name cannot be empty!");
            req.setAttribute("p", p.getProductByID2(id));
            req.setAttribute("log", changelog);
            req.getRequestDispatcher("MarketingEditProduct.jsp").forward(req, resp);
            return;
        }

        String pr = req.getParameter("price");
        if (pr.isEmpty()) {
            req.setAttribute("mess", "Price cannot be empty!");
            req.setAttribute("p", p.getProductByID2(id));
            req.setAttribute("log", changelog);
            req.getRequestDispatcher("MarketingEditProduct.jsp").forward(req, resp);
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
            req.getRequestDispatcher("MarketingEditProduct.jsp").forward(req, resp);
            return;
        }

        if (req.getPart("image") != null) {
            System.out.println("good");
            InputStream inputStream = null;
            byte[] imageData = null;
            Part image = req.getPart("image");
            try {
                inputStream = image.getInputStream();
                imageData = new byte[inputStream.available()];
                inputStream.read(imageData);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("error");
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            p.updateImageProduct(imageData, id);
        }

        if (req.getParameter("quantity").isEmpty()) {
            req.setAttribute("mess", "Quantity cannot be empty!");
            req.setAttribute("p", p.getProductByID2(id));
            req.setAttribute("log", changelog);
            req.getRequestDispatcher("MarketingEditProduct.jsp").forward(req, resp);
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
            req.getRequestDispatcher("MarketingEditProduct.jsp").forward(req, resp);
            return;
        }

        p.updateProduct(id, name, price, quantity, wire, description);
        p.updateHistory(changelog, id);

        List<Product> list = p.getAllProduct();
        req.setAttribute("listPro", list);
        req.setAttribute("mess", "Edit success!");
        req.getRequestDispatcher("MarketingProduct.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        
        req.setAttribute("test", id);
        Product p = new Product();

        HttpSession session = req.getSession();
        session.setAttribute("tid", id);
        req.setAttribute("p", p.getProductByID3(id));
        req.getRequestDispatcher("MarketingEditProduct.jsp").forward(req, resp);
    }

}
