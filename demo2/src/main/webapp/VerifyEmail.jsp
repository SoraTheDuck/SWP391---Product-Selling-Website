<!doctype html>
<html class="no-js"
      lang="zxx">

    <head>
        <meta charset="utf-8">
        <title>Home || limupa - Digital Products Store ECommerce Bootstrap 4 Template</title>
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
            
            form{
                padding-bottom: 15px;
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
            
            button[type="submit"] {
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                background-color: #45a049;
            }

            input{
                padding: 10px 10px;
                width: 270px;
            }
            
            input[type="submit"] {
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
            <div  class="form">
                <h2> Verify email </h2>
                <p>Please input the correct verification code to complete the registration process</p>
                <div>
                    <h4>${message}</h4>
                    <form action="verifyEmail" method="post">
                        <input name="otp" id="otp" type="text" placeholder="Enter code" required>
                        <button type="submit">Verify code</button>
                    </form>

                    <button><a href="verifyEmail">Resend verification code</a></button>
                    <button><a href="register">Return to register page</a></button>
                </div>
            </div>
        </div>
    </body>
</html>