/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.OrderDetail;

/**
 *
 * @author admin
 */
public class HistoryDetailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int oid = Integer.parseInt(req.getParameter("oid"));
        OrderDetail od = new OrderDetail();
        List<OrderDetail> historyDetails = od.getHistory(oid);
        float t = od.getTotalMoney(historyDetails);
        req.setAttribute("total", t);
        req.setAttribute("historyDetails", historyDetails);
        req.getRequestDispatcher("HistoryDetail.jsp").forward(req, resp);
    }

}
