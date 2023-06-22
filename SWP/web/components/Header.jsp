<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <!-- Begin Header Middle Area -->
    <div class="header-middle pl-sm-0 pr-sm-0 pl-xs-0 pr-xs-0">
        <div class="container">
            <div class="row">
                <!-- Begin Header Logo Area -->
                <div class="col-lg-3">
                    <div class="logo pb-sm-30 pb-xs-30">
                        <a href="./Home.jsp">
                            <img src="images/menu/logo/1.jpg"
                                 alt="">
                        </a>
                    </div>
                </div>
                <!-- Header Logo Area End Here -->
                <!-- Begin Header Middle Right Area -->
                <div class="header-middle-search col-lg-9 pl-0 ml-sm-15 ml-xs-15">
                    <!-- Begin Header Middle Searchbox Area -->
                    <form action="#"
                          class="hm-searchbox">
                        <input type="text"
                               placeholder="Enter your search key ...">
                        <button class="li-btn"
                                type="submit"><i class="fa fa-search"></i></button>
                    </form>
                    <!-- Header Middle Searchbox Area End Here -->
                    <!-- Begin Header Middle Right Area -->
                    <div class="header-middle-right">
                        <!-- Begin Login Button Area -->
                        <c:choose>
                            <c:when test="${sessionScope.cus != null}">
                                <a href="./Customer_profile.jsp" class="log-sign-btn log">User</a>
                                <a href="LogoutController" class="log-sign-btn sign">Log out</a>
                            </c:when>
                            <c:otherwise>
                                <a href="./Login.jsp"
                                   class="log-sign-btn log">Login</a>
                                <a href="./Register.jsp"
                                   class="log-sign-btn sign">Sign-up</a>
                            </c:otherwise>
                        </c:choose>
<!--                        <a href="./Login.jsp"
                           class="log-sign-btn log">Login</a>
                        <a href="./Register.jsp"
                           class="log-sign-btn sign">Sign-up</a>-->
                        <!-- Header Login Button Area End Here -->
                    </div>
                    <!-- Header Middle Right Area End Here -->
                </div>
                <!-- Header Middle Right Area End Here -->
            </div>
        </div>
    </div>

    <!-- Begin Header Bottom Area -->
    <div class="header-bottom header-sticky d-none d-lg-block">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <!-- Begin Header Bottom Menu Area -->
                    <div class="hb-menu hb-menu-2 d-xl-block">
                        <nav>
                            <ul>
                                <li><a href="Home.jsp">Home</a></li>
                                <li class="megamenu-holder mn-drop"><a href="shop-left-sidebar.jsp">Shop</a>
                                    <ul class="megamenu hb-megamenu">
                                        <li><a href="shop-left-sidebar.jsp">Shop Page Layout</a></li>
                                        <li><a href="single-product.jsp">Single Products</a>
                                            <ul>
                                                <li><a href="single-product.jsp">Single Products</a></li>
                                                <li><a href="single-product-normal.jsp">Single Product
                                                        Normal</a></li>
                                                <li><a href="single-product-sale.jsp">Single Product Sale</a>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="shop-left-sidebar.jsp">Accessories</a></li>
                                <!-- Begin Mini Cart Button Area -->
                                <li class="hm-minicart f-right">
                                    <div class="hm-minicart-trigger">
                                        <span class="item-icon"></span>
                                        <span class="item-text">£160
                                            <span class="cart-item-count">2</span>
                                        </span>
                                    </div>
                                    <span></span>
                                    <div class="minicart">
                                        <ul class="minicart-product-list">
                                            <li>
                                                <a href="single-product.jsp"
                                                   class="minicart-product-image">
                                                    <img src="images/product/small-size/3.jpg"
                                                         alt="cart products">
                                                </a>
                                                <div class="minicart-product-details">
                                                    <h6><a href="single-product.jsp">Aenean eu tristique</a>
                                                    </h6>
                                                    <span>£80 x 1</span>
                                                </div>
                                                <button class="close">
                                                    <i class="fa fa-close"></i>
                                                </button>
                                            </li>
                                            <li>
                                                <a href="single-product.jsp"
                                                   class="minicart-product-image">
                                                    <img src="images/product/small-size/4.jpg"
                                                         alt="cart products">
                                                </a>
                                                <div class="minicart-product-details">
                                                    <h6><a href="single-product.jsp">Aenean eu tristique</a>
                                                    </h6>
                                                    <span>£80 x 1</span>
                                                </div>
                                                <button class="close">
                                                    <i class="fa fa-close"></i>
                                                </button>
                                            </li>
                                        </ul>
                                        <p class="minicart-total">SUBTOTAL: <span>£160</span></p>
                                        <div class="minicart-button">
                                            <a href="Shopping-cart.jsp"
                                               class="li-button li-button-dark li-button-fullwidth li-button-sm">
                                                <span>View Full Cart</span>
                                            </a>
                                            <a href="checkout.jsp"
                                               class="li-button li-button-fullwidth li-button-sm">
                                                <span>Checkout</span>
                                            </a>
                                        </div>
                                    </div>
                                </li>
                                <!-- Mini Cart Button Area End Here-->
                                <!-- Header Bottom Menu Information Area End Here -->
                            </ul>
                        </nav>
                    </div>
                    <!-- Header Bottom Menu Area End Here -->
                </div>
            </div>
        </div>
    </div>
    <!-- Header Bottom Area End Here -->
    <!-- Begin Mobile Menu Area -->
    <div class="mobile-menu-area d-lg-none d-xl-none col-12">
        <div class="container">
            <div class="row">
                <div class="mobile-menu">
                </div>
            </div>
        </div>
    </div>
    <!-- Mobile Menu Area End Here -->
</header>
<!-- Header Area End Here -->
