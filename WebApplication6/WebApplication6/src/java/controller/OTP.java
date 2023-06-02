/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CustomerDAO;
import helper.EmailConfig;
import helper.helper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import model.Customer;

/**
 *
 * @author toden
 */
public class OTP extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OTP</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OTP at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String forgotPassEmail = (String) session.getAttribute("forgotPassEmail");
        String otp = helper.generateRandomString();
            try {
                EmailConfig ec = new EmailConfig();
                ec.SendEmail(forgotPassEmail, "Your OTP code "+otp);
                session.setAttribute("otp", otp);
            } catch (MessagingException ex) {
                request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
            }
        request.setAttribute("forgotPassEmail", forgotPassEmail);
        request.getRequestDispatcher("OTPPage.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String otp = (String) session.getAttribute("otp");
        String forgotPassEmail = (String) session.getAttribute("forgotPassEmail");
        String[] otpParts = request.getParameterValues("otp");
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
                cus = CustomerDAO.UpdatePassAcc(resetPass, cus.getId());
                session.setAttribute("cus", cus);
                session.setAttribute("otp", null);
                session.setAttribute("forgotPassEmail", null);
                request.getRequestDispatcher("login-register.jsp").forward(request, response);
            } catch (MessagingException ex) {
                Logger.getLogger(OTP.class.getName()).log(Level.SEVERE, null, ex);
                //request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
            }

        }else{
            request.setAttribute("err", "incorrect otp or out of date");
            request.getRequestDispatcher("OTPPage.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
