<%-- 
    Document   : dashboardAdmin
    Created on : Oct 26, 2024, 12:57:33 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                        Total Users
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
                                        Total View News
                                    </h4>
                                    <div class="desc-detail-overview stats-figure">
                                        40
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-6 col-lg-3 item-row-detail">
                            <div class="app-card ">
                                <div class="app-card-body">
                                    <h4 class="title-overview stats-type ">
                                        Views 5 News
                                    </h4>
                                    <div class="desc-detail-overview stats-figure">
                                        100
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-6 col-lg-3 item-row-detail">
                            <div class="app-card ">
                                <div class="app-card-body">
                                    <h4 class="title-overview stats-type ">
                                        Total sales
                                    </h4>
                                    <div class="desc-detail-overview stats-figure">
                                        12000000
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="chart-container ">
                        <div class="row">
                            <div class="col-lg-5 item_chart-detail">
                                <h1>Views of the 5 Most Recent News Articles</h1>

                                <div id="chart_user_status" style="width: 100%; height: 400px;"></div>
                            </div>
                            <div class="col-lg-7 item_chart-detail">
                                <h1>Views of the 5 Most Recent News Articles</h1>
                                <div id="chart_view_news" style="width: 100%; height: 400px;"></div>
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
    <script>
        var chart = echarts.init(document.getElementById('chart_view_news'));

        option = {
            title: {
                text: '',

            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            
    legend: {
      itemWidth: 50,  
      itemHeight: 12,    
      textStyle: {
        fontSize: 16, // Tăng kích thước chữ
        fontWeight: 'bold' // Làm đậm chữ nếu muốn
      } 
    },
            xAxis: [
                {
                    type: 'category',
                    data: ['1', '2', '3', '4', '5'],
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    axisLabel: {
                        formatter: '{value} Views'
                    }
                }
            ],
            series: [
                {
                    name: 'Quantity',
                    type: 'bar',
                    barWidth: '60%',
                    data: [100, 52, 200, 334, 390]
                    // ,
                    // itemStyle:{
                    //   color : function(param){
                    //     return '#000';
                    //   }
                    // }
                }
            ]
        };

        chart.setOption(option); 
    </script>
    <script>
        var chart2 = echarts.init(document.getElementById('chart_user_status'));

        option = {
            title: {
                text: '',
                subtext: '',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left'
            },
            series: [
                {
                    name: 'Access From',
                    type: 'pie',
                    radius: '50%',
                    data: [
                        { value: 1048, name: 'Active' },
                        { value: 735, name: 'Deactive' },
                        { value: 580, name: 'Suspend' } 
                    ],
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };    

        chart2.setOption(option); 
    </script>
</body>

</html>