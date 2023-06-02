<%-- 
    Document   : navbar
    Created on : Apr 19, 2023, 10:07:15 PM
    Author     : toden
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav style="overflow: hidden;
     background-color: #333;
     position: fixed;
     top: 0;
     width: 100%;
     z-index: 1;" class="navbar navbar-dark bg-dark navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="cilentPage">CompStore</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="cilentPage">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="NewsList" class="nav-link">News</a>
                </li>
                <li class="nav-item">
                    <a href="AboutUsPage.jsp" class="nav-link">About Us</a>
                </li>
                <c:if test="${sessionScope.acc.getRole().getRole_id()==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="AdminPage.jsp">Dash Board</a>
                    </li>
                </c:if>
            </ul>
            <form class="d-flex" method="post" action="filter">
                <input name="search" class="form-control me-2" type="search" placeholder="" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            <c:choose>
                <c:when test="${sessionScope.cus!=null}">
                    <a href="profileDetailPage">
                        <span id="avatar" style="color: white; margin-left: 20px;"><i class="fas fa-user-alt fa-lg"></i>
                            ${sessionScope.acc.getAcc_name()}</span>
                    </a>
                </c:when>
                <c:otherwise>
                    <span id="avatar" style="color: white; margin-left: 20px;"><i class="fas fa-user-alt fa-lg"></i>
                        ${sessionScope.acc.getAcc_name()}</span>
                    </c:otherwise>
                </c:choose>

            <c:if test="${sessionScope.acc.getRole().getRole_id()==3}">
                <c:choose>
                    <c:when test="${sessionScope.cart.size()>0}">
                        <a href="Cart" style="color: white; margin-left: 20px;">Card</a>
                    </c:when>
                    <c:otherwise>
                        <a href="Cart" style="color: white; margin-left: 20px;">Card</a>
                    </c:otherwise>

                </c:choose>

            </c:if>


            <c:if test="${sessionScope.acc!=null}">
                <a href="logOutServlet" style="margin-left: 12px">
                    <button type="button" id="btnSignIn" onmouseout="hoverOutSignIn()" onmouseover="hoverSignIn()" class="btn btn-primary">LogOut</button>
                </a>
            </c:if>    

            <c:if test="${sessionScope.acc==null}">
                <a href="LoginPage.jsp" style="margin-left: 12px">
                    <button type="button" id="btnSignIn" onmouseout="hoverOutSignIn()" onmouseover="hoverSignIn()" class="btn btn-primary">SignIn</button>
                </a>  
            </c:if>   





        </div>
    </div>
</nav>
