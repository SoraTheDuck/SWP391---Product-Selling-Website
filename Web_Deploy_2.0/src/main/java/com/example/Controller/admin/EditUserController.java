/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.Controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditCustomerController", urlPatterns = {"/edit-cus"})
public class EditUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("cId"));
        System.out.println(request.getParameter("cId"));
        Customer cus = new Customer();
        request.setAttribute("cus", cus.getCusById(id));
        request.setAttribute("cId", id);
        request.getRequestDispatcher("Admin_edit-user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("id"));
        String cname = request.getParameter("name");
        String cpass = request.getParameter("pass");
        String caddr = request.getParameter("address");
        String cemail = request.getParameter("email");
        Customer cus = new Customer();

        cus.updateCus(cname, cpass, caddr, cemail, cid);
        request.setAttribute("upmess", "Update customer successfully!!");
        request.getRequestDispatcher("list-user").forward(request, response);
    }
}
