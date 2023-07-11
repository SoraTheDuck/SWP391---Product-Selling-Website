<%-- 
    Document   : OrderManager
    Created on : Jul 6, 2023, 10:08:16 AM
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
        <table border="1">
            <tr>
                <th>Order ID</th>
                <th>Order Date</th>
                <th>Total Money</th>
                <th>Customer ID</th>
                <th colspan="2">Action</th>
            </tr>
            <c:forEach var="o" items="${list}">
                <tr>
                    <td>${o.getID()}</td>
                    <td>${o.getDate()}</td>
                    <td>${o.getTotalMoney()}</td>
                    <td>${o.getCustomerID()}</td>
                    <td>
                        <form action="ordermanager" method="post">
                            <input type="hidden" name="id" value="${o.getID()}">
                            <input type="submit" name="approve" value="Approve">
                        </form>
                    </td>
                    <td>
                        <form action="ordermanager" method="post">
                            <input type="hidden" name="id" value="${o.getID()}">
                            <input type="submit" name="reject" value="Reject">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
