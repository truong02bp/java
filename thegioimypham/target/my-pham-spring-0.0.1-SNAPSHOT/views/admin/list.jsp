<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/4/2020
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="itemAPI" value="/api-item"/>
<c:url var="listUrl" value="/admin-list?page=1&limit=2"/>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<div class="main-content">
    <c:url var="createUrl" value="/admin-chinh-sua"/>
    <c:if test="${not empty messenge}">
        <div class="alert alert-${alert}" role="alert">
            ${messenge}
        </div>
    </c:if>
    <a href="${createUrl}" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Thêm sản phẩm</a>
    <button type="button" id="deleteItem" class="btn btn-outline-danger">Xóa các sản phẩm</button>
    <form action="/admin-list?page=${model.page}&limit=${model.limit}" id="formSubmit" method="get">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Code</th>
                <th scope="col">Loại sản phẩm</th>
                <th scope="col">Giá trước</th>
                <th scope="col">Giá sau</th>
                <th scope="col">Link</th>
                <th scope="col">Sale</th>
                <th scope="col">Khuyến mại</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach  var="item" items="${model.list}">
            <tr>
                <th scope="row">${item.id}</th>
                <td>${item.name}</td>
                <td>${item.code}</td>
                <td>${item.categoryId}</td>
                <td>${item.giaTruoc}</td>
                <td>${item.giaSau}</td>
                <td>${item.link}</td>
                <td>${item.sale}</td>
                <td>${item.khuyenMai}</td>
                <td>
                    <c:url var="updateUrl" value="/admin-chinh-sua">
                        <c:param name="id" value="${item.id}"/>
                    </c:url>
                    <a href="${updateUrl}" class="btn btn-outline-primary" role="button" aria-pressed="true">Sửa</a>
                    <input type="checkbox" id="checkbox_${item.id}" value="${item.id}">
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <ul class="pagination" id="pagination"></ul>
        <input type="hidden" id="page" name="page">
        <input type="hidden" id="limit" name="limit">
    </form>
</div>
<script type="text/javascript">
    $(function ()
    {
        var currentPage = ${model.page};
        var totalPage = ${model.totalPage};
        var limit = ${model.limit};
        window.pagObj = $('#pagination').twbsPagination({
            startPage: currentPage,
            totalPages: totalPage,
            visiblePages: 3,
            onPageClick: function (event, page)
            {
                if (currentPage != page)
                {
                    $('#page').val(page);
                    $('#limit').val(10);
                    $('#formSubmit').submit();
                }
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
    $('#deleteItem').click(
        function (e) {
            e.preventDefault();
            var ids = $('tbody input[type=checkbox]:checked').map(function ()
            {
                return $(this).val();
            }).get();
            xoa(ids);
        }
    )
    function xoa(data)
    {
        $.ajax(
            {
                url: "${itemAPI}",
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result)
                {
                    window.location.href = "${listUrl}&messenge=success_delete";
                },
                error: function (error)
                {
                    window.location.href = "${listUrl}&messenge=error_delete";
                    console.log(error);
                }
            }
        )
    }

</script>
</body>
</html>
