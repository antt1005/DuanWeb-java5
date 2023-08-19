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
             modelAttribute="data">
        <h1>From Create CHI TIET SP</h1><br><br>
    <div class="row">
        <div class="col-6">
        <div class="form-control">
            <br>
            <label >San Pham</label>
            <sf:select path="sp.id" class="form-control">
                <c:forEach items="${sps}" var="a">
                    <sf:option value="${a.id}">${a.ten}</sf:option>
                </c:forEach>
            </sf:select>
        </div>
        <div class="form-control">
            <br>
            <label >NSX </label>
            <sf:select path="nsx.id" class="form-control"  >
                <c:forEach items="${nsxs}" var="h">
                    <sf:option value="${h.id}">${h.ten}</sf:option>
                </c:forEach>
            </sf:select>
            <br>
        </div >
        <div class="form-control">
            <br>
            <label >Mau Sac </label>
            <sf:select path="ms.id" class="form-control"  >
                <c:forEach items="${mss}" var="m">
                    <sf:option value="${m.id}">${m.ten}</sf:option>
                </c:forEach>
            </sf:select>
            <br>
        </div >
        <div class="form-control">
            <br>
            <label >Dong SP</label>
            <sf:select path="dsp.id" class="form-control"  >
                <c:forEach items="${dsps}" var="n">
                    <sf:option value="${n.id}">${n.ten}</sf:option>
                </c:forEach>
            </sf:select>
            <br>
        </div >
        </div>
            <div class="col-6">
                <div class="form-control">
                    <label>Nam BH</label>
                    <sf:input path="namBH" class="form-control"/>
                    <sf:errors path="namBH" />
                </div>
                <div class="form-control">
                    <label>moTa</label>
                    <sf:input path="moTa" class="form-control"/>
                    <sf:errors path="moTa"/>
                </div>
                <div class="form-control">
                    <label>soLuongTon</label>
                    <sf:input path="soLuongTon" class="form-control" type="number" min="0" value="1" />
                    <sf:errors path="soLuongTon"/>
                </div>
                <div class="form-control">
                    <label>giaNhap</label>
                    <sf:input path="giaNhap" class="form-control"/>
                    <sf:errors path="giaNhap"/>
                </div>
                <div class="form-control">
                    <label>giaBan</label>
                    <sf:input path="giaBan" class="form-control"  />
                    <sf:errors path="giaBan" />
                </div>
            </div>
            </div>


        <button class="btn btn-primary">Thêm</button>
    </sf:form>
</div>
</body>
</html>