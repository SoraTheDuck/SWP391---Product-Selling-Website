<%-- 
    Document   : History
    Created on : Jun 26, 2023, 8:28:41 AM
    Author     : admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
    </head>
    <body>
        <h1>Order History</h1>
        <table style="margin: 10px">
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Total</th>
                <th></th>
            </tr>
            <c:forEach items="${history}" var="h">
                <tr>
                    <td><a href="historyDetail?oid=${h.getID()}">${h.getID()}</a></td>
                    <td>${h.getDate()}</td>
                    <td>${h.getTotalMoney()}</td>
                    <td><a href="historyDetail?oid=${h.getID()}">Detail</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
