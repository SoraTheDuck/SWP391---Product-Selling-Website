<%-- 
    Document   : AddStaff
    Created on : Jul 6, 2023, 11:03:03 AM
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
        <h3 style="color: red">${mess}</h3>
        <form action="addstaff" method="post">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="${name}"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="password" value="${password}"></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="${email}"></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" name="phone" value="${phone}"></td>
                </tr>
                <tr>
                    <td>Accountant</td>
                    <td><input type="checkbox" name="accountant"></td>
                </tr>
                <tr>
                    <td>Marketing</td>
                    <td><input type="checkbox" name="marketing"></td>
                </tr>
                <tr>
                    <td>Order Manager</td>
                    <td><input type="checkbox" name="ordermanager"></td>
                </tr>
            </table>
            <input type="submit" value="Add">
        </form>
    </body>
</html>
