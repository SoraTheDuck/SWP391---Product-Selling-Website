<%-- 
    Document   : Register
    Created on : Jun 2, 2023, 1:46:45 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Online Headphone Shop</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">
        <!-- Material Design Iconic Font-V2.2.0 -->
        <link rel="stylesheet" href="css/material-design-iconic-font.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <!-- Font Awesome Stars-->
        <link rel="stylesheet" href="css/fontawesome-stars.css">
        <!-- Meanmenu CSS -->
        <link rel="stylesheet" href="css/meanmenu.css">
        <!-- owl carousel CSS -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <!-- Slick Carousel CSS -->
        <link rel="stylesheet" href="css/slick.css">
        <!-- Animate CSS -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Jquery-ui CSS -->
        <link rel="stylesheet" href="css/jquery-ui.min.css">
        <!-- Venobox CSS -->
        <link rel="stylesheet" href="css/venobox.css">
        <!-- Nice Select CSS -->
        <link rel="stylesheet" href="css/nice-select.css">
        <!-- Magnific Popup CSS -->
        <link rel="stylesheet" href="css/magnific-popup.css">
        <!-- Bootstrap V4.1.3 Fremwork CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Helper CSS -->
        <link rel="stylesheet" href="css/helper.css">
        <!-- Main Style CSS -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Modernizr js -->

        <script src="js/vendor/modernizr-2.8.3.min.js"></script>

        <style>
            body{
                background: #92aae5;
            }
            .re-button{
                height: 36px;
                padding: 6px 20px;
                border: none;
                background-color: #363f4d;
                border-radius: 3px;
                transition: all 0.3s ease-in-out;
            }
            .re-button a{
                color: white;
                text-transform: uppercase;
            }
            .re-button:hover {
                background: grey;
            }
        </style>
    </head>
    <body>
        <div class="body-wrapper">
            <!-- Begin Register Content Area-->
            <div class="container mt-10 mb-100">
                <div class="login-form"  style="margin-top: 60px; border-radius:5px">
                    <h2> Verify email </h2>
                    <p>An OTP is sent to your email</p>
                    <p>Please input the correct verification code to complete the registration process</p>
                    <div>
                        <p style="color: green">${message}<p>
                        <form action="verifyEmail" method="post">
                            <input name="otp" id="otp" type="text" placeholder="Enter code" required>
                            <button class="register-button mt-0" type="submit">Verify code</button>
                        </form>
                    </div>
                    <br>
                    <br>
                    <div style="margin-top: 10px">  
                        <button class="re-button" style="display: inline-block">    
                            <a href="verifyEmail">Resend verification code</a>
                        </button>
                        <button class="re-button" style="display: inline-block">    
                            <a href="register">Return to register page</a>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Register Content Area End Here -->

    </div>
    <!-- Body Wrapper End Here -->
    <!-- jQuery-V1.12.4 -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <!-- Popper js -->
    <script src="js/vendor/popper.min.js"></script>
    <!-- Bootstrap V4.1.3 Fremwork js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Ajax Mail js -->
    <script src="js/ajax-mail.js"></script>
    <!-- Meanmenu js -->
    <script src="js/jquery.meanmenu.min.js"></script>
    <!-- Wow.min js -->
    <script src="js/wow.min.js"></script>
    <!-- Slick Carousel js -->
    <script src="js/slick.min.js"></script>
    <!-- Owl Carousel-2 js -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- Magnific popup js -->
    <script src="js/jquery.magnific-popup.min.js"></script>
    <!-- Isotope js -->
    <script src="js/isotope.pkgd.min.js"></script>
    <!-- Imagesloaded js -->
    <script src="js/imagesloaded.pkgd.min.js"></script>
    <!-- Mixitup js -->
    <script src="js/jquery.mixitup.min.js"></script>
    <!-- Countdown -->
    <script src="js/jquery.countdown.min.js"></script>
    <!-- Counterup -->
    <script src="js/jquery.counterup.min.js"></script>
    <!-- Waypoints -->
    <script src="js/waypoints.min.js"></script>
    <!-- Barrating -->
    <script src="js/jquery.barrating.min.js"></script>
    <!-- Jquery-ui -->
    <script src="js/jquery-ui.min.js"></script>
    <!-- Venobox -->
    <script src="js/venobox.min.js"></script>
    <!-- Nice Select js -->
    <script src="js/jquery.nice-select.min.js"></script>
    <!-- ScrollUp js -->
    <script src="js/scrollUp.min.js"></script>
    <!-- Main/Activator js -->
    <script src="js/main.js"></script>
</body>
</html>




