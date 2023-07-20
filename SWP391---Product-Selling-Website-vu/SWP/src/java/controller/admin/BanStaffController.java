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
import model.Order;
import model.Staff;

/**
 *
 * @author admin
 */
public class BanStaffController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int staffid = Integer.parseInt(req.getParameter("id"));
        Staff s = new Staff();

        if (Boolean.parseBoolean(req.getParameter("ban"))) {
            //System.out.println("ban");
            s.Ban(1, staffid);
            Staff s1 = s.getStaffByID(staffid);
            if (s1.isOrderManager()) {
                System.out.println("inside if");
                Order o = new Order();
                List<Order> lo = o.getListNotCompletedOrder(staffid);
                o.updateStaffOrder(lo, staffid);
            }
            System.out.println("after if");
        } else {
            //System.out.println("unban");
            s.Ban(0, staffid);
        }

        List<Staff> list = s.getListStaff();
        req.setAttribute("list", list);

        req.getRequestDispatcher("Admin_staffs.jsp").forward(req, resp);
    }

}
