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
    <style>

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: Arial;
            background: #92aae5;
            margin-top: 80px;
        }

        h2 {
            margin-bottom: 20px;
        }

        ol {
            text-align: left;
            padding-left: 0;
        }
        li {
            list-style-position: inside;
            margin-left: 0;
        }

        .form {
            max-width: 700px;
            margin-left: auto;
            margin-right: auto;
            background-color: #ffffff;
            padding: 30px;
            -webkit-box-shadow: 0px 5px 4px 0px rgba(0, 0, 0, 0.1);
            box-shadow: 0px 5px 4px 0px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        input[type="text"] {
            padding: 10px;
            width: 300px;
            margin-right: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            outline: none;
        }

        button[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }

        a {
            text-decoration: none;
            color: #ffffff;
        }

        button {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #428bca;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #92bfe5;
        }
    </style>
</head>
<body>
<div class="form">
    <form action="enternewpassword" method="post">
        <h3>Verify email successfully </h3>
        <h4>Please enter your new password </h4>
        <p style="color: red">${enmessage}</p>
        <form action="enternewpassword" method="post">
            <input name="newpassword" type="password" placeholder="Enter new password" required> <br> <br>
            <input name="renewpassword" type="password" placeholder="Confirm new password" required> <br>
            <button type="submit">Confirm</button>
    </form>
</div>
</body>
</html>