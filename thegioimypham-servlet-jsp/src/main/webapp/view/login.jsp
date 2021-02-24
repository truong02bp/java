<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/3/2020
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-center h-100">
        <div class="card">
            <div class="card-header">
                <h3>Đăng nhập</h3>
                <div class="d-flex justify-content-end social_icon">
                    <span><i class="fab fa-facebook-square"></i></span>
                    <span><i class="fab fa-google-plus-square"></i></span>
                    <span><i class="fab fa-twitter-square"></i></span>
                </div>
            </div>
            <div class="card-body">
                <form action="<c:url value="/trang-chu"/>" method="post">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control" name="username" placeholder="Tài khoản">

                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input type="password"  class="form-control" name="password" placeholder="Mật khẩu">
                    </div>
                    <c:if test="${not empty messenge}">
                    <div class="alert alert-${alert}">
                        ${messenge}
                    </div>
                    </c:if>
                    <div class="row align-items-center remember">
                        <input type="checkbox">Lưu mật khẩu
                    </div>
                    <div class="form-group">
                        <input type="hidden" value="login" name="action">
                        <input type="submit" value="Đăng nhập " class="btn float-right login_btn">
                    </div>
                </form>
            </div>
            <div class="card-footer">
                <div class="d-flex justify-content-center links">
                    Bạn chưa có tài khoản?<a href="#">Đăng ký</a>
                </div>
                <div class="d-flex justify-content-center">
                    <a href="#">Quên tài khoản ?</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
