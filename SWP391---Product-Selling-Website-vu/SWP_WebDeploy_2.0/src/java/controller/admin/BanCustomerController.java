/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Customer;

/**
 *
 * @author admin
 */
public class BanCustomerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cusid = Integer.parseInt(req.getParameter("id"));
        Customer cus = new Customer();
        
        if (Boolean.parseBoolean(req.getParameter("ban"))) {
            //System.out.println("ban");
            cus.Ban(1, cusid);
        } else{
            //System.out.println("unban");
            cus.Ban(0, cusid);
        }

        List<Customer> list = cus.getAllCus();
        req.setAttribute("listUser", list);

        String upmess = (String) req.getAttribute("upmess");
        req.setAttribute("upmess", upmess);

        req.getRequestDispatcher("Admin_users.jsp").forward(req, resp);

    }

}
