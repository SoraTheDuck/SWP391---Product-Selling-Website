<%-- 
    Document   : Admin_page
    Created on : Jun 2, 2023, 2:03:09 PM
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
        <h1>Hello ${admin}</h1>
        
        <form action="discount" method="post">
            Choose product: 
            <select name="id">
                <c:forEach var="p" items="${list}">
                    <option value="${p.id}">${p.name} &nbsp;(${p.releaseDate})</option>
                </c:forEach>
            </select>
            <br><br>
            Set discount value (%): <input type="number" name="discount" value="10" />
            Set date from <input type="date" name="start"/> to <input type="date" name="end"/>
            
        </form>
    </body>
</html>
