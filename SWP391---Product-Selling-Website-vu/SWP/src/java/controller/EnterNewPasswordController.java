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
public class EnterNewPasswordController extends HttpServlet {
    
    public boolean checkPassword(String pass){
        if(pass.length() < 8){
            return false;
        }
        
        boolean containsLetterAndNumber = pass.matches(".*[a-zA-Z].*") && pass.matches(".*\\d.*");
        
        return containsLetterAndNumber;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newpassword = req.getParameter("newpassword");
        String renewpassword = req.getParameter("renewpassword");
        HttpSession session=req.getSession();
        Customer c = (Customer) session.getAttribute("fcustomer");
        Customer temp = new Customer();
        
        if(checkPassword(newpassword)){
            
            if(!newpassword.equals(renewpassword)){
                req.setAttribute("enmessage", "New Password must be the same as Confirm New Password");
                req.getRequestDispatcher("EnterNewPassword.jsp").forward(req, resp);
                return;
            }
            
            temp.updatePass(newpassword, c.getId());
            req.setAttribute("mess", "Reset password successfully !!");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }else{
            req.setAttribute("enmessage", "Password must at least be 8 characters containing both letter and number");
            req.getRequestDispatcher("EnterNewPassword.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("EnterNewPassword.jsp").forward(req, resp);
    }
    
}
