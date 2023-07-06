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
import model.Order;

/**
 *
 * @author Admin
 */
public class DeleteOrderController extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ordId = request.getParameter("ordId");
        Order order = new Order();
        order.delete(ordId);
        response.sendRedirect(request.getContextPath() + "/list-order");
    }
}
