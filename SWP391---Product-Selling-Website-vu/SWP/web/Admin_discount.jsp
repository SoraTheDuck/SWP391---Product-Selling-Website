<%-- 
    Document   : Admin_discount.jsp
    Created on : Jul 11, 2023, 3:47:17 PM
    Author     : Acer Aspire
--%>
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
                            <h3 class="title-5 m-b-35">data table</h3>
                            <h3 style="color: red">${mess}</h3>
                            <div class="table-data__tool">


                            </div>
                            <div class="table-responsive table-responsive-data2">
                                <table class="table table-data2">
                                    <thead>
                                        <tr>
                                            <th>Product ID</th>
                                            <th>Product Name</th>
                                            <th>Start Date</th>
                                            <th>End Date</th>
                                            <th>Original Price</th>
                                            <th>Sale Price</th>
                                            <th>Discount</th>
                                            <th>Status</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="p" items="${list}">
                                            <tr class="tr-shadow">
                                                <td>${p.getId()}</td>
                                                <td>${p.getName()}</td>
                                                <td>${p.getStartdate()}</td>
                                                <td>${p.getEnddate()}</td>
                                                <td>${p.getPrice()}</td>
                                                <td>${p.getSaleprice()}</td>
                                                <td>${p.getDiscount()}</td>
                                                <td>
                                                    <c:if test="${p.getSaleprice()!=0}">
                                                        <p style="color: green">Sale Off</p>
                                                    </c:if>
                                                    <c:if test="${p.getSaleprice()==0}">
                                                        <p style="color: red">Not on Sale</p>
                                                    </c:if>
                                                </td>
                                                <td class="action-cell">
                                                    <div class="table-data-feature">
                                                        <form action="list-discount" method="post">
                                                            <input type="hidden" name="id" value="${p.getId()}">
                                                            <button type="submit" value="Add discount" class="item" data-toggle="tooltip" data-placement="top" title="Add" style="margin-right: 8px">
                                                                <i class="zmdi zmdi-edit"></i>
                                                            </button>

                                                        </form>

                                                        <c:if test="${p.getSaleprice()!=0}">
                                                            <form action="deletediscount" method="post">
                                                                <input type="hidden" name="id" value="${p.getId()}">
                                                                <button type="submit" value="Delete discount" class="item" data-toggle="tooltip" data-placement="top" title="Delete">
                                                                    <i class="zmdi zmdi-delete"></i>
                                                                </button>

                                                            </form>
                                                        </c:if>


                                                    </div>
                                                </td>

                                            </tr>
                                            <tr class="spacer"></tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>


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
