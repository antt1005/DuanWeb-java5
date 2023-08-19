<%@page pageEncoding="UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
    <header>
        <title>Ban Hang View</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <style>
            table {
                border-collapse: collapse;
            }

            th, td {

                border: 1px solid black;
                padding: 15px 100px;
            }

            .table-wrap {
                width: 100%;
                height: 222px;
                overflow-y: scroll;
                display: inline-block;
            }
        </style>
    </header>
<body>

    <div class="container">
        <div class="row">
            <div class="col-6">

                <table class="table-wrap table">
                    <tr style="background-color: #68778e">
                        <td>STT</td>
                        <td>MaHD</td>
                        <td>TenNVTao</td>
                        <td>NgayTao</td>
                        <td>TrangThai</td>
                        <td>Action</td>
                    </tr>
                    <tbody>
                    <c:forEach varStatus="count" var="a" items="${listHoaDon}">
                        <c:if test="${hoadonhientai == a.id}">
                            <tr style="background-color: blanchedalmond">
                        </c:if>
                        <c:if test="${hoadonhientai != a.id}">
                            <tr>
                        </c:if>

                            <td >${count.index+1}</td>
                            <td>${a.ma}</td>
                            <td>${a.nhanVien.ho} ${a.nhanVien.tenDem} ${a.nhanVien.ten}</td>
                            <td>${a.ngayTao}</td>
                            <td>Chua Thanh Toan</td>
                            <td>
                                <a href="/admin/ban-hang/hoa-don/hien-thi/${a.id}" class="btn btn-primary">Choose</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
            <div class="col-6">
                <table class="table-wrap table">
                    <tr style="background-color: #68778e">
                        <td>STT</td>
                        <td>MaHD</td>
                        <td>TenSP</td>
                        <td>SoLuong</td>
                        <td>DonGia</td>
                        <td colspan="2">Actiom</td>
                    </tr>
                    <tbody>
                    <c:forEach varStatus="count" var="b" items="${listHDCT}">
                        <tr>
                            <td>${count.index+1}</td>
                            <td>${b.hoaDon.ma}</td>
                            <td>${b.chiTietSp.sp.ten}</td>
                            <td>${b.soLuongTon}</td>
                            <td>${b.donGia}</td>
                            <td >
                                <sf:form action="/admin/ban-hang/addone/${b.chiTietSp.id}" method="post">
                                    <button type="submit" class="btn btn-primary">+</button>
                                </sf:form>
                            </td>
                            <td>
                                <sf:form action="/admin/ban-hang/deleteone/${b.chiTietSp.id}" method="post">
                                    <button type="submit" class="btn btn-danger">-</button>
                                </sf:form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="row" style="margin-top: 30px">
            <div class="col-6">
                <table class="table-wrap table">
                    <tr style="background-color: #68778e">
                        <td>STT</td>
                        <td>TenSP</td>
                        <td>MauSac</td>
                        <td>DongSP</td>
                        <td>NhaSanXuat</td>
                        <td>SoLuong</td>
                        <td>GiaBan</td>
                        <td>Action</td>
                    </tr>
                    <tbody>
                    <c:forEach varStatus="count" var="c" items="${listSP}">
                        <tr>
                            <td>${count.index+1}</td>
                            <td>${c.sp.ten}</td>
                            <td>${c.ms.ten}</td>
                            <td>${c.dsp.ten}</td>
                            <td>${c.nsx.ten}</td>
                            <td>${c.soLuongTon}</td>
                            <td>${c.giaBan}</td>
                            <td>
                                <sf:form action="/admin/ban-hang/addSP/${c.id}" method="post">
                                    <button type="submit" class="btn btn-primary">addSP</button>
                                </sf:form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-6">
                <div class="row">
                    <div class="col-3">
                        <sf:form action="/admin/ban-hang/createHD" method="post">
                            <button type="submit" class="btn btn-primary">ADD Hoa Don</button>
                        </sf:form>
                    </div>
                    <div class="col-3" style="margin-left: 30px">
                       <h4 >
                               Thanh Tien  ${thanhTien} $

                           <h4 style="color: red">${param.erro}</h4>
                       </h4>
                        <sf:form action="/admin/ban-hang/thanhToan" method="post">
                            <input type="number" name="khachTra" class="" min="0" value="0">
                            <button type="submit" class="btn btn-primary" >Thanh Toan Hoa Don</button>
                        </sf:form>
                    </div>
                </div>


            </div>
        </div>
    </div>
</body>
</html>