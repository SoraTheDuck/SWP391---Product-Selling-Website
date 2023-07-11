<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- HEADER MOBILE-->
<header class="header-mobile d-block d-lg-none">
    <div class="header-mobile__bar">
        <!-- HEADER MOBILE BUTTON-->
        <div class="container-fluid">
            <div class="header-mobile-inner">
                <a class="logo" href="ad_page">
                    <img src="images/menu/logo/1.jpg" alt="" />
                </a>
                <button class="hamburger hamburger--slider" type="button">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
                </button>
            </div>
        </div>
        <!-- HEADER MOBILE BUTTON-->
    </div>
    <!-- HEADER MOBILE DROPDOWN MENU-->
    <nav class="navbar-mobile">
        <div class="container-fluid">
            <ul class="navbar-mobile__list list-unstyled">
                <c:if test="${sessionScope.admin eq 'admin'}">
                    <li class="active has-sub">
                        <a href="ad_page">Dashboard</a>
                    </li>
                    <li class=" has-sub">
                        <a  href="list-user">Manage Customer</a>
                    </li>
                    <li class="has-sub">
                        <a  href="ad_page">Manage Staffs</a>
                    </li>
                    <li class="has-sub">
                        <a href="list-product">
                            Manage Products</a>
                    </li>
                    <li class="has-sub">
                        <a  href="ad_page">
                            </i>Manage Discount</a>
                    </li>
                    <li class="has-sub">
                        <a  href="list-order">
                            </i>Manage Orders</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.accountant eq 'accountant'}">
                    <li class="active has-sub" id="dashboard">
                        <a href="#">Dashboard</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>
    <!-- HEADER MOBILE DROPDOWN MENU-->
</header>
<!-- END HEADER MOBILE-->

<!-- MENU SIDEBAR-->
<aside class="menu-sidebar d-none d-lg-block">
    <div class="logo">
        <a href="ad_page">
            <img src="images/menu/logo/1.jpg" alt="logo" />
        </a>
    </div>
    <div class="menu-sidebar__content">
        <nav class="navbar-sidebar">
            <ul class="list-unstyled navbar__list">
                <c:if test="${sessionScope.admin eq 'admin'}">
                    <li class="active has-sub" id="dashboard">
                        <a href="ad_page">Dashboard</a>
                    </li>
                    <li class="has-sub" id="manage-customer">
                        <a  href="list-user">Manage Customer</a>
                    </li>
                    <li class="has-sub" id="manage-staff">
                        <a  href="ad_page">Manage Staffs</a>
                    </li>
                    <li class="has-sub" id="manage-product">
                        <a href="list-product">
                            Manage Products</a>
                    </li>
                    <li class="has-sub" id="manage-discount">
                        <a  href="ad_page">Manage Discount</a>
                    </li>
                    <li class="has-sub" id="manage-order">
                        <a  href="list-order">Manage Orders</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.accountant eq 'accountant'}">
                    <li class="active has-sub" id="dashboard">
                        <a href="#">Dashboard</a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</aside>
<!-- END MENU SIDEBAR-->

<!-- PAGE CONTAINER-->
<div class="page-container">
    <!-- HEADER DESKTOP-->
    <header class="header-desktop">
        <div class="section__content section__content">
            <div class="container-fluid">
                <div class="header-wrap">
                    <!-- search bar -->
                    <!-- <form class="form-header" action="" method="POST">
                                            <input class="au-input au-input--xl" type="text" name="search" placeholder="Search for datas &amp; reports..." />
                                            <button class="au-btn--submit" type="submit">
                                                <i class="zmdi zmdi-search"></i>
                                            </button>
                                        </form>-->
                    <div class="header-button">
                        <div class="account-wrap">
                            <div class="account-item clearfix js-item-menu">
                                <c:if test="${sessionScope.admin eq 'admin'}">
                                    <div class="image">
                                        <img src="images/icon/avatar-admin.jpg" alt="admin" />
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="#">admin</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="account-dropdown__footer">
                                            <a href="ad_logout">
                                                <i class="zmdi zmdi-power"></i>Logout</a>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${sessionScope.accountant eq 'accountant'}">
                                    <div class="image">
                                        <img src="images/icon/avatar-admin.jpg" alt="acc" />
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="#">accountant</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="account-dropdown__footer">
                                            <a href="staff_logout">
                                                <i class="zmdi zmdi-power"></i>Logout</a>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <script>
        function setActiveSidebar() {
            //get the current page 
            var currentPage = window.location.href;

            // remove the active class from all sidebar items
            var sidebarItems = document.querySelectorAll('.navbar__list li');
            sidebarItems.forEach(function (item) {
                item.classList.remove('active');
            });

            // set the active class for the current page
            if (currentPage.includes('Admin_page.jsp')) {
                document.getElementById('dashboard').classList.add('active');
            } else if (currentPage.includes('list-user')) {
                document.getElementById('manage-customer').classList.add('active');
                //for staff
//            } else if (currentPage.includes('')) {
//                document.getElementById('manage-staff').classList.add('active');
            } else if (currentPage.includes('list-product')) {
                document.getElementById('manage-product').classList.add('active');
                //for discount
//            } else if (currentPage.includes('')) {
//                document.getElementById('manage-discount').classList.add('active');
            } else if (currentPage.includes('list-order')) {
                document.getElementById('manage-order').classList.add('active');
            }
        }

        window.addEventListener('DOMContentLoaded', setActiveSidebar);

        var sidebarLinks = document.querySelectorAll('.navbar__list li a');
        sidebarLinks.forEach(function (link) {
            link.addEventListener('click', setActiveSidebar);
        });
    </script>
