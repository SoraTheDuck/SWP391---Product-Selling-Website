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

    </head>
    <body>
        <%@include file="components/Dashboard.jsp" %>
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-8">
                            <h3 class="title-5 m-b-35">Edit customer</h3>
                            <div class="card">
                                <div class="card-header">
                                    <strong>Add Customer</strong> Form
                                </div>
                                <div class="card-body card-block">
                                    <form action="edit-user" method="post" class="form-horizontal"  id="edit-form">


                                        <div class="row form-group">
                                            <div class="col col-md-2">
                                                <label class=" form-control-label">Id</label>
                                            </div>
                                            <div class="col-12 col-md-10">
                                                <input type="text" name="id" class="form-control" value="${cId}" readonly>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-2">
                                                <label class=" form-control-label">Name</label>
                                            </div>
                                            <div class="col-12 col-md-10">
                                                <input type="text" name="name" placeholder="Please enter customer name" class="form-control" value="${cus.name}" >
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-2">
                                                <label class=" form-control-label">Email</label>
                                            </div>
                                            <div class="col-12 col-md-10">
                                                <input type="email" id="hf-email" name="email" placeholder="Please enter email" class="form-control" value="${cus.email}" readonly>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-2">
                                                <label class=" form-control-label">Password</label>
                                            </div>
                                            <div class="col-12 col-md-10">
                                                <input type="text" id="hf-password" name="pass" placeholder="Please enter password" class="form-control" value="${cus.password}">
                                                
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-2">
                                                <label class=" form-control-label">Address</label>
                                            </div>
                                            <div class="col-12 col-md-10">
                                                <input type="text" name="address" placeholder="Please enter address" class="form-control" value="${cus.address}">
                                            </div>
                                        </div>

                                        <input type="submit" class="btn btn-primary btn-sm" value="Edit Customer"/>
                                        <input type="reset" class="btn btn-danger btn-sm" value="Cancel"/>
                                    </form>
                                </div>
                                            
                                             
                            </div>
                        </div>
                    </div>
                </div>
                                            
                
                                            
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


                    

        

