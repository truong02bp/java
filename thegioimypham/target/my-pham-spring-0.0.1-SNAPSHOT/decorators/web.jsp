<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/4/2020
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
    <!-- Facebook Pixel Code -->
    <script>
        !function(f,b,e,v,n,t,s)
        {if(f.fbq)return;n=f.fbq=function(){n.callMethod?
            n.callMethod.apply(n,arguments):n.queue.push(arguments)};
            if(!f._fbq)f._fbq=n;n.push=n;n.loaded=!0;n.version='2.0';
            n.queue=[];t=b.createElement(e);t.async=!0;
            t.src=v;s=b.getElementsByTagName(e)[0];
            s.parentNode.insertBefore(t,s)}(window, document,'script',
            'https://connect.facebook.net/en_US/fbevents.js');
        fbq('init', '476949866518878');
        fbq('track', 'PageView');
    </script>
    <noscript><img height="1" width="1" style="display:none"
                   src="https://www.facebook.com/tr?id=476949866518878&ev=PageView&noscript=1"
    /></noscript>
    <!-- End Facebook Pixel Code -->
    <title><dec:title default="Trang chủ"/></title>
    <meta name="author" content="ThemePunch"/>
    <meta name="description" content="The Garden theme tempalte">
    <meta name="keywords" content="The Garden theme template">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <link rel="icon" href="images/favicon.ico" type="image/gif" sizes="16x16"> -->
    <!--Icons fonts-->
    <link href="<c:url value="/template/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/vendor/line-awesome/css/line-awesome.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/template/vendor/themify-icons/themify-icons.css"/>" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i,900,900i|Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Overpass:100,100i,200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&display=swap"
          rel="stylesheet">
    <!--Styles-->
     <link href="<c:url value="/template/vendor/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
<%--    <link rel="stylesheet"--%>
<%--          href="<c:url value='/template/assets/css/bootstrap.min.css'/>"/>--%>

    <link href="<c:url value="/template/vendor/animsition/dist/css/animsition.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/vendor/animate.css/source/slide_fwd_center/slide_fwd_center.css"/>"
          rel="stylesheet">
    <link href="<c:url value="/template/vendor/owl-carousel/css/owl.carousel.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/vendor/css-hamburgers/css/hamburgers.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/vendor/slick/css/slick.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/vendor/range_filter/css/jquery-ui.css"/>" rel="stylesheet">
    <!-- Revolution -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/template/vendor/slider-revolution/css/settings.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/template/vendor/slider-revolution/css/layers.css"/>">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/template/vendor/slider-revolution/css/navigation.css"/>">
    <!--Theme style-->
    <link href="<c:url value="/template/css/main.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/css/responsive.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/template/vendor/slide-zoom/css/jquery.fancybox.css"/>">
    <link rel="stylesheet" href="<c:url value="/template/vendor/slide-zoom/css/fontello.css"/>">
    <script src="<c:url value='/template/assets/js/jquery-2.1.4.min.js'/>"></script>
    <script src="<c:url value='/template/assets/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js'/>" type="text/javascript"></script>
</head>
<body>
<div class="the-garden">
    <%@include file="/common/web/header.jsp" %>
    <dec:body/>
    <%@include file="/common/web/footer.jsp" %>
</div>
<%--<script src="<c:url value="/template/vendor/jquery/dist/jquery.min.js"/>"></script>--%>
<%--<script src="<c:url value="/template/vendor/bootstrap/dist/js/bootstrap.min.js"/>"></script>--%>
<script src="<c:url value="/template/vendor/jquery_easing/jquery.easing.min.js"/>"></script>
<script src="<c:url value="/template/vendor/owl-carousel/js/owl.carousel.js"/>"></script>
<script src="<c:url value="/template/vendor/slick/js/slick.js"/>"></script>
<script src="<c:url value="/template/vendor/isotope/js/isotope.js"/>"></script>
<script src="<c:url value="/template/vendor/isotope/js/imagesloaded.pkgd.js"/>"></script>
<script src="<c:url value="/template/vendor/range_filter/js/jquery-ui.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/template/vendor/slider-revolution/js/jquery.themepunch.tools.min.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/template/vendor/slider-revolution/js/jquery.themepunch.revolution.min.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/template/vendor/slider-revolution/js/revolution.extension.actions.min.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/template/vendor/slider-revolution/js/revolution.extension.carousel.min.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/template/vendor/slider-revolution/js/revolution.extension.kenburn.min.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/template/vendor/slider-revolution/js/revolution.extension.layeranimation.min.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/template/vendor/slider-revolution/js/revolution.extension.migration.min.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/template/vendor/slider-revolution/js/revolution.extension.navigation.min.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/template/vendor/slider-revolution/js/revolution.extension.parallax.min.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/template/vendor/slider-revolution/js/revolution.extension.slideanims.min.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/template/vendor/slider-revolution/js/revolution.extension.video.min.js"/>"></script>
<script src="<c:url value="/template/script/main.js"/>"></script>
<!-- Zoom slide -->
<script src="<c:url value="/template/vendor/slide-zoom/js/jquery.modernizr.js"/>"></script>
<script src="<c:url value="/template/vendor/slide-zoom/js/instafeed.min.js"/>"></script>
<script src="<c:url value="/template/vendor/slide-zoom/js/elevatezoom.min.js"/>"></script>
<script src="<c:url value="/template/vendor/slide-zoom/js/jquery.fancybox.min.js"/>"></script>
</body>
</html>
