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
import model.Customer;

/**
 *
 * @author Acer Aspire
 */
public class VerifyEmailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int value=Integer.parseInt(req.getParameter("otp"));
	HttpSession session=req.getSession();
	int otp=(int)session.getAttribute("otp");
        
        Customer c = (Customer) session.getAttribute("customer");
        
        if(otp==value){
            c.register();
            String mess = "Register Successfully !!";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("Login-Register.jsp").forward(req, resp);
        }else{
            String fail = "Invalid code !!";
            req.setAttribute("fail", fail);
            req.getRequestDispatcher("VerifyEmail.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
