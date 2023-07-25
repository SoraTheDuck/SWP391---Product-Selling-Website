
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="au theme template">
        <meta name="author" content="">
        <meta name="keywords" content="au theme template">
        <title>Online Headphone Shop</title>
        <!-- Fontfaces CSS-->
        <link href="css/font-face.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
        <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

        <!-- Bootstrap CSS-->
        <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

        <!-- Vendor CSS-->
        <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
        <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
        <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
        <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
        <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
        <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="css/theme.css" rel="stylesheet" media="all">
    </head>
    <body>
    <header class="header-mobile d-block d-lg-none">
        <div class="header-mobile__bar">
            <div class="container-fluid">
                <div class="header-mobile-inner">
                    <a class="logo">
                        <img src="images/icon/Logo1.jpg" alt="" />
                    </a>
                    <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                    </button>
                </div>
            </div>
        </div>
    </header>

    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar d-lg-block d-none">
        <div class="logo">
            <a>
                <img src="images/menu/logo/Logo1.jpg" alt="Cool Admin" />
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li class="has-sub">
                        <a  href="marketing">
                            </i>Manage Discount</a>
                    </li>
                    <li class="has-sub">
                        <a href="marketingproduct">
                            Manage Products</a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap">
                            <form class="form-header" action="" method="POST">
                            </form>
                            <div class="header-button">
                                <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                            <img src="images/menu/avatar-admin.jpg" alt="staff" />
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="#">Marketing</a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">

                                            <div class="account-dropdown__footer">
                                                <a href="stafflogin">
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- HEADER DESKTOP-->

            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-8">
                                <h3 class="title-5 m-b-35">Add Discount</h3>
                                <h3 style="color: red">${mess}</h3>
                                <div class="card">
                                    <div class="card-header">
                                        <strong>Add Discount Form</strong>
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="marketingdiscount" method="post" class="form-horizontal"  id="edit-form">


                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">ID</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="text" name="id" class="form-control" value="${p.getId()}" readonly>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Name</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="text" name="name" placeholder="Please enter customer name" class="form-control" value="${p.getName()}" readonly>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Price</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="text" id="hf-email" name="price" placeholder="Please enter email" class="form-control" value="${p.getPrice()}" readonly>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Start Date</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="date"  name="start"  class="form-control" value="${todayDate}" readonly>

                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">End Date</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="date" name="end"  class="form-control" value="">
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Set Discount</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="number" name="discount" placeholder="Enter discount percentage %" class="form-control" value="">
                                                </div>
                                            </div>


                                            <input type="submit" name="set" value="Set Discount" class="btn btn-primary btn-sm">

                                        </form>
                                    </div>


                                </div>
                            </div>
                        </div>
                    </div>



                    <script src="vendor/jquery-3.2.1.min.js"></script>
                    <!-- Bootstrap JS-->
                    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
                    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
                    <!-- Vendor JS       -->
                    <script src="vendor/slick/slick.min.js">
                    </script>
                    <script src="vendor/wow/wow.min.js"></script>
                    <script src="vendor/animsition/animsition.min.js"></script>
                    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
                    </script>
                    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
                    <script src="vendor/counter-up/jquery.counterup.min.js">
                    </script>
                    <script src="vendor/circle-progress/circle-progress.min.js"></script>
                    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
                    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
                    <script src="vendor/select2/select2.min.js">
                    </script>

                    <!-- Main JS-->
                    <script src="js/main2.js"></script>
                    </body>
                    </html>
