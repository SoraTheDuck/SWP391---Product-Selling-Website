package controller.marketing;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

public class MDeleteProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product pro = new Product();
        pro.delete(id);
        req.setAttribute("dmess", "Delete product successfully!");
        req.getRequestDispatcher("/marketingproduct").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        Product pro = new Product();
        pro.delete(id);
        req.setAttribute("dmess", "Delete product successfully!");
        req.getRequestDispatcher("/marketingproduct").forward(req, resp);
    }
}
