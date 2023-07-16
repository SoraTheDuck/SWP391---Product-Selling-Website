/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.Customer;

/**
 *
 * @author Acer Aspire
 */
import jakarta.servlet.annotation.*;
@WebServlet(name = "ForgotPasswordController", urlPatterns = "/forgotpassword")
public class ForgotPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String femail = req.getParameter("femail");
        Customer c = new Customer();
        c.getCustomerByAccount(femail);
        boolean con = true;
        int fotp = 0;
        HttpSession mySession = req.getSession();
        
        if(!c.checkCustomerExist(femail)){
            req.setAttribute("fmess", "Your registered email id is not found");
            req.getRequestDispatcher("ForgotPassword.jsp").forward(req, resp);
        }else{
            Random rand = new Random();
            fotp = rand.nextInt(1255650);
            
            String to = femail;
            //get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("tofunm271203@gmail.com", "vdhvnaoublgvhjcu");
                    }
		});
            
            //email message content
            try {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(femail));// change accordingly
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("Headphone Website");
		message.setText("Your code for verification is: " + fotp);
		// send message
		Transport.send(message);
		System.out.println("Email sent successfully");
		}catch(MessagingException e){
                    System.out.println("Send email failed");
                    con = false;
                }
            
            if(con){
                req.setAttribute("message","The verification code is sent to your email id !");
                mySession.setAttribute("fotp",fotp); 
                mySession.setAttribute("fcustomer", c);
                System.out.println(c.getId());
                req.getRequestDispatcher("ResetPassword.jsp").forward(req, resp);
            }else{
                req.setAttribute("mess", "Something went wrong. Please try again later !!");
                req.getRequestDispatcher("Login.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ForgotPassword.jsp").forward(req, resp);
    }
    
}
