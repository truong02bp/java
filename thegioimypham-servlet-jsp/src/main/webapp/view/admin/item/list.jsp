<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="apiUrl" value="/api-item"/>
<c:url var="reload" value="/admin-item?action=list&page=1&maxPage=5&sortName=categoryId&sortBy=DESC"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">

    <title>Danh sách sản phẩm</title>
</head>

<body>
<div class="main-content">
    <c:if test="${not empty messengeResponse}">
        <div class="alert alert-${alertResponse}" role="alert">
                ${messengeResponse}
        </div>
    </c:if>
    <div>
    <a flag="info"
       class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
       title='Thêm bài viết' href='<c:url value="/admin-item?action=add"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
    </a>
    <button id="btnDelete" type="button"
            class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
    </button>
    </div>
    <form action="<c:url value='/admin-item'/>" id="formSubmit" method="get">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Tên</th>
                <th scope="col">Giá</th>
                <th scope="col">Category Id</th>
                <th scope="col">Giới thiệu</th>
                <th scope="col">Mô tả ngắn</th>
                <th scope="col">Ảnh</th>
                <th scope="col">Title</th>
                <th scope="col">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${model.getListResult()}">
                <tr>
                    <td>${item.getName()}</td>
                    <td>${item.getGia()}</td>
                    <td>${item.getCategoryId()}</td>
                    <td>${item.getContent()}</td>
                    <td>${item.getShortDescription()}</td>
                    <td>${item.getImage()}</td>
                    <td>${item.getTitle()}</td>
                    <td>
                        <c:url var="editURL" value="/admin-item?action=edit">
                            <c:param name="id" value="${item.id}"/>
                        </c:url>
                        <a href="${editURL}" role="button"> Sửa </a>
                        <input type="checkbox" id="checkbox_${item.getId()}" value="${item.getId()}">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <ul class="pagination" id="pagination"></ul>
        <input type="hidden" id="page" name="page">
        <input type="hidden" id="maxPage" name="maxPage">
        <input type="hidden" id="sortName" name="sortName">
        <input type="hidden" id="sortBy" name="sortBy">
        <input type="hidden" id="action" name="action">
    </form>
</div>
<!-- /.main-content -->
<script type="text/javascript">
    var currentPage = ${model.getPage()};
    var totalPages = ${model.getTotalPage()};
    var sortName = "categoryId";
    var sortBy = "desc";
    var action = "list";
    var limit = 5;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 3,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#action').val(action);
                    $('#sortName').val(sortName);
                    $('#sortBy').val(sortBy);
                    $('#maxPage').val(limit);
                    $('#page').val(page);
                    $('#formSubmit').submit();
                }
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
    $('#btnDelete').click(function (e)
    {
        e.preventDefault();
        var data ={};
        var formData = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['ids'] = formData;
        deleteItem(data);
    });

    function deleteItem(data) {
        $.ajax(
            {
                url: '${apiUrl}',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    window.location.href = '${reload}&messenge=Delete_Success';
                },
                error: function (error) {
                    window.location.href = '${reload}&messenge=Delete_Fail';
                }
            }
        );
    }
</script>
</body>

</html>