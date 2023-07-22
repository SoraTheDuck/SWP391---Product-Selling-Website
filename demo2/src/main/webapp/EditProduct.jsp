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
    <body  class="animsition">
        <div class="page-wrapper">
            <%@include file="components/Dashboard.jsp" %>
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <h2 class="title-5 m-b-35">edit products</h2>
                                <div class="card">
                                    <div class="card-header">
                                        <strong>Edit Product</strong> Elements
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="editproduct" method="post" enctype="multipart/form-data">
                                            <p style="color: red">${mess}</p>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Product Id</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="text" name="id" placeholder="Please enter product ID" class="form-control" value="${p.getId()}" readonly>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Product Name</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="text" name="name" placeholder="Please enter product name" class="form-control" value="${p.getName()}">
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Image</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <img src="data:image/jpg;charset=utf8;base64,${p.getImage()}"
                                                         alt="Li's Product Image">
                                                    <input type="file" name="image" accept=".png,.jpg,.webp,.jpeg,.jpe" class="form-control"/>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Price</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="number" name="price" placeholder="Please enter product price" class="form-control" value="${p.getPrice()}">
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Quantity</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="number" id="password-input" name="quantity" placeholder="Please enter product quantity" class="form-control" value="${p.getQuantity()}">
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Description</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <textarea name="description" id="textarea-input" rows="5" placeholder="Content..." class="form-control">${p.getDescription()}</textarea>
                                                </div>
                                            </div>
                                                <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Release Date</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="text" name="releasedate" class="form-control" value="${p.getReleasedate()}" readonly>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Wire/Wireless</label>
                                                </div>
                                                <div class="col col-md-10">
                                                    <div class="form-check">
                                                        <c:choose>
                                                            <c:when test="${p.getWire()=='Wired'}">
                                                                Wire <input type="checkbox" name="wire" checked>
                                                            </c:when>
                                                            <c:otherwise>
                                                                Wire <input type="checkbox" name="wire">
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Changelog:</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="text" name="change" id="textarea-input" rows="5" placeholder="Content:" class="form-control" required>
                                                </div>
                                            </div>
                                                <input type="submit" value="Edit Product" class="btn btn-primary btn-sm"/>
                                            <input type="reset" value="Reset" class="btn btn-danger btn-sm"/>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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