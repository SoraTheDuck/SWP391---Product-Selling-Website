<%-- 
    Document   : Admin_page
    Created on : Jun 2, 2023, 2:03:09 PM
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
        <div class="row">
            <div style="padding: 20px">
                <a href="#">Home</a>
                <a href="list-user">Users</a>
                <a href="list-product">Products</a>
                <a href="list-order">Orders</a>
                <a style="margin-left:50px;" href="LogoutController">Log out</a>
            </div>
        </div>
        Hello ${email}
        
    </body>
</html>
