/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
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
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String rePass = req.getParameter("rePass");
        
        Customer c = new Customer(name,pass,address,email);
        
        int otp = 0;
        HttpSession mySession = req.getSession();
        
        if(!pass.equals(rePass)){
            String fail = "Password must be the same as Confirm Password !!";
            req.setAttribute("mess", fail);
            req.getRequestDispatcher("Login-Register.jsp").forward(req, resp);
        }else{
            boolean check;
            check = c.checkCustomerExist(email);
            
            if(check){
                String fail = "Email is already registred !! Please use a different email address !!";
                req.setAttribute("mess", fail);
                req.getRequestDispatcher("Login-Register.jsp").forward(req, resp);
            }else{
                
            //generate otp
            Random rand = new Random();
            otp = rand.nextInt(1255650);
            
            String to = email;
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
		message.setFrom(new InternetAddress(email));// change accordingly
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("Headphone Website");
		message.setText("Your code for verification is: " + otp);
		// send message
		Transport.send(message);
		System.out.println("Email sent successfully");
		}catch(MessagingException e){
                    throw new RuntimeException(e);
                }
            
            req.setAttribute("message","The verification code is sent to your email id");
            
            mySession.setAttribute("otp",otp); 
            mySession.setAttribute("customer", c);
            req.getRequestDispatcher("VerifyEmail.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
}
