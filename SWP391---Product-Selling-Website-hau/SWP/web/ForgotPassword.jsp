<%-- 
    Document   : ForgotPassword
    Created on : Jul 3, 2023, 2:10:44 PM
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
            Forgot your password ?
            Follow these steps to reset your account password
            1. Enter your registered email
            2. Our system will sent you an OTP code to your email
            3. Enter code on the next page
            4. If verify code successfully the OTP code will be become your new password (You can change it later)
        </div>
        <p>${fmess}</p>
        <form action="forgotpassword" method="post">
            <input name="femail" type="email" placeholder="Enter your registered email address" required>
            <button type="submit">Get code</button>
        </form>
        <button><a href="login">Return to login page</a></button>
    </body>
</html>
