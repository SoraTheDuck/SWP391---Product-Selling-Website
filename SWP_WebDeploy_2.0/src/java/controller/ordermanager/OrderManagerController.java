/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.ordermanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Order;

/**
 *
 * @author admin
 */
public class OrderManagerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int oid = Integer.parseInt(req.getParameter("id"));
        int sid = Integer.parseInt(req.getParameter("ord_id"));

        if (req.getParameter("approve") != null) {
            Order o = new Order();
            o.completeOrder(oid);

            List<Order> list = o.getListNotCompletedOrder(sid);
            req.setAttribute("ord_id", sid);
            req.setAttribute("list", list);
            req.getRequestDispatcher("OrderManager.jsp").forward(req, resp);
            return;
        }

        if (req.getParameter("reject") != null) {
            Order o = new Order();

            List<Order> list = o.getListNotCompletedOrder(sid);
            req.setAttribute("ord_id", sid);
            req.setAttribute("list", list);
            req.getRequestDispatcher("OrderManager.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
