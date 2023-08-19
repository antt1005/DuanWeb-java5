<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/04/2023
  Time: 7:48 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap');

        body {
            font-family: "Poppins", sans-serif;
            color: #444444;
        }

        a,
        a:hover {
            text-decoration: none;
            color: inherit;
        }

        .section-products {
            padding: 80px 0 54px;
        }

        .section-products .header {
            margin-bottom: 50px;
        }

        .section-products .header h3 {
            font-size: 1rem;
            color: #fe302f;
            font-weight: 500;
        }

        .section-products .header h2 {
            font-size: 2.2rem;
            font-weight: 400;
            color: #444444;
        }

        .section-products .single-product {
            margin-bottom: 26px;
        }

        .section-products .single-product .part-1 {
            position: relative;
            height: 290px;
            max-height: 290px;
            margin-bottom: 20px;
            overflow: hidden;
        }


        .section-products .single-product .part-1::before {
            position: absolute;
            content: "";
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: -1;
            transition: all 0.3s;
        }

        .section-products .single-product:hover .part-1::before {
            transform: scale(1.2,1.2) rotate(5deg);
        }

        .section-products #product-1 .part-1::before {
            background: url("https://i.ibb.co/L8Nrb7p/1.jpg") no-repeat center;
            background-size: cover;
            transition: all 0.3s;
        }

        .section-products #product-2 .part-1::before {
            background: url("https://i.ibb.co/cLnZjnS/2.jpg") no-repeat center;
            background-size: cover;
        }

        .section-products #product-3 .part-1::before {
            background: url("https://i.ibb.co/L8Nrb7p/1.jpg") no-repeat center;
            background-size: cover;
        }

        .section-products #product-4 .part-1::before {
            background: url("https://i.ibb.co/cLnZjnS/2.jpg") no-repeat center;
            background-size: cover;
        }

        .section-products .single-product .part-1 .discount,
        .section-products .single-product .part-1 .new {
            position: absolute;
            top: 15px;
            left: 20px;
            color: #ffffff;
            background-color: #fe302f;
            padding: 2px 8px;
            text-transform: uppercase;
            font-size: 0.85rem;
        }

        .section-products .single-product .part-1 .new {
            left: 0;
            background-color: #444444;
        }

        .section-products .single-product .part-1 ul {
            position: absolute;
            bottom: -41px;
            left: 20px;
            margin: 0;
            padding: 0;
            list-style: none;
            opacity: 0;
            transition: bottom 0.5s, opacity 0.5s;
        }

        .section-products .single-product:hover .part-1 ul {
            bottom: 30px;
            opacity: 1;
        }

        .section-products .single-product .part-1 ul li {
            display: inline-block;
            margin-right: 4px;
        }

        .section-products .single-product .part-1 ul li a {
            display: inline-block;
            width: 40px;
            height: 40px;
            line-height: 40px;
            background-color: #ffffff;
            color: #444444;
            text-align: center;
            box-shadow: 0 2px 20px rgb(50 50 50 / 10%);
            transition: color 0.2s;
        }

        .section-products .single-product .part-1 ul li a:hover {
            color: #fe302f;
        }

        .section-products .single-product .part-2 .product-title {
            font-size: 1rem;
        }

        .section-products .single-product .part-2 h4 {
            display: inline-block;
            font-size: 1rem;
        }

        .section-products .single-product .part-2 .product-old-price {
            position: relative;
            padding: 0 7px;
            margin-right: 2px;
            opacity: 0.6;
        }

        .section-products .single-product .part-2 .product-old-price::after {
            position: absolute;
            content: "";
            top: 50%;
            left: 0;
            width: 100%;
            height: 1px;
            background-color: #444444;
            transform: translateY(-50%);
        }
    </style>
    <style>
        /*===== GOOGLE FONTS =====*/
        @import url("https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap");

        /*===== VARIABLES CSS =====*/
        :root {
            --dark-color-lighten: #f2f5ff;
            --red-card: #a62121;
            --blue-card: #4bb7e6;
            --btn: #141414;
            --btn-hover: #3a3a3a;
            --text: #fbf7f7;
        }

        /*===== RESET =====*/
        *,
        ::before,
        ::after {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            height: 100vh;
            width: 100vw;
            background-color: var(--dark-color-lighten);
            font-family: "Montserrat", sans-serif;
        }

        button {
            font-family: "Montserrat", sans-serif;
            display: inline-block;
            border: none;
            outline: none;
            border-radius: 0.2rem;
            color: var(--text);
            cursor: pointer;
        }

        a {
            text-decoration: none;
        }

        img {
            margin-left: 20px;
            max-width: 90%;
            height: 90%;
            user-select: none;
        }

        /*===== CARD =====*/
        /*.container {*/
        /*    height: 100%;*/
        /*    width: 850px;*/
        /*    margin: auto;*/
        /*    display: flex;*/
        /*    align-items: center;*/
        /*    justify-content: space-evenly;*/
        /*}*/

        .card {
            margin-top: 30px;
            position: relative;
            padding: 1rem;
            width: 300px;
            height: 400px;
            box-shadow: -1px 15px 30px -12px rgb(32, 32, 32);
            border-radius: 0.9rem;
            background-color: var(--red-card);
            color: var(--text);
            cursor: pointer;
        }

        .card-blue {
            background: var(--blue-card);
        }

        .product-image {
            height: 230px;
            width: 100%;
            transform: translate(0, -1.5rem);
            transition: transform 500ms ease-in-out;
            filter: drop-shadow(5px 10px 15px rgba(8, 9, 13, 0.4));
        }

        .product-info {
            text-align: center;
        }

        .card:hover .product-image {
            transform: translate(-1.5rem, -7rem) rotate(-20deg);
        }

        .product-info h2 {
            font-size: 1.4rem;
            font-weight: 600;
        }

        .product-info p {
            margin: 0.4rem;
            font-size: 0.8rem;
            font-weight: 600;
        }

        .price {
            font-size: 1.2rem;
            font-weight: 500;
        }

        .btn {
            display: flex;
            justify-content: space-evenly;
            align-items: center;
            margin-top: 0.8rem;
        }

        .buy-btn {
            background-color: var(--btn);
            padding: 0.6rem 3.5rem;
            font-weight: 600;
            font-size: 1rem;
            transition: 300ms ease;
        }

        .buy-btn:hover {
            background-color: var(--btn-hover);
        }

        .fav {
            box-sizing: border-box;
            background: #fff;
            padding: 0.5rem 0.5rem;
            border: 1px solid#000;
            display: grid;
            place-items: center;
        }

        .svg {
            height: 25px;
            width: 25px;
            fill: #fff;
            transition: all 500ms ease;
        }

        .fav:hover .svg {
            fill: #000;
        }

        @media screen and (max-width: 800px) {
            body {
                height: auto;
            }

            .container {
                padding: 2rem 0;
                width: 100%;
                flex-direction: column;
                gap: 3rem;
            }
        }
    </style>
</head>
<body>
<section class="section-products" style="margin-top: -100px">
    <div class="container">
        <div class="row justify-content-center text-center">
            <div class="col-md-8 col-lg-6">
                <div class="header">
                    <h3>Product Buy</h3>
                    <h2>Popular Products</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <!-- Single Product -->
            <c:forEach var="sp" items="${sp.content}">

                <div class="col-md-6 col-lg-4 col-xl-3">

                    <section class="card">
                        <div class="product-image">
                            <img src="https://i.ibb.co/cNWqxGx/red.png" alt="OFF-white Red Edition" draggable="false" />
                        </div>


                            <div class="product-info">
                                <h2>${sp.sp.ten}</h2>
                                <p>${sp.moTa}</p>
                                <div class="price">${sp.giaBan} $</div>
                            </div>
                            <div class="btn">
                                    <%--                        <button class="buy-btn">/button>--%>
                                <a href="detail-product/${sp.id}" class="buy-btn" style="color: white">Buy Now</a>

                                <button class="fav">
                                    <svg class="svg" id="i-star" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32" stroke="#000" stroke-linecap="round" stroke-linejoin="round" stroke-width="2">
                                        <path d="M16 2 L20 12 30 12 22 19 25 30 16 23 7 30 10 19 2 12 12 12 Z" />
                                    </svg>
                                </button>
                            </div>
                        </section>
                </div>
                <!-- Single Product -->
            </c:forEach>
        </div>
    </div>
    <br><br><br>

</section>
<div class="container">
    <nav aria-label="Page navigation example" style="margin-left: 600px">
        <ul class="pagination">
            <c:forEach begin="0" end="${ sp.totalPages -1}" varStatus="loop">
                <li class="page-item">
                    <a class="page-link" href="/home?page=${loop.begin + loop.count -1}">
                            ${loop.begin + loop.count }
                    </a>
                </li>
            </c:forEach>
        </ul>
    </nav>
</div>
</body>
</html>
