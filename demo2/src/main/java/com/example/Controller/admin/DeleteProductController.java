package com.example.Controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author Admin
 */
@WebServlet(name = "DeleteProductController", urlPatterns = "/delete-product")
public class DeleteProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Product pro = new Product();
        pro.delete(id);
        request.getSession().setAttribute("mess", "Delete product successfully!");
        response.sendRedirect(request.getContextPath() + "/list-product");
    }

}
