<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light ftco-navbar-light-2"
     id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="<c:url value='/trang-chu'/>">Beauty Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a href="<c:url value='/trang-chu'/>" class="nav-link">TRANG CHỦ</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">TRANG ĐIỂM</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown05">
                        <a class="dropdown-item" href="<c:url value='/shop'/>">Son môi</a>
                        <a class="dropdown-item" href="<c:url value='/single-product'/>">Son dưỡng</a>
                        <a class="dropdown-item" href="<c:url value='/cart'/>">Mascara</a>
                        <a class="dropdown-item" href="<c:url value='/check-out'/>">Kem - phấn</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown06" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">CHĂM SÓC DA</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown06">
                        <a class="dropdown-item" href="<c:url value='/shop'/>">Kem dưỡng da</a>
                        <a class="dropdown-item" href="<c:url value='/single-product'/>">Sữa rửa mặt</a>
                        <a class="dropdown-item" href="<c:url value='/cart'/>">Mặt nạ</a>
                        <a class="dropdown-item" href="<c:url value='/check-out'/>">Tẩy da chết</a>
                    </div>
                </li>
                <li class="nav-item active"><a href="<c:url value='/about'/>" class="nav-link">THỰC PHẨM SỨC KHỎE</a></li>
                <li class="nav-item"><a href="<c:url value='/blog'/>" class="nav-link">BlOG</a></li>
                <li class="nav-item cta cta-colored"><a href="<c:url value='/cart'/>" class="nav-link"><span
                        class="icon-shopping_cart"></span>[0]</a></li>
                <c:if test="${empty UserModel}">
                <li class="nav-item"><a href="<c:url value='/dang-nhap?action=login'/>" class="nav-link">ĐĂNG NHẬP</a></li>
                </c:if>
                <c:if test="${not empty UserModel}">
                    <li class="nav-item"><a href="#" class="nav-link">Chào ${UserModel.getFullName()}</a></li>
                    <li class="nav-item"><a href="<c:url value='/thoat?action=logout'/>" class="nav-link">Đăng xuất</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->