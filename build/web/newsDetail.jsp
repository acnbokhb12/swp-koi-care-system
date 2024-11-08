<%-- 
    Document   : newsDetail
    Created on : Oct 4, 2024, 1:57:26 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                            <c:forEach var="detail" items="${List}">
                                <h1>${detail.title}</h1>
                                <div class="desc_short-detail"> 
                                    <h2 class="user_post">Posted on <fmt:formatDate value="${detail.newsDate}" pattern="dd-MM-yyyy hh:mm" /> </h2>
                                    <h2 class="cate_news">${detail.newsCategory.name}</h2>
                                </div>
                                <div class="desc_img-news-c">
                                    <img src="${detail.newsImage}" alt="">
                                </div>
                                <div class="desc-all-infor"> 
                                    <!-- place de info -->
                                    ${detail.newsDescription}
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="trending-title">
                            <strong>Trending now</strong> 
                        </div>
                        <div class="content-news-trend">
                            <c:forEach var="list" items="${listNewsInDetail}">
                                <a href="MainController?action=viewNews&id=${list.newsID}" class="trend-right-single d-flex">
                                    <div class="tren-right-img">
                                        <img src="${list.newsImage}" alt="">
                                    </div>
                                    <div class="trend-rigth-cap">
                                        <span>${list.newsCategory.name}</span>
                                        <h4>${list.title}</h4>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div id="modal-logout-confirm"></div> 
        <!-- footer -->
        <div id="footer"></div>
        <style>
            .desc-all-infor{
                font-size: 1.6rem;
            }
                        .desc-all-infor img{
                            
                             width: 100%;   
                            }
        </style>
    </body>
    <script>
        $('#header').load('utils.jsp #header__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
        $('#footer').load('utils.jsp #footer__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
         $('#modal-logout-confirm').load('utils.jsp #modal-logout-confirm_nav', () => {
            $.getScript('./assets/js/utilsCustomer.js')
        });
    </script>

</html>