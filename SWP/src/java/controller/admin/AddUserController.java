/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;

/**
 *
 * @author Admin
 */
public class AddUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/Admin_add-user.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        Customer customer = new Customer();
        
        // Check for duplicate email
        if (customer.isEmailAlreadyExists(email)) {
        req.setAttribute("mess", "Email already exists");
        req.getRequestDispatcher("Admin_add-user.jsp").forward(req, resp);
        return;
        }
        
        Customer cus = new Customer(name,pass,address,email,0);
        cus.register();
        req.setAttribute("mess", "Add new user successfully!");
        req.getRequestDispatcher("Admin_add-user.jsp").forward(req, resp);
        
    }


}
