<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/3/2020
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="apiUrl" value="/api-item"/>
<c:url var="reload" value="/admin-item?action=edit"/>
<html>
<head>
    <title>Chỉnh sửa</title>
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
            <input type="text" class="form-control" id="name" name="name" value="${model.getName()}">
        </div>
        <div class="form-group">
            <label for="gia">Gía sản phẩm</label>
            <input type="text" class="form-control" id="gia" name="gia" value="${model.getGia()}">
        </div>
        <div class="form-group">
            <label for="shortDescription">ShortDescription</label>
            <input type="text" class="form-control" id="shortDescription" name="shortDescription"
                   value="${model.getShortDescription()}">
        </div>
        <div class="form-group">
            <label for="title">Title</label>

            <input type="text" class="form-control" id="title" name="title" value="${model.getTitle()}" >
        </div>
        <div class="form-group">
            <label for="content"> Content</label>
            <textarea rows="20" class="form-control" id="content" name="content" >${model.getContent()}</textarea>
        </div>
        <div class="form-group">
            <label for="categoryName">Loại sản phẩm</label>
            <select class="form-control form-control-lg" name="categoryName" id="categoryName">
                <c:forEach var="item" items="${categories}">
                    <option value = "${item.getName()}" <c:if test="${model.getName()==item.getName()}">selected="selected"</c:if>>
                            ${item.getName()}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="image">Image</label>
            <input type="text" class="form-control" id="image" name="image" value="${model.getImage()}">
        </div>
        <input type="button" id="update" value="Cập nhật sản phẩm"></input>
        <input type="hidden" name="id" value="${model.getId()}">
    </form>
</div>
<script>
    var editor='';
    $(document).ready(function () {
        editor = CKEDITOR.replace('content');
    });

    $('#update').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#submitForm').serializeArray();
        $.each(formData , function (i,v) {
            data[""+v.name+""] = v.value;
        });
        data["content"] = editor.getData();
        updateItem(data);
    })
    function updateItem(data)
    {
        $.ajax({
            url: '${apiUrl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${reload}&messenge=Update_Success&id="+result.id;
            },
            error: function (result) {
                window.location.href = "${reload}&messenge=Update_Fail&id="+result.id;
            }
        })
    }
</script>

</body>
</html>
