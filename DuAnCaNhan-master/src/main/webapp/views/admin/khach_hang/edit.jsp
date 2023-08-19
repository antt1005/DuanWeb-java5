<%@ page language="java" pageEncoding="UTF-8"  %>
<html>
<head>
    <title>SD17313 - Thêm mới khách hàng</title>

    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <h1>Edit Form</h1>
    <sf:form action="/admin/khach-hang/update/${data.id}" method="post"
             modelAttribute="data" >
        <div>
            <label>Mã</label>
            <div>
                <sf:input path="ma" cssClass="form-control"/>
                <sf:errors path="ma" cssStyle="color: red"/>
            </div>
        </div>

        <div>
            <label>Tên</label>
            <div>
                <sf:input path="ten" cssClass="form-control"/>
                <sf:errors path="ten" cssStyle="color: red"/>
            </div>
        </div>

        <div>
            <label>Tên Đệm</label>
            <div>
                <sf:input path="tenDem" cssClass="form-control"/>
                <sf:errors path="tenDem" cssStyle="color: red"/>
            </div>
        </div>

        <div>
            <label>Họ</label>
            <div>
                <sf:input path="ho" cssClass="form-control"/>
                <sf:errors path="ho" cssStyle="color: red"/>
            </div>
        </div>
        <div>
            <label>Ngày Sinh</label>
            <div>
                <sf:input path="ngaySinh" cssClass="form-control" type="date"/>
                <sf:errors path="ngaySinh" cssStyle="color: red"/>
            </div>
        </div>
        <div>
            <label>SDT</label>
            <div>
                <sf:input path="sdt" cssClass="form-control"/>
                <sf:errors path="sdt" cssStyle="color: red"/>
            </div>
        </div>
        <div>
            <label>Địa chỉ</label>
            <div>
                <sf:input path="diaChi" cssClass="form-control"/>
                <sf:errors path="diaChi" cssStyle="color: red"/>
            </div>
        </div>
        <div>
            <label>Thành Phố</label>
            <div>
                <sf:input path="thanhPho" cssClass="form-control"/>
                <sf:errors path="thanhPho" cssStyle="color: red"/>
            </div>
        </div>
        <div>
            <label>Quốc Gia</label>
            <div>
                <sf:input path="quocGia" cssClass="form-control"/>
                <sf:errors path="quocGia" cssStyle="color: red"/>
            </div>
        </div>
        <div>
            <label>Mật khẩu</label>
            <div>
                <sf:input path="matKhau" cssClass="form-control"/>
                <sf:errors path="matKhau" cssStyle="color: red"/>
            </div>
        </div>
        <div>
            <button class="btn btn-primary">Update mới</button>
        </div>
    </sf:form>
</div>
</body>
</html>