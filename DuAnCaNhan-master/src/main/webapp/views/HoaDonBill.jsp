<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/04/2023
  Time: 3:33 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
    <style>
        @import url(http://fonts.googleapis.com/css?family=Calibri:400,300,700);

        body {
            background-color: blue;
            font-family: 'Calibri', sans-serif !important;
        }


        .mt-100{
            margin-top: 50px;
        }

        .mb-100{
            margin-bottom: 50px;
        }

        .card{
            border-radius:1px !important;
        }

        .card-header{

            background-color:#fff;
        }

        .card-header:first-child {
            border-radius: calc(0.25rem - 1px) calc(0.25rem - 1px) 0 0;
        }

        .btn-sm, .btn-group-sm>.btn {
            padding: .25rem .5rem;
            font-size: .765625rem;
            line-height: 1.5;
            border-radius: .2rem;
        }
    </style>
</head>
<body>
<div class="container-fluid mt-100 mb-100">
    <div id="ui-view"><div><div class="card">
        <div class="card-header">

            Invoice<strong>#BBB-245432</strong>
            <div class="pull-right">
                <a class="btn btn-sm btn-info" href="#" data-abc="true"><i class="fa fa-print mr-1"></i> Print</a>
                <a class="btn btn-sm btn-info" href="#" data-abc="true"><i class="fa fa-file-text-o mr-1"></i> Save</a>
            </div>



        </div>
        <div class="card-body">
            <div class="row mb-4">
                <div class="col-sm-4">
                    <h6 class="mb-3">From:</h6>
                    <div><strong>BILL : </strong></div>
                    <div>${kh.ho} ${kh.tenDem} ${kh.ten} </div>
                    <div>${kh.diaChi}</div>
                    <div>${kh.thanhPho}</div>
                    <div>Phone: +${kh.sdt}</div>
                </div>

                <div class="col-sm-4">
                    <h6 class="mb-3">To:</h6>
                    <div><strong>BILL : </strong></div>
                    <div>${hd.tenNguoiNhan}</div>
                    <div>${hd.diaChi}</div>
                    <div>Phone: ${hd.sdt}</div>
                </div>

                <div class="col-sm-4">
                    <h6 class="mb-3">Details:</h6>
                    <div>Invoice<strong> ${hd.ma}</strong></div>
                    <div>${hd.ngayTao}</div>
                    <div>VAT: BBB0909090</div>
                    <div>Account Name: BANK OF AMERICA</div>
                    <div><strong>SWIFT code: 985798579487</strong></div>
                </div>

            </div>

            <div class="table-responsive-sm">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="center">#</th>
                        <th>Item</th>
                        <th>Description</th>
                        <th class="center">UNIT</th>
                        <th class="right">COST</th>
                        <th class="right">Total</th>
                    </tr>
                    </thead>
                    <c:forEach items="${hdct}" var="c" varStatus="aaaaa">
                        <tbody>
                        <td>${aaaaa.index+1}</td>
                        <td>${c.chiTietSp.sp.ten}</td>
                        <td>${c.chiTietSp.moTa}</td>
                        <td>${c.soLuongTon}</td>
                        <td>${c.chiTietSp.giaBan}</td>
                        <td>${c.donGia}</td>

                        </tbody>
                    </c:forEach>

                </table>
            </div>
            <div class="row">
                <div class="col-lg-4 col-sm-5">Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia.</div>
                <div class="col-lg-4 col-sm-5 ml-auto">
                    <table class="table table-clear">
                        <tbody>
                        <tr>
                            <td class="left"><strong>Subtotal</strong></td>
                            <td class="right">${donGia}</td>
                        </tr>
                        <tr>
                            <td class="left"><strong>Ship (20$)</strong></td>
                            <td class="right">$20</td>
                        </tr>
                        <tr>
                            <td class="left"><strong>VAT (0%)</strong></td>
                            <td class="right">$0</td>
                        </tr>
                        <tr>
                            <td class="left"><strong>Total</strong></td>
                            <td class="right"><strong>$ ${donGia + 20}</strong></td>
                        </tr>
                        </tbody>
                    </table>
                <sf:form action="/thanh-toan/${hd.id}" method="post">
                    <div class="pull-right">
                        <button type="submit"> <i class="fa fa-paper-plane mr-1"></i>Thanh Toan Nhan Hang</button>


                    </div>
                </sf:form>
                </div>
            </div>
        </div>
    </div></div></div>
</div>
</body>
</html>
