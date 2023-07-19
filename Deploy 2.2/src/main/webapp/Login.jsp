<%-- Document
     :
     login-register
     Created
     on
     :
     May
     30,
     2023,
     4:09:18
     PM
     Author
     :
     Acer
     Aspire
     --%>

  <%@page contentType="text/html"
          pageEncoding="UTF-8"
          %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="utf-8">
      <meta http-equiv="x-ua-compatible"
            content="ie=edge">
      <title>Online Headphone Shop</title>
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
        <%@include file="components/Header.jsp" %>
          <!-- Begin Mobile Menu Area -->
          <div class="mobile-menu-area d-lg-none d-xl-none col-12">
            <div class="container">
              <div class="row">
                <div class="mobile-menu">
                </div>
              </div>
            </div>
          </div>
          <!-- Mobile Menu Area End Here -->
        </header>
        <!-- Header Area End Here -->
        <!-- Begin Li's Breadcrumb Area -->
        <div class="breadcrumb-area">
          <div class="container">
            <div class="breadcrumb-content">
              <ul>
                <li><a href="./home">Home</a></li>
                <li class="active">Login</li>
              </ul>
            </div>
          </div>
        </div>
        <!-- Li's Breadcrumb Area End Here -->
        <!-- Begin Login Content Area -->
        <div class="form-space container mt-20 mb-30">
          <!-- Login Form s-->
          <p>${mess}</p>
          <c:set var="cookie" value="${pageContext.request.cookies}"/>
          <form action="login"
                method="post">
            <div class="login-form">
              <h4 class="login-title">Login</h4>
              <div class="row">
                <div class="col-md-12 col-12 mb-20">
                  <label>Email Address*</label>
                  <input class="mb-0"
                         type="email"
                         name="email"
                         id="email"
                         placeholder="Email Address" value="${cookie.cmail.value}">
                </div>
                <div class="col-12 mb-20">
                  <label>Password</label>
                  <input class="mb-0"
                         type="password"
                         name="password"
                         id="password"
                         placeholder="Password" value="${cookie.cpassword.value}">
                </div>
                <div class="col-md-8">
                  <div class="check-box d-inline-block ml-0 ml-md-2 mt-10">
                    <input type="checkbox"
                           id="remember_me" name="rem" value="on" ${(cookie.cr!=null ? 'checked':'')}>
                    <label for="remember_me">Remember me</label>
                  </div>
                </div>
                <div class="col-md-4 mt-10 mb-20 text-left text-md-right">
                  <a href="forgotpassword"> Forgot your password?</a>
                </div>
                <div class="col-md-12">
                  <button class="register-button mt-0">Login</button>
                </div>
              </div>
            </div>
          </form>
        </div>
        <!-- Login Content Area End Here -->
        <!-- Begin Footer Area -->
        <%@include file="components/Footer.jsp" %>
        <!-- Footer Area End Here-->
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

    <!-- login-register31:27-->

    </html>