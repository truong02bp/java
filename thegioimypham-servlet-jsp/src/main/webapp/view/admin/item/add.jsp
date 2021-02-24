
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/3/2020
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="apiUrl" value="/api-item"/>
<c:url var="reload" value="/admin-item?action=add"/>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>

<div class="main-content">
    <c:if test="${not empty messengeResponse}">
    <div class="alert alert-${alertResponse}" role="alert">
        ${messengeResponse}
    </div>
    </c:if>
    <form id="submitForm">
        <div class="form-group">
            <label for="name">Tên sản phẩm</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="tên sản phẩm">
        </div>
        <div class="form-group">
            <label for="gia">Gía sản phẩm</label>
            <input type="text" class="form-control" id="gia" name="gia" placeholder="Gía sản phẩm">
        </div>
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="title">
        </div>
        <div class="form-group">
            <label for="shortDescription">ShortDescription</label>
            <input type="text" class="form-control" id="shortDescription" name="shortDescription"
                   placeholder="shortDescription">
        </div>
        <div class="form-group">
            <label for="content"> Content</label>
            <textarea rows="20" class="form-control" id="content" name="content" placeholder="content"> </textarea>
        </div>
        <div class="form-group">
            <label for="categoryName">Loại sản phẩm</label>
            <select class="form-control form-control-lg" name="categoryName" id="categoryName">
                <option>Chọn loại sản phẩm</option>
                <c:forEach var="item" items="${categories}">
                    <option value="${item.getName()}">${item.getName()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="image">Image</label>
            <input type="text" class="form-control" id="image" name="image" placeholder="image">
        </div>
        <button type="button" id="add" >Thêm sản phẩm</button>
    </form>
</div>
<script>
    var editor = '';
    $(document).ready(function(){
        editor = CKEDITOR.replace( 'content');
    });

    $('#add').click(function (e) {
        e.preventDefault();
        var data={};
        var formData = $('#submitForm').serializeArray();
        $.each(formData , function (i,v) {
            data[""+v.name+""] = v.value;
        });
        data["content"] = editor.getData();
        add(data);
    })
    function add(data) {
        $.ajax(
            {
                url: '${apiUrl}',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    window.location.href = '${reload}&messenge=Add_Success';
                },
                error: function (error) {
                    window.location.href = '${reload}&messenge=Add_Fail';
                }
            }
        )
    }
</script>
</body>
</html>
