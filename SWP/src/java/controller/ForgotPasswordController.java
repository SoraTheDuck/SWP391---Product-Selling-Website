/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import helper.EmailConfig;
import helper.helper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import model.Customer;

/**
 *
 * @author quany
 */
public class ForgotPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        HttpSession session = req.getSession();
       String forgotPassEmail = req.getParameter("email");
       String email=req.getParameter("email");
       String password=req.getParameter("password");
        Customer cus = new Customer(email, password);
        cus = cus.getCusByEmail(forgotPassEmail);
        try {
            if (cus == null) {
                req.setAttribute("err", "email havent registed");
                req.getRequestDispatcher("ForgotPass.jsp").forward(req, resp);
            } else {

                String otp = helper.generateRandomString();

                EmailConfig ec = new EmailConfig();
                ec.SendEmail(forgotPassEmail, "Your OTP code " + otp);

                session.setAttribute("otp", otp);
                session.setAttribute("forgotPassEmail", forgotPassEmail);
                session.setAttribute("cus", cus);
                req.getRequestDispatcher("OTPPage.jsp").forward(req, resp);

            }
        } catch (MessagingException ex) {
            Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
//            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
}
