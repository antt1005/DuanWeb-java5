<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/04/2023
  Time: 2:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        html,
        body,
        .intro {
            height: 100%;
        }
        tablee{
            width: 100%;
            overflow-y:scroll;
            height:600px;
            display:block;
        }

        table td,
        table th {
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }

        thead th,
        tbody th {
            margin-left: 20px;
            color: #fff;
        }

        tbody td {
            margin-left: 20px;
            font-weight: 500;
            color: rgba(255,255,255,.65);
        }

        .card {
            border-radius: .5rem;
        }
    </style>
</head>
<body>
<section class="intro">
    <div class="bg-image h-100" style="background-image: url('https://mdbootstrap.com/img/Photos/new-templates/tables/img2.jpg');">
        <div class="mask d-flex align-items-center h-100" style="background-color: rgba(0,0,0,.25);">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12">
                        <div class="card bg-dark shadow-2-strong">
                            <div class="card-body">
                                <div class="tablee">
                                    <div class="table-responsive">
                                        <table class="table table-dark table-borderless mb-0">
                                            <thead>
                                            <tr>
                                                <th scope="col">MaHD</th>
                                                <th scope="col">Ngay Tao</th>
                                                <th scope="col">Ngay Ship</th>
                                                <th scope="col">Ngay Nhan</th>
                                                <th scope="col">Ten Nguoi Nhan</th>
                                                <th scope="col">Dia Chi</th>
                                                <th scope="col">SDT</th>
                                                <th scope="col">Tuy Chon</th>
                                            </tr>
                                            </thead>
                                            <c:forEach var="hd" items="${hd.content}">
                                                <tbody>
                                                <tr>
                                                    <th scope="row">${hd.ma}</th>
                                                    <td>${hd.ngayTao}</td>
                                                    <td>${hd.ngayShip}</td>
                                                    <td>${hd.ngayNhan}</td>
                                                    <td>${hd.tenNguoiNhan}</td>
                                                    <td>${hd.diaChi}</td>
                                                    <td>${hd.sdt}</td>
                                                    <td>
                                                        <a href="/user/hoa-don-chi-tiet/${hd.id}" class="btn btn-light" style="border: none">Xem</a>
                                                    </td>
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
                <div class="container">
                    <nav aria-label="Page navigation example" style="margin-left: 600px">
                        <ul class="pagination">
                            <c:forEach begin="0" end="${ hd.totalPages -1}" varStatus="loop">
                                <li class="page-item">
                                    <a class="page-link" href="/hoa-don/user?page=${loop.begin + loop.count -1}">
                                            ${loop.begin + loop.count }
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>

</section>
</body>
</html>
