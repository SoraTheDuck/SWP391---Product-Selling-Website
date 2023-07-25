
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
        <%@include file="components/Dashboard.jsp" %>
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            
                            <!-- DATA TABLE -->
                            <h3 class="title-5 m-b-35">manage customer</h3>
                            
                            <p style="color: green">${upmess}</p>
                            <br>
                            <div class="table-data__tool">
                                
                                <div class="table-data__tool-right">
                                    <button class="au-btn au-btn-icon au-btn--green au-btn--small" onclick="window.location.href = 'add-user'">
                                        <i class="zmdi zmdi-plus"></i>add customer</button>
                                    
                                </div>
                            </div>
                            <div class="table-responsive table-responsive-data2">
                                <table class="table table-data2">
                                    <thead>
                                        <tr>
                                            <th>name</th>
                                            <th>email</th>
                                            <th>address</th>
                                            <th>status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="ls" items="${listUser}" >
                                            <tr class="tr-shadow">
                                                <td>${ls.name}</td>
                                                <td>
                                                    <span class="block-email">${ls.email}</span>
                                                </td>
                                                <td>${ls.address}</td>
                                                <td>
                                                    <c:choose>
                                                            <c:when test="${ls.banned==0}">
                                                                <p style="color: green">Active</p>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <p style="color: red">Inactive</p>
                                                            </c:otherwise>
                                                        </c:choose>
                                                </td>
                                                <td class="action-cell">
                                                    <div class="table-data-feature">
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Edit" onclick="window.location.href = 'edit-user?cId=${ls.id}'">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <c:choose>
                                                            <c:when test="${ls.banned==0}">
                                                                <button class="item" data-toggle="tooltip" data-placement="top" title="Ban" 
                                                                        onclick="window.location.href='bancus?id=${ls.id}&ban=true';">
                                                                    <i class="zmdi zmdi-circle"></i>
                                                                </button>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <button class="item" data-toggle="tooltip" data-placement="top" title="Unban"
                                                                        onclick="window.location.href='bancus?id=${ls.id}&ban=false';">
                                                                    <i class="zmdi zmdi-block"></i>
                                                                </button>
                                                            </c:otherwise>
                                                        </c:choose>
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

        <script>
            window.onload = function()
            {
                sessionStorage.removeItem('mess');
            };
        </script>
        
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
