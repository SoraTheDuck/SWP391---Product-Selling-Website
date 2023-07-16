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

            input[type="email"] {
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
        <div  class="form">
            <div>  
                <h2>Forgot Your Password?</h2>
                <p>Follow these steps to reset your account password:</p>
                <ol>
                    <li>Enter your registered email address</li>
                    <li>Our system will send you an OTP code to your email</li>
                    <li>Enter the code on the next page</li>
                    <li>If the code is verified successfully, it will become your new password (you can change it later)</li>
                </ol>
            </div>

            <p style="color: red">${fmess}</p>

            <form action="forgotpassword" method="post">
                <input name="femail" type="email" placeholder="Enter your registered email address" required>
                <button type="submit">Get Code</button>
            </form>

            <button><a href="login">Return to Login Page</a></button>
        </div>
    </body>
</html>