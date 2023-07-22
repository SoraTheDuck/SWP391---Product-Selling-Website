
<!DOCTYPE html>
<html>
    <!-- index-231:32-->

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="x-ua-compatible" content="ie=edge" />
        <title>
            Online Headphone Shop
        </title>
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />
        <!-- Material Design Iconic Font-V2.2.0 -->
        <link rel="stylesheet" href="css/material-design-iconic-font.min.css" />
        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.min.css" />
        <!-- Font Awesome Stars-->
        <link rel="stylesheet" href="css/fontawesome-stars.css" />
        <!-- Meanmenu CSS -->
        <link rel="stylesheet" href="css/meanmenu.css" />
        <!-- owl carousel CSS -->
        <link rel="stylesheet" href="css/owl.carousel.min.css" />
        <!-- Slick Carousel CSS -->
        <link rel="stylesheet" href="css/slick.css" />
        <!-- Animate CSS -->
        <link rel="stylesheet" href="css/animate.css" />
        <!-- Jquery-ui CSS -->
        <link rel="stylesheet" href="css/jquery-ui.min.css" />
        <!-- Venobox CSS -->
        <link rel="stylesheet" href="css/venobox.css" />
        <!-- Nice Select CSS -->
        <link rel="stylesheet" href="css/nice-select.css" />
        <!-- Magnific Popup CSS -->
        <link rel="stylesheet" href="css/magnific-popup.css" />
        <!-- Bootstrap V4.1.3 Fremwork CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <!-- Helper CSS -->
        <link rel="stylesheet" href="css/helper.css" />
        <!-- Main Style CSS -->
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/profile_css.css" />
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css" />
        <!-- Modernizr js -->

        <script src="js/vendor/modernizr-2.8.3.min.js"></script>
    </head>

    <body>

        <!-- Begin Body Wrapper -->
        <div class="body-wrapper">
            <!-- Begin Header Area -->
            <%@include file="components/Header.jsp" %>
            <!-- Begin Li's Breadcrumb Area -->
            <div class="breadcrumb-area">
                <div class="container">
                    <div class="breadcrumb-content">
                        <ul>
                            <li><a href="Home">Home</a></li>
                            <li class="active">Profile</li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Li's Breadcrumb Area End Here -->
            <!-- Account page navigation-->
            <div class="container px-4 mt-4 my-4">
                <!-- Account page navigation-->
                <button class="btn btn-primary mb-20 ml-10" style="width: 330px;">
                    <a style="color: #fff" href="history">View order history</a>
                </button>
                <div class="row">
                    <div class="col-xl-4">
                        <div class="card mb-4 mb-xl-0">
                            <div class="card-header">Change Password</div>
                            <div class="card-body">
                                <!-- Profile picture image-->
                                <form action ="change-pass?id=${sessionScope.cus.id}" method ="POST">
                                    <p class ="text-danger">${pass_mess}</p>
                                    <div class="row gx-3 mb-3">
                                        <!-- Form Group (first name)-->
                                        <div class="col-md-12">
                                            <label class="small mb-1" for="inputOldPass">Old Password</label>
                                            <input class="form-control" id="inputOldPass" type="password" placeholder="Old Password" name="oldpassword" />
                                        </div>
                                    </div>
                                    <!-- Form Row -->
                                    <div class="row gx-3 mb-3">
                                        <!-- Form Group (organization name)-->
                                        <div class="col-md-12">
                                            <label class="small mb-1" for="inputNewPass">New Password</label>
                                            <input class="form-control" id="inputNewPass" type="password" placeholder="New Password" name="newpassword" />
                                        </div>
                                    </div>
                                    <!-- Form Row        -->
                                    <div class="row gx-3 mb-3">
                                        <!-- Form Group (organization name)-->
                                        <div class="col-md-12">
                                            <label class="small mb-1" for="confirmNewPass">Confirm New Password</label>
                                            <input class="form-control" id="confirmNewPass" type="password" placeholder="Confirm New Password"
                                                   name="renewpassword" />
                                        </div>
                                    </div>
                                    <!-- Save changes button-->
                                    <button class="btn btn-primary" type="submit">
                                        Save changes
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-8">
                        <!-- Account details card-->
                        <div class="card mb-4">
                            <div class="card-header">Account Details</div>
                            <div class="card-body">
                                <p class ="text-danger">${profile_mess}</p>
                                <form action ="update-profile?id=${sessionScope.cus.id}" method="POST">
                                    <div class="mb-3">
                                        <!-- Form Group (name)-->
                                        <label class="small mb-1" for="inputName">Name</label>
                                        <input class="form-control" id="inputName" type="text" name="name" placeholder="Enter your name"
                                               value="${sessionScope.cus.name}" />
                                    </div>
                                    <!-- Form Group (address) -->
                                    <div class="mb-3">
                                        <label class="small mb-1" for="inputAddress">Address</label>
                                        <input class="form-control" id="inputAddress" type="text" name="address" placeholder="Enter your address"
                                               value="${sessionScope.cus.address}" />
                                    </div>
                                    <!-- Form Group (email address)-->
                                    <div class="mb-3">
                                        <label class="small mb-1" for="inputEmail">Email address</label>
                                        <input class="form-control" id="inputEmail" type="email" name="email" placeholder="Enter your email address"
                                               value="${sessionScope.cus.email}" readonly />
                                    </div>
                                    
                                    <!-- Save changes button-->
                                    <button class="btn btn-primary" type="submit">
                                        Save changes
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Begin Footer Area -->
            <%@include file="components/Footer.jsp" %>
            <!-- Footer Area End Here -->
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