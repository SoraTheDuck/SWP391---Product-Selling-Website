<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <!-- Begin Header Middle Area -->
    <div class="header-middle">
        <div class="container">
            <div class="row">
                <!-- Begin Header Logo Area -->
                <div class="col-lg-3">
                    <div class="logo pb-sm-30 pb-xs-30">
                        <a href="/SWP/home">
                            <img src="images/menu/logo/1.jpg"
                                 alt="">
                        </a>
                    </div>
                </div>
                <!-- Header Logo Area End Here -->
                <!-- Begin Header Middle Right Area -->
                <div class="header-middle-search col-lg-6">
                    <!-- Begin Header Middle Searchbox Area -->
                    <form action="search" method ="post" 
                          class="hm-searchbox">
                        <input type="text" name="searchbox" placeholder="Enter your search key ..." required>
                        <button class="li-btn" type="submit">
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                    <!-- Header Middle Searchbox Area End Here -->
                </div>
                <!-- Begin Header Middle Right Area -->
                    <div class="header-middle-right col-lg-3">
                        <!-- Begin Login Button Area -->
                        <c:choose>
                            <c:when test="${sessionScope.cus != null}">
                                <a href="profile" class="log-sign-btn log">${sessionScope.cus.name}</a>
                                <a href="logout" class="log-sign-btn sign">Log out</a>
                            </c:when>
                            <c:otherwise>
                                <a href="login"
                                   class="log-sign-btn log">Login</a>
                                <a href="register"
                                   class="log-sign-btn sign">Sign-up</a>
                            </c:otherwise>
                        </c:choose>
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
                                <li><a href="/SWP/home">Home</a></li>
                                <li class="megamenu-holder mn-drop"><a href="/SWP/shop">Shop</a>
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
                                <!-- Begin Mini Cart Button Area -->
                                <li class="hm-minicart f-right">
                                    <div class="hm-minicart-trigger">
                                        <span class="item-icon"></span>
                                        <span class="item-text">$ ${sessionScope.cart.getTotalMoney()}
                                            <c:set var="t" value="0" />
                                            <c:forEach var="o" items="${sessionScope.cart.items}">
                                                <c:set var="t" value="${t+o.quantity}" />
                                            </c:forEach>
                                            <span class="cart-item-count">${t}</span>
                                        </span>
                                    </div>
                                    <span></span>
                                    <div class="minicart">
                                        <ul class="minicart-product-list">
                                            <c:forEach var="o" items="${sessionScope.cart.items}">
                                            <li>
                                                <a href="detail?pid=${o.product.id}"
                                                   class="minicart-product-image">
                                                    <img src="${o.product.image}"
                                                         alt="cart products">
                                                </a>
                                                <div class="minicart-product-details">
                                                    <h6><a href="detail?pid=${o.product.id}">${o.product.name} x ${o.quantity}</a>
                                                    </h6>
                                                    <span>$ ${o.price}</span>
                                                </div>
                                            </li>
                                            </c:forEach>
                                            
                                        </ul>
                                        <p class="minicart-total">TOTAL: <span>$ ${sessionScope.cart.getTotalMoney()}</span></p>
                                        <div class="minicart-button">
                                            <a href="Shopping-cart.jsp"
                                               class="li-button li-button-dark li-button-fullwidth li-button-sm">
                                                <span>View Full Cart</span>
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
