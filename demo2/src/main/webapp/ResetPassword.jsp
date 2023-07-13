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
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                font-family: Arial;
                background: #92aae5;
                margin-top: 80px;
            }

            .container {
                max-width: 800px;
                margin: 0 auto;
                padding: 20px;
            }

            h4 {
                font-size: 18px;
                margin-bottom: 20px;
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
            form{
                padding-bottom:10px;
            }

            input{
                padding: 10px 10px;
                width: 270px;
            }
            button[type="submit"] {
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
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
        </style>
    </head>

    <body>
        <div class="container">
            <div class="form">
                <h2> Reset password </h2>
                <p>Enter the correct code to complete the reset password process</p>
                <div>
                    <p style="color: red">${rmess}</p>
                    <form action="resetpassword" method="post">
                        <input name="fcode" type="text" placeholder="Enter code">
                        <button type="submit">Verify code</button>
                    </form>

                    <button><a href="resetpassword">Resend code</a></button>
                    <button><a href="login">Return to login page</a></button>
                </div>
            </div>
        </div>
    </body>
</html>