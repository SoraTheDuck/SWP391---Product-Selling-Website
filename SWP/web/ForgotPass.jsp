<%-- 
    Document   : ForgotPass
    Created on : Jun 15, 2023, 11:37:44 PM
    Author     : quany
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        
        <div style="margin-top: 100px; margin-bottom: 100px" class="container" width="500px">
            <form method="post" action="forgotpassword">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email</label>
                    <input name="email" type="email" placeholder="examples@gmail.com" required>
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    <span style="color: red">${requestScope.err}</span>
                </div>
                
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>


    </body>
</html>

