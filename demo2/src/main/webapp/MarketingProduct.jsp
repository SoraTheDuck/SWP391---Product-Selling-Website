
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
        <style>
            .confirm-notice {
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: #f9f9f9;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                
            }

            .confirm-notice p {
                margin: 0;
                margin-bottom: 10px;
            }

            .confirm-buttons {
                text-align: right;
            }

            .confirm-buttons button {
                margin-left: 10px;
            }

            .highlighted {
                color: red !important;
                font-weight: bold;
            }

        </style>
    </head>
    <body>
    <header class="header-mobile d-block d-lg-none">
        <div class="header-mobile__bar">
            <div class="container-fluid">
                <div class="header-mobile-inner">
                    <a class="logo">
                        <img src="images/menu/logo/Footer.png" alt="" />
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
                    <img src="images/menu/logo/Footer.png" alt="" />
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
            <!-- END MENU SIDEBAR-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Manage Products</h3>
                                <p style="color: green">${dmess}</p>
                                <div class="table-data__tool">

                                    <div class="table-data__tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small" onclick="window.location.href = 'marketingaddproduct'">
                                            <i class="zmdi zmdi-plus"></i>add item</button>
                                        
                                    </div>
                                </div>
                                <div class="table-responsive table-responsive-data2">
                                    <table class="table table-data2">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>product name</th>
                                                <th>quantity</th>
                                                <th>price</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="ls" items="${listPro}" >
                                                <tr class="tr-shadow">
                                                    <td>${ls.id}</td>
                                                    <td>${ls.name}</td>
                                                    <td>${ls.quantity}</td>
                                                    <td>${ls.price}</td>

                                                    <td  class="action-cell">
                                                        <div class="table-data-feature">
                                                            <button class="item" data-toggle="tooltip" data-placement="top" title="Edit" onclick="window.location.href = 'marketingeditproduct?id=${ls.id}'">
                                                                <i class="zmdi zmdi-edit"></i>
                                                            </button>
                                                            <button class="item" data-toggle="tooltip" data-placement="top" title="Delete" onclick="showConfirmation('${ls.id}', '${ls.name}')">
                                                                <i class="zmdi zmdi-block"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr class="spacer"></tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                                <!-- END DATA TABLE -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="confirmation-notice" class="confirm-notice" style="display: none;  z-index: 9999;">
                <p>Are you sure you want to delete the following product?</p>
                <p><strong>Product ID:</strong> <span id="product-id"></span></p>
                <p><strong>Product Name:</strong> <span id="product-name"></span></p>
                <div class="confirm-buttons">
                    <button onclick="deleteProduct()">Yes</button>
                    <button onclick="cancelDelete()">Cancel</button>
                </div>
            </div>

            <script>
                var productIdToDelete;

                // Show confirmation dialog
                function showConfirmation(id, name) {
                    productIdToDelete = id;
                    document.getElementById('product-id').textContent = id;
                    document.getElementById('product-name').textContent = name;
                    document.getElementById('confirmation-notice').style.display = 'block';
                }

                // Delete product
                function deleteProduct() {
                    // Redirect to the delete action
                    window.location.href = 'marketingdeleteproduct?id=' + productIdToDelete;
                }

                // Cancel delete
                function cancelDelete() {
                    document.getElementById('confirmation-notice').style.display = 'none';
                }
            </script>
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
F