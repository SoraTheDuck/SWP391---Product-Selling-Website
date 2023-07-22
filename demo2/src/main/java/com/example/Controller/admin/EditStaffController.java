/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Staff;

/**
 *
 * @author admin
 */
@WebServlet(name = "EditStaffController", urlPatterns = "/editstaff")
public class EditStaffController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");

        Staff s = new Staff();
        s.editStaff(id, name, password, phone);

        Staff s1 = s.getStaffByID(id);

        req.setAttribute("s", s1);
        req.setAttribute("mess", "Edit success!");
        req.getRequestDispatcher("Admin_edit-staff.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("admin") != null || session.getAttribute("marketing") != null) {
            int id = Integer.parseInt(req.getParameter("id"));
            Staff s = new Staff();
            Staff s1 = s.getStaffByID(id);

            req.setAttribute("s", s1);
            req.getRequestDispatcher("Admin_edit-staff.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("404").forward(req, resp);
        }
    }

}
