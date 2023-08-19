<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/04/2023
  Time: 1:39 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
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
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css"
            rel="stylesheet"
    />
    <style>
        @media (min-width: 1025px) {
            .h-custom {
                height: 100vh !important;
            }
        }
    </style>
</head>
<body>
<script >
    function check(){
        var ch = confirm('ban co muon xoa khong')
        if(ch == false){
            event.preventDefault()
        }
    }
</script>
<section class="h-100 h-custom" style="background-color: #eee;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card">
                    <div class="card-body p-4">

                        <div class="row">

                            <div class="col-lg-7">
                                <h5 class="mb-3"><a href="#!" class="text-body"><i
                                        class="fas fa-long-arrow-alt-left me-2"></i>Continue shopping</a></h5>
                                <hr>

                                <div class="d-flex justify-content-between align-items-center mb-4">
                                    <div>
                                        <p class="mb-1">Shopping cart</p>
                                        <%--                                        hien thi so luong sp--%>
                                        <p class="mb-0"></p>
                                        <%--                                        --%>
                                    </div>
                                    <div>
                                        <%--                                        <p class="mb-0"><span class="text-muted">Sort by:</span> <a href="#!"--%>
                                        <%--                                                                                                    class="text-body">price <i class="fas fa-angle-down mt-1"></i></a></p>--%>
                                    </div>
                                </div>
                                <c:forEach var="gh" items="${gh}">
                                    <div class="card mb-3">
                                        <div class="card-body">
                                            <div class="d-flex justify-content-between">
                                                <div class="d-flex flex-row align-items-center">
                                                    <div>
                                                        <img
                                                                src="https://tse3.mm.bing.net/th?id=OIP.C9uZa4UO-XxFeew7NJnjywHaFj&pid=Api&P=0"
                                                                class="img-fluid rounded-3" alt="Shopping item" style="width: 65px;">
                                                    </div>
                                                    <div class="ms-3">
                                                        <h5>${gh.chiTietSp.sp.ten}</h5>
                                                        <p class="small mb-0">${gh.chiTietSp.nsx.ten},${gh.chiTietSp.ms.ten}</p>
                                                    </div>
                                                </div>
                                                <div class="d-flex flex-row align-items-center">

                                                    <sf:form action="/gio-hang/AddOne/${gh.chiTietSp.id}" method="post">
                                                    <div>
                                                        <button type="submit" style="width: 30px;border: none" > + </button>
                                                    </div>
                                                    </sf:form>

                                                    <sf:form action="/gio-hang/TruOne/${gh.chiTietSp.id}" method="post">
                                                    <div style="margin-left: 30px ; margin-right: 30px">
                                                        <button type="submit"  style="width: 30px; border: none"> - </button>
                                                    </div>
                                                    </sf:form>

                                                    <div style="width: 50px;">
                                                        <h5 class="fw-normal mb-0">${gh.soLuongTon}</h5>
                                                    </div>

                                                    <div style="width: 80px;">
                                                        <h5 class="mb-0">${gh.donGia}</h5>
                                                    </div>
                                                    <sf:form action="/delete-product/${gh.chiTietSp.id}" method="post">
                                                        <button type="submit" style="border: none" class="fas fa-trash-alt"  onclick="check()"></button>

                                                    </sf:form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </c:forEach>




                            </div>


                            <div class="col-lg-5">

                                <div class="card bg-primary text-white rounded-3">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between align-items-center mb-4">
                                            <h5 class="mb-0">Card details</h5>
                                            <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp"
                                                 class="img-fluid rounded-3" style="width: 45px;" alt="Avatar">
                                        </div>

                                        <p class="small mb-2">Card type</p>
                                        <a href="#!" type="submit" class="text-white"><i
                                                class="fab fa-cc-mastercard fa-2x me-2"></i></a>
                                        <a href="#!" type="submit" class="text-white"><i
                                                class="fab fa-cc-visa fa-2x me-2"></i></a>
                                        <a href="#!" type="submit" class="text-white"><i
                                                class="fab fa-cc-amex fa-2x me-2"></i></a>
                                        <a href="#!" type="submit" class="text-white"><i class="fab fa-cc-paypal fa-2x"></i></a>


                                        <sf:form action="/gio-hang/thanh-toan" method="post">
                                        <div>
                                            <form class="mt-4">
                                                <div class="form-outline form-white mb-4">
                                                    <input type="text" id="typeName" class="form-control form-control-lg" siez="17"
                                                           placeholder="Ten Nguoi Nhan's Name" name="ten"/>

                                                </div>

                                                <div class="form-outline form-white mb-4">
                                                    <input type="text" id="" class="form-control form-control-lg" siez="17"
                                                           placeholder="1234 5678 9012 3457"  name="sdt" />

                                                </div>

                                                <div class="row mb-4">
                                                    <div class="col-md-6">
                                                        <div class="form-outline form-white">
                                                            <input type="text" id="typeExp" class="form-control form-control-lg"
                                                                   placeholder="Dia Chi Nguoi Nhan" size="7" id="exp" name="diaChi"/>

                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                            <%--                                                    <div class="form-outline form-white">--%>
                                                            <%--                                                        <input type="password" id="typeText" class="form-control form-control-lg"--%>
                                                            <%--                                                               placeholder="&#9679;&#9679;&#9679;" size="1" minlength="3" maxlength="3" />--%>
                                                            <%--                                                        <label class="form-label" for="typeText">Cvv</label>--%>
                                                            <%--                                                    </div>--%>
                                                    </div>
                                                </div>

                                            </form>

                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between">
                                                <p class="mb-2">Subtotal</p>
                                                <p class="mb-2">$ ${dongia == null?"0":dongia}</p>
                                            </div>

                                            <div class="d-flex justify-content-between">
                                                <p class="mb-2">Shipping</p>
                                                <p class="mb-2">$20.00</p>
                                            </div>

                                            <div class="d-flex justify-content-between mb-4">
                                                <p class="mb-2">Total(Incl. taxes)</p>
                                                <p class="mb-2">$ ${dongia + 20}</p>
                                            </div>

                                            <button type="submit" class="btn btn-info btn-block btn-lg">
                                                <div class="d-flex justify-content-between">
                                                    <span>$ ${dongia + 20}</span>
                                                    <span>Checkout <i class="fas fa-long-arrow-alt-right ms-2"></i></span>
                                                </div>
                                            </button>
                                        </div>
                                        </sf:form>
                                    </div>
                                </div>

                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
