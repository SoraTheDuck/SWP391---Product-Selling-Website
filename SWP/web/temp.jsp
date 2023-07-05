<%-- 
    Document   : temp
    Created on : Jun 17, 2023, 1:30:18 PM
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
        hello
        <c:forEach items="${list}" var="o">
                                    ${o.getCategoryName()}
    </c:forEach>
    ${alo}
    </body>
</html>
