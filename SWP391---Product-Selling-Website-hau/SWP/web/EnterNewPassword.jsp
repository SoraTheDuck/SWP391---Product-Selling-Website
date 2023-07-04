<%-- 
    Document   : EnterNewPassword
    Created on : Jul 4, 2023, 9:56:28 PM
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
        ${enmessage}
        <form action="enternewpassword" method="post">
            <input name="newpassword" type="text" placeholder="Enter new password" required>
            <button type="submit">Confirm</button>
        </form>
    </body>
</html>
