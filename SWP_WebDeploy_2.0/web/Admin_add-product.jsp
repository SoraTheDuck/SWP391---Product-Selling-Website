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
    <body  class="animsition">
        <div class="page-wrapper">
            <%@include file="components/Dashboard.jsp" %>

            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <h2 class="title-5 m-b-35">add products</h2>
                                <div class="card">
                                    <div class="card-header">
                                        <strong>Add Product</strong> Elements
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="add-product" method="post" class="form-horizontal">
                                            <p style="color: red">${mess}</p>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Product Id</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="text" name="id" placeholder="Please enter product ID" class="form-control" required>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Product Name</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="text" name="name" placeholder="Please enter product name" class="form-control" required>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Image</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="text" name="image" placeholder="Please enter product image URL"  class="form-control"  value="images/product/large-size/6.jpg" readonly>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Price</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="number" name="price" placeholder="Please enter product price" class="form-control" required>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Quantity</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <input type="number" id="password-input" name="quantity" placeholder="Please enter product quantity" class="form-control" required>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Description</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <textarea name="textarea-input" id="textarea-input" rows="5" placeholder="Content..." class="form-control"></textarea>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Wire/Wireless</label>
                                                </div>
                                                <div class="col col-md-10">
                                                    <div class="form-check">
                                                        <input type="radio" id="wired" name="wire" value="0" checked="true">
                                                        <label for="wired">Wired</label>
                                                        <input type="radio" id="wireless" name="wire" value="1">
                                                        <label for="wireless">Wireless</label><br>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-2">
                                                    <label class=" form-control-label">Category</label>
                                                </div>
                                                <div class="col-12 col-md-10">
                                                    <select name="category" id="select" class="form-control">
                                                        <c:forEach items="${categoryList}" var="o">
                                                            <option value="${o.getId()}">${o.getCategoryName()}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <input type="submit" value="Add Product" class="btn btn-primary btn-sm"/>
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

