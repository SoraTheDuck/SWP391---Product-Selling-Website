<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>JSP Page</title>
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
            #viewPassword i {
                cursor: pointer;
            }

            #viewPassword .fa-eye {
                display: block;
            }

            #viewPassword .fa-eye-slash {
                display: none;
            }
        </style>
    </head>
    <body>
        <%@include file="components/Dashboard.jsp" %>
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-8">
                            <h3 class="title-5 m-b-35">Edit Staff</h3>
                            <div class="card">
                                <div class="card-header">
                                    <strong>Edit Form </strong>
                                </div>
                                <div class="card-body card-block">
                                    <p style="color: red">${mess}</P><br>
                                    <form action="editstaff" method="post" class="form-horizontal"  id="edit-form">


                                        <div class="row form-group">
                                            <div class="col col-md-2">
                                                <label class=" form-control-label">Staff ID</label>
                                            </div>
                                            <div class="col-12 col-md-10">
                                                <input type="text" name="id" class="form-control" value="${s.getId()}" readonly>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-2">
                                                <label class=" form-control-label">Name</label>
                                            </div>
                                            <div class="col-12 col-md-10">
                                                <input type="text" name="name" placeholder="Please enter staff name" class="form-control" value="${s.getName()}" >
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-2">
                                                <label class=" form-control-label">Email</label>
                                            </div>
                                            <div class="col-12 col-md-10">
                                                <input type="email" id="hf-email" name="email" placeholder="Please enter email" class="form-control" value="${s.getEmail()}" readonly>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-2">
                                                <label class="form-control-label">Password</label>
                                            </div>
                                            <div class="col-12 col-md-10">
                                                <div class="input-group">
                                                    <input type="password" id="passwordInput" name="pass" placeholder="Please enter password" class="form-control" value="${s.getPassword()}">
                                                    <div class="input-group-append">
                                                        <button type="button" id="viewPassword" class="btn btn-outline-secondary">
                                                            <i class="fa fa-eye" aria-hidden="true"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-2">
                                                <label class=" form-control-label">Phone</label>
                                            </div>
                                            <div class="col-12 col-md-10">
                                                <input type="number" name="phone" placeholder="Please enter phone" class="form-control" value="${s.getPhone()}">
                                            </div>
                                        </div>

                                        <input type="submit" class="btn btn-primary btn-sm" value="Edit"/>
                                        <input type="reset" class="btn btn-danger btn-sm" value="Cancel"/>
                                    </form>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
                <script>
                    const passwordInput = document.getElementById('passwordInput');
                    const togglePassword = document.getElementById('viewPassword');

                    // event click "eye"
                    togglePassword.addEventListener('click', function () {
                        const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
                        passwordInput.setAttribute('type', type);

                        // change eye
                        if (type === 'password') {
                            togglePassword.querySelector('.fa-eye').style.display = 'block';
                            togglePassword.querySelector('.fa-eye-slash').style.display = 'none';
                        } else {
                            togglePassword.querySelector('.fa-eye').style.display = 'none';
                            togglePassword.querySelector('.fa-eye-slash').style.display = 'block';
                        }
                    });
                </script>


                <!-- Jquery JS-->
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