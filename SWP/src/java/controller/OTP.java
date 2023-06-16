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
public class OTP  extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                HttpSession session = req.getSession();
        String otp = (String) session.getAttribute("otp");
        String forgotPassEmail = (String) session.getAttribute("forgotPassEmail");
        String[] otpParts = req.getParameterValues("otp");
        String inputotp = "";

        Customer cus = (Customer) session.getAttribute("cus");

        for (String i : otpParts) {
            inputotp += i;
        }
        if (inputotp.trim().equals(otp)) {
            try {
                String resetPass = helper.generateRandomString();
                EmailConfig ec = new EmailConfig();
                ec.SendEmail(forgotPassEmail, "Your reset password is " + resetPass);
                System.out.println("cusid " + cus.getId());                
                System.out.println("ressetpass" + resetPass);

                cus = cus.UpdatePassAcc(resetPass, cus.getId());
                session.setAttribute("cus", cus);
                session.setAttribute("otp", null);
                session.setAttribute("forgotPassEmail", null);
                req.getRequestDispatcher("Login.jsp").forward(req, resp);
            } catch (MessagingException ex) {
                Logger.getLogger(OTP.class.getName()).log(Level.SEVERE, null, ex);
                //request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
            }

        }else{
            req.setAttribute("err", "incorrect otp or out of date");
            req.getRequestDispatcher("OTPPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
}
