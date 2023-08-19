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
                                    <th scope="col">MaHD</th>
                                    <th scope="col">TenSP</th>
                                    <th scope="col">SoLuong</th>
                                    <th scope="col">DonGia</th>

                                </tr>
                                </thead>
                                <c:forEach items="${hdct}" var="a">
                                    <tbody>
                                    <tr>
                                        <th scope="row" style="color: #666666;">${a.hoaDon.ma}</th>
                                        <td>${a.chiTietSp.sp.ten}</td>
                                        <td>${a.soLuongTon}</td>
                                        <td>${a.donGia}</td>
                                    </tr>

                                    </tbody>
                                </c:forEach>

                            </table>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
</section>
</body>
</html>
