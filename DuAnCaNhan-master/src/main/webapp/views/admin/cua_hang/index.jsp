<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17313 - CRUD Cua Hang</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
    <a href="/admin/cua-hang/createch" class="btn btn-primary"> Thêm mới</a>
    <table class="table table-bordered">
        <thead>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Địa Chỉ</th>
            <th>Thành Phố</th>
            <th>Quốc gia</th>
            <th colspan="2">Thao tác</th>
        </thead>
        <tbody>
        <c:forEach items="${ data }" var="ch">
            <tr>
                <td>${ ch.id }</td>
                <td>${ ch.ma }</td>
                <td>${ ch.ten }</td>
                <td>${ ch.diaChi }</td>
                <td>${ ch.thanhPho }</td>
                <td>${ ch.quocGia }</td>
                <td>
                    <a href="/admin/cua-hang/edit/${ch.id}">Cập nhật</a>
                </td>
                <td>
                    <a href="/admin/cua-hang/delete/${ch.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>

            </ul>
        </nav>
        </tbody>
    </table>
</body>
</html>