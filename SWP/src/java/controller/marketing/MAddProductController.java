/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.marketing;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class MAddProductController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Category c = new Category();
        List<Category> categoryList = c.getAllCategory();
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("MarketingAddProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");
        
        InputStream inputStream = null;
        byte[] imageData = null;
        Part image = req.getPart("image");

        
        String quantityStr = req.getParameter("quantity");
        String wire = req.getParameter("wire");
        String description = req.getParameter("description");
        String cateIdStr = req.getParameter("category");
        

        
        try{
            inputStream = image.getInputStream();
            imageData = new byte[inputStream.available()];
            inputStream.read(imageData);
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        
        // Check for null or empty values
        try {
            float price = Float.parseFloat(priceStr);
            int quantity = Integer.parseInt(quantityStr);
            int cateId = Integer.parseInt(cateIdStr);
            String wireValue = String.valueOf(wire.equals("1") ? 1 : 0);

            Product pro = new Product();
            // Check if product already exists
            boolean isProductExists = pro.isProductExists(id);
            if (isProductExists) {
                req.setAttribute("mess", "Product already exists."); // Set error message
            } else {
                boolean isProductAdded = pro.addProduct(id, name, price, imageData, quantity, wireValue, description, cateId);
                if (isProductAdded) {
                    req.setAttribute("mess", "Add new product successfully!");
                } else {
                    req.setAttribute("mess", "Failed to add product.");
                }
            }
        } catch (NumberFormatException e) {
            req.setAttribute("mess", "Invalid data. Please check the numeric values.");
        }

        Category c = new Category();
        List<Category> categoryList = c.getAllCategory();
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("MarketingAddProduct.jsp").forward(req, resp);

    }

}
