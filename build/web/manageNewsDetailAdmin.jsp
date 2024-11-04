<%-- 
    Document   : manageNewsDetailAdmin
    Created on : Oct 4, 2024, 2:05:04 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>News Detail</title>
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
    <body>
        <div class="container_admin">
            <div id="db-wrapper">
                <!-- start-sidebar -->
                <div id="sidebar_admin"></div>
                <!-- start header -->
                <header id="header">  </header>
                <!-- right -->
                <div class="right-navbar-admin-manage">
                    <div class="content">
                        <!-- Title -->
                        <div class="header d-flex "> 
                            <h1>News Detail</h1>  

                            <div>
                                <a id="delete_news" class="btn-utils" href="MainController?action=adminDeleteNews&nId=${newsId}" style="background-color: rgb(235, 75, 75); border-color: rgb(235, 75, 75);">Delete News</a>
                            </div>

                        </div>
                        <div class="container_desc-all-news">
                            <c:forEach var="news" items="${List}">
                                <h1>${news.title}</h1>
                                <div class="desc_short-detail">
                                    <h2 class="user_post">Posted on 
                                        <span class="font-weight-bold text-dark">
                                            <fmt:formatDate value="${news.newsDate}" pattern="dd-MM-yyyy hh:mm" /> 
                                        </span>
                                    </h2>
                                    <h2 class="cate_news">${news.newsCategory.name}</h2>
                                </div>
                                <div class="desc_img-news">
                                    <img src="${news.newsImage}" alt="News Image">
                                </div>
                                <div class="desc-all-infor">
                                    <h4>${news.newsDescription}</h4>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${toastMessage != null}"> 
            <div id="toast" style="z-index: 10">  
                <div class="toast_main row ${toastMessage.equals('success') ? 'toast--success' : 'toast--error' }" style="display:flex">
                    <div class="toast__icon">
                        <i class="fa-solid ${toastMessage.equals('success') ? 'fa-circle-check' : 'fa-times-circle' }"></i>
                    </div>
                    <div class="toast_body">
                        <h3 class="toast__title">${toastMessage.equals('success') ? 'Success' : 'Error' }</h3>
                        <p class="toast__msg">${message}</p>
                    </div>
                    <div class="toast__close">
                        <i class="fas fa-times"></i>
                    </div>
                </div>
            </div>
        </c:if>
    </body>

    <script>
        $('#header').load('utils.jsp #header_admin', () => {
            $.getScript('./assets/js/utilsAdmin.js');
        });
        $('#sidebar_admin').load('utils.jsp  #sidebar_admin');

        const btnDelete = document.getElementById('delete_news');
        btnDelete.addEventListener('click', (e) => {
            const sure = confirm('Are you sure you want to delete this news?');
            if (!sure) {
                e.preventDefault();
            }
        });
    </script>
</html>