<!doctype html>
<html class="no-js"
      lang="zxx">

    <!-- index-231:32-->

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
        <!--[if lt IE 8]>
                    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
            <![endif]-->
        <!-- Begin Body Wrapper -->
        <div class="body-wrapper">
            <!-- Begin Header Area -->
            <%@include file="components/Header.jsp" %>
            <!-- Header Area End Here -->
            <!-- Begin Verify Email Area -->
            <div class="error404-area pt-30 pb-60">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="error-wrapper text-center ptb-50 pt-xs-20">
                            <p>${fail}</p>
                            <h4>The verification code is sent to your Email</h4>
                            <form action="verifyEmail" method="post">
                                <input name="otp" id="otp" type="text" placeholder="Enter code" required>
                                <input type="submit" value="Verify code">
                            </form>
                        
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Verify Email Area End Here -->
            <!-- Begin Footer Area -->
            <%@include file="components/Footer.jsp" %>
            <!-- Footer Area End Here -->
        </div>
    </body>
</html>

