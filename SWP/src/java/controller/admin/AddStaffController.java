/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Admin;
import model.Staff;

/**
 *
 * @author admin
 */
public class AddStaffController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        
        boolean accountant = false;
        if (req.getParameter("accountant") != null) {
            accountant = true;
        }
        boolean marketing = false;
        if (req.getParameter("marketing") != null) {
            marketing = true;
        }
        boolean ordermanager = false;
        if (req.getParameter("ordermanager") != null) {
            ordermanager = true;
        }
        
        if (name.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            req.setAttribute("name", name);
            req.setAttribute("password", password);
            req.setAttribute("email", email);
            req.setAttribute("phone", phone);
            req.setAttribute("mess", "Please complete all information to continue");
            req.getRequestDispatcher("Admin_add-staff.jsp").forward(req, resp);
            return;
        }
        
        if (accountant == false && marketing == false && ordermanager == false) {
            req.setAttribute("name", name);
            req.setAttribute("password", password);
            req.setAttribute("email", email);
            req.setAttribute("phone", phone);
            req.setAttribute("mess", "Please choose a role");
            req.getRequestDispatcher("Admin_add-staff.jsp").forward(req, resp);
            return;
        }
        
        if ((accountant == true && marketing == true && ordermanager == false)
                || (accountant == true && marketing == false && ordermanager == true)
                || (accountant == false && marketing == true && ordermanager == true)
                || (accountant == true && marketing == true && ordermanager == true)) {
            req.setAttribute("name", name);
            req.setAttribute("password", password);
            req.setAttribute("email", email);
            req.setAttribute("phone", phone);
            req.setAttribute("mess", "Each staff can only have 1 role");
            req.getRequestDispatcher("Admin_add-staff.jsp").forward(req, resp);
            return;
        }
        
        HttpSession session = req.getSession();
        Admin a = (Admin) session.getAttribute("admin");
        
        Staff s = new Staff();
        if (s.checkExist(email)) {
            req.setAttribute("name", name);
            req.setAttribute("password", password);
            req.setAttribute("email", email);
            req.setAttribute("phone", phone);
            req.setAttribute("mess", "Staff existed!");
            req.getRequestDispatcher("Admin_add-staff.jsp").forward(req, resp);
            return;
        }
        
        s.addStaff(name, password, email, phone, accountant, marketing, ordermanager, a.getId());
        
        List<Staff> list = s.getListStaff();
        req.setAttribute("list", list);
        req.setAttribute("mess", "Add staff success");
        req.getRequestDispatcher("Admin_staffs.jsp").forward(req, resp);
        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("admin") != null) {
            req.getRequestDispatcher("Admin_add-staff.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("404").forward(req, resp);
        }
    }
    
}
