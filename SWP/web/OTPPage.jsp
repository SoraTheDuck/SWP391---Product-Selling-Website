<%-- 
    Document   : OTPpage
    Created on : Jun 16, 2023, 12:02:22 AM
    Author     : quany
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible"
              content="ie=edge">
        <title>Home || limupa - Digital Products Store ECommerce Bootstrap 4 Template</title>
        <meta name="description"
              content="">
        <meta name="viewport"
              content="width=device-width, initial-scale=1">
        <!-- Favicon -->
        <link rel="shortcut icon"
              type="image/x-icon"
              href="images/favicon.png">
        <!-- Material Design Iconic Font-V2.2.0 -->
        <link rel="stylesheet"
              href="css/material-design-iconic-font.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet"
              href="css/font-awesome.min.css">
        <!-- Font Awesome Stars-->
        <link rel="stylesheet"
              href="css/fontawesome-stars.css">
        <!-- Meanmenu CSS -->
        <link rel="stylesheet"
              href="css/meanmenu.css">
        <!-- owl carousel CSS -->
        <link rel="stylesheet"
              href="css/owl.carousel.min.css">
        <!-- Slick Carousel CSS -->
        <link rel="stylesheet"
              href="css/slick.css">
        <!-- Animate CSS -->
        <link rel="stylesheet"
              href="css/animate.css">
        <!-- Jquery-ui CSS -->
        <link rel="stylesheet"
              href="css/jquery-ui.min.css">
        <!-- Venobox CSS -->
        <link rel="stylesheet"
              href="css/venobox.css">
        <!-- Nice Select CSS -->
        <link rel="stylesheet"
              href="css/nice-select.css">
        <!-- Magnific Popup CSS -->
        <link rel="stylesheet"
              href="css/magnific-popup.css">
        <!-- Bootstrap V4.1.3 Fremwork CSS -->
        <link rel="stylesheet"
              href="css/bootstrap.min.css">
        <!-- Helper CSS -->
        <link rel="stylesheet"
              href="css/helper.css">
        <!-- Main Style CSS -->
        <link rel="stylesheet"
              href="css/style.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet"
              href="css/responsive.css">
        <!-- Modernizr js -->
        <script src="js/vendor/modernizr-2.8.3.min.js"></script>
    </head>
    <body>
        <div class="container height-100 d-flex justify-content-center align-items-center"> 
            <div class="position-relative"> 
                <form action="OTP" method="post">
                    <div class="card p-2 text-center"> 
                        <h6>Please enter the one time password <br> to verify your account</h6> 
                        <div> 
                            <span>A code has been sent to</span> 
                            <span>${forgotPassEmail}</span> 
                        </div> 
                        <div id="otp" class="inputs d-flex flex-row justify-content-center mt-2"> 
                            <input class="m-2 text-center form-control rounded" type="text" name="otp" maxlength="1" /> 
                            <input class="m-2 text-center form-control rounded" type="text" name="otp" maxlength="1" /> 
                            <input class="m-2 text-center form-control rounded" type="text" name="otp" maxlength="1" /> 
                            <input class="m-2 text-center form-control rounded" type="text" name="otp" maxlength="1" /> 
                            <input class="m-2 text-center form-control rounded" type="text" name="otp" maxlength="1" /> 
                            <input class="m-2 text-center form-control rounded" type="text" name="otp" maxlength="1" /> 
                        </div> 
                        <span style="color: red">${requestScope.err}</span>
                        <div class="mt-4"> 
                            <button class="btn btn-danger px-4 validate">Validate</button> </div> </div> <div class="card-2"> 
                        <div class="content d-flex justify-content-center align-items-center"> 
                            <span>Didn't get the code</span> 
                            <a href="OTP" class="text-decoration-none ms-3">Resend</a> 
                        </div> 
                        <div class="content d-flex justify-content-center align-items-center">
                            <a href="#" class="text-decoration-none ms-3">Back to Home</a>      
                        </div>
                    </div> 
                </form>

            </div>
        </div>

        <script>
            document.addEventListener("DOMContentLoaded", function (event) {

                function OTPInput() {
                    const inputs = document.querySelectorAll('#otp > *[id]');
                    for (let i = 0; i < inputs.length; i++) {
                        inputs[i].addEventListener('keydown', function (event) {
                            if (event.key === "Backspace") {
                                inputs[i].value = '';
                                if (i !== 0)
                                    inputs[i - 1].focus();
                            } else {
                                if (i === inputs.length - 1 && inputs[i].value !== '') {
                                    return true;
                                } else if (event.keyCode > 47 && event.keyCode < 58) {
                                    inputs[i].value = event.key;
                                    if (i !== inputs.length - 1)
                                        inputs[i + 1].focus();
                                    event.preventDefault();
                                } else if (event.keyCode > 64 && event.keyCode < 91) {
                                    inputs[i].value = String.fromCharCode(event.keyCode);
                                    if (i !== inputs.length - 1)
                                        inputs[i + 1].focus();
                                    event.preventDefault();
                                }
                            }
                        });
                    }
                }
                OTPInput();


            });
        </script>
    </body>

 
</html>
