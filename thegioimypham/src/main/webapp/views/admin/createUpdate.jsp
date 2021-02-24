<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/4/2020
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="itemAPI" value="/api-item"/>
<c:url var="editUrl" value="/admin-chinh-sua"/>
<html>
<head>

    <title>
        <c:if test="${not empty model.id}">
            Cập nhật sản phẩm
        </c:if>
        <c:if test="${empty model.id}">
            Thêm sản phẩm
        </c:if>
    </title>
</head>
<body>
<div class="main-content">
    <c:if test="${not empty messenge}">
        <div class="alert alert-${alert}" role="alert">
                ${messenge}
        </div>
    </c:if>
    <form:form id="formSubmit" modelAttribute="model">
        <div class="form-group">
            <label for="name">Tên sản phẩm</label>
            <form:input path="name" id="name" cssClass="form-control"/>
            <label for="code">Mã sản phẩm</label>
            <form:input path="code" id="code" cssClass="form-control"/>
            <label for="categoryName">Loại sản phẩm</label>
            <form:select path="categoryName" id="categoryName" cssClass="form-control">
                <c:if test="${empty model.id}">
                    <form:option value="" label="Loại sản phẩm"/>
                </c:if>
                <form:options items="${categories}"/>
            </form:select>
            <label for="web">Website</label>
            <form:select path="web" id="web" cssClass="form-control">
                <form:option value="adflex" label="Adflex"/>
                <form:option value="accesstrade" label="Accesstrade"/>
            </form:select>
            <label for="giaTruoc">Giá trước giảm giá</label>
            <form:input path="giaTruoc" id="giaTruoc" cssClass="form-control"/>
            <label for="giaSau">Giá sau giảm giá</label>
            <form:input path="giaSau" id="giaSau" cssClass="form-control"/>
            <label for="sale">Sale</label>
            <form:input path="sale" id="sale" cssClass="form-control"/>
            <label for="link">Link sản phẩm</label>
            <form:input path="link" id="link" cssClass="form-control"/>
            <form:hidden path="id" id="itemId"/>
            <label for="content">Mô tả ngắn</label>
            <form:textarea path="shortDescription" id="shortDescription" rows="10" cols="50" cssClass="form-control"/>
            <label for="content">Khuyến mại</label>
            <form:textarea path="khuyenMai" id="khuyenMai" rows="10" cols="50" cssClass="form-control"/>
            <label for="content">Nội dung</label>
            <form:textarea path="content" id="content" cssClass="form-control"/>
        </div>
        <c:if test="${not empty model.id}">
            <button type="button" class="btn btn-primary" id="updateOrAdd">Cập nhật</button>
        </c:if>
        <c:if test="${empty model.id}">
            <button type="button" class="btn btn-primary" id="updateOrAdd">Thêm sản phẩm</button>
        </c:if>
    </form:form>
</div>
<script>
    var editor = '';
    $(document).ready(function () {
        editor = CKEDITOR.replace('content');
    })
    var editor2 = '';
    $(document).ready(function () {
        editor2 = CKEDITOR.replace('khuyenMai');
    })
    var editor3 ='';
    $(document).ready(function () {
        editor3 = CKEDITOR.replace('shortDescription');
    })
    $('#updateOrAdd').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        })
        data["content"] = editor.getData();
        data["khuyenMai"] = editor2.getData();
        data["shortDescription"] = editor3.getData();
        var id = $('#itemId').val();
        if (id == "") {
            add(data);
        } else {
            update(data);
        }
    })

    function add(data) {
        $.ajax({
            url: "${itemAPI}",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                console.log(result.id);
                window.location.href = "${editUrl}?id=" + result.id + "&messenge=success_insert";
            },
            error: function (result) {
                window.location.href = "${editUrl}?messenge=error_insert";
            }
        });
    }

    function update(data) {
        $.ajax({
            url: "${itemAPI}",
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                console.log(result.id);
                window.location.href = "${editUrl}?id=" + result.id + "&messenge=success_update";
            },
            error: function (result) {
                window.location.href = "${editUrl}?id=" + result.id + "&messenge=error_update";
            }
        });
    }
</script>
</body>
</html>
