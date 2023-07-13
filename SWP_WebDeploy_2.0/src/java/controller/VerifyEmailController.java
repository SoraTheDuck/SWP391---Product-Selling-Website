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
public class VerifyEmailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value=req.getParameter("otp");
	HttpSession session=req.getSession();
	String otp= session.getAttribute("otp").toString();
        
        Customer c = (Customer) session.getAttribute("customer");
        
        if(otp.equals(value) && !req.getParameter("otp").trim().isEmpty()){
            c.register();
            String mess = "Register Successfully !!";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        }else{
            String fail = "Invalid code !!";
            req.setAttribute("message", fail);
            req.getRequestDispatcher("VerifyEmail.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession mySession=req.getSession();
        Customer c = (Customer) mySession.getAttribute("customer");
        int otp=(int)mySession.getAttribute("otp");
        boolean con = true;
        
        Random rand = new Random();
            otp = rand.nextInt(1255650);
            
            String to = c.getEmail();
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
		message.setFrom(new InternetAddress(c.getEmail()));// change accordingly
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("Headphone Website");
		message.setText("Your code for verification is: " + otp);
		// send message
		Transport.send(message);
		System.out.println("Email sent successfully");
		}catch(MessagingException e){
                    System.out.println("Send email failed");
                    con = false;
                }
            
            if(con){
                req.setAttribute("message","The resend of vertification code to your email id is successful !");
                mySession.setAttribute("otp",otp); 
                mySession.setAttribute("customer", c);
                req.getRequestDispatcher("VerifyEmail.jsp").forward(req, resp);
            }else{
                req.setAttribute("mess", "Something went wrong. Please try again later !!");
                req.getRequestDispatcher("Register.jsp").forward(req, resp);
            }
            
    }
    
}
