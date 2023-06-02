/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Customer;

/**
 *
 * @author Acer Aspire
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String rePass = req.getParameter("rePass");
        
        Customer c = new Customer(name,pass,address,email);
        if(CustomerDAO.getCusByEmail(email)!=null){
            String fail = "Email duplicated";
            req.setAttribute("fail", fail);
            req.getRequestDispatcher("login-register.jsp").forward(req, resp);
        }
        else if(pass.equals(rePass) && req.getParameter("register")!=null){
            c.register();
            String fail = "Register Successfully";
            req.setAttribute("fail", fail);
            req.getRequestDispatcher("login-register.jsp").forward(req, resp);
        }else{
            String fail = "Password must be the same as Confirm Password";
            req.setAttribute("fail", fail);
            req.getRequestDispatcher("login-register.jsp").forward(req, resp);
        }
    }

    
    
    ///////a luong beo
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
}
