/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Nhận thông tin
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        //Xử lí thông tin
        User u = new User(email, password);
        boolean check = u.checkUserLogin();

        //Trả kết quả về
        if (check) {
            //Lưu thông tin login vào session
            HttpSession session = req.getSession();
            u.getUserByAccount(email);
            session.setAttribute("u", u);
            req.setAttribute("u", u.getName());
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("message", "Tài khoản hoặc mật khẩu không đúng!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }
    
}
