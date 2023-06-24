<%-- 
    Document   : Admin_manageUsers
    Created on : Jun 23, 2023, 11:00:33 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Manage Users</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>All</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Email</th>                              
                    <th colspan="2" align="center"> <a href="#"/> Add </a> </th>                                
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <span class="custom-checkbox">
                            <input type="checkbox" id="checkbox1" name="options[]" value="1">
                            <label for="checkbox1"></label>
                        </span>
                    </td>                                
                    <td>${ls.getName()}</td>
                    <td>${ls.getAddress()}</td>
                    <td>${ls.getEmail()}</td>
                    <td><a href="#">  Edit </a> </td>
                    <td><a href="#">  Delete </a> </td>
                </tr>
        </tbody>
    </table>
                    <p><a href="Admin_page.jsp">Back to homepage</a>
</body>
</html>
