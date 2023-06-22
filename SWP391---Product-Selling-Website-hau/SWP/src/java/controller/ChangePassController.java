package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;

public class ChangePassController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("id"));
            String oldpassword = request.getParameter("oldpassword");
            String newpassword = request.getParameter("newpassword");
            String renewpassword = request.getParameter("renewpassword");
            Customer c = new Customer();

            String oldpassCheck = c.getPassword(id);
            if (oldpassCheck == null || !oldpassCheck.equals(oldpassword)) {
                request.setAttribute("pass_mess", "Old password is wrong!");
                request.setAttribute("id", id);
                request.getRequestDispatcher("Customer_profile.jsp").forward(request, response);
                return;
            }
            if (!newpassword.equals(renewpassword)) {
                request.setAttribute("pass_mess", "The new passwords do not match!");
                request.setAttribute("id", id);
                request.getRequestDispatcher("Customer_profile.jsp").forward(request, response);
                return;
            }

            c.updatePass(newpassword, id);
            request.setAttribute("pass_mess", "Change password successfully!");
            request.setAttribute("id", id);
            request.getRequestDispatcher("Customer_profile.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
