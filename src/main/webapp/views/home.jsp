<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<div id="carousel" class="carousel slide">
    <!--индикаторы слайдов-->
    <ol class="carousel-indicators">
        <li class="active" data-target="#carousel" data-slide-to="0"></li>
        <li data-target="#carousel" data-slide-to="1"></li>
        <li data-target="#carousel" data-slide-to="2"></li>
    </ol>
    <!--слайды-->
    <div class="carousel-inner">

        <div class="item active">
            <img src="/resources/pictures/slide1.jpg" alt="">
            <div class="carousel-caption">
                <h3>first slide</h3>
                <p>description</p>
            </div>
        </div>

        <div class="item">
            <img src="/resources/pictures/slide2.jpg" alt="">
            <div class="carousel-caption">
                <h3>second slide</h3>
                <p>description2</p>
            </div>
        </div>

        <div class="item">
            <img src="/resources/pictures/slide3.jpg" alt="">
            <div class="carousel-caption">
                <h3>third slide</h3>
                <p>description3</p>
            </div>
        </div>
    </div>

    <!--стрелки переключения слайдов-->
    <a href="#carousel" class="left carousel-control" data-slide="prev">
        <span class="gliphicon gliphicon-chevron-left"></span>
    </a>
    <a href="#carousel" class="right carousel-control" data-slide="next">
        <span class="gliphicon gliphicon-chevron-right"></span>
    </a>

</div>

</body>
<html>
