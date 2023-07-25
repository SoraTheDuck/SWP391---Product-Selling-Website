<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    @media (max-width: 991px){
        .header-button {
        justify-content: flex-end;
        }
        .header-desktop {
            height: 100px;
        }
    }
</style>
<header class="header-mobile d-block d-lg-none">
    <div class="header-mobile__bar">
        <div class="container-fluid">
            <div class="header-mobile-inner">
                <a class="logo">
                    <img src="images/menu/logo/Footer.png" alt="CoolAdmin" />
                </a>
                <button class="hamburger hamburger--slider" type="button">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
                </button>
            </div>
        </div>
    </div>
    <nav class="navbar-mobile">
        <div class="container-fluid">
            <ul class="navbar-mobile__list list-unstyled">
                <li class="active has-sub">
                    <a href="adminpage">Dashboard</a>
                </li>
                <li class="has-sub">
                    <a  href="list-user">Manage Customer</a>
                </li>
                <li class="has-sub">
                    <a  href="liststaff">Manage Staffs</a>
                </li>
                <li class="has-sub">
                    <a href="list-product">
                        Manage Products</a>
                </li>
                <li class="has-sub">
                    <a  href="list-discount">
                        </i>Manage Discount</a>
                </li>
                <li class="has-sub">
                    <a  href="list-order">
                        </i>Manage Orders</a>
                </li>
            </ul>
        </div>
    </nav>
</header>

<!-- MENU SIDEBAR-->
<aside class="menu-sidebar d-lg-block d-none">
    <div class="logo">
        <a>
            <img src="images/menu/logo/Footer.png" alt="Cool Admin" />
        </a>
    </div>
    <div class="menu-sidebar__content js-scrollbar1">
        <nav class="navbar-sidebar">
            <ul class="list-unstyled navbar__list">
                <li class="active has-sub">
                    <a href="adminpage">Dashboard</a>
                </li>
                <li class="has-sub">
                    <a  href="list-user">Manage Customer</a>
                </li>
                <li class="has-sub">
                    <a  href="liststaff">Manage Staffs</a>
                </li>
                <li class="has-sub">
                    <a href="list-product">
                        Manage Products</a>
                </li>
                <li class="has-sub">
                    <a  href="list-discount">
                        </i>Manage Discount</a>
                </li>
                <li class="has-sub">
                    <a  href="list-order">
                        </i>Manage Orders</a>
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
                                    <img src="images/menu/avatar-admin.jpg" alt="admin" />
                                </div>
                                <div class="content">
                                    <a class="js-acc-btn" href="#">Admin</a>
                                </div>
                                <div class="account-dropdown js-dropdown">

                                    <div class="account-dropdown__footer">
                                        <a href="ad_login">
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