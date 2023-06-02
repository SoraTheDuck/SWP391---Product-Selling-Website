<%-- 
    Document   : VerifyEmail
    Created on : Jun 1, 2023, 11:57:21 AM
    Author     : Acer Aspire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>${fail}</p>
        <p>The verification code is sent to your Email</p>
        <form action="verifyEmail" method="post">
            <input name="otp" id="otp" type="text" placeholder="Enter code">
            <input type="submit" value="Verify code">
        </form>
    </body>
</html>
