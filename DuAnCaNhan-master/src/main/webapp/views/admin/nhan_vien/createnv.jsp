<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>SD17313 - CRUD mau sac</title>
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
<div class="container">
    <br><br>
    <sf:form action="${ action }" method="post"
             modelAttribute="nv">
        <h1>From Create Nhan Vien</h1><br><br>
       <div class="row">
           <div class="col-6">
               <div class="form-control">
                   <label>Mã</label>
                   <sf:input path="ma" class="form-control"/>
                   <sf:errors path="ma"  />
               </div>
               <div class="form-control">
                   <label>Tên</label>
                   <sf:input path="ten" class="form-control"/>
                   <sf:errors path="ten" />
               </div>
               <div class="form-control">
                   <label>tendem</label>
                   <sf:input path="tenDem" class="form-control"/>
                   <sf:errors path="tenDem" />
               </div>
               <div class="form-control">
                   <label>ho</label>
                   <sf:input path="ho" class="form-control"/>
                   <sf:errors path="ho" />
               </div>
               <div class="form-control">
                   <label >gioi tinh </label>
                   <input type="radio" name="gioiTinh" value="nam" checked>nam
                   <input type="radio" name="gioiTinh" value="nu">nu
               </div>
               <div class="form-control">
                   <label>ngaysinh</label>
                   <sf:input path="ngaySinh" class="form-control" type="date" />
                   <sf:errors path="ngaySinh" />
               </div>
           </div>
           <div class="col-6">
               <div class="form-control">
                   <label>dia chi</label>
                   <sf:input path="diaChi" class="form-control"/>
                   <sf:errors path="diaChi" />
               </div>
               <div class="form-control">
                   <label>sdt</label>
                   <sf:input path="sdt" class="form-control"/>
                   <sf:errors path="sdt" />
               </div>
               <div class="form-control">
                   <label>matKhau</label>
                   <sf:input path="matKhau" class="form-control"/>
                   <sf:errors path="matKhau" />
               </div>
               <div class="form-control">
                   <br>
                   <label >cua hang </label>
                   <sf:select path="ch.id" class="form-control">
                       <c:forEach items="${chs}" var="a">
                           <sf:option value="${a.id}">${a.ten}</sf:option>
                       </c:forEach>
                   </sf:select>
               </div>
               <div class="form-control">
                   <br>
                   <label >chuc vu </label>
                   <sf:select path="cv.id" class="form-control"  >
                       <c:forEach items="${cvs}" var="h">
                           <sf:option value="${h.id}">${h.ten}</sf:option>
                       </c:forEach>
                   </sf:select>
                   <br>
               </div >

               <div class="form-control">
                   <label>Mã</label>
                   <input type="radio" name="trangThai" value="0" checked>ok
                   <input type="radio" name="trangThai" value="1">not ok
               </div>
           </div>
       </div>
        <button class="btn btn-primary">Thêm</button>
    </sf:form>
</div>
</body>
</html>