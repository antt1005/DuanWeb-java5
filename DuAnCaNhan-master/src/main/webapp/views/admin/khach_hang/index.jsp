<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17313 - CRUD Khách Hàng</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="f" uri="jakarta.tags.functions" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
            integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
            crossorigin="anonymous"></script>
</head>
<body>
<a href="/admin/khach-hang/create" class="btn btn-primary">Thêm mới</a>
<table class="table table-bordered">
    <thead>
    <td>Ma</td>
    <td>Ten</td>
    <td>Ten Dem</td>
    <td>Ho</td>
    <td>Ngay Sinh</td>
    <td>SDT</td>
    <td>Dia Chi</td>
    <td>Thanh Pho</td>
    <td>Quoc Gia</td>
    <td>Mat Khau</td>
    <td>Action</td>

    <th colspan="2">Thao tác</th>
    </thead>
    <tbody>
    <c:forEach items="${ data }" var="kh">
        <tr>
            <td>${ kh.id }</td>
            <td>${ kh.ma }</td>
            <td>${ kh.ten }</td>
            <td>${ kh.tenDem }</td>
            <td>${ kh.ho }</td>
            <td>${ kh.ngaySinh }</td>
            <td>${ kh.sdt }</td>
            <td>${ kh.diaChi }</td>
            <td>${ kh.thanhPho }</td>
            <td>${ kh.quocGia }</td>
            <td>${ kh.matKhau }</td>
            <td>
                <a href="/admin/khach-hang/edit/${kh.id}">Cập nhật</a>
            </td>
            <td>
                <a href="/admin/khach-hang/delete/${kh.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>