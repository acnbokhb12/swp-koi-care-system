<%-- 
    Document   : dashboardManager
    Created on : Oct 26, 2024, 12:58:07 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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

<body>
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
                                        Total Sales
                                    </h4>
                                    <div class="desc-detail-overview stats-figure">
                                        86
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-6 col-lg-3 item-row-detail">
                            <div class="app-card ">
                                <div class="app-card-body">
                                    <h4 class="title-overview stats-type ">
                                        Total Order
                                    </h4>
                                    <div class="desc-detail-overview ">
                                        40
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-6 col-lg-3 item-row-detail">
                            <div class="app-card ">
                                <div class="app-card-body">
                                    <h4 class="title-overview stats-type ">
                                        Total Products
                                    </h4>
                                    <div class="desc-detail-overview ">
                                        200
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-6 col-lg-3 item-row-detail">
                            <div class="app-card ">
                                <div class="app-card-body">
                                    <h4 class="title-overview stats-type ">
                                        Total Customer
                                    </h4>
                                    <div class="desc-detail-overview ">
                                        30
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-6 col-lg-3 item-row-detail">
                            <div class="app-card ">
                                <div class="app-card-body">
                                    <h4 class="title-overview stats-type ">
                                        Best-selling product
                                    </h4>
                                    <div class="desc-detail-overview-img">
                                        <img src="https://koithienduong.com/wp-content/uploads/2023/11/thuc-an-ca-koi-hikari-color-enhancer.jpg"
                                            alt="">
                                    </div>
                                    <div class="desc-detail-overview stats-figure">
                                        30
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-6 col-lg-3 item-row-detail">
                            <div class="app-card ">
                                <div class="app-card-body">
                                    <h4 class="title-overview stats-type ">
                                        Top spender
                                    </h4>
                                    <div class="desc-detail-overview-img">
                                        <img src="https://scontent.fsgn2-3.fna.fbcdn.net/v/t1.6435-9/120846118_1393138717744114_5343318628172679837_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=1d70fc&_nc_ohc=HRW0w38pbEQQ7kNvgF_Y1rD&_nc_ht=scontent.fsgn2-3.fna&_nc_gid=ARzB8qdQeV6A2gtFkV7lUga&oh=00_AYDhskM-yEdWNkPKeY4tujMz6Vwn07AZEpNMCJn3qOn-hA&oe=67242460"
                                            alt="">
                                    </div>
                                    <div class="desc-detail-overview stats-figure">
                                        khanh@gmail.com
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="chart-container ">
                        <div class="row">
                            <div class="col-lg-5 item_chart-detail-v2">
                                <h1>Orders in the past 7 days</h1>
                                <div id="chart_Orders_past" style="width: 100%; height: 400px;"></div>
                            </div>
                            <div class="col-lg-7 item_chart-detail-v2">
                                <h1>Amount collected over the past 5 months</h1>
                                <div id="chart_month_collect" style="width: 100%; height: 400px;"></div>
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
        $('#sidebar_admin').load('utils.jsp  #sidebar_manager');
         
    </script>
    <script>
         var chart = echarts.init(document.getElementById('chart_Orders_past'));
        var option = {
            title: {

            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['salt']
            },
            xAxis: {
                type: 'category',
                data: ['20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26'],
                axisLabel: {
                    rotate: 30,
                    fontSize: 10,
                    fontWeight: 'bold',


                }
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: '{value} %'
                }
            },
            series: [
                {
                    name: 'salt',
                    type: 'line',
                    data: [120, 132, 101, 134, 90, 230, 210]
                }
            ]
        };
        chart.setOption(option); 
    </script>
    <!-- Thy tien trong 5 months qua -->
    <script>
        var chart2 = echarts.init(document.getElementById('chart_month_collect'));
        var option2 = {
            title: {

            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['salt']
            },
            xAxis: {
                type: 'category',
                data: ['20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26'],
                axisLabel: {
                    rotate: 30,
                    fontSize: 10,
                    fontWeight: 'bold',


                }
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: '{value} %'
                }
            },
            series: [
                {
                    name: 'salt',
                    type: 'line',
                    data: [120, 132, 101, 134, 90, 230, 210]
                }
            ]
        };
        chart2.setOption(option2);

    </script>
</body>

</html>