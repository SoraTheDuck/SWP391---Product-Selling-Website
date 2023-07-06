<%-- 
    Document   : Discount
    Created on : Jul 1, 2023, 6:22:44 PM
    Author     : admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3 style="color: red">${mess}</h3>
        <table border="1">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Release Date</th>
                <th>Start Sale Date</th>
                <th>End Sale Date</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="p" items="${list}">
                <tr>
                    <td>${p.getId()}</td>
                    <td>${p.getName()}</td>
                    <td>${p.getReleasedate()}</td>
                    <td>${p.getStartdate()}</td>
                    <td>${p.getEnddate()}</td>
                    <td>
                        <c:if test="${p.getSaleprice()!=0}">
                            Sale off
                        </c:if>
                    </td>
                    <td>
                        <form action="discount" method="post">
                            <input type="hidden" name="id" value="${p.getId()}">
                            <input type="submit" value="Add discount">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
