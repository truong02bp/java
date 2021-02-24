<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/4/2020
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
    <title>${item.name}</title>
</head>
<body>
<section style="margin-top: 100px;margin-bottom: 50px;">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <%--                <div style="max-width: 470px">--%>
                <div style="">
                    <div class="image-preview-container">
                        <!-- - - - - - - - - - - - - - Image Preview Container - - - - - - - - - - - - - - - - -->
                        <div class="image-preview" style="width: 100%;">
                            <a href="<c:url value="/template/images/${item.code}.jpg"/>"
                               data-zoom-image="<c:url value="/template/images/${item.code}.jpg"/>"
                               data-fancybox="group">
                                <img id="zoom-image"
                                     src="<c:url value="/template/images/${item.code}.jpg"/>"
                                     alt="" style="max-height: 310px; max-width: 470px;width: 100%;height: 100%;display: block;margin: 0 auto;">
                            </a>
                        </div>
                        <!--/ .image-preview-->
                        <!-- - - - - - - - - - - - - - End of Image Preview Container - - - - - - - - - - - - - - - - -->
                        <!-- - - - - - - - - - - - - - Thumbnails - - - - - - - - - - - - - - - - -->
                        <div class="carousel-type-2">
                            <div class="owl-carousel type-small product-thumbs" id="thumbnails" data-max-items="4">
                                <a class="active" href="#"
                                   data-image="<c:url value="/template/images/${item.code}.jpg"/>"
                                   data-zoom-image="<c:url value="/template/images/${item.code}.jpg"/>"
                                   style="max-height: 470px; width: 100%;object-fit: cover; max-width: 100%;">
                                    <img src="<c:url value="/template/images/${item.code}.jpg"/>"
                                         alt="" style="height: 110px; width: 110px">
                                </a>
                                <a href="<c:url value="/template/images/${item.code}12.jpg"/>"
                                   data-image="<c:url value="/template/images/${item.code}12.jpg"/>"
                                   data-zoom-image="<c:url value="/template/images/${item.code}12.jpg"/>"
                                   style=""
                                   data-fancybox="group">
                                    <img src="<c:url value="/template/images/${item.code}12.jpg"/>"
                                         alt="" style="height: 110px; width: 110px">
                                </a>
                                <a href="<c:url value="/template/images/${item.code}13.jpg"/>"
                                   data-image="<c:url value="/template/images/${item.code}13.jpg"/>"
                                   data-zoom-image="<c:url value="/template/images/${item.code}13.jpg"/>"
                                   style="height: 470px; width: 470px"
                                   data-fancybox="group">
                                    <img src="<c:url value="/template/images/${item.code}13.jpg"/>"
                                         alt="" style="height: 110px; width: 110px">
                                </a>
                                <a href="<c:url value="/template/images/${item.code}14.jpg"/>"
                                   data-image="<c:url value="/template/images/${item.code}14.jpg"/>"
                                   data-zoom-image="<c:url value="/template/images/${item.code}14.jpg"/>"
                                   style="height: 470px; width: 470px"
                                   data-fancybox="group">
                                    <img src="<c:url value="/template/images/${item.code}14.jpg"/>"
                                         alt="" style="height: 110px; width: 110px">
                                </a>
                            </div>
                        </div>
                        <!-- - - - - - - - - - - - - - End of Thumbnails - - - - - - - - - - - - - - - - -->
                    </div>
                    <!--/ .image-preview-container -->
                </div>
            </div>
            <div class="col-md-6  clearfix">
                <div class="mid-product-content media-body">
                    <h3 style="font-size: 35px; color: #c19b76">${item.name}</h3>
                    <p style="color: #000">${item.categoryName}</p>
                    <div class="notable clearfix">
                        <ul>
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                        </ul>
                        <p>(${item.id + 23} đánh giá)</p>
                    </div><!--/notable-->
                    <div class="details-desc" style="margin-top: 0">
                        <p>${item.shortDescription}</p>
                    </div>
                    <span class="details-price">${item.giaSau}</span>
                    <span class="price-old" style="font-size: 18px; font-weight: 400;">${item.giaTruoc}</span>
                    <div class="lineAbout" style="width: 100%;height: 1px"></div>

                    <div class="details-button clearfix" style="margin-bottom: 0">
                        <p>${item.khuyenMai}</p>
                    </div>
                    <div class="lineAbout" style="width: 100%;height: 1px;    margin-top: 15px;"></div>
                    <div class="addCart">
                        <ul>
                            <li>
                                <button class="button btn-hover btn-details btn-buy" data-type="trigger-modal"
                                        data-modal="popup1">Đặt hàng <i
                                        class="la la-shopping-cart"
                                        style="font-size: 20px;position: relative;top: 2px;"></i></button>
                            </li>
                            <li>
                                <button class="button btn-hover btn-details btn-buy" data-type="trigger-modal"
                                        data-modal="popup1">Tư vấn<i
                                        class="la la-shopping-cart"
                                        style="font-size: 20px;position: relative;top: 2px;"></i></button>
                            </li>
                        </ul>
                    </div>
                </div><!--/mid-product-content-->
            </div>

        </div>
    </div>
</section>
<div id="popup1" class="overlay">
    <div class="popup">
        <a class="close close-modal" href="#">&times;</a>
        <div class="content">
            ${item.link}
        </div>
    </div>
</div>
<script>
    $('.btn-buy').on('click', function () {
        $(`#popup1`).toggleClass('overlay-modal');
    });
    $('.close-modal').click(function () {
        $(`#popup1`).toggleClass('overlay-modal');
    })
</script>
<section class="tabProduct">
    <div class="container">
        <div class="menuTabPro">
            <ul class="">
                <li class="active"><a data-toggle="tab" href="#home">Mô tả sản phẩm</a></li>
            </ul>
        </div>
        <div class="tab-content">
            <div id="home" class="tab-pane fade in active tabProText" style="width: 100%; overflow: hidden">
                <div class="if-box">
                    <p>${item.content}</p>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="page-shop-slidebar" style="    padding-top: 60px;">
    <div class="container">
        <div class="text-center">
            <h3>Một số sản phẩm nổi bật</h3>
        </div>
        <div class="row">
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="productG " style="margin-top: 0;     min-height: 360px;display: flex;flex-direction: column;align-items: center;">
                    <div class="sizeImg" style="width: 100%;float: none;display: flex;flex-direction: column;align-items: center;">
                        <a href="<c:url value="/san-pham?id=18&name=22again-vn"/>">
                            <img src="<c:url value="/template/images/22again-vn.jpg"/>" alt="product1"
                                 class="img-responsive" style="height: 240px;width: 270px"/>
                        </a>
                        <div class="arrIcon"></div>
                        <div class="box-posi">HOT</div>
                        <div class="arrIcon2">
                            <ul>
                                <li>
                                    <a href="<c:url value="/san-pham?id=18&name=22again-vn"/>">
                                        <i class="la la-shopping-cart"></i>
                                    </a>
                                </li>
                                <li style="margin-left: 6px;margin-right: 6px;">
                                    <a href="<c:url value="/san-pham?id=18&name=22again-vn"/>">
                                        <i class="la la-eye"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="product-text clearfix">
                        <div class="product-left pull-left"
                             style="padding-top: 20px;padding-bottom: 15px;">
                            <div class="product-name">
                                <h3 class="product-title">
                                    <a href="/san-pham?id=18&name=22again-vn"
                                       class="color-setting">Kem chống lão hòa 22again</a>
                                </h3>
                            </div>
                            <div class="product-price">
                                <span class="price1">1.580.000 Đ</span>
                                <span class="price">790.000 Đ</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="productG " style="margin-top: 0;     min-height: 360px;display: flex;flex-direction: column;align-items: center;">
                    <div class="sizeImg" style="width: 100%;float: none;display: flex;flex-direction: column;align-items: center;">
                        <a href="/san-pham?id=20&name=dakami-vn"> <img
                                src="<c:url value="/template/images/dakami-vn.jpg"/>" alt="product1"
                                class="img-responsive" style="height: 240px;width: 270px"/>
                        </a>
                        <div class="arrIcon"></div>
                        <div class="box-posi">HOT</div>
                        <div class="arrIcon2">
                            <ul>
                                <li>
                                    <a href="/san-pham?id=20&name=dakami-vn">
                                        <i class="la la-shopping-cart"></i>
                                    </a>
                                </li>
                                <li style="margin-left: 6px;margin-right: 6px;">
                                    <a href="/san-pham?id=20&name=dakami-vn">
                                        <i class="la la-eye"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="product-text clearfix">
                        <div class="product-left pull-left"
                             style="padding-top: 20px;padding-bottom: 15px;">
                            <div class="product-name">
                                <h3 class="product-title">
                                    <a href="/san-pham?id=20&name=dakami-vn"
                                       class="color-setting">Kem chống lão hóa Dakami</a>
                                </h3>
                            </div>
                            <div class="product-price">
                                <span class="price1">1.580.000 Đ</span>
                                <span class="price">790.000 Đ</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="productG " style="margin-top: 0;     min-height: 360px;display: flex;flex-direction: column;align-items: center;">
                    <div class="sizeImg" style="width: 100%;float: none;display: flex;flex-direction: column;align-items: center;">
                        <a href="<c:url value="/san-pham?id=22&name=fedora-vn"/>">
                            <img src="<c:url value="/template/images/fedora-vn.jpg"/>" alt="product1"
                                 class="img-responsive" style="height: 240px;width: 270px"/>
                        </a>
                        <div class="arrIcon"></div>
                        <div class="box-posi">HOT</div>
                        <div class="arrIcon2">
                            <ul>
                                <li>
                                    <a href="<c:url value="/san-pham?id=22&name=fedora-vn"/>">
                                        <i class="la la-shopping-cart"></i>
                                    </a>
                                </li>
                                <li style="margin-left: 6px;margin-right: 6px;">
                                    <a href="<c:url value="/san-pham?id=22&name=fedora-vn"/>">
                                        <i class="la la-eye"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="product-text clearfix">
                        <div class="product-left pull-left"
                             style="padding-top: 20px;padding-bottom: 15px;">
                            <div class="product-name">
                                <h3 class="product-title">
                                    <a href="/san-pham?id=22&name=fedora-vn"
                                       class="color-setting">Kem chống lão hóa Fedora</a>
                                </h3>
                            </div>
                            <div class="product-price">
                                <span class="price1">1.590.000 Đ</span>
                                <span class="price">790.000 Đ</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="productG " style="margin-top: 0;     min-height: 360px;display: flex;flex-direction: column;align-items: center;">
                    <div class="sizeImg" style="width: 100%;float: none;display: flex;flex-direction: column;align-items: center;">
                        <a href="<c:url value="/san-pham?id=21%name=gluwhite-vn"/>">
                            <img src="<c:url value="/template/images/gluwhite-vn.jpg"/>" alt="product1"
                                 class="img-responsive" style="height: 240px;width: 270px"/>
                        </a>
                        <div class="arrIcon"></div>
                        <div class="box-posi">HOT</div>
                        <div class="arrIcon2">
                            <ul>
                                <li>
                                    <a href="<c:url value="/san-pham?id=21&name=gluwhite-vn"/>">
                                        <i class="la la-shopping-cart"></i>
                                    </a>
                                </li>
                                <li style="margin-left: 6px;margin-right: 6px;">
                                    <a href="<c:url value="/san-pham?id=21&name=gluwhite-vn"/>">
                                        <i class="la la-eye"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="product-text clearfix">
                        <div class="product-left pull-left"
                             style="padding-top: 20px;padding-bottom: 15px;">
                            <div class="product-name">
                                <h3 class="product-title">
                                    <a href="/san-pham?id=21&name=gluwhite-vn"
                                       class="color-setting">Viên sủi trắng da Gluwhite</a>
                                </h3>
                            </div>
                            <div class="product-price">
                                <span class="price1">1.500.000 Đ</span>
                                <span class="price">890.000 Đ</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>