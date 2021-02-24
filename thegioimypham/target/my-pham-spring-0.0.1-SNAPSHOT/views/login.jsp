<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/4/2020
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="<c:url value="/template/login/images/img-01.png"/>" alt="IMG">
            </div>
            <form action="/j_spring_security_check" class="login100-form validate-form" method="post">
					<span class="login100-form-title">
                        Đăng nhập
					</span>
                <c:if test="${param.accessDenied!=null}">
                    <div class="alert alert-danger" role="alert">
                        Bạn cần đăng nhập để truy cập
                    </div>
                </c:if>
                <c:if test="${param.incorrect!=null}">
                    <div class="alert alert-danger" role="alert">
                        Sai tài khoản hoặc mật khẩu
                    </div>
                </c:if>
                <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                    <input class="input100" type="text" name="j_username" placeholder="Tài khoản">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Password is required">
                    <input class="input100" type="password" name="j_password" placeholder="Mật khẩu">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" type="submit">
                        Đăng nhập
                    </button>
                </div>

                <div class="text-center p-t-12">
						<span class="txt1">
							Quên
						</span>
                    <a class="txt2" href="#">
                        Tài khoản / Mật khẩu?
                    </a>
                </div>

                <div class="text-center p-t-136">
                    <a class="txt2" href="#">
                        Tạo tài khoản
                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
