<%-- 
    Document   : ProductDiscount
    Created on : Jul 2, 2023, 2:26:17 PM
    Author     : admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3 style="color: red">${mess}</h3>
        <form action="productdiscount" method="post">
            ID: <input type="text" name="id" value="${p.getId()}" readonly>
            <br><br>Name: <input type="text" name="name" value="${p.getName()}" readonly>
            <br><br>Price: <input type="text" name="price" value="${p.getPrice()}" readonly>
            <br><br>Set start date: <input type="date" name="start" value="">
            <br><br>Set end date: <input type="date" name="end" value="">
            <br><br>Set discount(%): <input type="number" name="discount" value="0">
            <br><br><input type="submit" name="set" value="Set">
        </form>
    </body>
</html>
