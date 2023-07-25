package com.example.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;

import jakarta.servlet.annotation.*;
@WebServlet(name = "CusUpdateProfileController", urlPatterns = "/update-profile")
public class CusUpdateProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý khi nhận HTTP GET request
        response.setContentType("text/html;charset=UTF-8");
        // TODO: Thêm code xử lý GET request tại đây (nếu cần)
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            Customer c = new Customer();
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String email = request.getParameter("email");

            boolean success = c.updateInfo(name, address, email, id);
            
            if (success) {
                HttpSession session = request.getSession();
                c.getCustomerByAccount(email);
                session.setAttribute("cus", c);
                request.setAttribute("profile_mess", "Update profile successfully!");
            } else {
                request.setAttribute("profile_mess", "Failed to update profile.");
            }
            
            request.getRequestDispatcher("Customer_profile.jsp").forward(request, response);
        }
    }
}
