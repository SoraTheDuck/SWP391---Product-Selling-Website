/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller;

import model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author admin
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AdminLoginController", urlPatterns = "/ad-login")
public class AdminLoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Nhận thông tin
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        //Xử lí thông tin
        Admin a = new Admin(email, password);
        boolean check = a.checkLogin();

        //Trả kết quả về
        if (check) {
            //Lưu thông tin login vào session
            HttpSession session = req.getSession();
            session.setAttribute("email", email);
            req.getRequestDispatcher("Admin_page.jsp").forward(req, resp);
        } else {
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("mess", "Tài khoản hoặc mật khẩu không đúng!");
            req.getRequestDispatcher("Admin_login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("admin_login.jsp");
    }

}
