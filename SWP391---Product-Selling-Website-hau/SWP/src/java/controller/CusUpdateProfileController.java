package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< Updated upstream
=======
import jakarta.servlet.http.HttpSession;
>>>>>>> Stashed changes
import model.Customer;

public class CusUpdateProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
<<<<<<< Updated upstream
        // Xử lý khi nhận HTTP GET request
        response.setContentType("text/html;charset=UTF-8");
        // TODO: Thêm code xử lý GET request tại đây (nếu cần)
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        Customer c = new Customer();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        boolean success = c.updateInfo(name, address, email, id, request.getSession());
        if (success) {
            request.setAttribute("profile_mess", "Update profile successfully!");
        } else {
            request.setAttribute("profile_mess", "Failed to update profile.");
        }
        request.getRequestDispatcher("Customer_profile.jsp").forward(request, response);
    }
}
}

=======
        response.setContentType("text/html;charset=UTF-8");

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

            HttpSession session = request.getSession(); // Get the current session

            // Retrieve the previously stored customer object from the session
            Customer customer = (Customer) session.getAttribute("customer");

            // If the customer object doesn't exist in the session, create a new one
            if (customer == null) {
                customer = new Customer();
            }

            // Update the customer object with the new profile information
            customer.setName(name);
            customer.setAddress(address);
            customer.setEmail(email);

            boolean success = c.updateInfo(name, address, email, id, request.getSession());
            if (success) {
                request.setAttribute("profile_mess", "Update profile successfully!");
            } else {
                request.setAttribute("profile_mess", "Failed to update profile.");
            }

            request.getRequestDispatcher("Customer_profile.jsp").forward(request, response);
        }
    }
}
>>>>>>> Stashed changes
