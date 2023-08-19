<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>SD17313</title>
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
<script >

    ${param.message}
</script>
<h1>Danh Sách Nhân Viên</h1>
</body>
<a href="/admin/nhan-vien/create" class="btn btn-primary">Thêm mới</a>
<table class="table    table-bordered">
    <tr style="background-color: gainsboro">
        <td>id</td>
        <td>Mã</td>
        <td>Tên</td>
        <td>Tên Đệm</td>
        <td>Họ</td>
        <td>Giới Tính</td>
        <td>Ngày Sinh</td>
        <td>Địa Chỉ</td>
        <td>Sdt</td>
        <td>Mật Khẩu</td>
        <td>Cửa Hàng</td>
        <td>chức vụ</td>
        <td>Trạng Thái</td>
        <td>Action</td>
    </tr>

    <c:forEach var="nv" items="${listNV.content }">

        <tbody>
        <tr>
            <td>${nv.id}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDem}</td>
            <td>${nv.ho}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.ch.ten}</td>
            <td>${nv.cv.ten}</td>
            <td>${nv.trangThai}</td>
            <td>
                <a href="/admin/nhan-vien/delete/${nv.id}" class="btn btn-danger">delete</a>
                <a href="/admin/nhan-vien/edit/${nv.id}" class="btn btn-primary">update</a>
            </td>

        </tr>
        </tbody>

    </c:forEach>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${ listNV.totalPages -1}" varStatus="loop">
            <li class="page-item">
                <a class="page-link" href="/admin/nhan-vien/index?page=${loop.begin + loop.count -1}">
                        ${loop.begin + loop.count }
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
</html>