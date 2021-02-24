<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/4/2020
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title><dec:title default="Đăng nhập"/></title>
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="<c:url value="/template/login/images/icons/favicon.ico"/>"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/template/login/vendor/bootstrap/css/bootstrap.min.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/template/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/template/login/vendor/animate/animate.css"/>"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/template/login/vendor/css-hamburgers/hamburgers.min.css"/>"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/template/login/vendor/select2/select2.min.css"/>"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/template/login/css/util.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/template/login/css/main.css"/>"/>
    <!--===============================================================================================-->
</head>
<body>
    <dec:body/>
    <!--===============================================================================================-->
    <script src="<c:url value="/template/login/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
    <!--===============================================================================================-->
    <script src="<c:url value="/template/login/vendor/bootstrap/js/popper.js"/>"></script>
    <script src="<c:url value="/template/login/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
    <!--===============================================================================================-->
    <script src="<c:url value="/template/login/vendor/select2/select2.min.js"/>"></script>
    <!--===============================================================================================-->
    <script src="<c:url value="/template/login/vendor/tilt/tilt.jquery.min.js"/>"></script>
    <script >
        $('.js-tilt').tilt({
            scale: 1.1
        })
    </script>
    <!--===============================================================================================-->
    <script src="<c:url value="/template/login/js/main.js"/>"></script>
</body>
</html>