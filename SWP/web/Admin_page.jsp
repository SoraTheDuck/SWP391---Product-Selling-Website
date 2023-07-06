<%-- 
    Document   : Admin_page
    Created on : Jun 2, 2023, 2:03:09 PM
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

        <c:choose>
            <c:when test="${sessionScope.admin != null}">
                <a href="listproduct">Products</a>
                <a href="discount">Discount</a>
                <a href="staffmanage">Staffs</a>
            </c:when>
            <c:otherwise>
                <a href="./Admin_login.jsp"
                   class="log-sign-btn log">Login</a>
            </c:otherwise>
        </c:choose>
    </body>
</html>
