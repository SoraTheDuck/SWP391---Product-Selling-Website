<%-- 
    Document   : login
    Created on : May 30, 2023, 4:56:17 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username="", password="", message="";
            if(request.getAttribute("username")!=null)
                username=(String)request.getAttribute("username");
            if(request.getAttribute("password")!=null)
                password=(String)request.getAttribute("password");
            if(request.getAttribute("message")!=null)
                message=(String)request.getAttribute("message");
        %>
        <div class="login">
            <h1>User Login</h1>
            <form action="login" method="post" >
                <input type="text" id="username" name="username" placeholder="Username" value="<%=username%>"><br>
                <input type="password" id="password" name="password" placeholder="Password" value="<%=password%>"><br>
                <input type="submit" value="Login">
            </form>
            <div style="color:red"><%=message%></div>
            <br>Bạn chưa có tài khoản? <a href="register.jsp">Đăng kí</a>
        </div>
    </body>
</html>
