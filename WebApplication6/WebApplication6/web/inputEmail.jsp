<%-- 
    Document   : inPhone
    Created on : May 18, 2023, 2:14:49 AM
    Author     : toden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="component/header.jsp" %>
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>
        <div style="margin-top: 100px; margin-bottom: 100px" class="container" width="500px">
            <form method="post" action="inputEmailServlet">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email</label>
                    <input name="email" type="email" placeholder="examples@gmail.com" required>
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    <span style="color: red">${requestScope.err}</span>
                </div>
                
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

        <%@include file="component/footer.jsp" %>
    </body>
</html>
