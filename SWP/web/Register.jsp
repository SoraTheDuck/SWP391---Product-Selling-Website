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
            /* Overlay */
            .overlay {
                display: none;
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.2);
                z-index: 9999;
            }

            /* Popup content */
            .popup-content {
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
                z-index: 10000;
            }

            /* Close button */
            .close-btn {
                position: absolute;
                top: 10px;
                right: 10px;
                cursor: pointer;
                font-size: 30px;
                margin-right: 20px;
            }
        </style>
    </head>
    <body>
        <div class="body-wrapper">
            <!-- Begin Header Area -->
            <%@include file="components/Header.jsp" %>
            <!-- Header Area End Here -->
            <!-- Begin Li's Breadcrumb Area -->
            <div class="breadcrumb-area">
                <div class="container">
                    <div class="breadcrumb-content">
                        <ul>
                            <li><a href="Home.jsp">Home</a></li>
                            <li class="active">Register</li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Li's Breadcrumb Area End Here -->
            <!-- Begin Register Content Area-->
            <div class="container mt-10 mb-60">
                <form action="register" method="post"  onsubmit="return validateForm()">
                    <div class="login-form">
                        <h4 class="login-title">Register</h4>
                        <p style="color: red;">${mess}</p>
                        <div class="row">
                            <div class="col-md-12 mb-20">
                                <label>Name</label>
                                <input class="mb-0" type="text" placeholder="Name" name="name" required>
                            </div>
                            <div class="col-md-12 mb-20">
                                <label>Address</label>
                                <input class="mb-0" type="text" placeholder="Address" name="address" required>
                            </div>
                            <div class="col-md-12 mb-20">
                                <label>Email Address*</label>
                                <input class="mb-0" type="email" placeholder="Email Address" name="email" required>
                            </div>
                            <div class="col-md-6 mb-20">
                                <label>Password</label>
                                <input class="mb-0" type="password" placeholder="Password" name="pass" required>
                            </div>
                            <div class="col-md-6 mb-20">
                                <label>Confirm Password</label>
                                <input class="mb-0" type="password" placeholder="Confirm Password" name="rePass" required>
                            </div>
                            <div class="col-12 mb-20">
                                <div class="check-box d-inline-block">
                                    <input type="checkbox" id="privacy_policy" name="privacy_policy">
                                    <label for="privacy_policy">I agree to the <a href="#" id="privacyLink">Privacy Policy</a> and <a href="#" id="termsLink">Terms and Conditions</a></label>
                                </div>
                                <br/>
                                <p class="notice"><em>Please check the Privacy Policy and Terms and Conditions checkbox to proceed.</em></p>
                                <p id="privacy_error" style="color: red; display: none;"><em>Please agree to the Privacy Policy and Terms and Conditions.</em></p>
                            </div>

                            <div class="col-12">
                                <button class="register-button mt-0" type="submit" name="register">Register</button>
                            </div>
                        </div>
                        <!-- Popup content for Privacy Policy -->
                        <div class="overlay" id="privacyPopup">
                            <div class="popup-content">
                                <span class="close-btn" onclick="closePrivacyPopup()">&times;</span>
                                <h3>Privacy Policy</h3>
                                <p>Welcome to Online Headphone Shop!</p>
                                <p>This Privacy Policy describes how Online Headphone Shop collects, uses, and shares your personal information when you visit and interact with our website.</p>
                                <p><strong>Information We Collect:</strong></p>
                                <p>When you register an account, place an order, we may collect personal information such as your name, email address.</p>
                                <p><strong>How We Use Your Information:</strong></p>
                                <p>We use your personal information to process and fulfill your orders, send order updates.</p>
                                <p><strong>How We Share Your Information:</strong></p>
                                <p>We may share your personal information with trusted third-party service providers to process payments and improve our website's performance.</p>
                                <p><strong>Security:</strong></p>
                                <p>We take reasonable measures to protect your personal information, but please remember that no method of transmission over the Internet or electronic storage is 100% secure.</p>
                                <p><strong>Cookies:</strong></p>
                                <p>We use cookies and similar technologies to improve your browsing experience and provide personalized content.</p>
                            </div>
                        </div>
                        <!-- Popup content for Terms and Conditions -->
                        <div class="overlay" id="termsPopup">
                            <div class="popup-content">
                                <span class="close-btn" onclick="closeTermsPopup()">&times;</span>
                                <h3>Terms and Conditions</h3>
                                <p>Welcome to Online Headphone Shop!</p>
                                <p>By accessing and using this website, you agree to be bound by the following Terms and Conditions:</p>
                                <p><strong>Use of Website:</strong></p>
                                <p>You may use this website for personal and non-commercial purposes only. You must not use this website in any way that violates any applicable laws or regulations.</p>
                                <p><strong>Product Information:</strong></p>
                                <p>While we strive to provide accurate product information, we do not warrant that product descriptions, prices, or availability are error-free. We reserve the right to correct any errors and update information at any time without prior notice.</p>
                                <p><strong>Disclaimer of Warranties:</strong></p>
                                <p>This website and its content are provided on an "as is" basis without any warranties, express or implied. We do not warrant that this website will be error-free or uninterrupted, or that it will meet your requirements.</p>
                                <p><strong>Limitation of Liability:</strong></p>
                                <p>Online Headphone Shop shall not be liable for any direct, indirect, incidental, consequential, or special damages arising out of or in connection with your use of this website.</p>
                            </div>
                        </div>
                    </div>
                </form>
                <script>
                    // Function to show the Privacy Policy popup
                    function showPrivacyPopup() {
                        document.getElementById("privacyPopup").style.display = "block";
                    }

                    // Function to close the Privacy Policy popup
                    function closePrivacyPopup() {
                        document.getElementById("privacyPopup").style.display = "none";
                    }

                    // Event listener for the Privacy Policy link
                    const privacyLink = document.getElementById("privacyLink");
                    if (privacyLink) {
                        privacyLink.addEventListener("click", function (e) {
                            e.preventDefault();
                            showPrivacyPopup();
                        });
                    }

                    // Function to show the Terms and Conditions popup
                    function showTermsPopup() {
                        document.getElementById("termsPopup").style.display = "block";
                    }

                    // Function to close the Terms and Conditions popup
                    function closeTermsPopup() {
                        document.getElementById("termsPopup").style.display = "none";
                    }

                    // Event listener for the Terms and Conditions link
                    const termsLink = document.getElementById("termsLink");
                    if (termsLink) {
                        termsLink.addEventListener("click", function (e) {
                            e.preventDefault();
                            showTermsPopup();
                        });
                    }

                    function validateForm() {
                        var privacyCheckbox = document.getElementById("privacy_policy");
                        var termsCheckbox = document.getElementById("terms_policy");
                        var privacyError = document.getElementById("privacy_error");

                        if (!privacyCheckbox.checked || !termsCheckbox.checked) {
                            privacyError.style.display = "block";
                            return false; // Prevent form submission
                        } else {
                            privacyError.style.display = "none";
                            return true; // Allow form submission
                        }
                    }
                </script>
            </div>
        </div>
    </div>
</div>
<!-- Register Content Area End Here -->
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
</html>
