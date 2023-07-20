<%-- 
    Document   : EditProduct
    Created on : Jul 4, 2023, 8:06:59 PM
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
        ${test}
       
        ${check}
        <form action="editproduct" method="post">
            Product ID <input type="text" name="id" value="${p.getId()}" readonly>
            <br><br>Product Name <input type="text" name="name" value="${p.getName()}">
            <br><br>Product Price <input type="text" name="price" value="${p.getPrice()}">
            <br><br>Image <input type="text" name="image" value="${p.getImage()}">
            <br><br>Quantity <input type="number" name="quantity" value="${p.getQuantity()}">
            <c:choose>
                <c:when test="${p.getWire()=='Wired'}">
                    <br><br>Wire <input type="checkbox" name="wire" checked>
                </c:when>
                <c:otherwise>
                    <br><br>Wire <input type="checkbox" name="wire">
                </c:otherwise>
            </c:choose>
            <br><br>Description <textarea name="description">${p.getDescription()}</textarea>
            <br><br>Release Date <input type="text" name="releasedate" value="${p.getReleasedate()}" readonly>
            <br><br>Changelog <input type="text" name="change" value="${log}">
            <br><br><input type="submit" value="Edit">
        </form>
    </body>
</html>
