package com.example.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.Customer;

import jakarta.servlet.annotation.*;
@WebServlet(name = "ChangePassController", urlPatterns = "/change-pass")
public class ChangePassController extends HttpServlet {

    public boolean checkPassword(String pass){
        if(pass.length() < 8){
            return false;
        }
        
        boolean containsLetterAndNumber = pass.matches(".*[a-zA-Z].*") && pass.matches(".*\\d.*");
        
        return containsLetterAndNumber;
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            int id = Integer.parseInt(req.getParameter("id"));
            String oldpassword = req.getParameter("oldpassword");
            String newpassword = req.getParameter("newpassword");
            String renewpassword = req.getParameter("renewpassword");
            Customer c = new Customer();

            String oldpassCheck = c.getPassword(id);
            if (oldpassCheck == null || !oldpassCheck.equals(oldpassword)) {
                req.setAttribute("pass_mess", "Old password is wrong!");
                req.setAttribute("id", id);
                req.getRequestDispatcher("Customer_profile.jsp").forward(req, resp);
                return;
            }
            if(!checkPassword(newpassword)){
                req.setAttribute("pass_mess", "The new password must be at least 8 characters containing both letter and digit");
                req.setAttribute("id", id);
                req.getRequestDispatcher("Customer_profile.jsp").forward(req, resp);
                return;
            }
            if (!newpassword.equals(renewpassword)) {
                req.setAttribute("pass_mess", "The new passwords do not match!");
                req.setAttribute("id", id);
                req.getRequestDispatcher("Customer_profile.jsp").forward(req, resp);
                return;
            }

            c.updatePass(newpassword, id);
            req.setAttribute("pass_mess", "Change password successfully!");
            req.setAttribute("id", id);
            req.getRequestDispatcher("Customer_profile.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Handle GET request if needed
    }
}