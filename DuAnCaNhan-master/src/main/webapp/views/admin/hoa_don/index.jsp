<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SD17313 - Thêm mới DÒNG SP</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
    />
    <!-- MDB -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.1/mdb.min.css"
            rel="stylesheet"
    />

</head>
<body>
<style>
    html,
    body,
    .intro {
        height: 100%;
    }

    .gradient-custom-1 {
        /* fallback for old browsers */
        background: #cd9cf2;

        /* Chrome 10-25, Safari 5.1-6 */
        background: -webkit-linear-gradient(to top, rgba(205, 156, 242, 1), rgba(246, 243, 255, 1));

        /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        background: linear-gradient(to top, rgba(205, 156, 242, 1), rgba(246, 243, 255, 1))
    }

    table td,
    table th {
        text-overflow: ellipsis;
        white-space: nowrap;
        overflow: hidden;
    }
    tbody td {
        font-weight: 500;
        color: #999999;
    }
</style>
<section class="intro">
    <div class="gradient-custom-1 h-100">
        <div class="mask d-flex align-items-center h-100">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12">
                        <div class="table-responsive bg-white">
                            <table class="table mb-0">
                                <thead>
                                <tr>
                                    <th scope="col">Ma</th>
                                    <th scope="col">TenKH</th>
                                    <th scope="col">TenNV</th>
                                    <th scope="col">NgayThanhToan</th>
                                    <th scope="col">NgayTao</th>
                                    <th scope="col">Action</th>
                                </tr>
                                </thead>
                                <c:forEach items="${list.content}" var="a">
                                    <tbody>
                                    <tr>
                                        <th scope="row" style="color: #666666;">${a.ma}</th>
                                        <td>${a.khachHang.ho} ${a.khachHang.tenDem} ${a.khachHang.ten}</td>
                                        <td>${a.nhanVien.ho} ${a.nhanVien.tenDem} ${a.nhanVien.ten}</td>
                                        <td>${a.ngayThanhToan}</td>
                                        <td>${a.ngayTao}</td>
                                        <td><a href="/admin/hoa-don-chi-tiet/index/${a.id}" class="btn btn-primary">Chosse</a></td>
                                    </tr>

                                    </tbody>
                                </c:forEach>

                            </table>
                        </div>
                    </div>
                </div>
                <nav aria-label="Page navigation example" style="margin-left: 30px;margin-top: 30px" >
                    <ul class="pagination">
                        <c:forEach begin="0" end="${ list.totalPages -1}" varStatus="loop">
                            <li class="page-item">
                                <a class="page-link" href="/admin/hoa-don/index?page=${loop.begin + loop.count -1}">
                                        ${loop.begin + loop.count }
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>
            </div>

        </div>

    </div>
</section>
</body>
</html>
