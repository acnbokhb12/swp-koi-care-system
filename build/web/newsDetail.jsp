<%-- 
    Document   : newsDetail
    Created on : Oct 4, 2024, 1:57:26 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- link logo img page -->
    <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
    <!-- Font gg family -->
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
        rel="stylesheet">
    <!-- Font icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- Jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- css -->
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
    <link rel="stylesheet" href="./assets/css/history.css">
</head>

<body class="body-detail-news">
    <!-- start header -->
    <div id="header"></div>
    <!-- end header -->

    <!-- Content -here -->
    <div class="container-main-news">
        <div class="container container-news">
            <div class="row row_news">
                <div class="col-md-8">
                    <div class="content_desc_all-news">
                        <h1>Koi: Learn About The Living Jewels of Portland Japanese Garden</h1>
                        <div class="desc_short-detail"> 
                            <h2 class="user_post">Posted by <span>Khanh</span>  on May 23, 2024</h2>
                            <h2 class="cate_news">Enviroment</h2>
                        </div>
                        <div class="desc_img-news-c">
                            <img src="https://wpmedia.japanesegarden.org/cb:An8z.2f0c8/w:788/h:525/q:mauto/ig:avif/id:aed028b992871073ff9301d84d87b332/http://live-japanesegarden.pantheonsite.io/Late-Spring-Early-Summer-by-Mike-Centioli-2017-05-31-Portland-Japanese-Garden-May-2017-28.jpg" alt="">
                        </div>
                        <div class="desc-all-infor"> 
                            <!-- place de info -->
                            In Portland, Oregon, sunshine is often more of a memory than a presence. Yet, while overcast skies may be thought of as gloomy in some spaces, in Portland Japanese Garden this kind of weather elevates the vivid colors present throughout its grounds. On a gray May day, the azaleas and rhododendrons showcase their lush purples and pinks, moss on stone and tree limb almost looks like it’s in motion with a kinetic green. However, there may be no element of the Garden’s landscape that truly comes alive against the cloud cover than its koi.
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="trending-title">
                        <strong>Trending now</strong> 
                    </div>
                    <div class="content-news-trend">
                        <a href="#" class="trend-right-single d-flex">
                            <div class="tren-right-img">
                                <img src="https://th.bing.com/th/id/OIP.dWp9EeuCr9hj184AeTpDewAAAA?rs=1&pid=ImgDetMain" alt="">
                            </div>
                            <div class="trend-rigth-cap">
                                <span>sea beach</span>
                                <h4>Welcome To The Best Model Winner Contest</h4>
                            </div>
                        </a>
                        <a href="#" class="trend-right-single d-flex">
                            <div class="tren-right-img">
                                <img src="https://th.bing.com/th/id/OIP.dWp9EeuCr9hj184AeTpDewAAAA?rs=1&pid=ImgDetMain" alt="">
                            </div>
                            <div class="trend-rigth-cap">
                                <span>sea beach</span>
                                <h4>Welcome To The Best Model Winner Contest</h4>
                            </div>
                        </a>
                        <a href="#" class="trend-right-single d-flex">
                            <div class="tren-right-img">
                                <img src="https://th.bing.com/th/id/OIP.dWp9EeuCr9hj184AeTpDewAAAA?rs=1&pid=ImgDetMain" alt="">
                            </div>
                            <div class="trend-rigth-cap">
                                <span>sea beach</span>
                                <h4>Welcome To The Best Model Winner Contest</h4>
                            </div>
                        </a>
                        <a href="#" class="trend-right-single d-flex">
                            <div class="tren-right-img">
                                <img src="https://th.bing.com/th/id/OIP.dWp9EeuCr9hj184AeTpDewAAAA?rs=1&pid=ImgDetMain" alt="">
                            </div>
                            <div class="trend-rigth-cap">
                                <span>sea beach</span>
                                <h4>Welcome To The Best Model Winner Contest</h4>
                            </div>
                        </a>
                        <a href="#" class="trend-right-single d-flex">
                            <div class="tren-right-img">
                                <img src="https://th.bing.com/th/id/OIP.dWp9EeuCr9hj184AeTpDewAAAA?rs=1&pid=ImgDetMain" alt="">
                            </div>
                            <div class="trend-rigth-cap">
                                <span>sea beach</span>
                                <h4>Welcome To The Best Model Winner Contest</h4>
                            </div>
                        </a>
                         
                    </div>
                </div>
            </div>
        </div>

    </div>
     
    <!-- footer -->
    <div id="footer"></div>
</body>
<script>
    $('#header').load('utils.jsp #header__nav', () => {
        $.getScript('./assets/js/utilsCustomer.js');
    });
    $('#footer').load('utils.jsp #footer__nav', () => {
        $.getScript('./assets/js/utilsCustomer.js');
    });
</script>

</html>