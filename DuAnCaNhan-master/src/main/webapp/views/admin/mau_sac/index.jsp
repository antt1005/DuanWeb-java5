<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17313 - CRUD Cua Hang</title>


        <title>Title</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<a href="/admin/mau-sac/createms" class="btn btn-primary">Thêm mới</a>
<table class="table table-bordered">
    <thead>
    <th>STT</th>
    <th>Mã</th>
    <th>Tên</th>
    <th colspan="2">Thao tác</th>
    </thead>
    <tbody>
    <c:forEach items="${lis.content}" var="ch">
        <tr>
            <td>${ ch.id }</td>
            <td>${ ch.ma }</td>
            <td>${ ch.ten }</td>
            <td>
                <a href="/admin/mau-sac/edit/${ch.id}">Cập nhật</a>
            </td>
            <td>
                <a href="/admin/mau-sac/delete/${ch.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach begin="0" end="${ lis.totalPages -1}" varStatus="loop">
            <li class="page-item">
                <a class="page-link" href="/admin/mau-sac/index?page=${loop.begin + loop.count - 1}">
                        ${loop.begin + loop.count }
                </a>
            </li>
            </c:forEach>
</table>
</body>
</html>