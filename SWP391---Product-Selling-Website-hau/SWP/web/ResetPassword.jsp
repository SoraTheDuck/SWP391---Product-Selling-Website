<%-- 
    Document   : ResetPassword
    Created on : Jul 3, 2023, 2:38:30 PM
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
        <div>
            Enter the correct code to complete the reset password process
        </div>
        <p>${rmess}</p>
        <form action="resetpassword" method="post">
            <input name="fcode" type="text" placeholder="Enter code" required>
            <button type="submit">Verify code</button>
        </form>
        <button><a href="resetpassword">Resend code</a></button>
        <button><a href="login">Return to login page</a></button>
    </body>
</html>
