<%-- 
    Document   : dashboardAdmin
    Created on : Oct 26, 2024, 12:57:33 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DashBoard</title>
    <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/echarts/dist/echarts.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
    <link rel="stylesheet" href="./assets/css/dashboard.css">
</head>

<body style="background-color: #f1f5f9;">
    <div class="container_admin">
        <div id="db-wrapper">
            <div id="sidebar_admin"></div>
            <header id="header"></header>
            <div class="right-navbar-admin-manage">
                <div class="content">
                    <div class="header d-flex ">
                        <h1>DashBoard</h1>
                    </div>
                    <div class="row g-4  contain-row-app-content">
                        <div class="col-6 col-lg-3 item-row-detail">
                            <div class="app-card ">
                                <div class="app-card-body">
                                    <h4 class="title-overview stats-type ">
                                        ${totalUsers}
                                    </h4>
                                    <div class="desc-detail-overview stats-figure">
                                        ${accountCount}
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-6 col-lg-3 item-row-detail">
                            <div class="app-card ">
                                <div class="app-card-body">
                                    <h4 class="title-overview stats-type ">
                                        ${totalNews}
                                    </h4>
                                    <div class="desc-detail-overview stats-figure">
                                        ${countNews}
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-6 col-lg-3 item-row-detail">
                            <div class="app-card ">
                                <div class="app-card-body">
                                    <h4 class="title-overview stats-type ">
                                        ${totalContact}
                                    </h4>
                                    <div class="desc-detail-overview stats-figure">
                                        ${countContact}
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-6 col-lg-3 item-row-detail">
                            <div class="app-card ">
                                <div class="app-card-body">
                                    <h4 class="title-overview stats-type ">
                                        ${totalOrder}
                                    </h4>
                                    <div class="desc-detail-overview stats-figure">
                                        ${countOrder}
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
               

    <script>
        $('#header').load('utils.jsp #header_admin', () => {
            $.getScript('./assets/js/utilsAdmin.js');
        });
        $('#sidebar_admin').load('utils.jsp  #sidebar_admin');
       
    </script>
    
</body>

</html>