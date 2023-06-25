/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Nhận thông tin
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String r = req.getParameter("rem");
        
        //tao 3 cookie moi
        Cookie cmail = new Cookie("cmail", email);
        Cookie cpassword = new Cookie("cpassword",password);
        Cookie cr = new Cookie("cr",r);
        
        if(r!=null){
            cmail.setMaxAge(60*60*24*7);
            cpassword.setMaxAge(60*60*24*7);
            cr.setMaxAge(60*60*24*7);
        }else{
            cmail.setMaxAge(0);
            cpassword.setMaxAge(0);
            cr.setMaxAge(0);
        }
        
        resp.addCookie(cmail);
        resp.addCookie(cpassword);
        resp.addCookie(cr);

        //Xử lí thông tin
        Customer c = new Customer(email, password);
        boolean check = c.checkLogin();

        //Trả kết quả về
        if (check) {
            //Lưu thông tin login vào session
            HttpSession session = req.getSession();
            c.getCustomerByAccount(email);
            session.setAttribute("cus", c);
            req.setAttribute("c", c.getName());
            
            req.getRequestDispatcher("home").forward(req, resp);     
        }
        else {
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("mess", "Account or Password is not correct !!");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }
    
}
