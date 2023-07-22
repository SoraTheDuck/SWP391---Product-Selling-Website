/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Controller.manager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Order;
import model.OrderDetail;

/**
 *
 * @author admin
 */
@WebServlet(name = "OrderManagerController", urlPatterns = "/ordermanager")
public class OrderManagerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int oid = Integer.parseInt(req.getParameter("id"));
        int sid = Integer.parseInt(req.getParameter("ord_id"));

        OrderDetail odummy = new OrderDetail();
        boolean checkAutoReject = odummy.checkAutoReject(oid);
        if (req.getParameter("reject") != null || !checkAutoReject) {
            Order o = new Order();
            o.completeOrder(oid, false);

            List<Order> list = o.getListNotCompletedOrder(sid);
            req.setAttribute("ord_id", sid);
            req.setAttribute("list", list);

            if(req.getParameter("reject") == null) req.setAttribute("message", "Auto rejected due to invalid amount");
            else req.setAttribute("message", "Rejected success");

            req.getRequestDispatcher("OrderManager.jsp").forward(req, resp);
            return;
        }

        if (req.getParameter("approve") != null) {
            Order o = new Order();
            o.completeOrder(oid, true);

            OrderDetail od=new OrderDetail();
            List<OrderDetail> lo=od.getListOrderDetail(oid);
            o.updateQuantity(lo);

            List<Order> list = o.getListNotCompletedOrder(sid);

            System.out.println("approve success");
            req.setAttribute("message", "Approve Success");

            req.setAttribute("ord_id", sid);
            req.setAttribute("list", list);
            req.getRequestDispatcher("OrderManager.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
