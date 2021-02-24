<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${item.getName()}</title>
</head>

<body>
<%--<div class="hero-wrap hero-bread" style="background-image: url('<c:url value='/template/images/chamsocda.png'/>');">--%>
<%--&lt;%&ndash;    <div class="container">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="row no-gutters slider-text align-items-center justify-content-center">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <div class="col-md-9 ftco-animate text-center">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <h1 class="mb-0 bread">Product Single</h1>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <p class="breadcrumbs"><span class="mr-2"><a href="<c:url value="/trang-chu"/>"> Home </a></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--</div>--%>
<img src="<c:url value='/template/images/chamsocda.png'/>">
<section class="ftco-section bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 mb-5 ftco-animate">
                <%--                <a href="<c:url value='${item.getImage()}'/>" class="image-popup"><img src="<c:url value='${item.getImage()}'/>" class="img-fluid"&ndash;%&gt;--%>
                <%--                           alt="Colorlib Template"></a>--%>
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <a href="<c:url value='/template/images/${item.getTitle()}1.png'/>" class="image-popup"><img
                                    src="<c:url value='/template/images/${item.getTitle()}1.png'/>" class="img-fluid"
                                    alt="Colorlib Template"></a>
                        </div>
                        <div class="carousel-item">
                            <a href="<c:url value='/template/images/${item.getTitle()}2.png'/>" class="image-popup"><img
                                    src="<c:url value='/template/images/${item.getTitle()}2.png'/>" class="img-fluid"
                                    alt="Colorlib Template"></a>
                        </div>
                        <div class="carousel-item">
                            <a href="<c:url value='/template/images/${item.getTitle()}3.png'/>" class="image-popup"><img
                                    src="<c:url value='/template/images/${item.getTitle()}3.png'/>" class="img-fluid"
                                    alt="Colorlib Template"></a>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <div class="col-lg-6 product-details pl-md-5 ftco-animate">
                <h3>${item.getName()}</h3>
                <p class="price"><span>${item.getGia()}</span></p>
                <div class="row mt-4">
                    <div class="col-md-6">
                        <div class="form-group d-flex">
                            <div class="select-wrap">
                                <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                <select name="" id="" class="form-control">
                                    <option value="">Small</option>
                                    <option value="">Medium</option>
                                    <option value="">Large</option>
                                    <option value="">Extra Large</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="w-100"></div>
                    <div class="input-group col-md-6 d-flex mb-3">
                            <span class="input-group-btn mr-2">
                                <button type="button" class="quantity-left-minus btn" data-type="minus" data-field="">
                                    <i class="ion-ios-remove"></i>
                                </button>
                            </span>
                        <input type="text" id="quantity" name="quantity" class="form-control input-number" value="1"
                               min="1" max="100">
                        <span class="input-group-btn ml-2">
                                <button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
                                    <i class="ion-ios-add"></i>
                                </button>
                            </span>
                    </div>
                </div>
                <p><a href="cart.html" class="btn btn-primary py-3 px-5">Add to Cart</a></p>
            </div>
        </div>
        <%--        <div>--%>
        <%--            ${item.getContent()}--%>
        <%--        </div>--%>
        <center>
            <p>
                <a  class="btn btn-primary" data-toggle="collapse" href="#multiCollapseExample1" role="button"
                   aria-expanded="false" aria-controls="multiCollapseExample1">Xem chi tiết</a>
            </p>
        </center>

        <div class="row">
            <div class="col">
                <div class="collapse multi-collapse" id="multiCollapseExample1">
                    <div class="card card-body">
                        ${item.getContent()}
                        <center>
                            <p id="short">
                                <a class="btn btn-primary" data-toggle="collapse" href="#multiCollapseExample1"
                                   role="button"
                                   aria-expanded="false"  aria-controls="multiCollapseExample1" >Rút gọn</a>
                            </p>
                        </center>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
   //kk cần đâu, nhưng sao nó ko chạy vào hàm
            $("#short").on("click",function(){
                $(window).scrollTop( 600 );
                console.log("magic");
            });

    </script>
<section>

<section class="ftco-section-parallax">
    <div class="parallax-img d-flex align-items-center">
        <div class="container">
            <div class="row d-flex justify-content-center py-5">
                <div class="col-md-7 text-center heading-section ftco-animate">
                    <h1 class="big">Subscribe</h1>
                    <h2>Subcribe to our Newsletter</h2>
                    <div class="row d-flex justify-content-center mt-5">
                        <div class="col-md-8">
                            <form action="#" class="subscribe-form">
                                <div class="form-group d-flex">
                                    <input type="text" class="form-control" placeholder="Enter email address">
                                    <input type="submit" value="Subscribe" class="submit px-3">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>