<%-- 
    Document   : Admin_add-user
    Created on : Jun 25, 2023, 10:10:50 AM
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
        <h1>Add user</h1>
        <form action="add-user" method="post">
            <p>${mess}</p>
            Name: <input type="text" name="name" required/>
            <br/> 
            Password: <input type="text" name="pass" required/>
            <br/>
            Address: <input type="text" name="address" required/>
            <br/>
            Email: <input type="email" name="email" required/>
            <br/>
            <input type="submit" value="Add"/>
        </form>
        <p><a href="Admin_page.jsp">Back to homepage</a>
    </body>
</html>
