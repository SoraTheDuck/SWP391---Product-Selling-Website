<%-- 
    Document   : Admin_discount.jsp
    Created on : Jul 11, 2023, 3:47:17 PM
    Author     : Acer Aspire
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="adminpage">Go back to dashboard</a>
        <h3 style="color: red">${mess}</h3>
        <table border="1">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Release Date</th>
                <th>Start Sale Date</th>
                <th>End Sale Date</th>
                <th>Original Price</th>
                <th>Sale Price</th>
                <th>Sale Percentage</th>
                <th>Status</th>
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
                    <td>${p.getPrice()}</td>
                    <td>${p.getSaleprice()}</td>
                    <td>${p.getDiscount()}</td>
                    <td>
                        <c:if test="${p.getSaleprice()!=0}">
                            <p style="color: green">Sale Off</p>
                        </c:if>
                        <c:if test="${p.getSaleprice()==0}">
                            <p style="color: red">Not on Sale</p>
                        </c:if>
                    </td>
                    <td>
                        <form action="list-discount" method="post">
                            <input type="hidden" name="id" value="${p.getId()}">
                            <input type="submit" value="Add discount">
                        </form>
                    </td>
                    <td>
                        <form action="#" method="post">
                            <input type="hidden" name="id" value="${p.getId()}">
                            <input type="submit" value="Delete discount">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
